# LPDL Compiler

**LPDL (Limbus Persona Description Language)** - 림버스 컴퍼니 게임 데이터를 위한 선언적 DSL 컴파일러

## 목차

- [개요](#개요)
- [주요 기능](#주요-기능)
- [빠른 시작](#빠른-시작)
- [설치](#설치)
- [사용법](#사용법)
- [Neo4j 그래프 모델](#neo4j-그래프-모델)
- [기술 스택](#기술-스택)
- [문서](#문서)

---

## 개요

LPDL Compiler는 림버스 컴퍼니 게임의 인격(Persona), 스킬, 패시브 등을 선언적으로 기술하고 데이터베이스 쿼리로 변환하는 컴파일러입니다.

### 지원 데이터베이스

- **MySQL**
- **Neo4j**

### 컴파일 방식

**방식 1: LPDL → 데이터베이스 쿼리**
```
.lpdl 파일 → ANTLR Parser → MySQL SQL / Neo4j Cypher
```

**방식 2: 자연어 → LPDL → 데이터베이스 쿼리**
```
자연어 설명 → LLM (GPT-4) → LPDL → ANTLR Parser → 데이터베이스 쿼리
```

---

## 주요 기능

### LPDL → SQL 컴파일러
- ANTLR 기반 문법 검증
- JPA 엔티티와 1:1 매핑
- MySQL 호환 SQL 생성
- AUTO_INCREMENT 및 외래 키 자동 처리

### LPDL → Neo4j Cypher 컴파일러
- **완전한 DSL 매핑**: 모든 Persona, Skill, Passive 속성을 그래프로 변환
- **그래프 데이터베이스 최적화**: 노드와 관계 기반 구조
- **시너지 분석 지원**: Effect, Trigger, Action 노드를 통한 스킬 조합 추천
- **MERGE 최적화**: SinAffinity, StatusEffect, Trigger 등 공유 노드 중복 방지

#### 완전 매핑 지원
- Persona: resistance, speed, health, season
- Skill: sync stats (basePower, coinPower, coinCount, weight, level)
- Passive: trigger + action (자동 Effect 변환)
- Effect, Trigger, Action 전체 구조

### 자연어 → SQL 컴파일러
- LLM 기반 자연어 처리 (OpenAI GPT-4)
- 구문 오류 자동 재시도 및 피드백
- 대화형 모드 지원
- .env 파일 기반 API 키 관리

---

## 빠른 시작

### LPDL 파일 컴파일 (SQL + Cypher 동시 생성)

```bash
./gradlew run --args='example_honglu.lpdl output.sql'
# 생성 결과:
# ✓ output.sql (MySQL)
# ✓ output.cypher (Neo4j)
```

### 콘솔로 출력 확인

```bash
./gradlew run --args='test/test1.lpdl'
# === SQL ===
# INSERT INTO persona ...
#
# === Neo4j Cypher ===
# CREATE (p1:Persona {name: '...'})
# SET p1.resistance = ...
```

### 자연어로 SQL 생성

```bash
# API 키 설정
cp .env.example .env
# .env 파일에 OPENAI_API_KEY 입력

# 실행
./gradlew nlcompile -Pargs='"홍루 페르소나를 만들어줘. 등급은 3이야."'
```

---

## 설치

### 요구사항
- Java 21+
- Gradle 8.0+
- OpenAI API 키 (자연어 컴파일러 사용 시)

### 빌드

```bash
git clone <repository-url>
cd LPDLc
./gradlew build
```

### API 키 설정

```bash
cp .env.example .env
# .env 파일에서 OPENAI_API_KEY 설정
```

---

## 사용법

### LPDL 파일 컴파일

```bash
# 콘솔 출력 (SQL + Cypher 모두 출력)
./gradlew run --args='input.lpdl'

# 파일 저장 (SQL + Cypher 모두 생성)
./gradlew run --args='input.lpdl output.sql'
# 생성: output.sql, output.cypher
```

### 생성되는 파일

| 파일 | 형식 | 용도 |
|------|------|------|
| `output.sql` | MySQL | 관계형 DB 저장 |
| `output.cypher` | Neo4j | 그래프 DB 저장 및 추천 시스템 |

### Neo4j Cypher 구조

```cypher
# Persona 노드
CREATE (p1:Persona {name: '남부 세븐 협회 6과'})
SET p1.res_slash = 'NORMAL', p1.res_pierce = 'RESIST', p1.res_blunt = 'WEAK'
SET p1.min_speed = 4, p1.max_speed = 8
SET p1.base_health = 82, p1.growth_rate = 2.82, p1.disturbed_levels = [60, 30]

# Skill 노드
CREATE (s2:Skill {name: '플레쉬', skill_number: 1})
SET s2.base_power = 5, s2.coin_power = 7, s2.coin_count = 1

# Effect → Trigger → Action 체인
CREATE (eff7:Effect {name: '파열 부여'})
CREATE (eff7)-[:TRIGGERS_ON]->(trig8:Trigger {type: 'ON_HEAD_HIT'})
CREATE (eff7)-[:PERFORMS]->(act9:Action {type: 'APPLY', stat: 'RUPTURE', value: '+2'})

# Passive의 자동 Effect 변환
CREATE (passive50:Passive {name: '관찰'})
CREATE (passive50)-[:HAS_EFFECT]->(eff51:Effect)
CREATE (eff51)-[:PERFORMS]->(act54:Action {type: 'APPLY', target: 'TARGET'})
```

### 자연어 컴파일

```bash
# 파일 입력/출력
./gradlew nlcompile -Pargs='--input description.txt --output result.sql'

# 대화형 모드
./gradlew nlcompile -Pargs='--interactive'

# LPDL 중간 파일 저장
./gradlew nlcompile -Pargs='"..." --save-lpdl persona.lpdl --output result.sql'
```

### 주요 옵션

| 옵션 | 설명 |
|------|------|
| `-i, --input <file>` | 입력 파일 경로 |
| `-o, --output <file>` | 출력 파일 경로 |
| `--save-lpdl <file>` | 중간 LPDL 파일 저장 |
| `--max-retries <n>` | 최대 재시도 횟수 (기본: 3) |
| `-v, --verbose` | 상세 로그 출력 |
| `--interactive` | 대화형 모드 |

전체 옵션: `./gradlew nlcompile -Pargs='--help'`

---

## Neo4j 그래프 모델

### 노드 타입

| 노드 | 설명 | 주요 속성 |
|------|------|-----------|
| `Persona` | 인격 | name, sinner_id, grade, res_*, speed_*, health_* |
| `Skill` | 스킬 | name, category, sin, attack_type, base_power, coin_power |
| `Coin` | 코인 | number, type, description |
| `Passive` | 패시브 | name, kind, condition_type, condition_sin |
| `Effect` | 효과 | name, trigger |
| `Trigger` | 트리거 | type, name |
| `Action` | 액션 | type, target, stat, value |
| `SinAffinity` | 죄악 속성 | type, name |
| `StatusEffect` | 상태이상 | type, name |

### 관계 타입

```cypher
(Persona)-[:HAS_SKILL]->(Skill)
(Persona)-[:HAS_PASSIVE]->(Passive)
(Skill)-[:HAS_COIN]->(Coin)
(Skill)-[:USES_SIN]->(SinAffinity)
(Skill)-[:HAS_KEYWORD]->(StatusEffect)
(Skill)-[:HAS_EFFECT]->(Effect)
(Coin)-[:HAS_EFFECT]->(Effect)
(Passive)-[:HAS_EFFECT]->(Effect)
(Passive)-[:REQUIRES_SIN]->(SinAffinity)
(Effect)-[:TRIGGERS_ON]->(Trigger)
(Effect)-[:PERFORMS]->(Action)
(Action)-[:APPLIES]->(StatusEffect)
```

### 활용 예시: 시너지 쿼리

```cypher
// 파열(RUPTURE) 상태이상을 부여하는 모든 스킬 찾기
MATCH (s:Skill)-[:HAS_EFFECT]->(e:Effect)-[:PERFORMS]->(a:Action)
      -[:APPLIES]->(status:StatusEffect {type: 'RUPTURE'})
RETURN s.name, e.name, a.value

// 특정 죄악(GREED)을 사용하는 스킬들 찾기
MATCH (s:Skill)-[:USES_SIN]->(sin:SinAffinity {type: 'GREED'})
RETURN s.name, s.base_power

// 공명 조건이 있는 패시브와 필요한 죄악 찾기
MATCH (p:Passive)-[:REQUIRES_SIN]->(sin:SinAffinity)
WHERE p.condition_type = 'RESONATE'
RETURN p.name, sin.type, p.condition_count
```

---

## 기술 스택

### 핵심
- Java 21
- ANTLR 4
- Gradle

### 의존성
- OkHttp 4.12.0 - HTTP 클라이언트
- Gson 2.10.1 - JSON 파싱
- Picocli 4.7.5 - CLI 프레임워크
- Dotenv-java 3.0.0 - 환경 변수 관리
- JUnit 5 - 테스트

### 외부 서비스
- OpenAI GPT-4o - 자연어 처리 (선택)


