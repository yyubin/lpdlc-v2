// LPDL.g4
// 림버스 컴퍼니 전용 데이터 DSL 파서
// ANTLR 4 기반, Java 타겟

grammar LPDL;

// ─────────────────────────────────────────────────────────────────────────────
// PARSER RULES
// ─────────────────────────────────────────────────────────────────────────────

program
    : (personaDecl | deckDecl)* EOF
    ;

// ── PERSONA DECLARATION ─────────────────────────────────────────────────────
personaDecl
    : PERSONA stringLiteral personaBody
    ;

personaBody
    : LBRACE personaStmt* RBRACE
    ;

personaStmt
    : gradeStmt
    | sinnerStmt
    | sinStmt
    | releaseStmt
    | maxLevelStmt
    | defenseLevelStmt
    | resistanceStmt
    | speedStmt
    | healthStmt
    | seasonStmt
    | synergyBlock
    | skillDecl
    | passiveDecl
    | imageDecl
    | metaStmt
    ;

// grade 3 또는 3★
gradeStmt
    : GRADE gradeValue
    ;

gradeValue
    : INT STAR?
    | IDENT
    ;

// sin WRATH
sinStmt
    : SIN sinAffinityType
    ;

sinAffinityType
    : WRATH | LUST | SLOTH | GREED | GLOOM | PRIDE | ENVY
    ;

// release "2023-05-15"
releaseStmt
    : RELEASE stringLiteral
    ;

// maxLevel 60
maxLevelStmt
    : MAXLEVEL INT
    ;

// defenseLevel 5
defenseLevelStmt
    : DEFENSELEVEL INT
    ;

// sinner "홍루" 또는 sinner HONGLU
sinnerStmt
    : SINNER (stringLiteral | IDENT)
    ;

// resistance { slash WEAK, pierce NORMAL, blunt RESIST }
resistanceStmt
    : RESISTANCE LBRACE resistancePair (COMMA resistancePair)* RBRACE
    ;

resistancePair
    : IDENT IDENT  // slash WEAK
    ;

// speed { min 3, max 5 }
speedStmt
    : SPEED LBRACE speedPair (COMMA speedPair)* RBRACE
    ;

speedPair
    : IDENT INT  // min 3, max 5
    ;

// health { base 80, growth 7.5, disturbed [30, 50, 70] }
healthStmt
    : HEALTH LBRACE healthField (COMMA healthField)* RBRACE
    ;

healthField
    : BASE INT
    | GROWTH numberLiteral
    | DISTURBED LBRACK INT (COMMA INT)* RBRACK
    ;

// season { type BATTLE_PASS, number 4 }
seasonStmt
    : SEASON LBRACE seasonField (COMMA seasonField)* RBRACE
    ;

seasonField
    : TYPE IDENT
    | NUMBER INT
    ;

// image { type ICON, url "...", priority 1, primary true }
imageDecl
    : IMAGE LBRACE imageField (COMMA imageField)* RBRACE
    ;

imageField
    : TYPE IDENT
    | URL stringLiteral
    | PRIORITY INT
    | PRIMARY booleanLiteral
    ;

// meta { key: "v1", version: 1 }
metaStmt
    : META objectLiteral
    ;

// synergy { with "히스클리프" boost BLEED +3.5 }
synergyBlock
    : SYNERGY LBRACE synergyStmt* RBRACE
    ;

synergyStmt
    : WITH (stringLiteral | IDENT) synergyDetail+
    ;

synergyDetail
    : BOOST IDENT additiveExpr?          // boost BLEED +3.5
    | SUPPORT IDENT additiveExpr?        // support CHARGE +1.2
    | TYPE IDENT                         // type BLEED_CHAIN
    | VALUE additiveExpr                 // value 4.5
    ;

// ── SKILL DECLARATION ───────────────────────────────────────────────────────
skillDecl
    : SKILL INT stringLiteral? skillBody
    ;

skillBody
    : LBRACE skillStmt* RBRACE
    ;

skillStmt
    : categoryStmt
    | skillSinStmt
    | attackStmt
    | defenseStmt
    | quantityStmt
    | keywordStmt
    | imageStmt
    | textDecl
    | syncDecl
    ;

categoryStmt : CATEGORY IDENT ;
skillSinStmt : SIN sinAffinityType ;
attackStmt   : ATTACK IDENT ;
defenseStmt  : DEFENSE IDENT ;
quantityStmt : QUANTITY INT ;
keywordStmt  : KEYWORD IDENT ;
imageStmt    : IMAGE (IDENT | NONE | stringLiteral) ;

// ── SYNC LEVEL (SYNC_1 ~ SYNC_4) ───────────────────────────────────────────
syncDecl
    : SYNC syncLevel syncBody
    ;

syncLevel
    : IDENT          // SYNC_1, SYNC_4 등
    | STRING         // "SYNC_4" 문자열도 허용
    ;

syncBody
    : LBRACE syncStmt* RBRACE
    ;

syncStmt
    : basePowerStmt
    | coinPowerStmt
    | coinCountStmt
    | weightStmt
    | levelStmt
    | effectDecl
    | coinDecl
    ;

basePowerStmt : BASEPOWER INT ;
coinPowerStmt : COINPOWER INT ;
coinCountStmt : COINCOUNT INT ;
weightStmt    : WEIGHT INT ;
levelStmt     : LEVEL INT ;

// ── EFFECT DECLARATION ──────────────────────────────────────────────────────
effectDecl
    : EFFECT effectHeader? effectBody
    ;

effectHeader
    : stringLiteral
    | STRING
    ;

effectBody
    : LBRACE effectStmt* RBRACE
    ;

effectStmt
    : textDecl
    | triggerStmt
    | whenStmt
    | branchBlock
    | ACTION actionClause
    | actionSimple
    ;

triggerStmt
    : TRIGGER IDENT
    ;

// when 조건 (재귀적)
whenStmt
    : WHEN conditionExpr
    ;

// 분기 블록
branchBlock
    : BRANCH LBRACE branchStmt* RBRACE
    ;

branchStmt
    : orderStmt
    | stopOnMatchStmt
    | whenStmt
    | ACTION actionClause
    | actionSimple
    ;

orderStmt        : ORDER INT ;
stopOnMatchStmt  : STOPONMATCH booleanLiteral ;

// ── COIN DECLARATION ────────────────────────────────────────────────────────
// IMPORTANT: coin은 반드시 text와 effect를 모두 포함해야 함
coinDecl
    : COIN INT IDENT coinBody
    ;

coinBody
    : LBRACE textDecl effectInlineDecl+ RBRACE
    ;

// 참고: coinStmt는 더 이상 사용하지 않음 (text와 effect를 직접 명시)

effectInlineDecl
    : EFFECT effectInlineHeader? effectBody
    ;

effectInlineHeader
    : stringLiteral
    ;

// ── PASSIVE DECLARATION ─────────────────────────────────────────────────────
passiveDecl
    : PASSIVE IDENT stringLiteral? passiveBody
    ;

passiveBody
    : LBRACE passiveStmt* RBRACE
    ;

passiveStmt
    : triggerStmt
    | whenStmt
    | ACTION actionClause
    | actionSimple
    | branchBlock
    | textDecl
    | passiveConditionStmt
    | passiveSyncLevelStmt
    ;

// condition HOLD sin WRATH count 3
passiveConditionStmt
    : CONDITION IDENT SIN sinAffinityType (COUNT INT)?
    ;

// syncLevel SYNC_3
passiveSyncLevelStmt
    : SYNCLEVEL IDENT
    ;

// ── ACTION STATEMENT ────────────────────────────────────────────────────────
actionStmt
    : ACTION actionClause
    | actionSimple
    ;

// ACTION SELF APPLY HP_HEAL ADD (damage * 0.5) capped 850
actionClause
    : targetSpec? verbSpec actionDetail
    ;

// 간소화된 액션: SELF APPLY BLEED +2 nextTurn true cap 3
actionSimple
    : targetSpec? APPLY statSpec policySpec? additiveExpr actionOptions*
    | targetSpec? REMOVE statSpec additiveExpr? actionOptions*
    | MODIFY (POWER | DAMAGE) additiveExpr actionOptions*
    ;

targetSpec
    : SELF
    | TARGET
    | ALLY
    | ENEMY
    | ALL_ALLIES
    | ALL_ENEMIES
    | SELF_ALLY
    | ANY
    | RIGHT_ALLY
    | LEFT_ALLY
    | LOWEST_HP_ALLY
    | HIGHEST_RESONANCE
    ;

verbSpec
    : APPLY statSpec policySpec? valueSpec
    | REMOVE statSpec
    | MODIFY (POWER | DAMAGE) valueSpec
    ;

policySpec : IDENT ;  // ADD, SET, MULTIPLY (POLICY 키워드 제거)
statSpec   : IDENT ;  // BLEED, CHARGE, HP_HEAL 등
valueSpec  : expr ;

actionDetail
    : actionOptions*
    ;

actionOptions
    : CAPPED additiveExpr
    | CAP additiveExpr
    | PERTURN additiveExpr
    | NEXTTURN booleanLiteral
    | DURATION additiveExpr
    | SCOPE targetSpec
    | PRIORITY INT
    | UNIT unitType
    | TIMING timingType
    | SELECT selectorType (FROM targetSpec)?
    | COINS coinSelectorType
    ;

unitType
    : IDENT  // STACK, FLAT, PERCENT, PERCENT_OF_MAX_HP, PERCENT_OF_DAMAGE, PER_N, PER_3, PER_10, UNITLESS
    ;

timingType
    : IDENT  // IMMEDIATE, THIS_TURN, NEXT_TURN, TURN_END, NEXT_COIN, ATTACK_END
    ;

selectorType
    : IDENT  // ALL, RANDOM, HIGHEST, LOWEST, FASTEST, SLOWEST, FIRST, LAST
    ;

coinSelectorType
    : IDENT  // ALL, FIRST, LAST, INDEX, CURRENT
    ;

// ── CONDITION EXPRESSION (재귀적, 우선순위: NOT > AND > OR) ───────────────
conditionExpr : conditionOr ;

conditionOr
    : conditionAnd (OR conditionAnd)*
    ;

conditionAnd
    : conditionNot (AND conditionNot)*
    ;

conditionNot
    : NOT conditionNot
    | conditionAtom
    ;

conditionAtom
    : LPAREN conditionExpr RPAREN
    | comparison
    | rangeCheck
    | divisibilityCheck
    | tagCheck
    | statusCheck
    | presenceCheck
    ;

comparison
    : side comparator side
    ;

// 범위 체크: 5 <= self.HP < 10 또는 self.HP in 5..10
rangeCheck
    : side IN side DOTDOT side           // self.HP in 5..10
    | side IN LBRACK side COMMA side RBRACK  // self.HP in [5, 10]
    ;

// 나누어떨어짐: self.CHARGE divisible_by 5
divisibilityCheck
    : side DIVISIBLE_BY side
    ;

// 태그 보유: target has_tag "BOSS"
tagCheck
    : side HAS_TAG (stringLiteral | IDENT)
    ;

// 상태 이상 보유: target has_status STUNNED
statusCheck
    : side HAS_STATUS IDENT
    ;

presenceCheck
    : side  // IS_DEAD, HAS_BUFF 등 boolean 상태
    ;

side
    : sidePrefix DOT sideCore
    | sideCore
    ;

sidePrefix
    : SELF
    | TARGET
    | ALLY
    | ENEMY
    | ALL_ALLIES
    | ALL_ENEMIES
    | SELF_ALLY
    | ANY
    | RIGHT_ALLY
    | LEFT_ALLY
    | LOWEST_HP_ALLY
    | HIGHEST_RESONANCE
    ;

sideCore
    : IDENT
    | numberLiteral
    ;

comparator
    : EQ | NEQ | GT | GTE | LT | LTE
    ;

// ── EXPRESSION (수식) ───────────────────────────────────────────────────────
expr : additiveExpr ;

additiveExpr
    : multiplicativeExpr ( (PLUS | MINUS) multiplicativeExpr )*
    ;

multiplicativeExpr
    : unaryExpr ( (MUL | DIV) unaryExpr )*
    ;

unaryExpr
    : (PLUS | MINUS) unaryExpr
    | primaryExpr
    ;

primaryExpr
    : numberLiteral
    | side
    | LPAREN expr RPAREN
    ;

// ── DECK (7인 조합) ─────────────────────────────────────────────────────────
deckDecl
    : DECK stringLiteral deckBody
    ;

deckBody
    : LBRACE deckStmt* RBRACE
    ;

deckStmt
    : personasBlock
    | synergyBlock
    | metaStmt
    ;

personasBlock
    : PERSONAS LBRACE personasStmt* RBRACE
    ;

personasStmt
    : ADD (stringLiteral | IDENT)
    ;

// ── OBJECT LITERAL (meta 등) ───────────────────────────────────────────────
objectLiteral
    : LBRACE objectPair (COMMA objectPair)* RBRACE
    ;

objectPair
    : IDENT COLON expr
    ;

// ── LITERALS ────────────────────────────────────────────────────────────────
booleanLiteral
    : TRUE
    | FALSE
    ;

numberLiteral
    : FLOAT
    | INT
    ;

stringLiteral
    : STRING
    ;

tripleStringLiteral
    : TRIPLE_STRING
    ;

// ── TEXT DECLARATION (원본 텍스트) ──────────────────────────────────────────
textDecl
    : TEXT tripleStringLiteral
    ;

// ─────────────────────────────────────────────────────────────────────────────
// LEXER RULES
// ─────────────────────────────────────────────────────────────────────────────

PERSONA     : 'persona' ;
DECK        : 'deck' ;
PERSONAS    : 'personas' ;
ADD         : 'add' ;
GRADE       : 'grade' ;
SINNER      : 'sinner' ;
SIN         : 'sin' ;
RELEASE      : 'release' ;
MAXLEVEL     : 'maxLevel' ;
DEFENSELEVEL : 'defenseLevel' ;
RESISTANCE   : 'resistance' ;
SPEED       : 'speed' ;
HEALTH      : 'health' ;
BASE        : 'base' ;
GROWTH      : 'growth' ;
DISTURBED   : 'disturbed' ;
SEASON      : 'season' ;
NUMBER      : 'number' ;
URL         : 'url' ;
PRIMARY     : 'primary' ;
META        : 'meta' ;
SYNERGY     : 'synergy' ;
WITH        : 'with' ;
BOOST       : 'boost' ;
SUPPORT     : 'support' ;
TYPE        : 'type' ;
TEXT        : 'text' ;
VALUE       : 'value' ;
SKILL       : 'skill' ;
CATEGORY    : 'category' ;
ATTACK      : 'attack' ;
DEFENSE     : 'defense' ;
QUANTITY    : 'quantity' ;
KEYWORD     : 'keyword' ;
IMAGE       : 'image' ;
NONE        : 'none' ;
SYNC        : 'sync' ;
BASEPOWER   : 'basePower' ;
COINPOWER   : 'coinPower' ;
COINCOUNT   : 'coinCount' ;
WEIGHT      : 'weight' ;
LEVEL       : 'level' ;
EFFECT      : 'effect' ;
TRIGGER     : 'trigger' ;
WHEN        : 'when' ;
BRANCH      : 'branch' ;
ORDER       : 'order' ;
STOPONMATCH : 'stopOnMatch' ;
COIN        : 'coin' ;
PASSIVE     : 'passive' ;
CONDITION   : 'condition' ;
COUNT       : 'count' ;
SYNCLEVEL   : 'syncLevel' ;
ACTION      : 'action' ;
APPLY       : 'apply' ;
REMOVE      : 'remove' ;
MODIFY      : 'modify' ;
POWER       : 'power' ;
DAMAGE      : 'damage' ;
POLICY      : 'policy' ;
CAPPED      : 'capped' ;
CAP         : 'cap' ;
PERTURN     : 'perTurn' ;
NEXTTURN    : 'nextTurn' ;
DURATION    : 'duration' ;
SCOPE       : 'scope' ;
PRIORITY    : 'priority' ;
UNIT        : 'unit' ;
TIMING      : 'timing' ;
SELECT      : 'select' ;
FROM        : 'from' ;
COINS       : 'coins' ;

// Target keywords
SELF               : 'self' ;
TARGET             : 'target' ;
ALLY               : 'ally' ;
ENEMY              : 'enemy' ;
ALL_ALLIES         : 'all_allies' ;
ALL_ENEMIES        : 'all_enemies' ;
SELF_ALLY          : 'self_ally' ;
ANY                : 'any' ;
RIGHT_ALLY         : 'right_ally' ;
LEFT_ALLY          : 'left_ally' ;
LOWEST_HP_ALLY     : 'lowest_hp_ally' ;
HIGHEST_RESONANCE  : 'highest_resonance' ;

// Operators
EQ           : '==' ;
NEQ          : '!=' ;
GTE          : '>=' ;
LTE          : '<=' ;
GT           : '>' ;
LT           : '<' ;
AND          : 'AND' ;
OR           : 'OR' ;
NOT          : 'NOT' ;
IN           : 'in' ;
DIVISIBLE_BY : 'divisible_by' ;
HAS_TAG      : 'has_tag' ;
HAS_STATUS   : 'has_status' ;
PLUS         : '+' ;
MINUS        : '-' ;
MUL          : '*' ;
DIV          : '/' ;

// Delimiters
LBRACE : '{' ;
RBRACE : '}' ;
LPAREN : '(' ;
RPAREN : ')' ;
LBRACK : '[' ;
RBRACK : ']' ;
STAR   : '★' ;
COMMA  : ',' ;
COLON  : ':' ;
DOT    : '.' ;
DOTDOT : '..' ;

// Literals
fragment DIGIT : [0-9] ;
INT    : DIGIT+ ;
FLOAT  : DIGIT+ '.' DIGIT+ ;

TRUE  : 'true' ;
FALSE : 'false' ;

STRING
    : '"' ( '\\' . | ~["\\\r\n] )* '"'
    ;

TRIPLE_STRING
    : '"""' ( '\\' . | ~["\\] )*? '"""'
    ;

// Sin Affinity Enum
WRATH  : 'WRATH' ;
LUST   : 'LUST' ;
SLOTH  : 'SLOTH' ;
GREED  : 'GREED' ;
GLOOM  : 'GLOOM' ;
PRIDE  : 'PRIDE' ;
ENVY   : 'ENVY' ;

// 식별자 (영문 + 숫자 + _)
// 한글 지원은 임시로 비활성화 (ATN 크기 문제)
IDENT
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

// Whitespace & Comments
WS
    : [ \t\r\n\u000C]+ -> channel(HIDDEN)
    ;

LINE_COMMENT
    : '//' ~[\r\n]* -> channel(HIDDEN)
    ;

BLOCK_COMMENT
    : '/*' .*? '*/' -> channel(HIDDEN)
    ;