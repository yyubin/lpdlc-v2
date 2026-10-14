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

# 원문(gesellschaft DB) → LPDL 컴파일. 결과: compiled/identity/{id}.lpdl + {id}.report.json
.venv/Scripts/lpdl compile 203 204                      # Claude Code 헤드리스 (claude -p, 로그인만 필요)
.venv/Scripts/lpdl compile 203 --backend api            # Anthropic API (ANTHROPIC_API_KEY), claude-opus-5-5
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
lpdl/source.py        gesellschaft DB → 컴파일 입력 원문
lpdl/prompt.py        컴파일 프롬프트 (어휘·해석 규칙·#202 예시)
lpdl/compiler.py      생성 → 검증 → 피드백 재생성 루프, 백엔드 (claude -p / Anthropic API)
lpdl/data/keywords.json  게임 키워드 이름 484개 (gesellschaft DB에서 추출)
examples/             손으로 검증한 spec
tests/
```
