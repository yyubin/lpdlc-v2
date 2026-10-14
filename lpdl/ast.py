"""LPDL v2 AST. 파서가 만들고 검증기·엔진이 읽는다."""
from __future__ import annotations

from typing import Annotated, Literal, Union

from pydantic import BaseModel, Field


class Node(BaseModel):
    line: int | None = None


# ── 수식 ─────────────────────────────────────────────────────────────────────
class Num(Node):
    kind: Literal["num"] = "num"
    value: float


class Str(Node):
    kind: Literal["str"] = "str"
    value: str


class Ref(Node):
    kind: Literal["ref"] = "ref"
    path: list[str]                     # self.보존.count → ["self", "보존", "count"]


class Name(Node):
    """`is` 우변의 분류 이름 (basic_attack 등)."""
    kind: Literal["name"] = "name"
    value: str


class SkillRef(Node):
    kind: Literal["skill_ref"] = "skill_ref"
    slot: Literal["S1", "S2", "S3", "DEF", "EGO"]
    variant: int = 0


class Call(Node):
    kind: Literal["call"] = "call"
    func: str
    args: list[Expr] = []
    kwargs: dict[str, Expr] = {}


class BinOp(Node):
    kind: Literal["binop"] = "binop"
    op: Literal["+", "-", "*", "/", ">=", "<=", "==", "!=", ">", "<", "and", "or"]
    left: Expr
    right: Expr


class Unary(Node):
    kind: Literal["unary"] = "unary"
    op: Literal["-", "not"]
    operand: Expr


class Is(Node):
    kind: Literal["is"] = "is"
    subject: Expr
    category: Name | SkillRef


class ListExpr(Node):
    kind: Literal["list"] = "list"
    items: list[Expr] = []


Expr = Annotated[
    Union[Num, Str, Ref, Name, SkillRef, Call, BinOp, Unary, Is, ListExpr],
    Field(discriminator="kind"),
]


# ── 옵션 ─────────────────────────────────────────────────────────────────────
class Limit(Node):
    times: int
    period: Literal["turn", "battle", "use"]
    per_target: bool = False


class StmtOpts(BaseModel):
    cap: Expr | None = None
    next_turn: bool = False
    this_turn: bool = False
    coins: str | None = None            # all | first | last | current | "3"
    budget: str | None = None
    to: Expr | None = None              # 오라: 다른 유닛(들)에 적용


# ── 문장 ─────────────────────────────────────────────────────────────────────
class Text(Node):
    kind: Literal["text"] = "text"
    value: str


class Note(Node):
    kind: Literal["note"] = "note"
    value: str


class Let(Node):
    kind: Literal["let"] = "let"
    name: str
    value: Expr


class Gain(Node):
    kind: Literal["gain"] = "gain"
    ref: Ref
    amount: Expr
    opts: StmtOpts = StmtOpts()


class Apply(Node):
    kind: Literal["apply"] = "apply"
    target: Expr
    keyword: str
    potency: Expr | None = None
    count: Expr | None = None
    opts: StmtOpts = StmtOpts()


class Consume(Node):
    kind: Literal["consume"] = "consume"
    ref: Ref
    mode: Literal["exact", "up_to", "all"]
    amount: Expr | None = None          # all 이면 None
    bind: str | None = None             # -> n : 실제 소모량
    opts: StmtOpts = StmtOpts()


class Modify(Node):
    kind: Literal["modify"] = "modify"
    target: str                         # vocab.MODIFY_TARGETS
    amount: Expr
    opts: StmtOpts = StmtOpts()


class Burst(Node):
    kind: Literal["burst"] = "burst"
    target: Expr
    keyword: str
    times: Expr | None = None


class Deal(Node):
    kind: Literal["deal"] = "deal"
    target: Expr
    damage_type: str                    # vocab.DAMAGE_TYPES
    amount: Expr


class Replace(Node):
    kind: Literal["replace"] = "replace"
    source: SkillRef | None             # None = this (현재 스킬)
    dest: SkillRef
    opts: StmtOpts = StmtOpts()


class Convert(Node):
    kind: Literal["convert"] = "convert"
    source: Ref
    dest: Ref
    opts: StmtOpts = StmtOpts()


class Hook(Node):
    kind: Literal["hook"] = "hook"
    name: str
    args: list[Expr] = []


class ReuseCoin(Node):
    kind: Literal["reuse_coin"] = "reuse_coin"
    times: Expr | None = None


class UseSkill(Node):
    kind: Literal["use_skill"] = "use_skill"
    skill: SkillRef
    target: Expr | None = None


class Retype(Node):
    kind: Literal["retype"] = "retype"
    target: Expr
    source: str
    dest: str


class Unparsed(Node):
    kind: Literal["unparsed"] = "unparsed"
    text: str
    reason: str | None = None


class When(Node):
    kind: Literal["when"] = "when"
    branches: list[tuple[Expr, list[Stmt]]]     # when + elif
    otherwise: list[Stmt] = []


class Defer(Node):
    kind: Literal["defer"] = "defer"
    event: str
    body: list[Stmt] = []


Stmt = Annotated[
    Union[Text, Note, Let, Gain, Apply, Consume, Modify, Burst, Deal, Replace, Convert,
          Hook, ReuseCoin, UseSkill, Retype, Unparsed, When, Defer],
    Field(discriminator="kind"),
]


# ── 블록 ─────────────────────────────────────────────────────────────────────
class On(Node):
    kind: Literal["on"] = "on"
    event: str                          # vocab.EVENTS
    args: list[Expr] = []
    when: Expr | None = None
    limit: Limit | None = None
    by: Expr | None = None
    every: Expr | None = None
    body: list[Stmt] = []


class Always(Node):
    kind: Literal["always"] = "always"
    body: list[Stmt] = []


Block = Annotated[Union[On, Always], Field(discriminator="kind")]


# ── 선언 ─────────────────────────────────────────────────────────────────────
class Requires(Node):
    type: Literal["hold", "resonate"]
    sins: list[str]
    count: int


class Coin(Node):
    index: int
    flags: list[str] = []
    texts: list[str] = []
    notes: list[str] = []
    blocks: list[Block] = []


class Skill(Node):
    ref: SkillRef
    name: str | None = None
    flags: list[str] = []
    texts: list[str] = []
    notes: list[str] = []
    blocks: list[Block] = []
    coins: list[Coin] = []


class Passive(Node):
    support: bool = False
    name: str
    requires: Requires | None = None
    uses: dict[str, str] = {}
    budgets: dict[str, Limit] = {}
    texts: list[str] = []
    notes: list[str] = []
    blocks: list[Block] = []


class KeywordDecl(Node):
    name: str
    props: dict[str, float | str] = {}
    uses: dict[str, str] = {}
    budgets: dict[str, Limit] = {}
    texts: list[str] = []
    notes: list[str] = []
    blocks: list[Block] = []


class Identity(Node):
    id: int
    name: str | None = None
    uses: dict[str, str] = {}           # 별칭 → 키워드 정식 이름
    budgets: dict[str, Limit] = {}
    texts: list[str] = []
    notes: list[str] = []
    skills: list[Skill] = []
    passives: list[Passive] = []


class Document(BaseModel):
    version: int = 2
    identities: list[Identity] = []
    keywords: list[KeywordDecl] = []


for _m in (Call, BinOp, Unary, Is, ListExpr, StmtOpts, Gain, Apply, Consume, Modify, Burst, Deal,
           Hook, ReuseCoin, UseSkill, Retype, When, Defer, On, Always, Coin, Skill, Passive, KeywordDecl, Identity, Document, Let):
    _m.model_rebuild()
