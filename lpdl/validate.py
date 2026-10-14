"""LPDL v2 의미 검증: 이름·참조·문맥. 파싱이 통과해도 여기서 막히면 실패로 본다 (v1은 구문 검사뿐이었음)."""
from __future__ import annotations

import difflib
from dataclasses import dataclass, field
from typing import Iterable, Literal

from . import ast as A
from . import vocab as V


@dataclass
class Issue:
    level: Literal["error", "warning", "review"]
    line: int | None
    where: str
    message: str

    def __str__(self) -> str:
        loc = f"{self.line}" if self.line is not None else "-"
        return f"[{self.level}] {loc} {self.where}: {self.message}"


@dataclass
class Report:
    issues: list[Issue] = field(default_factory=list)

    @property
    def errors(self) -> list[Issue]:
        return [i for i in self.issues if i.level == "error"]

    @property
    def ok(self) -> bool:
        return not self.errors

    def of(self, level: str) -> list[Issue]:
        return [i for i in self.issues if i.level == level]


def _suggest(name: str, choices: Iterable[str]) -> str:
    m = difflib.get_close_matches(name, list(choices), n=1, cutoff=0.6)
    return f" (혹시 '{m[0]}'?)" if m else ""


@dataclass
class _Scope:
    where: str
    aliases: dict[str, str]                 # 별칭 → 정식 키워드 이름
    keywords: set[str]                      # 사용 가능한 정식 키워드 이름
    keyword_kinds: dict[str, str]           # 선언된 키워드의 kind
    budgets: set[str]
    locals: set[str] = field(default_factory=set)
    event: str | None = None
    in_coin: bool = False
    in_pick: bool = False

    def child(self, **kw) -> "_Scope":
        s = _Scope(self.where, self.aliases, self.keywords, self.keyword_kinds, self.budgets,
                   set(self.locals), self.event, self.in_coin, self.in_pick)
        for k, v in kw.items():
            setattr(s, k, v)
        return s

    def resolve_keyword(self, name: str) -> str | None:
        if name in self.aliases:
            return self.aliases[name]
        if name in self.keywords:
            return name
        return None


class _Validator:
    def __init__(self, extra_keywords: Iterable[str] = ()):
        self.report = Report()
        self.base_keywords = set(V.registry_keywords()) | set(extra_keywords)

    def issue(self, level, node, scope_or_where, message):
        where = scope_or_where.where if isinstance(scope_or_where, _Scope) else scope_or_where
        self.report.issues.append(Issue(level, getattr(node, "line", None), where, message))

    # ── 문서 ──
    def document(self, doc: A.Document):
        if doc.version != 2:
            self.issue("error", None, "document", f"lpdl {doc.version} 은 지원하지 않음 (2만 지원)")
        kinds = {}
        for k in doc.keywords:
            kinds[k.name] = str(k.props.get("kind", "status"))
        keywords = self.base_keywords | set(kinds)
        for k in doc.keywords:
            self.keyword_decl(k, keywords, kinds)
        for ident in doc.identities:
            self.identity(ident, keywords, kinds)

    def _aliases(self, uses: dict[str, str], keywords: set[str], where: str, node) -> dict[str, str]:
        for alias, full in uses.items():
            if full not in keywords:
                self.issue("error", node, where, f"use {alias} = \"{full}\": 알 수 없는 키워드{_suggest(full, keywords)}")
        return dict(uses)

    def keyword_decl(self, k: A.KeywordDecl, keywords, kinds):
        where = f"keyword \"{k.name}\""
        if k.name not in self.base_keywords:
            self.issue("warning", k, where, "게임 키워드 사전에 없는 이름 (신규 키워드면 무시)")
        for p, v in k.props.items():
            if p not in V.KEYWORD_PROPS:
                self.issue("error", k, where, f"prop {p}: 알 수 없는 속성{_suggest(p, V.KEYWORD_PROPS)}")
        kind = k.props.get("kind", "status")
        if kind not in V.KEYWORD_KINDS:
            self.issue("error", k, where, f"kind {kind}: {sorted(V.KEYWORD_KINDS)} 중 하나여야 함")
        inherit = k.props.get("inherit")
        if inherit is not None and inherit not in keywords:
            self.issue("error", k, where, f"inherit \"{inherit}\": 알 수 없는 키워드")
        aliases = self._aliases(k.uses, keywords, where, k)
        scope = _Scope(where, aliases, keywords, kinds, set(k.budgets))
        self.review(k.notes, k, where)
        for b in k.blocks:
            self.block(b, scope)

    def identity(self, ident: A.Identity, keywords, kinds):
        where = f"identity {ident.id}"
        aliases = self._aliases(ident.uses, keywords, where, ident)
        budgets = set(ident.budgets)
        seen = set()
        for s in ident.skills:
            key = (s.ref.slot, s.ref.variant)
            if key in seen:
                self.issue("error", s, where, f"skill {s.ref.slot} variant {s.ref.variant} 중복")
            seen.add(key)
        self.review(ident.notes, ident, where)
        for s in ident.skills:
            sw = f"{where} skill {s.ref.slot}" + (f" variant {s.ref.variant}" if s.ref.variant else "")
            scope = _Scope(sw, aliases, keywords, kinds, budgets)
            self.flags(s.flags, s, sw)
            self.review(s.notes, s, sw)
            idx = [c.index for c in s.coins]
            if len(idx) != len(set(idx)):
                self.issue("error", s, sw, f"coin 번호 중복: {idx}")
            for b in s.blocks:
                self.block(b, scope)
            for c in s.coins:
                cw = f"{sw} coin {c.index}"
                self.flags(c.flags, c, cw)
                self.review(c.notes, c, cw)
                cs = scope.child(where=cw, in_coin=True)
                for b in c.blocks:
                    self.block(b, cs)
        for p in ident.passives:
            pw = f"{where} {'support' if p.support else 'passive'} \"{p.name}\""
            pa = {**aliases, **self._aliases(p.uses, keywords, pw, p)}
            scope = _Scope(pw, pa, keywords, kinds, budgets | set(p.budgets))
            if p.requires:
                for sin in p.requires.sins:
                    if sin not in V.SINS:
                        self.issue("error", p.requires, pw, f"requires: 죄악 '{sin}' 아님{_suggest(sin, V.SINS)}")
            self.review(p.notes, p, pw)
            for b in p.blocks:
                self.block(b, scope)

    def flags(self, flags, node, where):
        for f in flags:
            if f not in V.FLAGS:
                self.issue("error", node, where, f"flag {f}: 알 수 없음{_suggest(f, V.FLAGS)}")

    def review(self, notes, node, where):
        for n in notes:
            self.issue("review", node, where, f"note: {n}")

    # ── 블록 ──
    def block(self, b, scope: _Scope):
        if isinstance(b, A.Always):
            self.stmts(b.body, scope.child(event=None))
            return
        if b.event not in V.EVENTS:
            self.issue("error", b, scope, f"on {b.event}: 알 수 없는 이벤트{_suggest(b.event, V.EVENTS)}")
        elif scope.in_coin and b.event not in V.COIN_EVENTS:
            self.issue("error", b, scope, f"on {b.event}: 코인 블록에서 쓸 수 없는 이벤트 (가능: {sorted(V.COIN_EVENTS)})")
        if b.event in V.RESOURCE_EVENTS:
            if len(b.args) != 1:
                self.issue("error", b, scope, f"on {b.event}(...): 대상 자원/키워드 1개 필요")
            for a in b.args:
                self.event_arg(a, scope)
        elif b.args:
            self.issue("error", b, scope, f"on {b.event}: 인자를 받지 않는 이벤트")
        if b.every is not None and b.event not in ("gained", "consumed"):
            self.issue("error", b, scope, "every 는 gained / consumed 에서만 사용")
        inner = scope.child(event=b.event)
        for e in (b.when, b.by, b.every):
            if e is not None:
                self.expr(e, inner)
        self.stmts(b.body, inner)

    def event_arg(self, a, scope):
        if isinstance(a, A.Ref) and len(a.path) == 1:
            if scope.resolve_keyword(a.path[0]) is None:
                self.issue("error", a, scope, f"'{a.path[0]}': 알 수 없는 키워드{_suggest(a.path[0], scope.keywords)}")
        else:
            self.expr(a, scope)

    # ── 문장 ──
    def stmts(self, stmts, scope: _Scope):
        for s in stmts:
            self.stmt(s, scope)

    def stmt(self, s, scope: _Scope):
        match s:
            case A.Text():
                pass
            case A.Note():
                self.issue("review", s, scope, f"note: {s.value}")
            case A.Unparsed():
                self.issue("review", s, scope, f"unparsed: {s.text[:60]}" + (f" ({s.reason})" if s.reason else ""))
            case A.Let():
                self.expr(s.value, scope)
                scope.locals.add(s.name)
            case A.Gain():
                self.ref(s.ref, scope, writable=True)
                self.expr(s.amount, scope)
                self.opts(s.opts, s, scope)
            case A.Apply():
                self.expr(s.target, scope)
                self.keyword_name(s.keyword, s, scope)
                if s.potency is None and s.count is None:
                    self.issue("error", s, scope, "apply: potency 또는 count 필요")
                for e in (s.potency, s.count):
                    if e is not None:
                        self.expr(e, scope)
                self.opts(s.opts, s, scope)
            case A.Consume():
                self.ref(s.ref, scope, writable=True)
                if s.mode != "all" and s.amount is None:
                    self.issue("error", s, scope, "consume: 수량 필요")
                if s.amount is not None:
                    self.expr(s.amount, scope)
                self.opts(s.opts, s, scope)
                if s.bind:
                    scope.locals.add(s.bind)
            case A.Modify():
                if s.target not in V.MODIFY_TARGETS:
                    self.issue("error", s, scope, f"modify {s.target}: 알 수 없는 대상{_suggest(s.target, V.MODIFY_TARGETS)}")
                elif s.target == "amount" and scope.event not in V.RESOURCE_EVENTS:
                    self.issue("error", s, scope, "modify amount 는 gained/consumed/applied/burst 이벤트 안에서만")
                self.expr(s.amount, scope)
                self.opts(s.opts, s, scope)
            case A.Burst():
                self.expr(s.target, scope)
                self.keyword_name(s.keyword, s, scope)
                if s.times is not None:
                    self.expr(s.times, scope)
            case A.Deal():
                self.expr(s.target, scope)
                if s.damage_type not in V.DAMAGE_TYPES:
                    self.issue("error", s, scope, f"deal {s.damage_type}: {sorted(V.DAMAGE_TYPES)} 중 하나")
                self.expr(s.amount, scope)
            case A.Replace():
                self.opts(s.opts, s, scope)
            case A.Convert():
                self.ref(s.source, scope, writable=True)
                self.ref(s.dest, scope, writable=True)
                self.opts(s.opts, s, scope)
            case A.Hook():
                self.issue("review", s, scope, f"hook {s.name}: Python 구현 필요")
                for a in s.args:
                    self.expr(a, scope)
            case A.When():
                for cond, body in s.branches:
                    self.expr(cond, scope)
                    self.stmts(body, scope.child())
                self.stmts(s.otherwise, scope.child())
            case A.Defer():
                if s.event not in V.EVENTS:
                    self.issue("error", s, scope, f"defer {s.event}: 알 수 없는 이벤트{_suggest(s.event, V.EVENTS)}")
                self.stmts(s.body, scope.child(event=s.event))

    def opts(self, o: A.StmtOpts, node, scope):
        if o.cap is not None:
            self.expr(o.cap, scope)
        if o.next_turn and o.this_turn:
            self.issue("error", node, scope, "next_turn 과 this_turn 을 함께 쓸 수 없음")
        if o.budget and o.budget not in scope.budgets:
            self.issue("error", node, scope, f"budget {o.budget}: 선언되지 않음")

    def keyword_name(self, name, node, scope):
        if scope.resolve_keyword(name) is None:
            self.issue("error", node, scope, f"'{name}': 알 수 없는 키워드{_suggest(name, scope.keywords)}")

    # ── 수식 ──
    def ref(self, r: A.Ref, scope: _Scope, writable=False):
        p = r.path
        root = p[0]
        if root in scope.locals:
            if len(p) > 1:
                self.issue("error", r, scope, f"{'.'.join(p)}: 지역 변수 '{root}' 에는 필드가 없음")
            elif writable:
                self.issue("error", r, scope, f"{root}: 지역 변수는 대상이 될 수 없음")
            return
        if root == "it" and not scope.in_pick:
            self.issue("error", r, scope, "it 은 pick(...) 안에서만 사용")
            return
        if root in V.UNIT_ROOTS:
            if len(p) == 1:
                if writable:
                    self.issue("error", r, scope, f"{root}: 필드 또는 키워드 필요 (예: {root}.shield)")
                return
            name = p[1]
            if name in V.UNIT_FIELDS:
                if len(p) > 2:
                    self.issue("error", r, scope, f"{'.'.join(p)}: {name} 에는 하위 필드가 없음")
                return
            full = scope.resolve_keyword(name)
            if full is None:
                self.issue("error", r, scope, f"{'.'.join(p)}: '{name}' 은 유닛 필드도 키워드도 아님"
                                              f"{_suggest(name, list(V.UNIT_FIELDS) + list(scope.aliases))}")
                return
            kind = scope.keyword_kinds.get(full)
            if len(p) == 2:
                if kind is not None and kind != "value":
                    self.issue("error", r, scope, f"{'.'.join(p)}: '{full}' 은 {kind} → .potency 또는 .count 지정 필요")
            elif len(p) == 3:
                if p[2] not in V.STATUS_FIELDS:
                    self.issue("error", r, scope, f"{'.'.join(p)}: '{p[2]}' 대신 potency / count")
                elif kind == "value":
                    self.issue("error", r, scope, f"{'.'.join(p)}: '{full}' 은 수치형(value) → 필드 없이 사용")
            else:
                self.issue("error", r, scope, f"{'.'.join(p)}: 경로가 너무 김")
            return
        if root in V.GROUP_ROOTS:
            if len(p) > 1 or writable:
                self.issue("error", r, scope, f"{root}: 그룹은 pick/count_of 의 인자로만 사용")
            return
        if root in V.SPECIAL_ROOTS:
            fields = V.SPECIAL_ROOTS[root]
            if root == "ev" and scope.event not in V.RESOURCE_EVENTS:
                self.issue("error", r, scope, "ev 는 gained/consumed/applied/burst 이벤트 안에서만")
            if root == "coin" and not scope.in_coin:
                self.issue("error", r, scope, "coin.* 은 코인 블록 안에서만")
            if len(p) == 1 and fields:
                self.issue("error", r, scope, f"{root}: 필드 필요 ({sorted(fields)})")
            elif len(p) == 2 and p[1] not in fields:
                self.issue("error", r, scope, f"{'.'.join(p)}: 알 수 없는 필드{_suggest(p[1], fields)}")
            elif len(p) > 2:
                self.issue("error", r, scope, f"{'.'.join(p)}: 경로가 너무 김")
            return
        self.issue("error", r, scope, f"'{'.'.join(p)}': 알 수 없는 이름"
                                      f"{_suggest(root, list(scope.locals) + list(V.UNIT_ROOTS) + list(V.SPECIAL_ROOTS))}")

    def expr(self, e, scope: _Scope):
        match e:
            case A.Num() | A.Str() | A.SkillRef():
                pass
            case A.Name():
                if e.value not in V.CATEGORIES:
                    self.issue("error", e, scope, f"is {e.value}: 알 수 없는 분류{_suggest(e.value, V.CATEGORIES)}")
            case A.Ref():
                self.ref(e, scope)
            case A.BinOp():
                self.expr(e.left, scope)
                self.expr(e.right, scope)
            case A.Unary():
                self.expr(e.operand, scope)
            case A.Is():
                self.expr(e.subject, scope)
                self.expr(e.category, scope)
            case A.ListExpr():
                for i in e.items:
                    self.expr(i, scope)
            case A.Call():
                self.call(e, scope)

    def call(self, c: A.Call, scope: _Scope):
        if c.func not in V.FUNCS:
            self.issue("error", c, scope, f"{c.func}(): 알 수 없는 함수{_suggest(c.func, V.FUNCS)}")
            return
        lo, hi, kw = V.FUNCS[c.func]
        if not lo <= len(c.args) <= hi:
            self.issue("error", c, scope, f"{c.func}(): 인자 {len(c.args)}개 (허용 {lo}~{hi})")
        for k in c.kwargs:
            if k not in kw:
                self.issue("error", c, scope, f"{c.func}(): 알 수 없는 인자 '{k}'")
        if c.func in ("has", "has_kind") and len(c.args) == 2:
            self.expr(c.args[0], scope)
            a = c.args[1]
            if not (isinstance(a, A.Ref) and len(a.path) == 1):
                self.issue("error", c, scope, f"{c.func}(): 둘째 인자는 이름 하나")
            elif c.func == "has":
                self.keyword_name(a.path[0], c, scope)
            elif a.path[0] not in V.KEYWORD_KINDS:
                self.issue("error", c, scope, f"has_kind(): '{a.path[0]}' 은 {sorted(V.KEYWORD_KINDS)} 중 하나")
            return
        if c.func in ("pick", "count_of"):
            inner = scope.child(in_pick=True)
            for i, a in enumerate(c.args):
                self.expr(a, inner if (c.func == "count_of" and i == 1) else scope)
            for k, v in c.kwargs.items():
                if k == "by":
                    if not (isinstance(v, A.Ref) and len(v.path) == 1 and v.path[0] in V.UNIT_FIELDS):
                        self.issue("error", v, scope, f"pick(by:): 유닛 필드 이름 ({sorted(V.UNIT_FIELDS)})")
                else:
                    self.expr(v, inner)
            return
        for a in c.args:
            self.expr(a, scope)


def validate(doc: A.Document, extra_keywords: Iterable[str] = ()) -> Report:
    v = _Validator(extra_keywords)
    v.document(doc)
    return v.report
