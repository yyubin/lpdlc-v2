"""LPDL v2 텍스트 → AST (lark LALR)."""
from __future__ import annotations

import textwrap
from functools import lru_cache
from pathlib import Path

from lark import Lark, Token, Transformer, v_args
from lark.exceptions import UnexpectedInput

from . import ast as A

GRAMMAR = Path(__file__).with_name("grammar.lark")


class LPDLSyntaxError(Exception):
    def __init__(self, message: str, line: int | None = None, column: int | None = None):
        self.line, self.column = line, column
        where = f"{line}:{column}: " if line is not None else ""
        super().__init__(where + message)


@lru_cache(maxsize=1)
def _lark() -> Lark:
    return Lark(GRAMMAR.read_text(encoding="utf-8"), parser="lalr", propagate_positions=True)


def _str(tok: Token) -> str:
    return tok[1:-1].replace('\\"', '"').replace("\\\\", "\\")


def _text(tok: Token) -> str:
    return textwrap.dedent(tok[3:-3]).strip()


def _int(tok) -> int:
    v = float(tok)
    if v != int(v):
        raise LPDLSyntaxError(f"정수가 필요함: {tok}", getattr(tok, "line", None), getattr(tok, "column", None))
    return int(v)


def _line(meta) -> int | None:
    return getattr(meta, "line", None)


class _Opt:
    """on_opt / stmt_opt 의 중간 표현."""
    def __init__(self, key, value):
        self.key, self.value = key, value


def _split_opts(children):
    plain, opts = [], {}
    for c in children:
        if isinstance(c, _Opt):
            opts[c.key] = c.value
        else:
            plain.append(c)
    return plain, opts


def _members(children, *, allow):
    """선언 본문의 멤버를 종류별로 분류."""
    out = {"texts": [], "notes": [], "flags": [], "blocks": [], "uses": {}, "budgets": {},
           "skills": [], "passives": [], "coins": [], "props": {}, "requires": None}
    for c in children:
        if isinstance(c, A.Text):
            out["texts"].append(c.value)
        elif isinstance(c, A.Note):
            out["notes"].append(c.value)
        elif isinstance(c, tuple) and c[0] == "flag":
            out["flags"].append(c[1])
        elif isinstance(c, tuple) and c[0] == "use":
            out["uses"][c[1]] = c[2]
        elif isinstance(c, tuple) and c[0] == "budget":
            out["budgets"][c[1]] = c[2]
        elif isinstance(c, tuple) and c[0] == "prop":
            out["props"][c[1]] = c[2]
        elif isinstance(c, (A.On, A.Always)):
            out["blocks"].append(c)
        elif isinstance(c, A.Skill):
            out["skills"].append(c)
        elif isinstance(c, A.Passive):
            out["passives"].append(c)
        elif isinstance(c, A.Coin):
            out["coins"].append(c)
        elif isinstance(c, A.Requires):
            out["requires"] = c
    return {k: out[k] for k in allow}


@v_args(meta=True)
class _ToAST(Transformer):
    # ── 최상위 ──
    def start(self, meta, ch):
        doc = A.Document()
        for c in ch:
            if isinstance(c, int):
                doc.version = c
            elif isinstance(c, A.Identity):
                doc.identities.append(c)
            elif isinstance(c, A.KeywordDecl):
                doc.keywords.append(c)
        return doc

    def header(self, meta, ch):
        return _int(ch[0])

    def identity(self, meta, ch):
        id_, rest = _int(ch[0]), ch[1:]
        name = None
        if rest and isinstance(rest[0], Token) and rest[0].type == "STRING":
            name, rest = _str(rest[0]), rest[1:]
        m = _members(rest, allow=("texts", "notes", "uses", "budgets", "skills", "passives"))
        return A.Identity(line=_line(meta), id=id_, name=name, **m)

    def use(self, meta, ch):
        return ("use", str(ch[0]), _str(ch[1]))

    def budget(self, meta, ch):
        return ("budget", str(ch[0]), ch[1])

    def text(self, meta, ch):
        return A.Text(line=_line(meta), value=_text(ch[0]))

    def note_stmt(self, meta, ch):
        return A.Note(line=_line(meta), value=_str(ch[0]))

    def flag(self, meta, ch):
        return ("flag", str(ch[0]))

    def skill(self, meta, ch):
        ref, rest = ch[0], ch[1:]
        name = None
        if rest and isinstance(rest[0], Token) and rest[0].type == "STRING":
            name, rest = _str(rest[0]), rest[1:]
        m = _members(rest, allow=("texts", "notes", "flags", "blocks", "coins"))
        return A.Skill(line=_line(meta), ref=ref, name=name, **m)

    def coin(self, meta, ch):
        m = _members(ch[1:], allow=("texts", "notes", "flags", "blocks"))
        return A.Coin(line=_line(meta), index=_int(ch[0]), **m)

    def passive(self, meta, ch):
        kind, name, rest = str(ch[0]), _str(ch[1]), ch[2:]
        m = _members(rest, allow=("texts", "notes", "blocks", "uses", "budgets", "requires"))
        return A.Passive(line=_line(meta), support=(kind == "support"), name=name, **m)

    def requires(self, meta, ch):
        return A.Requires(line=_line(meta), type=str(ch[0]), sins=[str(t) for t in ch[1:-1]], count=_int(ch[-1]))

    def keyword_decl(self, meta, ch):
        m = _members(ch[1:], allow=("texts", "notes", "blocks", "uses", "budgets", "props"))
        return A.KeywordDecl(line=_line(meta), name=_str(ch[0]), **m)

    def prop(self, meta, ch):
        v = ch[1]
        value = v.value if isinstance(v, (A.Num, A.Str, A.Name)) else str(v)
        return ("prop", str(ch[0]), value)

    # ── 블록 ──
    def on_block(self, meta, ch):
        event, rest = str(ch[0]), ch[1:]
        args = []
        if rest and isinstance(rest[0], tuple) and rest[0][0] == "args":
            args, rest = rest[0][1], rest[1:]
        body = rest[-1]
        _, opts = _split_opts(rest[:-1])
        return A.On(line=_line(meta), event=event, args=args, body=body, **opts)

    def event_args(self, meta, ch):
        return ("args", [c for c in ch if c is not None])

    def on_when(self, meta, ch):
        return _Opt("when", ch[0])

    def on_limit(self, meta, ch):
        return _Opt("limit", ch[0])

    def on_by(self, meta, ch):
        return _Opt("by", ch[0])

    def on_every(self, meta, ch):
        return _Opt("every", ch[0])

    def always_block(self, meta, ch):
        return A.Always(line=_line(meta), body=ch[0])

    def limit_spec(self, meta, ch):
        return A.Limit(line=_line(meta), times=_int(ch[0]), period=str(ch[1]), per_target=len(ch) > 2)

    def per_target(self, meta, ch):
        return True

    def body(self, meta, ch):
        return list(ch)

    # ── 문장 ──
    def when_stmt(self, meta, ch):
        branches = [(ch[0], ch[1])]
        otherwise = []
        for c in ch[2:]:
            if c[0] == "elif":
                branches.append((c[1], c[2]))
            else:
                otherwise = c[1]
        return A.When(line=_line(meta), branches=branches, otherwise=otherwise)

    def elif_clause(self, meta, ch):
        return ("elif", ch[0], ch[1])

    def else_clause(self, meta, ch):
        return ("else", ch[0])

    def let_stmt(self, meta, ch):
        return A.Let(line=_line(meta), name=str(ch[0]), value=ch[1])

    def gain_stmt(self, meta, ch):
        plain, opts = _split_opts(ch)
        return A.Gain(line=_line(meta), ref=plain[0], amount=plain[1], opts=A.StmtOpts(**opts))

    def apply_stmt(self, meta, ch):
        plain, opts = _split_opts(ch)
        parts = {k: v for k, v in plain[2:]}
        return A.Apply(line=_line(meta), target=plain[0], keyword=str(plain[1]), opts=A.StmtOpts(**opts), **parts)

    def potency(self, meta, ch):
        return ("potency", ch[0])

    def count(self, meta, ch):
        return ("count", ch[0])

    def consume_stmt(self, meta, ch):
        plain, opts = _split_opts(ch)
        mode, amount = plain[1]
        bind = plain[2][1] if len(plain) > 2 else None
        return A.Consume(line=_line(meta), ref=plain[0], mode=mode, amount=amount, bind=bind,
                         opts=A.StmtOpts(**opts))

    def amount_exact(self, meta, ch):
        return ("exact", ch[0])

    def amount_up_to(self, meta, ch):
        return ("up_to", ch[0])

    def amount_all(self, meta, ch):
        return ("all", None)

    def bind(self, meta, ch):
        return ("bind", str(ch[0]))

    def modify_stmt(self, meta, ch):
        plain, opts = _split_opts(ch)
        return A.Modify(line=_line(meta), target=str(plain[0]), amount=plain[1], opts=A.StmtOpts(**opts))

    def burst_stmt(self, meta, ch):
        times = ch[2] if len(ch) > 2 else None
        return A.Burst(line=_line(meta), target=ch[0], keyword=str(ch[1]), times=times)

    def times(self, meta, ch):
        return ch[0]

    def deal_stmt(self, meta, ch):
        return A.Deal(line=_line(meta), target=ch[0], damage_type=str(ch[1]), amount=ch[2])

    def replace_stmt(self, meta, ch):
        plain, opts = _split_opts(ch)
        src = None if plain[0] == "this" else plain[0]
        return A.Replace(line=_line(meta), source=src, dest=plain[1], opts=A.StmtOpts(**opts))

    def this_skill(self, meta, ch):
        return "this"

    def convert_stmt(self, meta, ch):
        plain, opts = _split_opts(ch)
        return A.Convert(line=_line(meta), source=plain[0], dest=plain[1], opts=A.StmtOpts(**opts))

    def defer_stmt(self, meta, ch):
        return A.Defer(line=_line(meta), event=str(ch[0]), body=ch[1])

    def hook_stmt(self, meta, ch):
        args = ch[1][1] if len(ch) > 1 else []
        return A.Hook(line=_line(meta), name=str(ch[0]), args=args)

    def unparsed_stmt(self, meta, ch):
        return A.Unparsed(line=_line(meta), text=_text(ch[0]), reason=ch[1] if len(ch) > 1 else None)

    def reason(self, meta, ch):
        return _str(ch[0])

    def opt_cap(self, meta, ch):
        return _Opt("cap", ch[0])

    def opt_next_turn(self, meta, ch):
        return _Opt("next_turn", True)

    def opt_this_turn(self, meta, ch):
        return _Opt("this_turn", True)

    def opt_coins(self, meta, ch):
        return _Opt("coins", str(ch[0]))

    def opt_budget(self, meta, ch):
        return _Opt("budget", str(ch[0]))

    def skill_ref(self, meta, ch):
        return A.SkillRef(line=_line(meta), slot=str(ch[0]), variant=ch[1] if len(ch) > 1 else 0)

    def variant(self, meta, ch):
        return _int(ch[0])

    # ── 수식 ──
    def _fold(self, meta, op, ch):
        e = ch[0]
        for r in ch[1:]:
            e = A.BinOp(line=_line(meta), op=op, left=e, right=r)
        return e

    def or_(self, meta, ch):
        return self._fold(meta, "or", ch)

    def and_(self, meta, ch):
        return self._fold(meta, "and", ch)

    def not_(self, meta, ch):
        return A.Unary(line=_line(meta), op="not", operand=ch[0])

    def compare(self, meta, ch):
        return A.BinOp(line=_line(meta), op=str(ch[1]), left=ch[0], right=ch[2])

    def is_(self, meta, ch):
        return A.Is(line=_line(meta), subject=ch[0], category=ch[1])

    def name(self, meta, ch):
        return A.Name(line=_line(meta), value=str(ch[0]))

    def add(self, meta, ch):
        return A.BinOp(line=_line(meta), op="+", left=ch[0], right=ch[1])

    def sub(self, meta, ch):
        return A.BinOp(line=_line(meta), op="-", left=ch[0], right=ch[1])

    def mul(self, meta, ch):
        return A.BinOp(line=_line(meta), op="*", left=ch[0], right=ch[1])

    def div(self, meta, ch):
        return A.BinOp(line=_line(meta), op="/", left=ch[0], right=ch[1])

    def neg(self, meta, ch):
        if isinstance(ch[0], A.Num):
            return A.Num(line=_line(meta), value=-ch[0].value)
        return A.Unary(line=_line(meta), op="-", operand=ch[0])

    def pos(self, meta, ch):
        return ch[0]

    def num(self, meta, ch):
        return A.Num(line=_line(meta), value=float(ch[0]))

    def str(self, meta, ch):
        return A.Str(line=_line(meta), value=_str(ch[0]))

    def list_(self, meta, ch):
        return A.ListExpr(line=_line(meta), items=[c for c in ch if c is not None])

    def call(self, meta, ch):
        args, kwargs = [], {}
        for c in ch[1:]:
            if c is None:
                continue
            if isinstance(c, tuple) and c[0] == "kwarg":
                kwargs[c[1]] = c[2]
            else:
                args.append(c)
        return A.Call(line=_line(meta), func=str(ch[0]), args=args, kwargs=kwargs)

    def kwarg(self, meta, ch):
        return ("kwarg", str(ch[0]), ch[1])

    def ref(self, meta, ch):
        return A.Ref(line=_line(meta), path=[str(t) for t in ch])


def parse(source: str) -> A.Document:
    try:
        tree = _lark().parse(source)
    except UnexpectedInput as e:
        expected = sorted(getattr(e, "expected", None) or getattr(e, "allowed", None) or [])
        hint = f" (기대: {', '.join(expected[:12])})" if expected else ""
        raise LPDLSyntaxError(f"구문 오류 near {e.get_context(source).splitlines()[0].strip()!r}{hint}",
                              e.line, e.column) from None
    return _ToAST().transform(tree)


def parse_file(path: str | Path) -> A.Document:
    return parse(Path(path).read_text(encoding="utf-8"))
