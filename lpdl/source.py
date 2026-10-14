"""gesellschaft DB → 컴파일 입력 원문 텍스트.

스탯 수치는 LPDL에 쓰지 않으므로 효과 텍스트와 식별 정보(슬롯, variant, 코인 번호)만 렌더링한다.
"""
from __future__ import annotations

import json
import sqlite3
from pathlib import Path

DEFAULT_DB = Path(__file__).resolve().parents[2] / "gesellschaft" / "data" / "gesellschaft.db"

_SLOT_ORDER = {"S1": 0, "S2": 1, "S3": 2, "DEF": 3, "EGO": 4}


def _connect(db: str | Path) -> sqlite3.Connection:
    path = Path(db).resolve()
    if not path.exists():
        raise FileNotFoundError(f"gesellschaft DB 없음: {path} (--db 로 지정)")
    con = sqlite3.connect(f"file:{path.as_posix()}?mode=ro", uri=True)
    con.row_factory = sqlite3.Row
    return con


def identity_keywords(db: str | Path, identity_id: int) -> list[str]:
    with _connect(db) as con:
        return [r["value"] for r in con.execute(
            "select value from tag where owner_type='identity' and owner_id=? and kind='keyword'", (identity_id,))]


def render_identity(db: str | Path, identity_id: int, uptie: int = 4) -> str:
    with _connect(db) as con:
        ident = con.execute("select * from identity where id=?", (identity_id,)).fetchone()
        if ident is None:
            raise KeyError(f"identity {identity_id} 없음")
        tags = con.execute("select kind, value from tag where owner_type='identity' and owner_id=?",
                           (identity_id,)).fetchall()
        skills = con.execute("select * from skill where owner_type='identity' and owner_id=? and uptie=?",
                             (identity_id, uptie)).fetchall()
        passives = con.execute("select * from passive where owner_type='identity' and owner_id=? and uptie=?"
                               " order by kind desc, id", (identity_id, uptie)).fetchall()
        keywords = [t["value"] for t in tags if t["kind"] == "keyword"]
        kw_rows = {r["name"]: r["description"] for r in con.execute(
            f"select name, description from keyword where name in ({','.join('?' * len(keywords))})", keywords)}

        out = [f"# identity {ident['id']} — {ident['sinner']} · {ident['name']} (동기화 {uptie})"]
        affil = [t["value"] for t in tags if t["kind"] == "affiliation"]
        if affil:
            out.append(f"소속: {', '.join(affil)}")
        out.append(f"키워드: {', '.join(keywords)}")
        out.append("")

        skills = sorted(skills, key=lambda s: (_SLOT_ORDER.get(s["slot"], 9), s["variant"]))
        for s in skills:
            head = f"## skill {s['slot']}" + (f" variant {s['variant']}" if s["variant"] else "")
            head += f' "{s["name"]}" — {s["atk_type"]} / {s["sin"]} / 코인 {s["coin_num"]}개'
            if not s["is_deck_skill"] and s["slot"] != "DEF":
                head += " (덱에 들어가지 않는 변형 스킬)"
            out.append(head)
            if s["effect"]:
                out.append("[스킬 효과]")
                out.append(s["effect"].strip())
            for c in con.execute("select idx, effect from coin where skill_id=? order by idx", (s["id"],)):
                if c["effect"]:
                    out.append(f"[코인 {c['idx']}]")
                    out.append(c["effect"].strip())
            out.append("")

        for p in passives:
            kind = "support" if p["kind"] == "support" else "passive"
            head = f'## {kind} "{p["name"]}"'
            sins = json.loads(p["cond_sins"] or "[]")
            if p["cond_type"] and sins:
                head += f" — 조건: {', '.join(sins)} {p['cond_count']} {p['cond_type']}"
            out.append(head)
            out.append(p["effect"].strip())
            out.append("")

        if kw_rows:
            out.append("## 키워드 설명 (게임 키워드 사전)")
            for k in keywords:
                if k in kw_rows and kw_rows[k]:
                    desc = kw_rows[k].replace("\\n", "\n").strip()
                    desc = desc.split("\n\n_")[0]          # 이탤릭 설정 문구 제거
                    out.append(f"### {k}")
                    out.append(desc)
            out.append("")
    return "\n".join(out).rstrip() + "\n"


def identity_outline(db: str | Path, identity_id: int, uptie: int = 4) -> dict:
    """완전성 검사용: 원문에 있는 스킬(슬롯, variant) · 효과 있는 코인 번호 · 패시브 이름."""
    with _connect(db) as con:
        skills = {}
        for s in con.execute("select id, slot, variant from skill where owner_type='identity' and owner_id=? and uptie=?",
                             (identity_id, uptie)):
            coins = [c["idx"] for c in con.execute("select idx, effect from coin where skill_id=? order by idx", (s["id"],))
                     if c["effect"]]
            skills[(s["slot"], s["variant"])] = coins
        passives = [(p["name"], p["kind"] == "support") for p in con.execute(
            "select name, kind from passive where owner_type='identity' and owner_id=? and uptie=?", (identity_id, uptie))]
    return {"skills": skills, "passives": passives}
