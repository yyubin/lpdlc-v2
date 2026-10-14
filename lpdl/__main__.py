"""python -m lpdl check <파일|디렉터리>..."""
import argparse
import sys

from . import LPDLSyntaxError, load, validate


def main(argv=None) -> int:
    ap = argparse.ArgumentParser(prog="lpdl")
    sub = ap.add_subparsers(dest="cmd", required=True)
    c = sub.add_parser("check", help="구문 + 의미 검증")
    c.add_argument("paths", nargs="+")
    c.add_argument("--review", action="store_true", help="검수 항목(note/unparsed/hook)도 출력")
    a = ap.parse_args(argv)

    try:
        doc = load(a.paths)
    except LPDLSyntaxError as e:
        print(f"[syntax] {e}")
        return 2
    rep = validate(doc)
    for i in rep.issues:
        if i.level != "review" or a.review:
            print(i)
    n = {lv: len(rep.of(lv)) for lv in ("error", "warning", "review")}
    print(f"identity {len(doc.identities)} · keyword {len(doc.keywords)} — "
          f"error {n['error']} · warning {n['warning']} · review {n['review']}")
    return 0 if rep.ok else 1


if __name__ == "__main__":
    sys.exit(main())
