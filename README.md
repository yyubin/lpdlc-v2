# LPDL v2

림버스 컴퍼니 인격·키워드의 메커니즘을 기술하는 DSL. 파서(lark) + AST(Pydantic) + 의미 검증기.
gesellschaft 전투 엔진의 입력 형식으로 쓰인다.

- 설계와 v1 대비 변경점: [docs/design.md](docs/design.md)
- 기준 예시: [examples/identity/202.lpdl](examples/identity/202.lpdl) (료슈 · 오트쿠튀르::르누아르 신발관), [examples/keyword/renoir.lpdl](examples/keyword/renoir.lpdl)
- v1 (Java/ANTLR → MySQL/Neo4j): [legacy/](legacy/)

## 사용

```bash
python -m venv .venv && .venv/Scripts/python -m pip install -e ".[dev]"
.venv/Scripts/python -m lpdl check examples --review     # 구문 + 의미 검증, 검수 항목 출력
.venv/Scripts/python -m pytest -q
```

```python
from lpdl import load, validate
doc = load(["examples"])          # 디렉터리 재귀, 파일 간 키워드 정의 공유
report = validate(doc)
report.ok, report.of("review")
```

## 구조
```
lpdl/grammar.lark     문법
lpdl/parser.py        텍스트 → AST
lpdl/ast.py           AST 모델 (JSON 직렬화 가능)
lpdl/vocab.py         이벤트·modify 대상·함수 등 고정 어휘
lpdl/validate.py      의미 검증 (error / warning / review)
lpdl/data/keywords.json  게임 키워드 이름 484개 (gesellschaft DB에서 추출)
examples/             손으로 검증한 spec
tests/
```
