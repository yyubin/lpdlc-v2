"""LPDL v2 — Limbus Persona Description Language."""
from pathlib import Path
from typing import Iterable

from . import ast
from .parser import LPDLSyntaxError, parse, parse_file
from .validate import Issue, Report, validate


def merge(docs: Iterable[ast.Document]) -> ast.Document:
    out = ast.Document()
    for d in docs:
        out.identities += d.identities
        out.keywords += d.keywords
    return out


def load(paths: Iterable[str | Path]) -> ast.Document:
    """여러 .lpdl 파일(디렉터리는 재귀)을 하나의 문서로 합친다. 키워드 정의는 파일 간에 공유된다."""
    files = []
    for p in map(Path, paths):
        files += sorted(p.rglob("*.lpdl")) if p.is_dir() else [p]
    return merge(parse_file(f) for f in files)


__all__ = ["ast", "Issue", "LPDLSyntaxError", "Report", "load", "merge", "parse", "parse_file", "validate"]
