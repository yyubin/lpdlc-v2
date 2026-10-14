// Generated from LPDL.g4 by ANTLR 4.13.1
package org.yyubin.lpdl.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LPDLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PERSONA=1, DECK=2, PERSONAS=3, ADD=4, GRADE=5, SINNER=6, SIN=7, RELEASE=8, 
		MAXLEVEL=9, DEFENSELEVEL=10, RESISTANCE=11, SPEED=12, HEALTH=13, BASE=14, 
		GROWTH=15, DISTURBED=16, SEASON=17, NUMBER=18, URL=19, PRIMARY=20, META=21, 
		SYNERGY=22, WITH=23, BOOST=24, SUPPORT=25, TYPE=26, TEXT=27, VALUE=28, 
		SKILL=29, CATEGORY=30, ATTACK=31, DEFENSE=32, QUANTITY=33, KEYWORD=34, 
		IMAGE=35, NONE=36, SYNC=37, BASEPOWER=38, COINPOWER=39, COINCOUNT=40, 
		WEIGHT=41, LEVEL=42, EFFECT=43, TRIGGER=44, WHEN=45, BRANCH=46, ORDER=47, 
		STOPONMATCH=48, COIN=49, PASSIVE=50, CONDITION=51, COUNT=52, SYNCLEVEL=53, 
		ACTION=54, APPLY=55, REMOVE=56, MODIFY=57, POWER=58, DAMAGE=59, POLICY=60, 
		CAPPED=61, CAP=62, PERTURN=63, NEXTTURN=64, DURATION=65, SCOPE=66, PRIORITY=67, 
		UNIT=68, TIMING=69, SELECT=70, FROM=71, COINS=72, SELF=73, TARGET=74, 
		ALLY=75, ENEMY=76, ALL_ALLIES=77, ALL_ENEMIES=78, SELF_ALLY=79, ANY=80, 
		RIGHT_ALLY=81, LEFT_ALLY=82, LOWEST_HP_ALLY=83, HIGHEST_RESONANCE=84, 
		EQ=85, NEQ=86, GTE=87, LTE=88, GT=89, LT=90, AND=91, OR=92, NOT=93, IN=94, 
		DIVISIBLE_BY=95, HAS_TAG=96, HAS_STATUS=97, PLUS=98, MINUS=99, MUL=100, 
		DIV=101, LBRACE=102, RBRACE=103, LPAREN=104, RPAREN=105, LBRACK=106, RBRACK=107, 
		STAR=108, COMMA=109, COLON=110, DOT=111, DOTDOT=112, INT=113, FLOAT=114, 
		TRUE=115, FALSE=116, STRING=117, TRIPLE_STRING=118, WRATH=119, LUST=120, 
		SLOTH=121, GREED=122, GLOOM=123, PRIDE=124, ENVY=125, IDENT=126, WS=127, 
		LINE_COMMENT=128, BLOCK_COMMENT=129;
	public static final int
		RULE_program = 0, RULE_personaDecl = 1, RULE_personaBody = 2, RULE_personaStmt = 3, 
		RULE_gradeStmt = 4, RULE_gradeValue = 5, RULE_sinStmt = 6, RULE_sinAffinityType = 7, 
		RULE_releaseStmt = 8, RULE_maxLevelStmt = 9, RULE_defenseLevelStmt = 10, 
		RULE_sinnerStmt = 11, RULE_resistanceStmt = 12, RULE_resistancePair = 13, 
		RULE_speedStmt = 14, RULE_speedPair = 15, RULE_healthStmt = 16, RULE_healthField = 17, 
		RULE_seasonStmt = 18, RULE_seasonField = 19, RULE_imageDecl = 20, RULE_imageField = 21, 
		RULE_metaStmt = 22, RULE_synergyBlock = 23, RULE_synergyStmt = 24, RULE_synergyDetail = 25, 
		RULE_skillDecl = 26, RULE_skillBody = 27, RULE_skillStmt = 28, RULE_categoryStmt = 29, 
		RULE_skillSinStmt = 30, RULE_attackStmt = 31, RULE_defenseStmt = 32, RULE_quantityStmt = 33, 
		RULE_keywordStmt = 34, RULE_imageStmt = 35, RULE_syncDecl = 36, RULE_syncLevel = 37, 
		RULE_syncBody = 38, RULE_syncStmt = 39, RULE_basePowerStmt = 40, RULE_coinPowerStmt = 41, 
		RULE_coinCountStmt = 42, RULE_weightStmt = 43, RULE_levelStmt = 44, RULE_effectDecl = 45, 
		RULE_effectHeader = 46, RULE_effectBody = 47, RULE_effectStmt = 48, RULE_triggerStmt = 49, 
		RULE_whenStmt = 50, RULE_branchBlock = 51, RULE_branchStmt = 52, RULE_orderStmt = 53, 
		RULE_stopOnMatchStmt = 54, RULE_coinDecl = 55, RULE_coinBody = 56, RULE_effectInlineDecl = 57, 
		RULE_effectInlineHeader = 58, RULE_passiveDecl = 59, RULE_passiveBody = 60, 
		RULE_passiveStmt = 61, RULE_passiveConditionStmt = 62, RULE_passiveSyncLevelStmt = 63, 
		RULE_actionStmt = 64, RULE_actionClause = 65, RULE_actionSimple = 66, 
		RULE_targetSpec = 67, RULE_verbSpec = 68, RULE_policySpec = 69, RULE_statSpec = 70, 
		RULE_valueSpec = 71, RULE_actionDetail = 72, RULE_actionOptions = 73, 
		RULE_unitType = 74, RULE_timingType = 75, RULE_selectorType = 76, RULE_coinSelectorType = 77, 
		RULE_conditionExpr = 78, RULE_conditionOr = 79, RULE_conditionAnd = 80, 
		RULE_conditionNot = 81, RULE_conditionAtom = 82, RULE_comparison = 83, 
		RULE_rangeCheck = 84, RULE_divisibilityCheck = 85, RULE_tagCheck = 86, 
		RULE_statusCheck = 87, RULE_presenceCheck = 88, RULE_side = 89, RULE_sidePrefix = 90, 
		RULE_sideCore = 91, RULE_comparator = 92, RULE_expr = 93, RULE_additiveExpr = 94, 
		RULE_multiplicativeExpr = 95, RULE_unaryExpr = 96, RULE_primaryExpr = 97, 
		RULE_deckDecl = 98, RULE_deckBody = 99, RULE_deckStmt = 100, RULE_personasBlock = 101, 
		RULE_personasStmt = 102, RULE_objectLiteral = 103, RULE_objectPair = 104, 
		RULE_booleanLiteral = 105, RULE_numberLiteral = 106, RULE_stringLiteral = 107, 
		RULE_tripleStringLiteral = 108, RULE_textDecl = 109;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "personaDecl", "personaBody", "personaStmt", "gradeStmt", 
			"gradeValue", "sinStmt", "sinAffinityType", "releaseStmt", "maxLevelStmt", 
			"defenseLevelStmt", "sinnerStmt", "resistanceStmt", "resistancePair", 
			"speedStmt", "speedPair", "healthStmt", "healthField", "seasonStmt", 
			"seasonField", "imageDecl", "imageField", "metaStmt", "synergyBlock", 
			"synergyStmt", "synergyDetail", "skillDecl", "skillBody", "skillStmt", 
			"categoryStmt", "skillSinStmt", "attackStmt", "defenseStmt", "quantityStmt", 
			"keywordStmt", "imageStmt", "syncDecl", "syncLevel", "syncBody", "syncStmt", 
			"basePowerStmt", "coinPowerStmt", "coinCountStmt", "weightStmt", "levelStmt", 
			"effectDecl", "effectHeader", "effectBody", "effectStmt", "triggerStmt", 
			"whenStmt", "branchBlock", "branchStmt", "orderStmt", "stopOnMatchStmt", 
			"coinDecl", "coinBody", "effectInlineDecl", "effectInlineHeader", "passiveDecl", 
			"passiveBody", "passiveStmt", "passiveConditionStmt", "passiveSyncLevelStmt", 
			"actionStmt", "actionClause", "actionSimple", "targetSpec", "verbSpec", 
			"policySpec", "statSpec", "valueSpec", "actionDetail", "actionOptions", 
			"unitType", "timingType", "selectorType", "coinSelectorType", "conditionExpr", 
			"conditionOr", "conditionAnd", "conditionNot", "conditionAtom", "comparison", 
			"rangeCheck", "divisibilityCheck", "tagCheck", "statusCheck", "presenceCheck", 
			"side", "sidePrefix", "sideCore", "comparator", "expr", "additiveExpr", 
			"multiplicativeExpr", "unaryExpr", "primaryExpr", "deckDecl", "deckBody", 
			"deckStmt", "personasBlock", "personasStmt", "objectLiteral", "objectPair", 
			"booleanLiteral", "numberLiteral", "stringLiteral", "tripleStringLiteral", 
			"textDecl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'persona'", "'deck'", "'personas'", "'add'", "'grade'", "'sinner'", 
			"'sin'", "'release'", "'maxLevel'", "'defenseLevel'", "'resistance'", 
			"'speed'", "'health'", "'base'", "'growth'", "'disturbed'", "'season'", 
			"'number'", "'url'", "'primary'", "'meta'", "'synergy'", "'with'", "'boost'", 
			"'support'", "'type'", "'text'", "'value'", "'skill'", "'category'", 
			"'attack'", "'defense'", "'quantity'", "'keyword'", "'image'", "'none'", 
			"'sync'", "'basePower'", "'coinPower'", "'coinCount'", "'weight'", "'level'", 
			"'effect'", "'trigger'", "'when'", "'branch'", "'order'", "'stopOnMatch'", 
			"'coin'", "'passive'", "'condition'", "'count'", "'syncLevel'", "'action'", 
			"'apply'", "'remove'", "'modify'", "'power'", "'damage'", "'policy'", 
			"'capped'", "'cap'", "'perTurn'", "'nextTurn'", "'duration'", "'scope'", 
			"'priority'", "'unit'", "'timing'", "'select'", "'from'", "'coins'", 
			"'self'", "'target'", "'ally'", "'enemy'", "'all_allies'", "'all_enemies'", 
			"'self_ally'", "'any'", "'right_ally'", "'left_ally'", "'lowest_hp_ally'", 
			"'highest_resonance'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", 
			"'AND'", "'OR'", "'NOT'", "'in'", "'divisible_by'", "'has_tag'", "'has_status'", 
			"'+'", "'-'", "'*'", "'/'", "'{'", "'}'", "'('", "')'", "'['", "']'", 
			"'\\u2605'", "','", "':'", "'.'", "'..'", null, null, "'true'", "'false'", 
			null, null, "'WRATH'", "'LUST'", "'SLOTH'", "'GREED'", "'GLOOM'", "'PRIDE'", 
			"'ENVY'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PERSONA", "DECK", "PERSONAS", "ADD", "GRADE", "SINNER", "SIN", 
			"RELEASE", "MAXLEVEL", "DEFENSELEVEL", "RESISTANCE", "SPEED", "HEALTH", 
			"BASE", "GROWTH", "DISTURBED", "SEASON", "NUMBER", "URL", "PRIMARY", 
			"META", "SYNERGY", "WITH", "BOOST", "SUPPORT", "TYPE", "TEXT", "VALUE", 
			"SKILL", "CATEGORY", "ATTACK", "DEFENSE", "QUANTITY", "KEYWORD", "IMAGE", 
			"NONE", "SYNC", "BASEPOWER", "COINPOWER", "COINCOUNT", "WEIGHT", "LEVEL", 
			"EFFECT", "TRIGGER", "WHEN", "BRANCH", "ORDER", "STOPONMATCH", "COIN", 
			"PASSIVE", "CONDITION", "COUNT", "SYNCLEVEL", "ACTION", "APPLY", "REMOVE", 
			"MODIFY", "POWER", "DAMAGE", "POLICY", "CAPPED", "CAP", "PERTURN", "NEXTTURN", 
			"DURATION", "SCOPE", "PRIORITY", "UNIT", "TIMING", "SELECT", "FROM", 
			"COINS", "SELF", "TARGET", "ALLY", "ENEMY", "ALL_ALLIES", "ALL_ENEMIES", 
			"SELF_ALLY", "ANY", "RIGHT_ALLY", "LEFT_ALLY", "LOWEST_HP_ALLY", "HIGHEST_RESONANCE", 
			"EQ", "NEQ", "GTE", "LTE", "GT", "LT", "AND", "OR", "NOT", "IN", "DIVISIBLE_BY", 
			"HAS_TAG", "HAS_STATUS", "PLUS", "MINUS", "MUL", "DIV", "LBRACE", "RBRACE", 
			"LPAREN", "RPAREN", "LBRACK", "RBRACK", "STAR", "COMMA", "COLON", "DOT", 
			"DOTDOT", "INT", "FLOAT", "TRUE", "FALSE", "STRING", "TRIPLE_STRING", 
			"WRATH", "LUST", "SLOTH", "GREED", "GLOOM", "PRIDE", "ENVY", "IDENT", 
			"WS", "LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LPDL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LPDLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LPDLParser.EOF, 0); }
		public List<PersonaDeclContext> personaDecl() {
			return getRuleContexts(PersonaDeclContext.class);
		}
		public PersonaDeclContext personaDecl(int i) {
			return getRuleContext(PersonaDeclContext.class,i);
		}
		public List<DeckDeclContext> deckDecl() {
			return getRuleContexts(DeckDeclContext.class);
		}
		public DeckDeclContext deckDecl(int i) {
			return getRuleContext(DeckDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PERSONA || _la==DECK) {
				{
				setState(222);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PERSONA:
					{
					setState(220);
					personaDecl();
					}
					break;
				case DECK:
					{
					setState(221);
					deckDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PersonaDeclContext extends ParserRuleContext {
		public TerminalNode PERSONA() { return getToken(LPDLParser.PERSONA, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public PersonaBodyContext personaBody() {
			return getRuleContext(PersonaBodyContext.class,0);
		}
		public PersonaDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_personaDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPersonaDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPersonaDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPersonaDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PersonaDeclContext personaDecl() throws RecognitionException {
		PersonaDeclContext _localctx = new PersonaDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_personaDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(PERSONA);
			setState(230);
			stringLiteral();
			setState(231);
			personaBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PersonaBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<PersonaStmtContext> personaStmt() {
			return getRuleContexts(PersonaStmtContext.class);
		}
		public PersonaStmtContext personaStmt(int i) {
			return getRuleContext(PersonaStmtContext.class,i);
		}
		public PersonaBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_personaBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPersonaBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPersonaBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPersonaBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PersonaBodyContext personaBody() throws RecognitionException {
		PersonaBodyContext _localctx = new PersonaBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_personaBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(LBRACE);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125934809890784L) != 0)) {
				{
				{
				setState(234);
				personaStmt();
				}
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(240);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PersonaStmtContext extends ParserRuleContext {
		public GradeStmtContext gradeStmt() {
			return getRuleContext(GradeStmtContext.class,0);
		}
		public SinnerStmtContext sinnerStmt() {
			return getRuleContext(SinnerStmtContext.class,0);
		}
		public SinStmtContext sinStmt() {
			return getRuleContext(SinStmtContext.class,0);
		}
		public ReleaseStmtContext releaseStmt() {
			return getRuleContext(ReleaseStmtContext.class,0);
		}
		public MaxLevelStmtContext maxLevelStmt() {
			return getRuleContext(MaxLevelStmtContext.class,0);
		}
		public DefenseLevelStmtContext defenseLevelStmt() {
			return getRuleContext(DefenseLevelStmtContext.class,0);
		}
		public ResistanceStmtContext resistanceStmt() {
			return getRuleContext(ResistanceStmtContext.class,0);
		}
		public SpeedStmtContext speedStmt() {
			return getRuleContext(SpeedStmtContext.class,0);
		}
		public HealthStmtContext healthStmt() {
			return getRuleContext(HealthStmtContext.class,0);
		}
		public SeasonStmtContext seasonStmt() {
			return getRuleContext(SeasonStmtContext.class,0);
		}
		public SynergyBlockContext synergyBlock() {
			return getRuleContext(SynergyBlockContext.class,0);
		}
		public SkillDeclContext skillDecl() {
			return getRuleContext(SkillDeclContext.class,0);
		}
		public PassiveDeclContext passiveDecl() {
			return getRuleContext(PassiveDeclContext.class,0);
		}
		public ImageDeclContext imageDecl() {
			return getRuleContext(ImageDeclContext.class,0);
		}
		public MetaStmtContext metaStmt() {
			return getRuleContext(MetaStmtContext.class,0);
		}
		public PersonaStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_personaStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPersonaStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPersonaStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPersonaStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PersonaStmtContext personaStmt() throws RecognitionException {
		PersonaStmtContext _localctx = new PersonaStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_personaStmt);
		try {
			setState(257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GRADE:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				gradeStmt();
				}
				break;
			case SINNER:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				sinnerStmt();
				}
				break;
			case SIN:
				enterOuterAlt(_localctx, 3);
				{
				setState(244);
				sinStmt();
				}
				break;
			case RELEASE:
				enterOuterAlt(_localctx, 4);
				{
				setState(245);
				releaseStmt();
				}
				break;
			case MAXLEVEL:
				enterOuterAlt(_localctx, 5);
				{
				setState(246);
				maxLevelStmt();
				}
				break;
			case DEFENSELEVEL:
				enterOuterAlt(_localctx, 6);
				{
				setState(247);
				defenseLevelStmt();
				}
				break;
			case RESISTANCE:
				enterOuterAlt(_localctx, 7);
				{
				setState(248);
				resistanceStmt();
				}
				break;
			case SPEED:
				enterOuterAlt(_localctx, 8);
				{
				setState(249);
				speedStmt();
				}
				break;
			case HEALTH:
				enterOuterAlt(_localctx, 9);
				{
				setState(250);
				healthStmt();
				}
				break;
			case SEASON:
				enterOuterAlt(_localctx, 10);
				{
				setState(251);
				seasonStmt();
				}
				break;
			case SYNERGY:
				enterOuterAlt(_localctx, 11);
				{
				setState(252);
				synergyBlock();
				}
				break;
			case SKILL:
				enterOuterAlt(_localctx, 12);
				{
				setState(253);
				skillDecl();
				}
				break;
			case PASSIVE:
				enterOuterAlt(_localctx, 13);
				{
				setState(254);
				passiveDecl();
				}
				break;
			case IMAGE:
				enterOuterAlt(_localctx, 14);
				{
				setState(255);
				imageDecl();
				}
				break;
			case META:
				enterOuterAlt(_localctx, 15);
				{
				setState(256);
				metaStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GradeStmtContext extends ParserRuleContext {
		public TerminalNode GRADE() { return getToken(LPDLParser.GRADE, 0); }
		public GradeValueContext gradeValue() {
			return getRuleContext(GradeValueContext.class,0);
		}
		public GradeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gradeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterGradeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitGradeStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitGradeStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GradeStmtContext gradeStmt() throws RecognitionException {
		GradeStmtContext _localctx = new GradeStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_gradeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(GRADE);
			setState(260);
			gradeValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GradeValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public TerminalNode STAR() { return getToken(LPDLParser.STAR, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public GradeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gradeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterGradeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitGradeValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitGradeValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GradeValueContext gradeValue() throws RecognitionException {
		GradeValueContext _localctx = new GradeValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_gradeValue);
		int _la;
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				match(INT);
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(263);
					match(STAR);
					}
				}

				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(IDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SinStmtContext extends ParserRuleContext {
		public TerminalNode SIN() { return getToken(LPDLParser.SIN, 0); }
		public SinAffinityTypeContext sinAffinityType() {
			return getRuleContext(SinAffinityTypeContext.class,0);
		}
		public SinStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sinStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSinStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSinStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSinStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SinStmtContext sinStmt() throws RecognitionException {
		SinStmtContext _localctx = new SinStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sinStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(SIN);
			setState(270);
			sinAffinityType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SinAffinityTypeContext extends ParserRuleContext {
		public TerminalNode WRATH() { return getToken(LPDLParser.WRATH, 0); }
		public TerminalNode LUST() { return getToken(LPDLParser.LUST, 0); }
		public TerminalNode SLOTH() { return getToken(LPDLParser.SLOTH, 0); }
		public TerminalNode GREED() { return getToken(LPDLParser.GREED, 0); }
		public TerminalNode GLOOM() { return getToken(LPDLParser.GLOOM, 0); }
		public TerminalNode PRIDE() { return getToken(LPDLParser.PRIDE, 0); }
		public TerminalNode ENVY() { return getToken(LPDLParser.ENVY, 0); }
		public SinAffinityTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sinAffinityType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSinAffinityType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSinAffinityType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSinAffinityType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SinAffinityTypeContext sinAffinityType() throws RecognitionException {
		SinAffinityTypeContext _localctx = new SinAffinityTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sinAffinityType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_la = _input.LA(1);
			if ( !(((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & 127L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReleaseStmtContext extends ParserRuleContext {
		public TerminalNode RELEASE() { return getToken(LPDLParser.RELEASE, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public ReleaseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_releaseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterReleaseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitReleaseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitReleaseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReleaseStmtContext releaseStmt() throws RecognitionException {
		ReleaseStmtContext _localctx = new ReleaseStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_releaseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(RELEASE);
			setState(275);
			stringLiteral();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MaxLevelStmtContext extends ParserRuleContext {
		public TerminalNode MAXLEVEL() { return getToken(LPDLParser.MAXLEVEL, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public MaxLevelStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maxLevelStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterMaxLevelStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitMaxLevelStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitMaxLevelStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MaxLevelStmtContext maxLevelStmt() throws RecognitionException {
		MaxLevelStmtContext _localctx = new MaxLevelStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_maxLevelStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(MAXLEVEL);
			setState(278);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefenseLevelStmtContext extends ParserRuleContext {
		public TerminalNode DEFENSELEVEL() { return getToken(LPDLParser.DEFENSELEVEL, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public DefenseLevelStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defenseLevelStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterDefenseLevelStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitDefenseLevelStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitDefenseLevelStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefenseLevelStmtContext defenseLevelStmt() throws RecognitionException {
		DefenseLevelStmtContext _localctx = new DefenseLevelStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_defenseLevelStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(DEFENSELEVEL);
			setState(281);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SinnerStmtContext extends ParserRuleContext {
		public TerminalNode SINNER() { return getToken(LPDLParser.SINNER, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public SinnerStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sinnerStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSinnerStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSinnerStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSinnerStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SinnerStmtContext sinnerStmt() throws RecognitionException {
		SinnerStmtContext _localctx = new SinnerStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sinnerStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(SINNER);
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(284);
				stringLiteral();
				}
				break;
			case IDENT:
				{
				setState(285);
				match(IDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResistanceStmtContext extends ParserRuleContext {
		public TerminalNode RESISTANCE() { return getToken(LPDLParser.RESISTANCE, 0); }
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public List<ResistancePairContext> resistancePair() {
			return getRuleContexts(ResistancePairContext.class);
		}
		public ResistancePairContext resistancePair(int i) {
			return getRuleContext(ResistancePairContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LPDLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LPDLParser.COMMA, i);
		}
		public ResistanceStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resistanceStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterResistanceStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitResistanceStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitResistanceStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResistanceStmtContext resistanceStmt() throws RecognitionException {
		ResistanceStmtContext _localctx = new ResistanceStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_resistanceStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(RESISTANCE);
			setState(289);
			match(LBRACE);
			setState(290);
			resistancePair();
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(291);
				match(COMMA);
				setState(292);
				resistancePair();
				}
				}
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(298);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResistancePairContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(LPDLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LPDLParser.IDENT, i);
		}
		public ResistancePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resistancePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterResistancePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitResistancePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitResistancePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResistancePairContext resistancePair() throws RecognitionException {
		ResistancePairContext _localctx = new ResistancePairContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_resistancePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(IDENT);
			setState(301);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpeedStmtContext extends ParserRuleContext {
		public TerminalNode SPEED() { return getToken(LPDLParser.SPEED, 0); }
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public List<SpeedPairContext> speedPair() {
			return getRuleContexts(SpeedPairContext.class);
		}
		public SpeedPairContext speedPair(int i) {
			return getRuleContext(SpeedPairContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LPDLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LPDLParser.COMMA, i);
		}
		public SpeedStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_speedStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSpeedStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSpeedStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSpeedStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpeedStmtContext speedStmt() throws RecognitionException {
		SpeedStmtContext _localctx = new SpeedStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_speedStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(SPEED);
			setState(304);
			match(LBRACE);
			setState(305);
			speedPair();
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(306);
				match(COMMA);
				setState(307);
				speedPair();
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(313);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpeedPairContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public SpeedPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_speedPair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSpeedPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSpeedPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSpeedPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpeedPairContext speedPair() throws RecognitionException {
		SpeedPairContext _localctx = new SpeedPairContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_speedPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(IDENT);
			setState(316);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HealthStmtContext extends ParserRuleContext {
		public TerminalNode HEALTH() { return getToken(LPDLParser.HEALTH, 0); }
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public List<HealthFieldContext> healthField() {
			return getRuleContexts(HealthFieldContext.class);
		}
		public HealthFieldContext healthField(int i) {
			return getRuleContext(HealthFieldContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LPDLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LPDLParser.COMMA, i);
		}
		public HealthStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_healthStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterHealthStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitHealthStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitHealthStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HealthStmtContext healthStmt() throws RecognitionException {
		HealthStmtContext _localctx = new HealthStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_healthStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(HEALTH);
			setState(319);
			match(LBRACE);
			setState(320);
			healthField();
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(321);
				match(COMMA);
				setState(322);
				healthField();
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(328);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HealthFieldContext extends ParserRuleContext {
		public TerminalNode BASE() { return getToken(LPDLParser.BASE, 0); }
		public List<TerminalNode> INT() { return getTokens(LPDLParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(LPDLParser.INT, i);
		}
		public TerminalNode GROWTH() { return getToken(LPDLParser.GROWTH, 0); }
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public TerminalNode DISTURBED() { return getToken(LPDLParser.DISTURBED, 0); }
		public TerminalNode LBRACK() { return getToken(LPDLParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(LPDLParser.RBRACK, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LPDLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LPDLParser.COMMA, i);
		}
		public HealthFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_healthField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterHealthField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitHealthField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitHealthField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HealthFieldContext healthField() throws RecognitionException {
		HealthFieldContext _localctx = new HealthFieldContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_healthField);
		int _la;
		try {
			setState(345);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				match(BASE);
				setState(331);
				match(INT);
				}
				break;
			case GROWTH:
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				match(GROWTH);
				setState(333);
				numberLiteral();
				}
				break;
			case DISTURBED:
				enterOuterAlt(_localctx, 3);
				{
				setState(334);
				match(DISTURBED);
				setState(335);
				match(LBRACK);
				setState(336);
				match(INT);
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(337);
					match(COMMA);
					setState(338);
					match(INT);
					}
					}
					setState(343);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(344);
				match(RBRACK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeasonStmtContext extends ParserRuleContext {
		public TerminalNode SEASON() { return getToken(LPDLParser.SEASON, 0); }
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public List<SeasonFieldContext> seasonField() {
			return getRuleContexts(SeasonFieldContext.class);
		}
		public SeasonFieldContext seasonField(int i) {
			return getRuleContext(SeasonFieldContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LPDLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LPDLParser.COMMA, i);
		}
		public SeasonStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seasonStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSeasonStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSeasonStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSeasonStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeasonStmtContext seasonStmt() throws RecognitionException {
		SeasonStmtContext _localctx = new SeasonStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_seasonStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(SEASON);
			setState(348);
			match(LBRACE);
			setState(349);
			seasonField();
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(350);
				match(COMMA);
				setState(351);
				seasonField();
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(357);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeasonFieldContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(LPDLParser.TYPE, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public TerminalNode NUMBER() { return getToken(LPDLParser.NUMBER, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public SeasonFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seasonField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSeasonField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSeasonField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSeasonField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeasonFieldContext seasonField() throws RecognitionException {
		SeasonFieldContext _localctx = new SeasonFieldContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_seasonField);
		try {
			setState(363);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				match(TYPE);
				setState(360);
				match(IDENT);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				match(NUMBER);
				setState(362);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImageDeclContext extends ParserRuleContext {
		public TerminalNode IMAGE() { return getToken(LPDLParser.IMAGE, 0); }
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public List<ImageFieldContext> imageField() {
			return getRuleContexts(ImageFieldContext.class);
		}
		public ImageFieldContext imageField(int i) {
			return getRuleContext(ImageFieldContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LPDLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LPDLParser.COMMA, i);
		}
		public ImageDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imageDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterImageDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitImageDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitImageDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImageDeclContext imageDecl() throws RecognitionException {
		ImageDeclContext _localctx = new ImageDeclContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_imageDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(IMAGE);
			setState(366);
			match(LBRACE);
			setState(367);
			imageField();
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(368);
				match(COMMA);
				setState(369);
				imageField();
				}
				}
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(375);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImageFieldContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(LPDLParser.TYPE, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public TerminalNode URL() { return getToken(LPDLParser.URL, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode PRIORITY() { return getToken(LPDLParser.PRIORITY, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public TerminalNode PRIMARY() { return getToken(LPDLParser.PRIMARY, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public ImageFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imageField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterImageField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitImageField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitImageField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImageFieldContext imageField() throws RecognitionException {
		ImageFieldContext _localctx = new ImageFieldContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_imageField);
		try {
			setState(385);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				match(TYPE);
				setState(378);
				match(IDENT);
				}
				break;
			case URL:
				enterOuterAlt(_localctx, 2);
				{
				setState(379);
				match(URL);
				setState(380);
				stringLiteral();
				}
				break;
			case PRIORITY:
				enterOuterAlt(_localctx, 3);
				{
				setState(381);
				match(PRIORITY);
				setState(382);
				match(INT);
				}
				break;
			case PRIMARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(383);
				match(PRIMARY);
				setState(384);
				booleanLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MetaStmtContext extends ParserRuleContext {
		public TerminalNode META() { return getToken(LPDLParser.META, 0); }
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public MetaStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metaStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterMetaStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitMetaStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitMetaStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetaStmtContext metaStmt() throws RecognitionException {
		MetaStmtContext _localctx = new MetaStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_metaStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(META);
			setState(388);
			objectLiteral();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SynergyBlockContext extends ParserRuleContext {
		public TerminalNode SYNERGY() { return getToken(LPDLParser.SYNERGY, 0); }
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<SynergyStmtContext> synergyStmt() {
			return getRuleContexts(SynergyStmtContext.class);
		}
		public SynergyStmtContext synergyStmt(int i) {
			return getRuleContext(SynergyStmtContext.class,i);
		}
		public SynergyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synergyBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSynergyBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSynergyBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSynergyBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SynergyBlockContext synergyBlock() throws RecognitionException {
		SynergyBlockContext _localctx = new SynergyBlockContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_synergyBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(SYNERGY);
			setState(391);
			match(LBRACE);
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WITH) {
				{
				{
				setState(392);
				synergyStmt();
				}
				}
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(398);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SynergyStmtContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(LPDLParser.WITH, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public List<SynergyDetailContext> synergyDetail() {
			return getRuleContexts(SynergyDetailContext.class);
		}
		public SynergyDetailContext synergyDetail(int i) {
			return getRuleContext(SynergyDetailContext.class,i);
		}
		public SynergyStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synergyStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSynergyStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSynergyStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSynergyStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SynergyStmtContext synergyStmt() throws RecognitionException {
		SynergyStmtContext _localctx = new SynergyStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_synergyStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			match(WITH);
			setState(403);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(401);
				stringLiteral();
				}
				break;
			case IDENT:
				{
				setState(402);
				match(IDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(406); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(405);
				synergyDetail();
				}
				}
				setState(408); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 385875968L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SynergyDetailContext extends ParserRuleContext {
		public TerminalNode BOOST() { return getToken(LPDLParser.BOOST, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public AdditiveExprContext additiveExpr() {
			return getRuleContext(AdditiveExprContext.class,0);
		}
		public TerminalNode SUPPORT() { return getToken(LPDLParser.SUPPORT, 0); }
		public TerminalNode TYPE() { return getToken(LPDLParser.TYPE, 0); }
		public TerminalNode VALUE() { return getToken(LPDLParser.VALUE, 0); }
		public SynergyDetailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synergyDetail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSynergyDetail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSynergyDetail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSynergyDetail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SynergyDetailContext synergyDetail() throws RecognitionException {
		SynergyDetailContext _localctx = new SynergyDetailContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_synergyDetail);
		int _la;
		try {
			setState(424);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOST:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				match(BOOST);
				setState(411);
				match(IDENT);
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 9010500037775359L) != 0)) {
					{
					setState(412);
					additiveExpr();
					}
				}

				}
				break;
			case SUPPORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(415);
				match(SUPPORT);
				setState(416);
				match(IDENT);
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 9010500037775359L) != 0)) {
					{
					setState(417);
					additiveExpr();
					}
				}

				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(420);
				match(TYPE);
				setState(421);
				match(IDENT);
				}
				break;
			case VALUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(422);
				match(VALUE);
				setState(423);
				additiveExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SkillDeclContext extends ParserRuleContext {
		public TerminalNode SKILL() { return getToken(LPDLParser.SKILL, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public SkillBodyContext skillBody() {
			return getRuleContext(SkillBodyContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public SkillDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skillDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSkillDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSkillDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSkillDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkillDeclContext skillDecl() throws RecognitionException {
		SkillDeclContext _localctx = new SkillDeclContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_skillDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			match(SKILL);
			setState(427);
			match(INT);
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(428);
				stringLiteral();
				}
			}

			setState(431);
			skillBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SkillBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<SkillStmtContext> skillStmt() {
			return getRuleContexts(SkillStmtContext.class);
		}
		public SkillStmtContext skillStmt(int i) {
			return getRuleContext(SkillStmtContext.class,i);
		}
		public SkillBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skillBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSkillBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSkillBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSkillBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkillBodyContext skillBody() throws RecognitionException {
		SkillBodyContext _localctx = new SkillBodyContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_skillBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			match(LBRACE);
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 205218906240L) != 0)) {
				{
				{
				setState(434);
				skillStmt();
				}
				}
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(440);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SkillStmtContext extends ParserRuleContext {
		public CategoryStmtContext categoryStmt() {
			return getRuleContext(CategoryStmtContext.class,0);
		}
		public SkillSinStmtContext skillSinStmt() {
			return getRuleContext(SkillSinStmtContext.class,0);
		}
		public AttackStmtContext attackStmt() {
			return getRuleContext(AttackStmtContext.class,0);
		}
		public DefenseStmtContext defenseStmt() {
			return getRuleContext(DefenseStmtContext.class,0);
		}
		public QuantityStmtContext quantityStmt() {
			return getRuleContext(QuantityStmtContext.class,0);
		}
		public KeywordStmtContext keywordStmt() {
			return getRuleContext(KeywordStmtContext.class,0);
		}
		public ImageStmtContext imageStmt() {
			return getRuleContext(ImageStmtContext.class,0);
		}
		public TextDeclContext textDecl() {
			return getRuleContext(TextDeclContext.class,0);
		}
		public SyncDeclContext syncDecl() {
			return getRuleContext(SyncDeclContext.class,0);
		}
		public SkillStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skillStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSkillStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSkillStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSkillStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkillStmtContext skillStmt() throws RecognitionException {
		SkillStmtContext _localctx = new SkillStmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_skillStmt);
		try {
			setState(451);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CATEGORY:
				enterOuterAlt(_localctx, 1);
				{
				setState(442);
				categoryStmt();
				}
				break;
			case SIN:
				enterOuterAlt(_localctx, 2);
				{
				setState(443);
				skillSinStmt();
				}
				break;
			case ATTACK:
				enterOuterAlt(_localctx, 3);
				{
				setState(444);
				attackStmt();
				}
				break;
			case DEFENSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(445);
				defenseStmt();
				}
				break;
			case QUANTITY:
				enterOuterAlt(_localctx, 5);
				{
				setState(446);
				quantityStmt();
				}
				break;
			case KEYWORD:
				enterOuterAlt(_localctx, 6);
				{
				setState(447);
				keywordStmt();
				}
				break;
			case IMAGE:
				enterOuterAlt(_localctx, 7);
				{
				setState(448);
				imageStmt();
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 8);
				{
				setState(449);
				textDecl();
				}
				break;
			case SYNC:
				enterOuterAlt(_localctx, 9);
				{
				setState(450);
				syncDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CategoryStmtContext extends ParserRuleContext {
		public TerminalNode CATEGORY() { return getToken(LPDLParser.CATEGORY, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public CategoryStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_categoryStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterCategoryStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitCategoryStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitCategoryStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CategoryStmtContext categoryStmt() throws RecognitionException {
		CategoryStmtContext _localctx = new CategoryStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_categoryStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(CATEGORY);
			setState(454);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SkillSinStmtContext extends ParserRuleContext {
		public TerminalNode SIN() { return getToken(LPDLParser.SIN, 0); }
		public SinAffinityTypeContext sinAffinityType() {
			return getRuleContext(SinAffinityTypeContext.class,0);
		}
		public SkillSinStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skillSinStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSkillSinStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSkillSinStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSkillSinStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkillSinStmtContext skillSinStmt() throws RecognitionException {
		SkillSinStmtContext _localctx = new SkillSinStmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_skillSinStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			match(SIN);
			setState(457);
			sinAffinityType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttackStmtContext extends ParserRuleContext {
		public TerminalNode ATTACK() { return getToken(LPDLParser.ATTACK, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public AttackStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attackStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterAttackStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitAttackStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitAttackStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttackStmtContext attackStmt() throws RecognitionException {
		AttackStmtContext _localctx = new AttackStmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_attackStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(ATTACK);
			setState(460);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefenseStmtContext extends ParserRuleContext {
		public TerminalNode DEFENSE() { return getToken(LPDLParser.DEFENSE, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public DefenseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defenseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterDefenseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitDefenseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitDefenseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefenseStmtContext defenseStmt() throws RecognitionException {
		DefenseStmtContext _localctx = new DefenseStmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_defenseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(DEFENSE);
			setState(463);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuantityStmtContext extends ParserRuleContext {
		public TerminalNode QUANTITY() { return getToken(LPDLParser.QUANTITY, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public QuantityStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantityStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterQuantityStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitQuantityStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitQuantityStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantityStmtContext quantityStmt() throws RecognitionException {
		QuantityStmtContext _localctx = new QuantityStmtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_quantityStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			match(QUANTITY);
			setState(466);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeywordStmtContext extends ParserRuleContext {
		public TerminalNode KEYWORD() { return getToken(LPDLParser.KEYWORD, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public KeywordStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterKeywordStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitKeywordStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitKeywordStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordStmtContext keywordStmt() throws RecognitionException {
		KeywordStmtContext _localctx = new KeywordStmtContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_keywordStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			match(KEYWORD);
			setState(469);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImageStmtContext extends ParserRuleContext {
		public TerminalNode IMAGE() { return getToken(LPDLParser.IMAGE, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public TerminalNode NONE() { return getToken(LPDLParser.NONE, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public ImageStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imageStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterImageStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitImageStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitImageStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImageStmtContext imageStmt() throws RecognitionException {
		ImageStmtContext _localctx = new ImageStmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_imageStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(IMAGE);
			setState(475);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				{
				setState(472);
				match(IDENT);
				}
				break;
			case NONE:
				{
				setState(473);
				match(NONE);
				}
				break;
			case STRING:
				{
				setState(474);
				stringLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SyncDeclContext extends ParserRuleContext {
		public TerminalNode SYNC() { return getToken(LPDLParser.SYNC, 0); }
		public SyncLevelContext syncLevel() {
			return getRuleContext(SyncLevelContext.class,0);
		}
		public SyncBodyContext syncBody() {
			return getRuleContext(SyncBodyContext.class,0);
		}
		public SyncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syncDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSyncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSyncDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSyncDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyncDeclContext syncDecl() throws RecognitionException {
		SyncDeclContext _localctx = new SyncDeclContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_syncDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(SYNC);
			setState(478);
			syncLevel();
			setState(479);
			syncBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SyncLevelContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public TerminalNode STRING() { return getToken(LPDLParser.STRING, 0); }
		public SyncLevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syncLevel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSyncLevel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSyncLevel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSyncLevel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyncLevelContext syncLevel() throws RecognitionException {
		SyncLevelContext _localctx = new SyncLevelContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_syncLevel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==IDENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SyncBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<SyncStmtContext> syncStmt() {
			return getRuleContexts(SyncStmtContext.class);
		}
		public SyncStmtContext syncStmt(int i) {
			return getRuleContext(SyncStmtContext.class,i);
		}
		public SyncBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syncBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSyncBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSyncBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSyncBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyncBodyContext syncBody() throws RecognitionException {
		SyncBodyContext _localctx = new SyncBodyContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_syncBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(LBRACE);
			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 580267261558784L) != 0)) {
				{
				{
				setState(484);
				syncStmt();
				}
				}
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(490);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SyncStmtContext extends ParserRuleContext {
		public BasePowerStmtContext basePowerStmt() {
			return getRuleContext(BasePowerStmtContext.class,0);
		}
		public CoinPowerStmtContext coinPowerStmt() {
			return getRuleContext(CoinPowerStmtContext.class,0);
		}
		public CoinCountStmtContext coinCountStmt() {
			return getRuleContext(CoinCountStmtContext.class,0);
		}
		public WeightStmtContext weightStmt() {
			return getRuleContext(WeightStmtContext.class,0);
		}
		public LevelStmtContext levelStmt() {
			return getRuleContext(LevelStmtContext.class,0);
		}
		public EffectDeclContext effectDecl() {
			return getRuleContext(EffectDeclContext.class,0);
		}
		public CoinDeclContext coinDecl() {
			return getRuleContext(CoinDeclContext.class,0);
		}
		public SyncStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syncStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSyncStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSyncStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSyncStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyncStmtContext syncStmt() throws RecognitionException {
		SyncStmtContext _localctx = new SyncStmtContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_syncStmt);
		try {
			setState(499);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BASEPOWER:
				enterOuterAlt(_localctx, 1);
				{
				setState(492);
				basePowerStmt();
				}
				break;
			case COINPOWER:
				enterOuterAlt(_localctx, 2);
				{
				setState(493);
				coinPowerStmt();
				}
				break;
			case COINCOUNT:
				enterOuterAlt(_localctx, 3);
				{
				setState(494);
				coinCountStmt();
				}
				break;
			case WEIGHT:
				enterOuterAlt(_localctx, 4);
				{
				setState(495);
				weightStmt();
				}
				break;
			case LEVEL:
				enterOuterAlt(_localctx, 5);
				{
				setState(496);
				levelStmt();
				}
				break;
			case EFFECT:
				enterOuterAlt(_localctx, 6);
				{
				setState(497);
				effectDecl();
				}
				break;
			case COIN:
				enterOuterAlt(_localctx, 7);
				{
				setState(498);
				coinDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasePowerStmtContext extends ParserRuleContext {
		public TerminalNode BASEPOWER() { return getToken(LPDLParser.BASEPOWER, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public BasePowerStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basePowerStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterBasePowerStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitBasePowerStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitBasePowerStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasePowerStmtContext basePowerStmt() throws RecognitionException {
		BasePowerStmtContext _localctx = new BasePowerStmtContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_basePowerStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(BASEPOWER);
			setState(502);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CoinPowerStmtContext extends ParserRuleContext {
		public TerminalNode COINPOWER() { return getToken(LPDLParser.COINPOWER, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public CoinPowerStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coinPowerStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterCoinPowerStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitCoinPowerStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitCoinPowerStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoinPowerStmtContext coinPowerStmt() throws RecognitionException {
		CoinPowerStmtContext _localctx = new CoinPowerStmtContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_coinPowerStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			match(COINPOWER);
			setState(505);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CoinCountStmtContext extends ParserRuleContext {
		public TerminalNode COINCOUNT() { return getToken(LPDLParser.COINCOUNT, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public CoinCountStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coinCountStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterCoinCountStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitCoinCountStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitCoinCountStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoinCountStmtContext coinCountStmt() throws RecognitionException {
		CoinCountStmtContext _localctx = new CoinCountStmtContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_coinCountStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			match(COINCOUNT);
			setState(508);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WeightStmtContext extends ParserRuleContext {
		public TerminalNode WEIGHT() { return getToken(LPDLParser.WEIGHT, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public WeightStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterWeightStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitWeightStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitWeightStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeightStmtContext weightStmt() throws RecognitionException {
		WeightStmtContext _localctx = new WeightStmtContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_weightStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			match(WEIGHT);
			setState(511);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LevelStmtContext extends ParserRuleContext {
		public TerminalNode LEVEL() { return getToken(LPDLParser.LEVEL, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public LevelStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_levelStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterLevelStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitLevelStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitLevelStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LevelStmtContext levelStmt() throws RecognitionException {
		LevelStmtContext _localctx = new LevelStmtContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_levelStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(LEVEL);
			setState(514);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EffectDeclContext extends ParserRuleContext {
		public TerminalNode EFFECT() { return getToken(LPDLParser.EFFECT, 0); }
		public EffectBodyContext effectBody() {
			return getRuleContext(EffectBodyContext.class,0);
		}
		public EffectHeaderContext effectHeader() {
			return getRuleContext(EffectHeaderContext.class,0);
		}
		public EffectDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effectDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterEffectDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitEffectDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitEffectDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EffectDeclContext effectDecl() throws RecognitionException {
		EffectDeclContext _localctx = new EffectDeclContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_effectDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			match(EFFECT);
			setState(518);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(517);
				effectHeader();
				}
			}

			setState(520);
			effectBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EffectHeaderContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode STRING() { return getToken(LPDLParser.STRING, 0); }
		public EffectHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effectHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterEffectHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitEffectHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitEffectHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EffectHeaderContext effectHeader() throws RecognitionException {
		EffectHeaderContext _localctx = new EffectHeaderContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_effectHeader);
		try {
			setState(524);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(522);
				stringLiteral();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(523);
				match(STRING);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EffectBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<EffectStmtContext> effectStmt() {
			return getRuleContexts(EffectStmtContext.class);
		}
		public EffectStmtContext effectStmt(int i) {
			return getRuleContext(EffectStmtContext.class,i);
		}
		public EffectBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effectBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterEffectBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitEffectBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitEffectBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EffectBodyContext effectBody() throws RecognitionException {
		EffectBodyContext _localctx = new EffectBodyContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_effectBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(LBRACE);
			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 288160009421717505L) != 0)) {
				{
				{
				setState(527);
				effectStmt();
				}
				}
				setState(532);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(533);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EffectStmtContext extends ParserRuleContext {
		public TextDeclContext textDecl() {
			return getRuleContext(TextDeclContext.class,0);
		}
		public TriggerStmtContext triggerStmt() {
			return getRuleContext(TriggerStmtContext.class,0);
		}
		public WhenStmtContext whenStmt() {
			return getRuleContext(WhenStmtContext.class,0);
		}
		public BranchBlockContext branchBlock() {
			return getRuleContext(BranchBlockContext.class,0);
		}
		public TerminalNode ACTION() { return getToken(LPDLParser.ACTION, 0); }
		public ActionClauseContext actionClause() {
			return getRuleContext(ActionClauseContext.class,0);
		}
		public ActionSimpleContext actionSimple() {
			return getRuleContext(ActionSimpleContext.class,0);
		}
		public EffectStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effectStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterEffectStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitEffectStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitEffectStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EffectStmtContext effectStmt() throws RecognitionException {
		EffectStmtContext _localctx = new EffectStmtContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_effectStmt);
		try {
			setState(542);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(535);
				textDecl();
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(536);
				triggerStmt();
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(537);
				whenStmt();
				}
				break;
			case BRANCH:
				enterOuterAlt(_localctx, 4);
				{
				setState(538);
				branchBlock();
				}
				break;
			case ACTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(539);
				match(ACTION);
				setState(540);
				actionClause();
				}
				break;
			case APPLY:
			case REMOVE:
			case MODIFY:
			case SELF:
			case TARGET:
			case ALLY:
			case ENEMY:
			case ALL_ALLIES:
			case ALL_ENEMIES:
			case SELF_ALLY:
			case ANY:
			case RIGHT_ALLY:
			case LEFT_ALLY:
			case LOWEST_HP_ALLY:
			case HIGHEST_RESONANCE:
				enterOuterAlt(_localctx, 6);
				{
				setState(541);
				actionSimple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TriggerStmtContext extends ParserRuleContext {
		public TerminalNode TRIGGER() { return getToken(LPDLParser.TRIGGER, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public TriggerStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterTriggerStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitTriggerStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitTriggerStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerStmtContext triggerStmt() throws RecognitionException {
		TriggerStmtContext _localctx = new TriggerStmtContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_triggerStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			match(TRIGGER);
			setState(545);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhenStmtContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(LPDLParser.WHEN, 0); }
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public WhenStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterWhenStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitWhenStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitWhenStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenStmtContext whenStmt() throws RecognitionException {
		WhenStmtContext _localctx = new WhenStmtContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_whenStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			match(WHEN);
			setState(548);
			conditionExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BranchBlockContext extends ParserRuleContext {
		public TerminalNode BRANCH() { return getToken(LPDLParser.BRANCH, 0); }
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<BranchStmtContext> branchStmt() {
			return getRuleContexts(BranchStmtContext.class);
		}
		public BranchStmtContext branchStmt(int i) {
			return getRuleContext(BranchStmtContext.class,i);
		}
		public BranchBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterBranchBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitBranchBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitBranchBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchBlockContext branchBlock() throws RecognitionException {
		BranchBlockContext _localctx = new BranchBlockContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_branchBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(BRANCH);
			setState(551);
			match(LBRACE);
			setState(555);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & 1099243200013L) != 0)) {
				{
				{
				setState(552);
				branchStmt();
				}
				}
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(558);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BranchStmtContext extends ParserRuleContext {
		public OrderStmtContext orderStmt() {
			return getRuleContext(OrderStmtContext.class,0);
		}
		public StopOnMatchStmtContext stopOnMatchStmt() {
			return getRuleContext(StopOnMatchStmtContext.class,0);
		}
		public WhenStmtContext whenStmt() {
			return getRuleContext(WhenStmtContext.class,0);
		}
		public TerminalNode ACTION() { return getToken(LPDLParser.ACTION, 0); }
		public ActionClauseContext actionClause() {
			return getRuleContext(ActionClauseContext.class,0);
		}
		public ActionSimpleContext actionSimple() {
			return getRuleContext(ActionSimpleContext.class,0);
		}
		public BranchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterBranchStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitBranchStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitBranchStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchStmtContext branchStmt() throws RecognitionException {
		BranchStmtContext _localctx = new BranchStmtContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_branchStmt);
		try {
			setState(566);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ORDER:
				enterOuterAlt(_localctx, 1);
				{
				setState(560);
				orderStmt();
				}
				break;
			case STOPONMATCH:
				enterOuterAlt(_localctx, 2);
				{
				setState(561);
				stopOnMatchStmt();
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(562);
				whenStmt();
				}
				break;
			case ACTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(563);
				match(ACTION);
				setState(564);
				actionClause();
				}
				break;
			case APPLY:
			case REMOVE:
			case MODIFY:
			case SELF:
			case TARGET:
			case ALLY:
			case ENEMY:
			case ALL_ALLIES:
			case ALL_ENEMIES:
			case SELF_ALLY:
			case ANY:
			case RIGHT_ALLY:
			case LEFT_ALLY:
			case LOWEST_HP_ALLY:
			case HIGHEST_RESONANCE:
				enterOuterAlt(_localctx, 5);
				{
				setState(565);
				actionSimple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OrderStmtContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(LPDLParser.ORDER, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public OrderStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterOrderStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitOrderStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitOrderStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderStmtContext orderStmt() throws RecognitionException {
		OrderStmtContext _localctx = new OrderStmtContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_orderStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			match(ORDER);
			setState(569);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StopOnMatchStmtContext extends ParserRuleContext {
		public TerminalNode STOPONMATCH() { return getToken(LPDLParser.STOPONMATCH, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public StopOnMatchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stopOnMatchStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterStopOnMatchStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitStopOnMatchStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitStopOnMatchStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StopOnMatchStmtContext stopOnMatchStmt() throws RecognitionException {
		StopOnMatchStmtContext _localctx = new StopOnMatchStmtContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_stopOnMatchStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			match(STOPONMATCH);
			setState(572);
			booleanLiteral();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CoinDeclContext extends ParserRuleContext {
		public TerminalNode COIN() { return getToken(LPDLParser.COIN, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public CoinBodyContext coinBody() {
			return getRuleContext(CoinBodyContext.class,0);
		}
		public CoinDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coinDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterCoinDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitCoinDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitCoinDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoinDeclContext coinDecl() throws RecognitionException {
		CoinDeclContext _localctx = new CoinDeclContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_coinDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574);
			match(COIN);
			setState(575);
			match(INT);
			setState(576);
			match(IDENT);
			setState(577);
			coinBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CoinBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public TextDeclContext textDecl() {
			return getRuleContext(TextDeclContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<EffectInlineDeclContext> effectInlineDecl() {
			return getRuleContexts(EffectInlineDeclContext.class);
		}
		public EffectInlineDeclContext effectInlineDecl(int i) {
			return getRuleContext(EffectInlineDeclContext.class,i);
		}
		public CoinBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coinBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterCoinBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitCoinBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitCoinBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoinBodyContext coinBody() throws RecognitionException {
		CoinBodyContext _localctx = new CoinBodyContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_coinBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			match(LBRACE);
			setState(580);
			textDecl();
			setState(582); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(581);
				effectInlineDecl();
				}
				}
				setState(584); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EFFECT );
			setState(586);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EffectInlineDeclContext extends ParserRuleContext {
		public TerminalNode EFFECT() { return getToken(LPDLParser.EFFECT, 0); }
		public EffectBodyContext effectBody() {
			return getRuleContext(EffectBodyContext.class,0);
		}
		public EffectInlineHeaderContext effectInlineHeader() {
			return getRuleContext(EffectInlineHeaderContext.class,0);
		}
		public EffectInlineDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effectInlineDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterEffectInlineDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitEffectInlineDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitEffectInlineDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EffectInlineDeclContext effectInlineDecl() throws RecognitionException {
		EffectInlineDeclContext _localctx = new EffectInlineDeclContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_effectInlineDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			match(EFFECT);
			setState(590);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(589);
				effectInlineHeader();
				}
			}

			setState(592);
			effectBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EffectInlineHeaderContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public EffectInlineHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effectInlineHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterEffectInlineHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitEffectInlineHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitEffectInlineHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EffectInlineHeaderContext effectInlineHeader() throws RecognitionException {
		EffectInlineHeaderContext _localctx = new EffectInlineHeaderContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_effectInlineHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
			stringLiteral();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PassiveDeclContext extends ParserRuleContext {
		public TerminalNode PASSIVE() { return getToken(LPDLParser.PASSIVE, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public PassiveBodyContext passiveBody() {
			return getRuleContext(PassiveBodyContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public PassiveDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_passiveDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPassiveDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPassiveDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPassiveDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PassiveDeclContext passiveDecl() throws RecognitionException {
		PassiveDeclContext _localctx = new PassiveDeclContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_passiveDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			match(PASSIVE);
			setState(597);
			match(IDENT);
			setState(599);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(598);
				stringLiteral();
				}
			}

			setState(601);
			passiveBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PassiveBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<PassiveStmtContext> passiveStmt() {
			return getRuleContexts(PassiveStmtContext.class);
		}
		public PassiveStmtContext passiveStmt(int i) {
			return getRuleContext(PassiveStmtContext.class,i);
		}
		public PassiveBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_passiveBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPassiveBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPassiveBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPassiveBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PassiveBodyContext passiveBody() throws RecognitionException {
		PassiveBodyContext _localctx = new PassiveBodyContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_passiveBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			match(LBRACE);
			setState(607);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 288160009505603585L) != 0)) {
				{
				{
				setState(604);
				passiveStmt();
				}
				}
				setState(609);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(610);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PassiveStmtContext extends ParserRuleContext {
		public TriggerStmtContext triggerStmt() {
			return getRuleContext(TriggerStmtContext.class,0);
		}
		public WhenStmtContext whenStmt() {
			return getRuleContext(WhenStmtContext.class,0);
		}
		public TerminalNode ACTION() { return getToken(LPDLParser.ACTION, 0); }
		public ActionClauseContext actionClause() {
			return getRuleContext(ActionClauseContext.class,0);
		}
		public ActionSimpleContext actionSimple() {
			return getRuleContext(ActionSimpleContext.class,0);
		}
		public BranchBlockContext branchBlock() {
			return getRuleContext(BranchBlockContext.class,0);
		}
		public TextDeclContext textDecl() {
			return getRuleContext(TextDeclContext.class,0);
		}
		public PassiveConditionStmtContext passiveConditionStmt() {
			return getRuleContext(PassiveConditionStmtContext.class,0);
		}
		public PassiveSyncLevelStmtContext passiveSyncLevelStmt() {
			return getRuleContext(PassiveSyncLevelStmtContext.class,0);
		}
		public PassiveStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_passiveStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPassiveStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPassiveStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPassiveStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PassiveStmtContext passiveStmt() throws RecognitionException {
		PassiveStmtContext _localctx = new PassiveStmtContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_passiveStmt);
		try {
			setState(621);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRIGGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(612);
				triggerStmt();
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(613);
				whenStmt();
				}
				break;
			case ACTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(614);
				match(ACTION);
				setState(615);
				actionClause();
				}
				break;
			case APPLY:
			case REMOVE:
			case MODIFY:
			case SELF:
			case TARGET:
			case ALLY:
			case ENEMY:
			case ALL_ALLIES:
			case ALL_ENEMIES:
			case SELF_ALLY:
			case ANY:
			case RIGHT_ALLY:
			case LEFT_ALLY:
			case LOWEST_HP_ALLY:
			case HIGHEST_RESONANCE:
				enterOuterAlt(_localctx, 4);
				{
				setState(616);
				actionSimple();
				}
				break;
			case BRANCH:
				enterOuterAlt(_localctx, 5);
				{
				setState(617);
				branchBlock();
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 6);
				{
				setState(618);
				textDecl();
				}
				break;
			case CONDITION:
				enterOuterAlt(_localctx, 7);
				{
				setState(619);
				passiveConditionStmt();
				}
				break;
			case SYNCLEVEL:
				enterOuterAlt(_localctx, 8);
				{
				setState(620);
				passiveSyncLevelStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PassiveConditionStmtContext extends ParserRuleContext {
		public TerminalNode CONDITION() { return getToken(LPDLParser.CONDITION, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public TerminalNode SIN() { return getToken(LPDLParser.SIN, 0); }
		public SinAffinityTypeContext sinAffinityType() {
			return getRuleContext(SinAffinityTypeContext.class,0);
		}
		public TerminalNode COUNT() { return getToken(LPDLParser.COUNT, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public PassiveConditionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_passiveConditionStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPassiveConditionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPassiveConditionStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPassiveConditionStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PassiveConditionStmtContext passiveConditionStmt() throws RecognitionException {
		PassiveConditionStmtContext _localctx = new PassiveConditionStmtContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_passiveConditionStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			match(CONDITION);
			setState(624);
			match(IDENT);
			setState(625);
			match(SIN);
			setState(626);
			sinAffinityType();
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COUNT) {
				{
				setState(627);
				match(COUNT);
				setState(628);
				match(INT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PassiveSyncLevelStmtContext extends ParserRuleContext {
		public TerminalNode SYNCLEVEL() { return getToken(LPDLParser.SYNCLEVEL, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public PassiveSyncLevelStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_passiveSyncLevelStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPassiveSyncLevelStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPassiveSyncLevelStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPassiveSyncLevelStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PassiveSyncLevelStmtContext passiveSyncLevelStmt() throws RecognitionException {
		PassiveSyncLevelStmtContext _localctx = new PassiveSyncLevelStmtContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_passiveSyncLevelStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			match(SYNCLEVEL);
			setState(632);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActionStmtContext extends ParserRuleContext {
		public TerminalNode ACTION() { return getToken(LPDLParser.ACTION, 0); }
		public ActionClauseContext actionClause() {
			return getRuleContext(ActionClauseContext.class,0);
		}
		public ActionSimpleContext actionSimple() {
			return getRuleContext(ActionSimpleContext.class,0);
		}
		public ActionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterActionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitActionStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitActionStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionStmtContext actionStmt() throws RecognitionException {
		ActionStmtContext _localctx = new ActionStmtContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_actionStmt);
		try {
			setState(637);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ACTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(634);
				match(ACTION);
				setState(635);
				actionClause();
				}
				break;
			case APPLY:
			case REMOVE:
			case MODIFY:
			case SELF:
			case TARGET:
			case ALLY:
			case ENEMY:
			case ALL_ALLIES:
			case ALL_ENEMIES:
			case SELF_ALLY:
			case ANY:
			case RIGHT_ALLY:
			case LEFT_ALLY:
			case LOWEST_HP_ALLY:
			case HIGHEST_RESONANCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(636);
				actionSimple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActionClauseContext extends ParserRuleContext {
		public VerbSpecContext verbSpec() {
			return getRuleContext(VerbSpecContext.class,0);
		}
		public ActionDetailContext actionDetail() {
			return getRuleContext(ActionDetailContext.class,0);
		}
		public TargetSpecContext targetSpec() {
			return getRuleContext(TargetSpecContext.class,0);
		}
		public ActionClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterActionClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitActionClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitActionClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionClauseContext actionClause() throws RecognitionException {
		ActionClauseContext _localctx = new ActionClauseContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_actionClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 4095L) != 0)) {
				{
				setState(639);
				targetSpec();
				}
			}

			setState(642);
			verbSpec();
			setState(643);
			actionDetail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActionSimpleContext extends ParserRuleContext {
		public TerminalNode APPLY() { return getToken(LPDLParser.APPLY, 0); }
		public StatSpecContext statSpec() {
			return getRuleContext(StatSpecContext.class,0);
		}
		public AdditiveExprContext additiveExpr() {
			return getRuleContext(AdditiveExprContext.class,0);
		}
		public TargetSpecContext targetSpec() {
			return getRuleContext(TargetSpecContext.class,0);
		}
		public PolicySpecContext policySpec() {
			return getRuleContext(PolicySpecContext.class,0);
		}
		public List<ActionOptionsContext> actionOptions() {
			return getRuleContexts(ActionOptionsContext.class);
		}
		public ActionOptionsContext actionOptions(int i) {
			return getRuleContext(ActionOptionsContext.class,i);
		}
		public TerminalNode REMOVE() { return getToken(LPDLParser.REMOVE, 0); }
		public TerminalNode MODIFY() { return getToken(LPDLParser.MODIFY, 0); }
		public TerminalNode POWER() { return getToken(LPDLParser.POWER, 0); }
		public TerminalNode DAMAGE() { return getToken(LPDLParser.DAMAGE, 0); }
		public ActionSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionSimple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterActionSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitActionSimple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitActionSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionSimpleContext actionSimple() throws RecognitionException {
		ActionSimpleContext _localctx = new ActionSimpleContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_actionSimple);
		int _la;
		try {
			setState(683);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(646);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 4095L) != 0)) {
					{
					setState(645);
					targetSpec();
					}
				}

				setState(648);
				match(APPLY);
				setState(649);
				statSpec();
				setState(651);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(650);
					policySpec();
					}
					break;
				}
				setState(653);
				additiveExpr();
				setState(657);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & 3071L) != 0)) {
					{
					{
					setState(654);
					actionOptions();
					}
					}
					setState(659);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(661);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 4095L) != 0)) {
					{
					setState(660);
					targetSpec();
					}
				}

				setState(663);
				match(REMOVE);
				setState(664);
				statSpec();
				setState(666);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(665);
					additiveExpr();
					}
					break;
				}
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & 3071L) != 0)) {
					{
					{
					setState(668);
					actionOptions();
					}
					}
					setState(673);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(674);
				match(MODIFY);
				setState(675);
				_la = _input.LA(1);
				if ( !(_la==POWER || _la==DAMAGE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(676);
				additiveExpr();
				setState(680);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & 3071L) != 0)) {
					{
					{
					setState(677);
					actionOptions();
					}
					}
					setState(682);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TargetSpecContext extends ParserRuleContext {
		public TerminalNode SELF() { return getToken(LPDLParser.SELF, 0); }
		public TerminalNode TARGET() { return getToken(LPDLParser.TARGET, 0); }
		public TerminalNode ALLY() { return getToken(LPDLParser.ALLY, 0); }
		public TerminalNode ENEMY() { return getToken(LPDLParser.ENEMY, 0); }
		public TerminalNode ALL_ALLIES() { return getToken(LPDLParser.ALL_ALLIES, 0); }
		public TerminalNode ALL_ENEMIES() { return getToken(LPDLParser.ALL_ENEMIES, 0); }
		public TerminalNode SELF_ALLY() { return getToken(LPDLParser.SELF_ALLY, 0); }
		public TerminalNode ANY() { return getToken(LPDLParser.ANY, 0); }
		public TerminalNode RIGHT_ALLY() { return getToken(LPDLParser.RIGHT_ALLY, 0); }
		public TerminalNode LEFT_ALLY() { return getToken(LPDLParser.LEFT_ALLY, 0); }
		public TerminalNode LOWEST_HP_ALLY() { return getToken(LPDLParser.LOWEST_HP_ALLY, 0); }
		public TerminalNode HIGHEST_RESONANCE() { return getToken(LPDLParser.HIGHEST_RESONANCE, 0); }
		public TargetSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterTargetSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitTargetSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitTargetSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetSpecContext targetSpec() throws RecognitionException {
		TargetSpecContext _localctx = new TargetSpecContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_targetSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			_la = _input.LA(1);
			if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 4095L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VerbSpecContext extends ParserRuleContext {
		public TerminalNode APPLY() { return getToken(LPDLParser.APPLY, 0); }
		public StatSpecContext statSpec() {
			return getRuleContext(StatSpecContext.class,0);
		}
		public ValueSpecContext valueSpec() {
			return getRuleContext(ValueSpecContext.class,0);
		}
		public PolicySpecContext policySpec() {
			return getRuleContext(PolicySpecContext.class,0);
		}
		public TerminalNode REMOVE() { return getToken(LPDLParser.REMOVE, 0); }
		public TerminalNode MODIFY() { return getToken(LPDLParser.MODIFY, 0); }
		public TerminalNode POWER() { return getToken(LPDLParser.POWER, 0); }
		public TerminalNode DAMAGE() { return getToken(LPDLParser.DAMAGE, 0); }
		public VerbSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterVerbSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitVerbSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitVerbSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerbSpecContext verbSpec() throws RecognitionException {
		VerbSpecContext _localctx = new VerbSpecContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_verbSpec);
		int _la;
		try {
			setState(699);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case APPLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(687);
				match(APPLY);
				setState(688);
				statSpec();
				setState(690);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(689);
					policySpec();
					}
					break;
				}
				setState(692);
				valueSpec();
				}
				break;
			case REMOVE:
				enterOuterAlt(_localctx, 2);
				{
				setState(694);
				match(REMOVE);
				setState(695);
				statSpec();
				}
				break;
			case MODIFY:
				enterOuterAlt(_localctx, 3);
				{
				setState(696);
				match(MODIFY);
				setState(697);
				_la = _input.LA(1);
				if ( !(_la==POWER || _la==DAMAGE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(698);
				valueSpec();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PolicySpecContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public PolicySpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_policySpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPolicySpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPolicySpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPolicySpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolicySpecContext policySpec() throws RecognitionException {
		PolicySpecContext _localctx = new PolicySpecContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_policySpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatSpecContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public StatSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterStatSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitStatSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitStatSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatSpecContext statSpec() throws RecognitionException {
		StatSpecContext _localctx = new StatSpecContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_statSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(703);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueSpecContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ValueSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterValueSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitValueSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitValueSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueSpecContext valueSpec() throws RecognitionException {
		ValueSpecContext _localctx = new ValueSpecContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_valueSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActionDetailContext extends ParserRuleContext {
		public List<ActionOptionsContext> actionOptions() {
			return getRuleContexts(ActionOptionsContext.class);
		}
		public ActionOptionsContext actionOptions(int i) {
			return getRuleContext(ActionOptionsContext.class,i);
		}
		public ActionDetailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionDetail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterActionDetail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitActionDetail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitActionDetail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionDetailContext actionDetail() throws RecognitionException {
		ActionDetailContext _localctx = new ActionDetailContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_actionDetail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & 3071L) != 0)) {
				{
				{
				setState(707);
				actionOptions();
				}
				}
				setState(712);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActionOptionsContext extends ParserRuleContext {
		public TerminalNode CAPPED() { return getToken(LPDLParser.CAPPED, 0); }
		public AdditiveExprContext additiveExpr() {
			return getRuleContext(AdditiveExprContext.class,0);
		}
		public TerminalNode CAP() { return getToken(LPDLParser.CAP, 0); }
		public TerminalNode PERTURN() { return getToken(LPDLParser.PERTURN, 0); }
		public TerminalNode NEXTTURN() { return getToken(LPDLParser.NEXTTURN, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public TerminalNode DURATION() { return getToken(LPDLParser.DURATION, 0); }
		public TerminalNode SCOPE() { return getToken(LPDLParser.SCOPE, 0); }
		public TargetSpecContext targetSpec() {
			return getRuleContext(TargetSpecContext.class,0);
		}
		public TerminalNode PRIORITY() { return getToken(LPDLParser.PRIORITY, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public TerminalNode UNIT() { return getToken(LPDLParser.UNIT, 0); }
		public UnitTypeContext unitType() {
			return getRuleContext(UnitTypeContext.class,0);
		}
		public TerminalNode TIMING() { return getToken(LPDLParser.TIMING, 0); }
		public TimingTypeContext timingType() {
			return getRuleContext(TimingTypeContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(LPDLParser.SELECT, 0); }
		public SelectorTypeContext selectorType() {
			return getRuleContext(SelectorTypeContext.class,0);
		}
		public TerminalNode FROM() { return getToken(LPDLParser.FROM, 0); }
		public TerminalNode COINS() { return getToken(LPDLParser.COINS, 0); }
		public CoinSelectorTypeContext coinSelectorType() {
			return getRuleContext(CoinSelectorTypeContext.class,0);
		}
		public ActionOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterActionOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitActionOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitActionOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionOptionsContext actionOptions() throws RecognitionException {
		ActionOptionsContext _localctx = new ActionOptionsContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_actionOptions);
		int _la;
		try {
			setState(739);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAPPED:
				enterOuterAlt(_localctx, 1);
				{
				setState(713);
				match(CAPPED);
				setState(714);
				additiveExpr();
				}
				break;
			case CAP:
				enterOuterAlt(_localctx, 2);
				{
				setState(715);
				match(CAP);
				setState(716);
				additiveExpr();
				}
				break;
			case PERTURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(717);
				match(PERTURN);
				setState(718);
				additiveExpr();
				}
				break;
			case NEXTTURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(719);
				match(NEXTTURN);
				setState(720);
				booleanLiteral();
				}
				break;
			case DURATION:
				enterOuterAlt(_localctx, 5);
				{
				setState(721);
				match(DURATION);
				setState(722);
				additiveExpr();
				}
				break;
			case SCOPE:
				enterOuterAlt(_localctx, 6);
				{
				setState(723);
				match(SCOPE);
				setState(724);
				targetSpec();
				}
				break;
			case PRIORITY:
				enterOuterAlt(_localctx, 7);
				{
				setState(725);
				match(PRIORITY);
				setState(726);
				match(INT);
				}
				break;
			case UNIT:
				enterOuterAlt(_localctx, 8);
				{
				setState(727);
				match(UNIT);
				setState(728);
				unitType();
				}
				break;
			case TIMING:
				enterOuterAlt(_localctx, 9);
				{
				setState(729);
				match(TIMING);
				setState(730);
				timingType();
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 10);
				{
				setState(731);
				match(SELECT);
				setState(732);
				selectorType();
				setState(735);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(733);
					match(FROM);
					setState(734);
					targetSpec();
					}
				}

				}
				break;
			case COINS:
				enterOuterAlt(_localctx, 11);
				{
				setState(737);
				match(COINS);
				setState(738);
				coinSelectorType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnitTypeContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public UnitTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterUnitType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitUnitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitUnitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitTypeContext unitType() throws RecognitionException {
		UnitTypeContext _localctx = new UnitTypeContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_unitType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(741);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimingTypeContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public TimingTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timingType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterTimingType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitTimingType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitTimingType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimingTypeContext timingType() throws RecognitionException {
		TimingTypeContext _localctx = new TimingTypeContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_timingType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(743);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectorTypeContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public SelectorTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSelectorType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSelectorType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSelectorType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorTypeContext selectorType() throws RecognitionException {
		SelectorTypeContext _localctx = new SelectorTypeContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_selectorType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CoinSelectorTypeContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public CoinSelectorTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coinSelectorType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterCoinSelectorType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitCoinSelectorType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitCoinSelectorType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoinSelectorTypeContext coinSelectorType() throws RecognitionException {
		CoinSelectorTypeContext _localctx = new CoinSelectorTypeContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_coinSelectorType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(747);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionExprContext extends ParserRuleContext {
		public ConditionOrContext conditionOr() {
			return getRuleContext(ConditionOrContext.class,0);
		}
		public ConditionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterConditionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitConditionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitConditionExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionExprContext conditionExpr() throws RecognitionException {
		ConditionExprContext _localctx = new ConditionExprContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_conditionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(749);
			conditionOr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionOrContext extends ParserRuleContext {
		public List<ConditionAndContext> conditionAnd() {
			return getRuleContexts(ConditionAndContext.class);
		}
		public ConditionAndContext conditionAnd(int i) {
			return getRuleContext(ConditionAndContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LPDLParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LPDLParser.OR, i);
		}
		public ConditionOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterConditionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitConditionOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitConditionOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionOrContext conditionOr() throws RecognitionException {
		ConditionOrContext _localctx = new ConditionOrContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_conditionOr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(751);
			conditionAnd();
			setState(756);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(752);
				match(OR);
				setState(753);
				conditionAnd();
				}
				}
				setState(758);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionAndContext extends ParserRuleContext {
		public List<ConditionNotContext> conditionNot() {
			return getRuleContexts(ConditionNotContext.class);
		}
		public ConditionNotContext conditionNot(int i) {
			return getRuleContext(ConditionNotContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(LPDLParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LPDLParser.AND, i);
		}
		public ConditionAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterConditionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitConditionAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitConditionAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionAndContext conditionAnd() throws RecognitionException {
		ConditionAndContext _localctx = new ConditionAndContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_conditionAnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(759);
			conditionNot();
			setState(764);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(760);
				match(AND);
				setState(761);
				conditionNot();
				}
				}
				setState(766);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionNotContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(LPDLParser.NOT, 0); }
		public ConditionNotContext conditionNot() {
			return getRuleContext(ConditionNotContext.class,0);
		}
		public ConditionAtomContext conditionAtom() {
			return getRuleContext(ConditionAtomContext.class,0);
		}
		public ConditionNotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionNot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterConditionNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitConditionNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitConditionNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionNotContext conditionNot() throws RecognitionException {
		ConditionNotContext _localctx = new ConditionNotContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_conditionNot);
		try {
			setState(770);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(767);
				match(NOT);
				setState(768);
				conditionNot();
				}
				break;
			case SELF:
			case TARGET:
			case ALLY:
			case ENEMY:
			case ALL_ALLIES:
			case ALL_ENEMIES:
			case SELF_ALLY:
			case ANY:
			case RIGHT_ALLY:
			case LEFT_ALLY:
			case LOWEST_HP_ALLY:
			case HIGHEST_RESONANCE:
			case LPAREN:
			case INT:
			case FLOAT:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(769);
				conditionAtom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionAtomContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(LPDLParser.LPAREN, 0); }
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LPDLParser.RPAREN, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public RangeCheckContext rangeCheck() {
			return getRuleContext(RangeCheckContext.class,0);
		}
		public DivisibilityCheckContext divisibilityCheck() {
			return getRuleContext(DivisibilityCheckContext.class,0);
		}
		public TagCheckContext tagCheck() {
			return getRuleContext(TagCheckContext.class,0);
		}
		public StatusCheckContext statusCheck() {
			return getRuleContext(StatusCheckContext.class,0);
		}
		public PresenceCheckContext presenceCheck() {
			return getRuleContext(PresenceCheckContext.class,0);
		}
		public ConditionAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterConditionAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitConditionAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitConditionAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionAtomContext conditionAtom() throws RecognitionException {
		ConditionAtomContext _localctx = new ConditionAtomContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_conditionAtom);
		try {
			setState(782);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(772);
				match(LPAREN);
				setState(773);
				conditionExpr();
				setState(774);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(776);
				comparison();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(777);
				rangeCheck();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(778);
				divisibilityCheck();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(779);
				tagCheck();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(780);
				statusCheck();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(781);
				presenceCheck();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ParserRuleContext {
		public List<SideContext> side() {
			return getRuleContexts(SideContext.class);
		}
		public SideContext side(int i) {
			return getRuleContext(SideContext.class,i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
			side();
			setState(785);
			comparator();
			setState(786);
			side();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RangeCheckContext extends ParserRuleContext {
		public List<SideContext> side() {
			return getRuleContexts(SideContext.class);
		}
		public SideContext side(int i) {
			return getRuleContext(SideContext.class,i);
		}
		public TerminalNode IN() { return getToken(LPDLParser.IN, 0); }
		public TerminalNode DOTDOT() { return getToken(LPDLParser.DOTDOT, 0); }
		public TerminalNode LBRACK() { return getToken(LPDLParser.LBRACK, 0); }
		public TerminalNode COMMA() { return getToken(LPDLParser.COMMA, 0); }
		public TerminalNode RBRACK() { return getToken(LPDLParser.RBRACK, 0); }
		public RangeCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeCheck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterRangeCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitRangeCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitRangeCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeCheckContext rangeCheck() throws RecognitionException {
		RangeCheckContext _localctx = new RangeCheckContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_rangeCheck);
		try {
			setState(802);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(788);
				side();
				setState(789);
				match(IN);
				setState(790);
				side();
				setState(791);
				match(DOTDOT);
				setState(792);
				side();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(794);
				side();
				setState(795);
				match(IN);
				setState(796);
				match(LBRACK);
				setState(797);
				side();
				setState(798);
				match(COMMA);
				setState(799);
				side();
				setState(800);
				match(RBRACK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DivisibilityCheckContext extends ParserRuleContext {
		public List<SideContext> side() {
			return getRuleContexts(SideContext.class);
		}
		public SideContext side(int i) {
			return getRuleContext(SideContext.class,i);
		}
		public TerminalNode DIVISIBLE_BY() { return getToken(LPDLParser.DIVISIBLE_BY, 0); }
		public DivisibilityCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divisibilityCheck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterDivisibilityCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitDivisibilityCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitDivisibilityCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivisibilityCheckContext divisibilityCheck() throws RecognitionException {
		DivisibilityCheckContext _localctx = new DivisibilityCheckContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_divisibilityCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(804);
			side();
			setState(805);
			match(DIVISIBLE_BY);
			setState(806);
			side();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagCheckContext extends ParserRuleContext {
		public SideContext side() {
			return getRuleContext(SideContext.class,0);
		}
		public TerminalNode HAS_TAG() { return getToken(LPDLParser.HAS_TAG, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public TagCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagCheck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterTagCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitTagCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitTagCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagCheckContext tagCheck() throws RecognitionException {
		TagCheckContext _localctx = new TagCheckContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_tagCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(808);
			side();
			setState(809);
			match(HAS_TAG);
			setState(812);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(810);
				stringLiteral();
				}
				break;
			case IDENT:
				{
				setState(811);
				match(IDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatusCheckContext extends ParserRuleContext {
		public SideContext side() {
			return getRuleContext(SideContext.class,0);
		}
		public TerminalNode HAS_STATUS() { return getToken(LPDLParser.HAS_STATUS, 0); }
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public StatusCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statusCheck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterStatusCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitStatusCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitStatusCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatusCheckContext statusCheck() throws RecognitionException {
		StatusCheckContext _localctx = new StatusCheckContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_statusCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(814);
			side();
			setState(815);
			match(HAS_STATUS);
			setState(816);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PresenceCheckContext extends ParserRuleContext {
		public SideContext side() {
			return getRuleContext(SideContext.class,0);
		}
		public PresenceCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_presenceCheck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPresenceCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPresenceCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPresenceCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PresenceCheckContext presenceCheck() throws RecognitionException {
		PresenceCheckContext _localctx = new PresenceCheckContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_presenceCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(818);
			side();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SideContext extends ParserRuleContext {
		public SidePrefixContext sidePrefix() {
			return getRuleContext(SidePrefixContext.class,0);
		}
		public TerminalNode DOT() { return getToken(LPDLParser.DOT, 0); }
		public SideCoreContext sideCore() {
			return getRuleContext(SideCoreContext.class,0);
		}
		public SideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_side; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SideContext side() throws RecognitionException {
		SideContext _localctx = new SideContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_side);
		try {
			setState(825);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELF:
			case TARGET:
			case ALLY:
			case ENEMY:
			case ALL_ALLIES:
			case ALL_ENEMIES:
			case SELF_ALLY:
			case ANY:
			case RIGHT_ALLY:
			case LEFT_ALLY:
			case LOWEST_HP_ALLY:
			case HIGHEST_RESONANCE:
				enterOuterAlt(_localctx, 1);
				{
				setState(820);
				sidePrefix();
				setState(821);
				match(DOT);
				setState(822);
				sideCore();
				}
				break;
			case INT:
			case FLOAT:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(824);
				sideCore();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SidePrefixContext extends ParserRuleContext {
		public TerminalNode SELF() { return getToken(LPDLParser.SELF, 0); }
		public TerminalNode TARGET() { return getToken(LPDLParser.TARGET, 0); }
		public TerminalNode ALLY() { return getToken(LPDLParser.ALLY, 0); }
		public TerminalNode ENEMY() { return getToken(LPDLParser.ENEMY, 0); }
		public TerminalNode ALL_ALLIES() { return getToken(LPDLParser.ALL_ALLIES, 0); }
		public TerminalNode ALL_ENEMIES() { return getToken(LPDLParser.ALL_ENEMIES, 0); }
		public TerminalNode SELF_ALLY() { return getToken(LPDLParser.SELF_ALLY, 0); }
		public TerminalNode ANY() { return getToken(LPDLParser.ANY, 0); }
		public TerminalNode RIGHT_ALLY() { return getToken(LPDLParser.RIGHT_ALLY, 0); }
		public TerminalNode LEFT_ALLY() { return getToken(LPDLParser.LEFT_ALLY, 0); }
		public TerminalNode LOWEST_HP_ALLY() { return getToken(LPDLParser.LOWEST_HP_ALLY, 0); }
		public TerminalNode HIGHEST_RESONANCE() { return getToken(LPDLParser.HIGHEST_RESONANCE, 0); }
		public SidePrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sidePrefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSidePrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSidePrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSidePrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SidePrefixContext sidePrefix() throws RecognitionException {
		SidePrefixContext _localctx = new SidePrefixContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_sidePrefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(827);
			_la = _input.LA(1);
			if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 4095L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SideCoreContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public SideCoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sideCore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterSideCore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitSideCore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitSideCore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SideCoreContext sideCore() throws RecognitionException {
		SideCoreContext _localctx = new SideCoreContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_sideCore);
		try {
			setState(831);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(829);
				match(IDENT);
				}
				break;
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(830);
				numberLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(LPDLParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(LPDLParser.NEQ, 0); }
		public TerminalNode GT() { return getToken(LPDLParser.GT, 0); }
		public TerminalNode GTE() { return getToken(LPDLParser.GTE, 0); }
		public TerminalNode LT() { return getToken(LPDLParser.LT, 0); }
		public TerminalNode LTE() { return getToken(LPDLParser.LTE, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(833);
			_la = _input.LA(1);
			if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & 63L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public AdditiveExprContext additiveExpr() {
			return getRuleContext(AdditiveExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(835);
			additiveExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExprContext extends ParserRuleContext {
		public List<MultiplicativeExprContext> multiplicativeExpr() {
			return getRuleContexts(MultiplicativeExprContext.class);
		}
		public MultiplicativeExprContext multiplicativeExpr(int i) {
			return getRuleContext(MultiplicativeExprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(LPDLParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(LPDLParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(LPDLParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(LPDLParser.MINUS, i);
		}
		public AdditiveExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitAdditiveExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitAdditiveExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExprContext additiveExpr() throws RecognitionException {
		AdditiveExprContext _localctx = new AdditiveExprContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_additiveExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(837);
			multiplicativeExpr();
			setState(842);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(838);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(839);
				multiplicativeExpr();
				}
				}
				setState(844);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExprContext extends ParserRuleContext {
		public List<UnaryExprContext> unaryExpr() {
			return getRuleContexts(UnaryExprContext.class);
		}
		public UnaryExprContext unaryExpr(int i) {
			return getRuleContext(UnaryExprContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(LPDLParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(LPDLParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(LPDLParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(LPDLParser.DIV, i);
		}
		public MultiplicativeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterMultiplicativeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitMultiplicativeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitMultiplicativeExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExprContext multiplicativeExpr() throws RecognitionException {
		MultiplicativeExprContext _localctx = new MultiplicativeExprContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_multiplicativeExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
			unaryExpr();
			setState(850);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(846);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(847);
				unaryExpr();
				}
				}
				setState(852);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(LPDLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LPDLParser.MINUS, 0); }
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_unaryExpr);
		int _la;
		try {
			setState(856);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(853);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(854);
				unaryExpr();
				}
				break;
			case SELF:
			case TARGET:
			case ALLY:
			case ENEMY:
			case ALL_ALLIES:
			case ALL_ENEMIES:
			case SELF_ALLY:
			case ANY:
			case RIGHT_ALLY:
			case LEFT_ALLY:
			case LOWEST_HP_ALLY:
			case HIGHEST_RESONANCE:
			case LPAREN:
			case INT:
			case FLOAT:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(855);
				primaryExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends ParserRuleContext {
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public SideContext side() {
			return getRuleContext(SideContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(LPDLParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LPDLParser.RPAREN, 0); }
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPrimaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPrimaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPrimaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_primaryExpr);
		try {
			setState(864);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(858);
				numberLiteral();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(859);
				side();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(860);
				match(LPAREN);
				setState(861);
				expr();
				setState(862);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeckDeclContext extends ParserRuleContext {
		public TerminalNode DECK() { return getToken(LPDLParser.DECK, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public DeckBodyContext deckBody() {
			return getRuleContext(DeckBodyContext.class,0);
		}
		public DeckDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deckDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterDeckDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitDeckDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitDeckDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeckDeclContext deckDecl() throws RecognitionException {
		DeckDeclContext _localctx = new DeckDeclContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_deckDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866);
			match(DECK);
			setState(867);
			stringLiteral();
			setState(868);
			deckBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeckBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<DeckStmtContext> deckStmt() {
			return getRuleContexts(DeckStmtContext.class);
		}
		public DeckStmtContext deckStmt(int i) {
			return getRuleContext(DeckStmtContext.class,i);
		}
		public DeckBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deckBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterDeckBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitDeckBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitDeckBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeckBodyContext deckBody() throws RecognitionException {
		DeckBodyContext _localctx = new DeckBodyContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_deckBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870);
			match(LBRACE);
			setState(874);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6291464L) != 0)) {
				{
				{
				setState(871);
				deckStmt();
				}
				}
				setState(876);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(877);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeckStmtContext extends ParserRuleContext {
		public PersonasBlockContext personasBlock() {
			return getRuleContext(PersonasBlockContext.class,0);
		}
		public SynergyBlockContext synergyBlock() {
			return getRuleContext(SynergyBlockContext.class,0);
		}
		public MetaStmtContext metaStmt() {
			return getRuleContext(MetaStmtContext.class,0);
		}
		public DeckStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deckStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterDeckStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitDeckStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitDeckStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeckStmtContext deckStmt() throws RecognitionException {
		DeckStmtContext _localctx = new DeckStmtContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_deckStmt);
		try {
			setState(882);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PERSONAS:
				enterOuterAlt(_localctx, 1);
				{
				setState(879);
				personasBlock();
				}
				break;
			case SYNERGY:
				enterOuterAlt(_localctx, 2);
				{
				setState(880);
				synergyBlock();
				}
				break;
			case META:
				enterOuterAlt(_localctx, 3);
				{
				setState(881);
				metaStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PersonasBlockContext extends ParserRuleContext {
		public TerminalNode PERSONAS() { return getToken(LPDLParser.PERSONAS, 0); }
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<PersonasStmtContext> personasStmt() {
			return getRuleContexts(PersonasStmtContext.class);
		}
		public PersonasStmtContext personasStmt(int i) {
			return getRuleContext(PersonasStmtContext.class,i);
		}
		public PersonasBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_personasBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPersonasBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPersonasBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPersonasBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PersonasBlockContext personasBlock() throws RecognitionException {
		PersonasBlockContext _localctx = new PersonasBlockContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_personasBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884);
			match(PERSONAS);
			setState(885);
			match(LBRACE);
			setState(889);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD) {
				{
				{
				setState(886);
				personasStmt();
				}
				}
				setState(891);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(892);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PersonasStmtContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(LPDLParser.ADD, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public PersonasStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_personasStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterPersonasStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitPersonasStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitPersonasStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PersonasStmtContext personasStmt() throws RecognitionException {
		PersonasStmtContext _localctx = new PersonasStmtContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_personasStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(894);
			match(ADD);
			setState(897);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(895);
				stringLiteral();
				}
				break;
			case IDENT:
				{
				setState(896);
				match(IDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LPDLParser.LBRACE, 0); }
		public List<ObjectPairContext> objectPair() {
			return getRuleContexts(ObjectPairContext.class);
		}
		public ObjectPairContext objectPair(int i) {
			return getRuleContext(ObjectPairContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(LPDLParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LPDLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LPDLParser.COMMA, i);
		}
		public ObjectLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterObjectLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitObjectLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitObjectLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectLiteralContext objectLiteral() throws RecognitionException {
		ObjectLiteralContext _localctx = new ObjectLiteralContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_objectLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(899);
			match(LBRACE);
			setState(900);
			objectPair();
			setState(905);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(901);
				match(COMMA);
				setState(902);
				objectPair();
				}
				}
				setState(907);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(908);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectPairContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LPDLParser.IDENT, 0); }
		public TerminalNode COLON() { return getToken(LPDLParser.COLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ObjectPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectPair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterObjectPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitObjectPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitObjectPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectPairContext objectPair() throws RecognitionException {
		ObjectPairContext _localctx = new ObjectPairContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_objectPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(910);
			match(IDENT);
			setState(911);
			match(COLON);
			setState(912);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(LPDLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(LPDLParser.FALSE, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberLiteralContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(LPDLParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(LPDLParser.INT, 0); }
		public NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberLiteralContext numberLiteral() throws RecognitionException {
		NumberLiteralContext _localctx = new NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_numberLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(916);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(LPDLParser.STRING, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(918);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TripleStringLiteralContext extends ParserRuleContext {
		public TerminalNode TRIPLE_STRING() { return getToken(LPDLParser.TRIPLE_STRING, 0); }
		public TripleStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tripleStringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterTripleStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitTripleStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitTripleStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TripleStringLiteralContext tripleStringLiteral() throws RecognitionException {
		TripleStringLiteralContext _localctx = new TripleStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_tripleStringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(920);
			match(TRIPLE_STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextDeclContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(LPDLParser.TEXT, 0); }
		public TripleStringLiteralContext tripleStringLiteral() {
			return getRuleContext(TripleStringLiteralContext.class,0);
		}
		public TextDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).enterTextDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LPDLListener ) ((LPDLListener)listener).exitTextDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LPDLVisitor ) return ((LPDLVisitor<? extends T>)visitor).visitTextDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextDeclContext textDecl() throws RecognitionException {
		TextDeclContext _localctx = new TextDeclContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_textDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(922);
			match(TEXT);
			setState(923);
			tripleStringLiteral();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0081\u039e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"+
		"^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"+
		"c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"+
		"h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"+
		"m\u0001\u0000\u0001\u0000\u0005\u0000\u00df\b\u0000\n\u0000\f\u0000\u00e2"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0005\u0002\u00ec\b\u0002\n\u0002\f\u0002"+
		"\u00ef\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003\u0102\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0109\b\u0005\u0001\u0005\u0003\u0005\u010c\b"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u011f\b\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0005\f\u0126\b\f\n\f\f\f\u0129\t\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u0135\b\u000e\n\u000e\f\u000e\u0138\t\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0144\b\u0010"+
		"\n\u0010\f\u0010\u0147\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u0154\b\u0011\n\u0011\f\u0011\u0157\t\u0011"+
		"\u0001\u0011\u0003\u0011\u015a\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u0161\b\u0012\n\u0012\f\u0012\u0164"+
		"\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u016c\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u0173\b\u0014\n\u0014\f\u0014\u0176\t\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0182\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u018a\b\u0017\n\u0017\f\u0017\u018d\t\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0194\b\u0018\u0001"+
		"\u0018\u0004\u0018\u0197\b\u0018\u000b\u0018\f\u0018\u0198\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0003\u0019\u019e\b\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u01a3\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u01a9\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u01ae\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0005\u001b\u01b4\b\u001b\n\u001b\f\u001b\u01b7\t\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u01c4\b\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001!\u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0003#\u01dc\b#"+
		"\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0005&\u01e6"+
		"\b&\n&\f&\u01e9\t&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0003\'\u01f4\b\'\u0001(\u0001(\u0001(\u0001)\u0001"+
		")\u0001)\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001,\u0001,\u0001"+
		",\u0001-\u0001-\u0003-\u0207\b-\u0001-\u0001-\u0001.\u0001.\u0003.\u020d"+
		"\b.\u0001/\u0001/\u0005/\u0211\b/\n/\f/\u0214\t/\u0001/\u0001/\u00010"+
		"\u00010\u00010\u00010\u00010\u00010\u00010\u00030\u021f\b0\u00011\u0001"+
		"1\u00011\u00012\u00012\u00012\u00013\u00013\u00013\u00053\u022a\b3\n3"+
		"\f3\u022d\t3\u00013\u00013\u00014\u00014\u00014\u00014\u00014\u00014\u0003"+
		"4\u0237\b4\u00015\u00015\u00015\u00016\u00016\u00016\u00017\u00017\u0001"+
		"7\u00017\u00017\u00018\u00018\u00018\u00048\u0247\b8\u000b8\f8\u0248\u0001"+
		"8\u00018\u00019\u00019\u00039\u024f\b9\u00019\u00019\u0001:\u0001:\u0001"+
		";\u0001;\u0001;\u0003;\u0258\b;\u0001;\u0001;\u0001<\u0001<\u0005<\u025e"+
		"\b<\n<\f<\u0261\t<\u0001<\u0001<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0001=\u0001=\u0003=\u026e\b=\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0001>\u0003>\u0276\b>\u0001?\u0001?\u0001?\u0001@\u0001@\u0001@\u0003"+
		"@\u027e\b@\u0001A\u0003A\u0281\bA\u0001A\u0001A\u0001A\u0001B\u0003B\u0287"+
		"\bB\u0001B\u0001B\u0001B\u0003B\u028c\bB\u0001B\u0001B\u0005B\u0290\b"+
		"B\nB\fB\u0293\tB\u0001B\u0003B\u0296\bB\u0001B\u0001B\u0001B\u0003B\u029b"+
		"\bB\u0001B\u0005B\u029e\bB\nB\fB\u02a1\tB\u0001B\u0001B\u0001B\u0001B"+
		"\u0005B\u02a7\bB\nB\fB\u02aa\tB\u0003B\u02ac\bB\u0001C\u0001C\u0001D\u0001"+
		"D\u0001D\u0003D\u02b3\bD\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001"+
		"D\u0003D\u02bc\bD\u0001E\u0001E\u0001F\u0001F\u0001G\u0001G\u0001H\u0005"+
		"H\u02c5\bH\nH\fH\u02c8\tH\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001"+
		"I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001"+
		"I\u0001I\u0001I\u0001I\u0001I\u0001I\u0003I\u02e0\bI\u0001I\u0001I\u0003"+
		"I\u02e4\bI\u0001J\u0001J\u0001K\u0001K\u0001L\u0001L\u0001M\u0001M\u0001"+
		"N\u0001N\u0001O\u0001O\u0001O\u0005O\u02f3\bO\nO\fO\u02f6\tO\u0001P\u0001"+
		"P\u0001P\u0005P\u02fb\bP\nP\fP\u02fe\tP\u0001Q\u0001Q\u0001Q\u0003Q\u0303"+
		"\bQ\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0003R\u030f\bR\u0001S\u0001S\u0001S\u0001S\u0001T\u0001T\u0001T\u0001"+
		"T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001"+
		"T\u0003T\u0323\bT\u0001U\u0001U\u0001U\u0001U\u0001V\u0001V\u0001V\u0001"+
		"V\u0003V\u032d\bV\u0001W\u0001W\u0001W\u0001W\u0001X\u0001X\u0001Y\u0001"+
		"Y\u0001Y\u0001Y\u0001Y\u0003Y\u033a\bY\u0001Z\u0001Z\u0001[\u0001[\u0003"+
		"[\u0340\b[\u0001\\\u0001\\\u0001]\u0001]\u0001^\u0001^\u0001^\u0005^\u0349"+
		"\b^\n^\f^\u034c\t^\u0001_\u0001_\u0001_\u0005_\u0351\b_\n_\f_\u0354\t"+
		"_\u0001`\u0001`\u0001`\u0003`\u0359\b`\u0001a\u0001a\u0001a\u0001a\u0001"+
		"a\u0001a\u0003a\u0361\ba\u0001b\u0001b\u0001b\u0001b\u0001c\u0001c\u0005"+
		"c\u0369\bc\nc\fc\u036c\tc\u0001c\u0001c\u0001d\u0001d\u0001d\u0003d\u0373"+
		"\bd\u0001e\u0001e\u0001e\u0005e\u0378\be\ne\fe\u037b\te\u0001e\u0001e"+
		"\u0001f\u0001f\u0001f\u0003f\u0382\bf\u0001g\u0001g\u0001g\u0001g\u0005"+
		"g\u0388\bg\ng\fg\u038b\tg\u0001g\u0001g\u0001h\u0001h\u0001h\u0001h\u0001"+
		"i\u0001i\u0001j\u0001j\u0001k\u0001k\u0001l\u0001l\u0001m\u0001m\u0001"+
		"m\u0001m\u0000\u0000n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\"+
		"^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090"+
		"\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8"+
		"\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0"+
		"\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8"+
		"\u00da\u0000\t\u0001\u0000w}\u0002\u0000uu~~\u0001\u0000:;\u0001\u0000"+
		"IT\u0001\u0000UZ\u0001\u0000bc\u0001\u0000de\u0001\u0000st\u0001\u0000"+
		"qr\u03b5\u0000\u00e0\u0001\u0000\u0000\u0000\u0002\u00e5\u0001\u0000\u0000"+
		"\u0000\u0004\u00e9\u0001\u0000\u0000\u0000\u0006\u0101\u0001\u0000\u0000"+
		"\u0000\b\u0103\u0001\u0000\u0000\u0000\n\u010b\u0001\u0000\u0000\u0000"+
		"\f\u010d\u0001\u0000\u0000\u0000\u000e\u0110\u0001\u0000\u0000\u0000\u0010"+
		"\u0112\u0001\u0000\u0000\u0000\u0012\u0115\u0001\u0000\u0000\u0000\u0014"+
		"\u0118\u0001\u0000\u0000\u0000\u0016\u011b\u0001\u0000\u0000\u0000\u0018"+
		"\u0120\u0001\u0000\u0000\u0000\u001a\u012c\u0001\u0000\u0000\u0000\u001c"+
		"\u012f\u0001\u0000\u0000\u0000\u001e\u013b\u0001\u0000\u0000\u0000 \u013e"+
		"\u0001\u0000\u0000\u0000\"\u0159\u0001\u0000\u0000\u0000$\u015b\u0001"+
		"\u0000\u0000\u0000&\u016b\u0001\u0000\u0000\u0000(\u016d\u0001\u0000\u0000"+
		"\u0000*\u0181\u0001\u0000\u0000\u0000,\u0183\u0001\u0000\u0000\u0000."+
		"\u0186\u0001\u0000\u0000\u00000\u0190\u0001\u0000\u0000\u00002\u01a8\u0001"+
		"\u0000\u0000\u00004\u01aa\u0001\u0000\u0000\u00006\u01b1\u0001\u0000\u0000"+
		"\u00008\u01c3\u0001\u0000\u0000\u0000:\u01c5\u0001\u0000\u0000\u0000<"+
		"\u01c8\u0001\u0000\u0000\u0000>\u01cb\u0001\u0000\u0000\u0000@\u01ce\u0001"+
		"\u0000\u0000\u0000B\u01d1\u0001\u0000\u0000\u0000D\u01d4\u0001\u0000\u0000"+
		"\u0000F\u01d7\u0001\u0000\u0000\u0000H\u01dd\u0001\u0000\u0000\u0000J"+
		"\u01e1\u0001\u0000\u0000\u0000L\u01e3\u0001\u0000\u0000\u0000N\u01f3\u0001"+
		"\u0000\u0000\u0000P\u01f5\u0001\u0000\u0000\u0000R\u01f8\u0001\u0000\u0000"+
		"\u0000T\u01fb\u0001\u0000\u0000\u0000V\u01fe\u0001\u0000\u0000\u0000X"+
		"\u0201\u0001\u0000\u0000\u0000Z\u0204\u0001\u0000\u0000\u0000\\\u020c"+
		"\u0001\u0000\u0000\u0000^\u020e\u0001\u0000\u0000\u0000`\u021e\u0001\u0000"+
		"\u0000\u0000b\u0220\u0001\u0000\u0000\u0000d\u0223\u0001\u0000\u0000\u0000"+
		"f\u0226\u0001\u0000\u0000\u0000h\u0236\u0001\u0000\u0000\u0000j\u0238"+
		"\u0001\u0000\u0000\u0000l\u023b\u0001\u0000\u0000\u0000n\u023e\u0001\u0000"+
		"\u0000\u0000p\u0243\u0001\u0000\u0000\u0000r\u024c\u0001\u0000\u0000\u0000"+
		"t\u0252\u0001\u0000\u0000\u0000v\u0254\u0001\u0000\u0000\u0000x\u025b"+
		"\u0001\u0000\u0000\u0000z\u026d\u0001\u0000\u0000\u0000|\u026f\u0001\u0000"+
		"\u0000\u0000~\u0277\u0001\u0000\u0000\u0000\u0080\u027d\u0001\u0000\u0000"+
		"\u0000\u0082\u0280\u0001\u0000\u0000\u0000\u0084\u02ab\u0001\u0000\u0000"+
		"\u0000\u0086\u02ad\u0001\u0000\u0000\u0000\u0088\u02bb\u0001\u0000\u0000"+
		"\u0000\u008a\u02bd\u0001\u0000\u0000\u0000\u008c\u02bf\u0001\u0000\u0000"+
		"\u0000\u008e\u02c1\u0001\u0000\u0000\u0000\u0090\u02c6\u0001\u0000\u0000"+
		"\u0000\u0092\u02e3\u0001\u0000\u0000\u0000\u0094\u02e5\u0001\u0000\u0000"+
		"\u0000\u0096\u02e7\u0001\u0000\u0000\u0000\u0098\u02e9\u0001\u0000\u0000"+
		"\u0000\u009a\u02eb\u0001\u0000\u0000\u0000\u009c\u02ed\u0001\u0000\u0000"+
		"\u0000\u009e\u02ef\u0001\u0000\u0000\u0000\u00a0\u02f7\u0001\u0000\u0000"+
		"\u0000\u00a2\u0302\u0001\u0000\u0000\u0000\u00a4\u030e\u0001\u0000\u0000"+
		"\u0000\u00a6\u0310\u0001\u0000\u0000\u0000\u00a8\u0322\u0001\u0000\u0000"+
		"\u0000\u00aa\u0324\u0001\u0000\u0000\u0000\u00ac\u0328\u0001\u0000\u0000"+
		"\u0000\u00ae\u032e\u0001\u0000\u0000\u0000\u00b0\u0332\u0001\u0000\u0000"+
		"\u0000\u00b2\u0339\u0001\u0000\u0000\u0000\u00b4\u033b\u0001\u0000\u0000"+
		"\u0000\u00b6\u033f\u0001\u0000\u0000\u0000\u00b8\u0341\u0001\u0000\u0000"+
		"\u0000\u00ba\u0343\u0001\u0000\u0000\u0000\u00bc\u0345\u0001\u0000\u0000"+
		"\u0000\u00be\u034d\u0001\u0000\u0000\u0000\u00c0\u0358\u0001\u0000\u0000"+
		"\u0000\u00c2\u0360\u0001\u0000\u0000\u0000\u00c4\u0362\u0001\u0000\u0000"+
		"\u0000\u00c6\u0366\u0001\u0000\u0000\u0000\u00c8\u0372\u0001\u0000\u0000"+
		"\u0000\u00ca\u0374\u0001\u0000\u0000\u0000\u00cc\u037e\u0001\u0000\u0000"+
		"\u0000\u00ce\u0383\u0001\u0000\u0000\u0000\u00d0\u038e\u0001\u0000\u0000"+
		"\u0000\u00d2\u0392\u0001\u0000\u0000\u0000\u00d4\u0394\u0001\u0000\u0000"+
		"\u0000\u00d6\u0396\u0001\u0000\u0000\u0000\u00d8\u0398\u0001\u0000\u0000"+
		"\u0000\u00da\u039a\u0001\u0000\u0000\u0000\u00dc\u00df\u0003\u0002\u0001"+
		"\u0000\u00dd\u00df\u0003\u00c4b\u0000\u00de\u00dc\u0001\u0000\u0000\u0000"+
		"\u00de\u00dd\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e3\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e4\u0005\u0000\u0000\u0001\u00e4\u0001\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e6\u0005\u0001\u0000\u0000\u00e6\u00e7\u0003\u00d6k\u0000\u00e7"+
		"\u00e8\u0003\u0004\u0002\u0000\u00e8\u0003\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ed\u0005f\u0000\u0000\u00ea\u00ec\u0003\u0006\u0003\u0000\u00eb\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed\u00eb"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00f0"+
		"\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0\u00f1"+
		"\u0005g\u0000\u0000\u00f1\u0005\u0001\u0000\u0000\u0000\u00f2\u0102\u0003"+
		"\b\u0004\u0000\u00f3\u0102\u0003\u0016\u000b\u0000\u00f4\u0102\u0003\f"+
		"\u0006\u0000\u00f5\u0102\u0003\u0010\b\u0000\u00f6\u0102\u0003\u0012\t"+
		"\u0000\u00f7\u0102\u0003\u0014\n\u0000\u00f8\u0102\u0003\u0018\f\u0000"+
		"\u00f9\u0102\u0003\u001c\u000e\u0000\u00fa\u0102\u0003 \u0010\u0000\u00fb"+
		"\u0102\u0003$\u0012\u0000\u00fc\u0102\u0003.\u0017\u0000\u00fd\u0102\u0003"+
		"4\u001a\u0000\u00fe\u0102\u0003v;\u0000\u00ff\u0102\u0003(\u0014\u0000"+
		"\u0100\u0102\u0003,\u0016\u0000\u0101\u00f2\u0001\u0000\u0000\u0000\u0101"+
		"\u00f3\u0001\u0000\u0000\u0000\u0101\u00f4\u0001\u0000\u0000\u0000\u0101"+
		"\u00f5\u0001\u0000\u0000\u0000\u0101\u00f6\u0001\u0000\u0000\u0000\u0101"+
		"\u00f7\u0001\u0000\u0000\u0000\u0101\u00f8\u0001\u0000\u0000\u0000\u0101"+
		"\u00f9\u0001\u0000\u0000\u0000\u0101\u00fa\u0001\u0000\u0000\u0000\u0101"+
		"\u00fb\u0001\u0000\u0000\u0000\u0101\u00fc\u0001\u0000\u0000\u0000\u0101"+
		"\u00fd\u0001\u0000\u0000\u0000\u0101\u00fe\u0001\u0000\u0000\u0000\u0101"+
		"\u00ff\u0001\u0000\u0000\u0000\u0101\u0100\u0001\u0000\u0000\u0000\u0102"+
		"\u0007\u0001\u0000\u0000\u0000\u0103\u0104\u0005\u0005\u0000\u0000\u0104"+
		"\u0105\u0003\n\u0005\u0000\u0105\t\u0001\u0000\u0000\u0000\u0106\u0108"+
		"\u0005q\u0000\u0000\u0107\u0109\u0005l\u0000\u0000\u0108\u0107\u0001\u0000"+
		"\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010c\u0001\u0000"+
		"\u0000\u0000\u010a\u010c\u0005~\u0000\u0000\u010b\u0106\u0001\u0000\u0000"+
		"\u0000\u010b\u010a\u0001\u0000\u0000\u0000\u010c\u000b\u0001\u0000\u0000"+
		"\u0000\u010d\u010e\u0005\u0007\u0000\u0000\u010e\u010f\u0003\u000e\u0007"+
		"\u0000\u010f\r\u0001\u0000\u0000\u0000\u0110\u0111\u0007\u0000\u0000\u0000"+
		"\u0111\u000f\u0001\u0000\u0000\u0000\u0112\u0113\u0005\b\u0000\u0000\u0113"+
		"\u0114\u0003\u00d6k\u0000\u0114\u0011\u0001\u0000\u0000\u0000\u0115\u0116"+
		"\u0005\t\u0000\u0000\u0116\u0117\u0005q\u0000\u0000\u0117\u0013\u0001"+
		"\u0000\u0000\u0000\u0118\u0119\u0005\n\u0000\u0000\u0119\u011a\u0005q"+
		"\u0000\u0000\u011a\u0015\u0001\u0000\u0000\u0000\u011b\u011e\u0005\u0006"+
		"\u0000\u0000\u011c\u011f\u0003\u00d6k\u0000\u011d\u011f\u0005~\u0000\u0000"+
		"\u011e\u011c\u0001\u0000\u0000\u0000\u011e\u011d\u0001\u0000\u0000\u0000"+
		"\u011f\u0017\u0001\u0000\u0000\u0000\u0120\u0121\u0005\u000b\u0000\u0000"+
		"\u0121\u0122\u0005f\u0000\u0000\u0122\u0127\u0003\u001a\r\u0000\u0123"+
		"\u0124\u0005m\u0000\u0000\u0124\u0126\u0003\u001a\r\u0000\u0125\u0123"+
		"\u0001\u0000\u0000\u0000\u0126\u0129\u0001\u0000\u0000\u0000\u0127\u0125"+
		"\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u012a"+
		"\u0001\u0000\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u012a\u012b"+
		"\u0005g\u0000\u0000\u012b\u0019\u0001\u0000\u0000\u0000\u012c\u012d\u0005"+
		"~\u0000\u0000\u012d\u012e\u0005~\u0000\u0000\u012e\u001b\u0001\u0000\u0000"+
		"\u0000\u012f\u0130\u0005\f\u0000\u0000\u0130\u0131\u0005f\u0000\u0000"+
		"\u0131\u0136\u0003\u001e\u000f\u0000\u0132\u0133\u0005m\u0000\u0000\u0133"+
		"\u0135\u0003\u001e\u000f\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0135"+
		"\u0138\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136"+
		"\u0137\u0001\u0000\u0000\u0000\u0137\u0139\u0001\u0000\u0000\u0000\u0138"+
		"\u0136\u0001\u0000\u0000\u0000\u0139\u013a\u0005g\u0000\u0000\u013a\u001d"+
		"\u0001\u0000\u0000\u0000\u013b\u013c\u0005~\u0000\u0000\u013c\u013d\u0005"+
		"q\u0000\u0000\u013d\u001f\u0001\u0000\u0000\u0000\u013e\u013f\u0005\r"+
		"\u0000\u0000\u013f\u0140\u0005f\u0000\u0000\u0140\u0145\u0003\"\u0011"+
		"\u0000\u0141\u0142\u0005m\u0000\u0000\u0142\u0144\u0003\"\u0011\u0000"+
		"\u0143\u0141\u0001\u0000\u0000\u0000\u0144\u0147\u0001\u0000\u0000\u0000"+
		"\u0145\u0143\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000"+
		"\u0146\u0148\u0001\u0000\u0000\u0000\u0147\u0145\u0001\u0000\u0000\u0000"+
		"\u0148\u0149\u0005g\u0000\u0000\u0149!\u0001\u0000\u0000\u0000\u014a\u014b"+
		"\u0005\u000e\u0000\u0000\u014b\u015a\u0005q\u0000\u0000\u014c\u014d\u0005"+
		"\u000f\u0000\u0000\u014d\u015a\u0003\u00d4j\u0000\u014e\u014f\u0005\u0010"+
		"\u0000\u0000\u014f\u0150\u0005j\u0000\u0000\u0150\u0155\u0005q\u0000\u0000"+
		"\u0151\u0152\u0005m\u0000\u0000\u0152\u0154\u0005q\u0000\u0000\u0153\u0151"+
		"\u0001\u0000\u0000\u0000\u0154\u0157\u0001\u0000\u0000\u0000\u0155\u0153"+
		"\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u0156\u0158"+
		"\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0158\u015a"+
		"\u0005k\u0000\u0000\u0159\u014a\u0001\u0000\u0000\u0000\u0159\u014c\u0001"+
		"\u0000\u0000\u0000\u0159\u014e\u0001\u0000\u0000\u0000\u015a#\u0001\u0000"+
		"\u0000\u0000\u015b\u015c\u0005\u0011\u0000\u0000\u015c\u015d\u0005f\u0000"+
		"\u0000\u015d\u0162\u0003&\u0013\u0000\u015e\u015f\u0005m\u0000\u0000\u015f"+
		"\u0161\u0003&\u0013\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0161\u0164"+
		"\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0163"+
		"\u0001\u0000\u0000\u0000\u0163\u0165\u0001\u0000\u0000\u0000\u0164\u0162"+
		"\u0001\u0000\u0000\u0000\u0165\u0166\u0005g\u0000\u0000\u0166%\u0001\u0000"+
		"\u0000\u0000\u0167\u0168\u0005\u001a\u0000\u0000\u0168\u016c\u0005~\u0000"+
		"\u0000\u0169\u016a\u0005\u0012\u0000\u0000\u016a\u016c\u0005q\u0000\u0000"+
		"\u016b\u0167\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000"+
		"\u016c\'\u0001\u0000\u0000\u0000\u016d\u016e\u0005#\u0000\u0000\u016e"+
		"\u016f\u0005f\u0000\u0000\u016f\u0174\u0003*\u0015\u0000\u0170\u0171\u0005"+
		"m\u0000\u0000\u0171\u0173\u0003*\u0015\u0000\u0172\u0170\u0001\u0000\u0000"+
		"\u0000\u0173\u0176\u0001\u0000\u0000\u0000\u0174\u0172\u0001\u0000\u0000"+
		"\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175\u0177\u0001\u0000\u0000"+
		"\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0177\u0178\u0005g\u0000\u0000"+
		"\u0178)\u0001\u0000\u0000\u0000\u0179\u017a\u0005\u001a\u0000\u0000\u017a"+
		"\u0182\u0005~\u0000\u0000\u017b\u017c\u0005\u0013\u0000\u0000\u017c\u0182"+
		"\u0003\u00d6k\u0000\u017d\u017e\u0005C\u0000\u0000\u017e\u0182\u0005q"+
		"\u0000\u0000\u017f\u0180\u0005\u0014\u0000\u0000\u0180\u0182\u0003\u00d2"+
		"i\u0000\u0181\u0179\u0001\u0000\u0000\u0000\u0181\u017b\u0001\u0000\u0000"+
		"\u0000\u0181\u017d\u0001\u0000\u0000\u0000\u0181\u017f\u0001\u0000\u0000"+
		"\u0000\u0182+\u0001\u0000\u0000\u0000\u0183\u0184\u0005\u0015\u0000\u0000"+
		"\u0184\u0185\u0003\u00ceg\u0000\u0185-\u0001\u0000\u0000\u0000\u0186\u0187"+
		"\u0005\u0016\u0000\u0000\u0187\u018b\u0005f\u0000\u0000\u0188\u018a\u0003"+
		"0\u0018\u0000\u0189\u0188\u0001\u0000\u0000\u0000\u018a\u018d\u0001\u0000"+
		"\u0000\u0000\u018b\u0189\u0001\u0000\u0000\u0000\u018b\u018c\u0001\u0000"+
		"\u0000\u0000\u018c\u018e\u0001\u0000\u0000\u0000\u018d\u018b\u0001\u0000"+
		"\u0000\u0000\u018e\u018f\u0005g\u0000\u0000\u018f/\u0001\u0000\u0000\u0000"+
		"\u0190\u0193\u0005\u0017\u0000\u0000\u0191\u0194\u0003\u00d6k\u0000\u0192"+
		"\u0194\u0005~\u0000\u0000\u0193\u0191\u0001\u0000\u0000\u0000\u0193\u0192"+
		"\u0001\u0000\u0000\u0000\u0194\u0196\u0001\u0000\u0000\u0000\u0195\u0197"+
		"\u00032\u0019\u0000\u0196\u0195\u0001\u0000\u0000\u0000\u0197\u0198\u0001"+
		"\u0000\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0198\u0199\u0001"+
		"\u0000\u0000\u0000\u01991\u0001\u0000\u0000\u0000\u019a\u019b\u0005\u0018"+
		"\u0000\u0000\u019b\u019d\u0005~\u0000\u0000\u019c\u019e\u0003\u00bc^\u0000"+
		"\u019d\u019c\u0001\u0000\u0000\u0000\u019d\u019e\u0001\u0000\u0000\u0000"+
		"\u019e\u01a9\u0001\u0000\u0000\u0000\u019f\u01a0\u0005\u0019\u0000\u0000"+
		"\u01a0\u01a2\u0005~\u0000\u0000\u01a1\u01a3\u0003\u00bc^\u0000\u01a2\u01a1"+
		"\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a9"+
		"\u0001\u0000\u0000\u0000\u01a4\u01a5\u0005\u001a\u0000\u0000\u01a5\u01a9"+
		"\u0005~\u0000\u0000\u01a6\u01a7\u0005\u001c\u0000\u0000\u01a7\u01a9\u0003"+
		"\u00bc^\u0000\u01a8\u019a\u0001\u0000\u0000\u0000\u01a8\u019f\u0001\u0000"+
		"\u0000\u0000\u01a8\u01a4\u0001\u0000\u0000\u0000\u01a8\u01a6\u0001\u0000"+
		"\u0000\u0000\u01a93\u0001\u0000\u0000\u0000\u01aa\u01ab\u0005\u001d\u0000"+
		"\u0000\u01ab\u01ad\u0005q\u0000\u0000\u01ac\u01ae\u0003\u00d6k\u0000\u01ad"+
		"\u01ac\u0001\u0000\u0000\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01ae"+
		"\u01af\u0001\u0000\u0000\u0000\u01af\u01b0\u00036\u001b\u0000\u01b05\u0001"+
		"\u0000\u0000\u0000\u01b1\u01b5\u0005f\u0000\u0000\u01b2\u01b4\u00038\u001c"+
		"\u0000\u01b3\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000"+
		"\u0000\u01b6\u01b8\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000"+
		"\u0000\u01b8\u01b9\u0005g\u0000\u0000\u01b97\u0001\u0000\u0000\u0000\u01ba"+
		"\u01c4\u0003:\u001d\u0000\u01bb\u01c4\u0003<\u001e\u0000\u01bc\u01c4\u0003"+
		">\u001f\u0000\u01bd\u01c4\u0003@ \u0000\u01be\u01c4\u0003B!\u0000\u01bf"+
		"\u01c4\u0003D\"\u0000\u01c0\u01c4\u0003F#\u0000\u01c1\u01c4\u0003\u00da"+
		"m\u0000\u01c2\u01c4\u0003H$\u0000\u01c3\u01ba\u0001\u0000\u0000\u0000"+
		"\u01c3\u01bb\u0001\u0000\u0000\u0000\u01c3\u01bc\u0001\u0000\u0000\u0000"+
		"\u01c3\u01bd\u0001\u0000\u0000\u0000\u01c3\u01be\u0001\u0000\u0000\u0000"+
		"\u01c3\u01bf\u0001\u0000\u0000\u0000\u01c3\u01c0\u0001\u0000\u0000\u0000"+
		"\u01c3\u01c1\u0001\u0000\u0000\u0000\u01c3\u01c2\u0001\u0000\u0000\u0000"+
		"\u01c49\u0001\u0000\u0000\u0000\u01c5\u01c6\u0005\u001e\u0000\u0000\u01c6"+
		"\u01c7\u0005~\u0000\u0000\u01c7;\u0001\u0000\u0000\u0000\u01c8\u01c9\u0005"+
		"\u0007\u0000\u0000\u01c9\u01ca\u0003\u000e\u0007\u0000\u01ca=\u0001\u0000"+
		"\u0000\u0000\u01cb\u01cc\u0005\u001f\u0000\u0000\u01cc\u01cd\u0005~\u0000"+
		"\u0000\u01cd?\u0001\u0000\u0000\u0000\u01ce\u01cf\u0005 \u0000\u0000\u01cf"+
		"\u01d0\u0005~\u0000\u0000\u01d0A\u0001\u0000\u0000\u0000\u01d1\u01d2\u0005"+
		"!\u0000\u0000\u01d2\u01d3\u0005q\u0000\u0000\u01d3C\u0001\u0000\u0000"+
		"\u0000\u01d4\u01d5\u0005\"\u0000\u0000\u01d5\u01d6\u0005~\u0000\u0000"+
		"\u01d6E\u0001\u0000\u0000\u0000\u01d7\u01db\u0005#\u0000\u0000\u01d8\u01dc"+
		"\u0005~\u0000\u0000\u01d9\u01dc\u0005$\u0000\u0000\u01da\u01dc\u0003\u00d6"+
		"k\u0000\u01db\u01d8\u0001\u0000\u0000\u0000\u01db\u01d9\u0001\u0000\u0000"+
		"\u0000\u01db\u01da\u0001\u0000\u0000\u0000\u01dcG\u0001\u0000\u0000\u0000"+
		"\u01dd\u01de\u0005%\u0000\u0000\u01de\u01df\u0003J%\u0000\u01df\u01e0"+
		"\u0003L&\u0000\u01e0I\u0001\u0000\u0000\u0000\u01e1\u01e2\u0007\u0001"+
		"\u0000\u0000\u01e2K\u0001\u0000\u0000\u0000\u01e3\u01e7\u0005f\u0000\u0000"+
		"\u01e4\u01e6\u0003N\'\u0000\u01e5\u01e4\u0001\u0000\u0000\u0000\u01e6"+
		"\u01e9\u0001\u0000\u0000\u0000\u01e7\u01e5\u0001\u0000\u0000\u0000\u01e7"+
		"\u01e8\u0001\u0000\u0000\u0000\u01e8\u01ea\u0001\u0000\u0000\u0000\u01e9"+
		"\u01e7\u0001\u0000\u0000\u0000\u01ea\u01eb\u0005g\u0000\u0000\u01ebM\u0001"+
		"\u0000\u0000\u0000\u01ec\u01f4\u0003P(\u0000\u01ed\u01f4\u0003R)\u0000"+
		"\u01ee\u01f4\u0003T*\u0000\u01ef\u01f4\u0003V+\u0000\u01f0\u01f4\u0003"+
		"X,\u0000\u01f1\u01f4\u0003Z-\u0000\u01f2\u01f4\u0003n7\u0000\u01f3\u01ec"+
		"\u0001\u0000\u0000\u0000\u01f3\u01ed\u0001\u0000\u0000\u0000\u01f3\u01ee"+
		"\u0001\u0000\u0000\u0000\u01f3\u01ef\u0001\u0000\u0000\u0000\u01f3\u01f0"+
		"\u0001\u0000\u0000\u0000\u01f3\u01f1\u0001\u0000\u0000\u0000\u01f3\u01f2"+
		"\u0001\u0000\u0000\u0000\u01f4O\u0001\u0000\u0000\u0000\u01f5\u01f6\u0005"+
		"&\u0000\u0000\u01f6\u01f7\u0005q\u0000\u0000\u01f7Q\u0001\u0000\u0000"+
		"\u0000\u01f8\u01f9\u0005\'\u0000\u0000\u01f9\u01fa\u0005q\u0000\u0000"+
		"\u01faS\u0001\u0000\u0000\u0000\u01fb\u01fc\u0005(\u0000\u0000\u01fc\u01fd"+
		"\u0005q\u0000\u0000\u01fdU\u0001\u0000\u0000\u0000\u01fe\u01ff\u0005)"+
		"\u0000\u0000\u01ff\u0200\u0005q\u0000\u0000\u0200W\u0001\u0000\u0000\u0000"+
		"\u0201\u0202\u0005*\u0000\u0000\u0202\u0203\u0005q\u0000\u0000\u0203Y"+
		"\u0001\u0000\u0000\u0000\u0204\u0206\u0005+\u0000\u0000\u0205\u0207\u0003"+
		"\\.\u0000\u0206\u0205\u0001\u0000\u0000\u0000\u0206\u0207\u0001\u0000"+
		"\u0000\u0000\u0207\u0208\u0001\u0000\u0000\u0000\u0208\u0209\u0003^/\u0000"+
		"\u0209[\u0001\u0000\u0000\u0000\u020a\u020d\u0003\u00d6k\u0000\u020b\u020d"+
		"\u0005u\u0000\u0000\u020c\u020a\u0001\u0000\u0000\u0000\u020c\u020b\u0001"+
		"\u0000\u0000\u0000\u020d]\u0001\u0000\u0000\u0000\u020e\u0212\u0005f\u0000"+
		"\u0000\u020f\u0211\u0003`0\u0000\u0210\u020f\u0001\u0000\u0000\u0000\u0211"+
		"\u0214\u0001\u0000\u0000\u0000\u0212\u0210\u0001\u0000\u0000\u0000\u0212"+
		"\u0213\u0001\u0000\u0000\u0000\u0213\u0215\u0001\u0000\u0000\u0000\u0214"+
		"\u0212\u0001\u0000\u0000\u0000\u0215\u0216\u0005g\u0000\u0000\u0216_\u0001"+
		"\u0000\u0000\u0000\u0217\u021f\u0003\u00dam\u0000\u0218\u021f\u0003b1"+
		"\u0000\u0219\u021f\u0003d2\u0000\u021a\u021f\u0003f3\u0000\u021b\u021c"+
		"\u00056\u0000\u0000\u021c\u021f\u0003\u0082A\u0000\u021d\u021f\u0003\u0084"+
		"B\u0000\u021e\u0217\u0001\u0000\u0000\u0000\u021e\u0218\u0001\u0000\u0000"+
		"\u0000\u021e\u0219\u0001\u0000\u0000\u0000\u021e\u021a\u0001\u0000\u0000"+
		"\u0000\u021e\u021b\u0001\u0000\u0000\u0000\u021e\u021d\u0001\u0000\u0000"+
		"\u0000\u021fa\u0001\u0000\u0000\u0000\u0220\u0221\u0005,\u0000\u0000\u0221"+
		"\u0222\u0005~\u0000\u0000\u0222c\u0001\u0000\u0000\u0000\u0223\u0224\u0005"+
		"-\u0000\u0000\u0224\u0225\u0003\u009cN\u0000\u0225e\u0001\u0000\u0000"+
		"\u0000\u0226\u0227\u0005.\u0000\u0000\u0227\u022b\u0005f\u0000\u0000\u0228"+
		"\u022a\u0003h4\u0000\u0229\u0228\u0001\u0000\u0000\u0000\u022a\u022d\u0001"+
		"\u0000\u0000\u0000\u022b\u0229\u0001\u0000\u0000\u0000\u022b\u022c\u0001"+
		"\u0000\u0000\u0000\u022c\u022e\u0001\u0000\u0000\u0000\u022d\u022b\u0001"+
		"\u0000\u0000\u0000\u022e\u022f\u0005g\u0000\u0000\u022fg\u0001\u0000\u0000"+
		"\u0000\u0230\u0237\u0003j5\u0000\u0231\u0237\u0003l6\u0000\u0232\u0237"+
		"\u0003d2\u0000\u0233\u0234\u00056\u0000\u0000\u0234\u0237\u0003\u0082"+
		"A\u0000\u0235\u0237\u0003\u0084B\u0000\u0236\u0230\u0001\u0000\u0000\u0000"+
		"\u0236\u0231\u0001\u0000\u0000\u0000\u0236\u0232\u0001\u0000\u0000\u0000"+
		"\u0236\u0233\u0001\u0000\u0000\u0000\u0236\u0235\u0001\u0000\u0000\u0000"+
		"\u0237i\u0001\u0000\u0000\u0000\u0238\u0239\u0005/\u0000\u0000\u0239\u023a"+
		"\u0005q\u0000\u0000\u023ak\u0001\u0000\u0000\u0000\u023b\u023c\u00050"+
		"\u0000\u0000\u023c\u023d\u0003\u00d2i\u0000\u023dm\u0001\u0000\u0000\u0000"+
		"\u023e\u023f\u00051\u0000\u0000\u023f\u0240\u0005q\u0000\u0000\u0240\u0241"+
		"\u0005~\u0000\u0000\u0241\u0242\u0003p8\u0000\u0242o\u0001\u0000\u0000"+
		"\u0000\u0243\u0244\u0005f\u0000\u0000\u0244\u0246\u0003\u00dam\u0000\u0245"+
		"\u0247\u0003r9\u0000\u0246\u0245\u0001\u0000\u0000\u0000\u0247\u0248\u0001"+
		"\u0000\u0000\u0000\u0248\u0246\u0001\u0000\u0000\u0000\u0248\u0249\u0001"+
		"\u0000\u0000\u0000\u0249\u024a\u0001\u0000\u0000\u0000\u024a\u024b\u0005"+
		"g\u0000\u0000\u024bq\u0001\u0000\u0000\u0000\u024c\u024e\u0005+\u0000"+
		"\u0000\u024d\u024f\u0003t:\u0000\u024e\u024d\u0001\u0000\u0000\u0000\u024e"+
		"\u024f\u0001\u0000\u0000\u0000\u024f\u0250\u0001\u0000\u0000\u0000\u0250"+
		"\u0251\u0003^/\u0000\u0251s\u0001\u0000\u0000\u0000\u0252\u0253\u0003"+
		"\u00d6k\u0000\u0253u\u0001\u0000\u0000\u0000\u0254\u0255\u00052\u0000"+
		"\u0000\u0255\u0257\u0005~\u0000\u0000\u0256\u0258\u0003\u00d6k\u0000\u0257"+
		"\u0256\u0001\u0000\u0000\u0000\u0257\u0258\u0001\u0000\u0000\u0000\u0258"+
		"\u0259\u0001\u0000\u0000\u0000\u0259\u025a\u0003x<\u0000\u025aw\u0001"+
		"\u0000\u0000\u0000\u025b\u025f\u0005f\u0000\u0000\u025c\u025e\u0003z="+
		"\u0000\u025d\u025c\u0001\u0000\u0000\u0000\u025e\u0261\u0001\u0000\u0000"+
		"\u0000\u025f\u025d\u0001\u0000\u0000\u0000\u025f\u0260\u0001\u0000\u0000"+
		"\u0000\u0260\u0262\u0001\u0000\u0000\u0000\u0261\u025f\u0001\u0000\u0000"+
		"\u0000\u0262\u0263\u0005g\u0000\u0000\u0263y\u0001\u0000\u0000\u0000\u0264"+
		"\u026e\u0003b1\u0000\u0265\u026e\u0003d2\u0000\u0266\u0267\u00056\u0000"+
		"\u0000\u0267\u026e\u0003\u0082A\u0000\u0268\u026e\u0003\u0084B\u0000\u0269"+
		"\u026e\u0003f3\u0000\u026a\u026e\u0003\u00dam\u0000\u026b\u026e\u0003"+
		"|>\u0000\u026c\u026e\u0003~?\u0000\u026d\u0264\u0001\u0000\u0000\u0000"+
		"\u026d\u0265\u0001\u0000\u0000\u0000\u026d\u0266\u0001\u0000\u0000\u0000"+
		"\u026d\u0268\u0001\u0000\u0000\u0000\u026d\u0269\u0001\u0000\u0000\u0000"+
		"\u026d\u026a\u0001\u0000\u0000\u0000\u026d\u026b\u0001\u0000\u0000\u0000"+
		"\u026d\u026c\u0001\u0000\u0000\u0000\u026e{\u0001\u0000\u0000\u0000\u026f"+
		"\u0270\u00053\u0000\u0000\u0270\u0271\u0005~\u0000\u0000\u0271\u0272\u0005"+
		"\u0007\u0000\u0000\u0272\u0275\u0003\u000e\u0007\u0000\u0273\u0274\u0005"+
		"4\u0000\u0000\u0274\u0276\u0005q\u0000\u0000\u0275\u0273\u0001\u0000\u0000"+
		"\u0000\u0275\u0276\u0001\u0000\u0000\u0000\u0276}\u0001\u0000\u0000\u0000"+
		"\u0277\u0278\u00055\u0000\u0000\u0278\u0279\u0005~\u0000\u0000\u0279\u007f"+
		"\u0001\u0000\u0000\u0000\u027a\u027b\u00056\u0000\u0000\u027b\u027e\u0003"+
		"\u0082A\u0000\u027c\u027e\u0003\u0084B\u0000\u027d\u027a\u0001\u0000\u0000"+
		"\u0000\u027d\u027c\u0001\u0000\u0000\u0000\u027e\u0081\u0001\u0000\u0000"+
		"\u0000\u027f\u0281\u0003\u0086C\u0000\u0280\u027f\u0001\u0000\u0000\u0000"+
		"\u0280\u0281\u0001\u0000\u0000\u0000\u0281\u0282\u0001\u0000\u0000\u0000"+
		"\u0282\u0283\u0003\u0088D\u0000\u0283\u0284\u0003\u0090H\u0000\u0284\u0083"+
		"\u0001\u0000\u0000\u0000\u0285\u0287\u0003\u0086C\u0000\u0286\u0285\u0001"+
		"\u0000\u0000\u0000\u0286\u0287\u0001\u0000\u0000\u0000\u0287\u0288\u0001"+
		"\u0000\u0000\u0000\u0288\u0289\u00057\u0000\u0000\u0289\u028b\u0003\u008c"+
		"F\u0000\u028a\u028c\u0003\u008aE\u0000\u028b\u028a\u0001\u0000\u0000\u0000"+
		"\u028b\u028c\u0001\u0000\u0000\u0000\u028c\u028d\u0001\u0000\u0000\u0000"+
		"\u028d\u0291\u0003\u00bc^\u0000\u028e\u0290\u0003\u0092I\u0000\u028f\u028e"+
		"\u0001\u0000\u0000\u0000\u0290\u0293\u0001\u0000\u0000\u0000\u0291\u028f"+
		"\u0001\u0000\u0000\u0000\u0291\u0292\u0001\u0000\u0000\u0000\u0292\u02ac"+
		"\u0001\u0000\u0000\u0000\u0293\u0291\u0001\u0000\u0000\u0000\u0294\u0296"+
		"\u0003\u0086C\u0000\u0295\u0294\u0001\u0000\u0000\u0000\u0295\u0296\u0001"+
		"\u0000\u0000\u0000\u0296\u0297\u0001\u0000\u0000\u0000\u0297\u0298\u0005"+
		"8\u0000\u0000\u0298\u029a\u0003\u008cF\u0000\u0299\u029b\u0003\u00bc^"+
		"\u0000\u029a\u0299\u0001\u0000\u0000\u0000\u029a\u029b\u0001\u0000\u0000"+
		"\u0000\u029b\u029f\u0001\u0000\u0000\u0000\u029c\u029e\u0003\u0092I\u0000"+
		"\u029d\u029c\u0001\u0000\u0000\u0000\u029e\u02a1\u0001\u0000\u0000\u0000"+
		"\u029f\u029d\u0001\u0000\u0000\u0000\u029f\u02a0\u0001\u0000\u0000\u0000"+
		"\u02a0\u02ac\u0001\u0000\u0000\u0000\u02a1\u029f\u0001\u0000\u0000\u0000"+
		"\u02a2\u02a3\u00059\u0000\u0000\u02a3\u02a4\u0007\u0002\u0000\u0000\u02a4"+
		"\u02a8\u0003\u00bc^\u0000\u02a5\u02a7\u0003\u0092I\u0000\u02a6\u02a5\u0001"+
		"\u0000\u0000\u0000\u02a7\u02aa\u0001\u0000\u0000\u0000\u02a8\u02a6\u0001"+
		"\u0000\u0000\u0000\u02a8\u02a9\u0001\u0000\u0000\u0000\u02a9\u02ac\u0001"+
		"\u0000\u0000\u0000\u02aa\u02a8\u0001\u0000\u0000\u0000\u02ab\u0286\u0001"+
		"\u0000\u0000\u0000\u02ab\u0295\u0001\u0000\u0000\u0000\u02ab\u02a2\u0001"+
		"\u0000\u0000\u0000\u02ac\u0085\u0001\u0000\u0000\u0000\u02ad\u02ae\u0007"+
		"\u0003\u0000\u0000\u02ae\u0087\u0001\u0000\u0000\u0000\u02af\u02b0\u0005"+
		"7\u0000\u0000\u02b0\u02b2\u0003\u008cF\u0000\u02b1\u02b3\u0003\u008aE"+
		"\u0000\u02b2\u02b1\u0001\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000\u0000"+
		"\u0000\u02b3\u02b4\u0001\u0000\u0000\u0000\u02b4\u02b5\u0003\u008eG\u0000"+
		"\u02b5\u02bc\u0001\u0000\u0000\u0000\u02b6\u02b7\u00058\u0000\u0000\u02b7"+
		"\u02bc\u0003\u008cF\u0000\u02b8\u02b9\u00059\u0000\u0000\u02b9\u02ba\u0007"+
		"\u0002\u0000\u0000\u02ba\u02bc\u0003\u008eG\u0000\u02bb\u02af\u0001\u0000"+
		"\u0000\u0000\u02bb\u02b6\u0001\u0000\u0000\u0000\u02bb\u02b8\u0001\u0000"+
		"\u0000\u0000\u02bc\u0089\u0001\u0000\u0000\u0000\u02bd\u02be\u0005~\u0000"+
		"\u0000\u02be\u008b\u0001\u0000\u0000\u0000\u02bf\u02c0\u0005~\u0000\u0000"+
		"\u02c0\u008d\u0001\u0000\u0000\u0000\u02c1\u02c2\u0003\u00ba]\u0000\u02c2"+
		"\u008f\u0001\u0000\u0000\u0000\u02c3\u02c5\u0003\u0092I\u0000\u02c4\u02c3"+
		"\u0001\u0000\u0000\u0000\u02c5\u02c8\u0001\u0000\u0000\u0000\u02c6\u02c4"+
		"\u0001\u0000\u0000\u0000\u02c6\u02c7\u0001\u0000\u0000\u0000\u02c7\u0091"+
		"\u0001\u0000\u0000\u0000\u02c8\u02c6\u0001\u0000\u0000\u0000\u02c9\u02ca"+
		"\u0005=\u0000\u0000\u02ca\u02e4\u0003\u00bc^\u0000\u02cb\u02cc\u0005>"+
		"\u0000\u0000\u02cc\u02e4\u0003\u00bc^\u0000\u02cd\u02ce\u0005?\u0000\u0000"+
		"\u02ce\u02e4\u0003\u00bc^\u0000\u02cf\u02d0\u0005@\u0000\u0000\u02d0\u02e4"+
		"\u0003\u00d2i\u0000\u02d1\u02d2\u0005A\u0000\u0000\u02d2\u02e4\u0003\u00bc"+
		"^\u0000\u02d3\u02d4\u0005B\u0000\u0000\u02d4\u02e4\u0003\u0086C\u0000"+
		"\u02d5\u02d6\u0005C\u0000\u0000\u02d6\u02e4\u0005q\u0000\u0000\u02d7\u02d8"+
		"\u0005D\u0000\u0000\u02d8\u02e4\u0003\u0094J\u0000\u02d9\u02da\u0005E"+
		"\u0000\u0000\u02da\u02e4\u0003\u0096K\u0000\u02db\u02dc\u0005F\u0000\u0000"+
		"\u02dc\u02df\u0003\u0098L\u0000\u02dd\u02de\u0005G\u0000\u0000\u02de\u02e0"+
		"\u0003\u0086C\u0000\u02df\u02dd\u0001\u0000\u0000\u0000\u02df\u02e0\u0001"+
		"\u0000\u0000\u0000\u02e0\u02e4\u0001\u0000\u0000\u0000\u02e1\u02e2\u0005"+
		"H\u0000\u0000\u02e2\u02e4\u0003\u009aM\u0000\u02e3\u02c9\u0001\u0000\u0000"+
		"\u0000\u02e3\u02cb\u0001\u0000\u0000\u0000\u02e3\u02cd\u0001\u0000\u0000"+
		"\u0000\u02e3\u02cf\u0001\u0000\u0000\u0000\u02e3\u02d1\u0001\u0000\u0000"+
		"\u0000\u02e3\u02d3\u0001\u0000\u0000\u0000\u02e3\u02d5\u0001\u0000\u0000"+
		"\u0000\u02e3\u02d7\u0001\u0000\u0000\u0000\u02e3\u02d9\u0001\u0000\u0000"+
		"\u0000\u02e3\u02db\u0001\u0000\u0000\u0000\u02e3\u02e1\u0001\u0000\u0000"+
		"\u0000\u02e4\u0093\u0001\u0000\u0000\u0000\u02e5\u02e6\u0005~\u0000\u0000"+
		"\u02e6\u0095\u0001\u0000\u0000\u0000\u02e7\u02e8\u0005~\u0000\u0000\u02e8"+
		"\u0097\u0001\u0000\u0000\u0000\u02e9\u02ea\u0005~\u0000\u0000\u02ea\u0099"+
		"\u0001\u0000\u0000\u0000\u02eb\u02ec\u0005~\u0000\u0000\u02ec\u009b\u0001"+
		"\u0000\u0000\u0000\u02ed\u02ee\u0003\u009eO\u0000\u02ee\u009d\u0001\u0000"+
		"\u0000\u0000\u02ef\u02f4\u0003\u00a0P\u0000\u02f0\u02f1\u0005\\\u0000"+
		"\u0000\u02f1\u02f3\u0003\u00a0P\u0000\u02f2\u02f0\u0001\u0000\u0000\u0000"+
		"\u02f3\u02f6\u0001\u0000\u0000\u0000\u02f4\u02f2\u0001\u0000\u0000\u0000"+
		"\u02f4\u02f5\u0001\u0000\u0000\u0000\u02f5\u009f\u0001\u0000\u0000\u0000"+
		"\u02f6\u02f4\u0001\u0000\u0000\u0000\u02f7\u02fc\u0003\u00a2Q\u0000\u02f8"+
		"\u02f9\u0005[\u0000\u0000\u02f9\u02fb\u0003\u00a2Q\u0000\u02fa\u02f8\u0001"+
		"\u0000\u0000\u0000\u02fb\u02fe\u0001\u0000\u0000\u0000\u02fc\u02fa\u0001"+
		"\u0000\u0000\u0000\u02fc\u02fd\u0001\u0000\u0000\u0000\u02fd\u00a1\u0001"+
		"\u0000\u0000\u0000\u02fe\u02fc\u0001\u0000\u0000\u0000\u02ff\u0300\u0005"+
		"]\u0000\u0000\u0300\u0303\u0003\u00a2Q\u0000\u0301\u0303\u0003\u00a4R"+
		"\u0000\u0302\u02ff\u0001\u0000\u0000\u0000\u0302\u0301\u0001\u0000\u0000"+
		"\u0000\u0303\u00a3\u0001\u0000\u0000\u0000\u0304\u0305\u0005h\u0000\u0000"+
		"\u0305\u0306\u0003\u009cN\u0000\u0306\u0307\u0005i\u0000\u0000\u0307\u030f"+
		"\u0001\u0000\u0000\u0000\u0308\u030f\u0003\u00a6S\u0000\u0309\u030f\u0003"+
		"\u00a8T\u0000\u030a\u030f\u0003\u00aaU\u0000\u030b\u030f\u0003\u00acV"+
		"\u0000\u030c\u030f\u0003\u00aeW\u0000\u030d\u030f\u0003\u00b0X\u0000\u030e"+
		"\u0304\u0001\u0000\u0000\u0000\u030e\u0308\u0001\u0000\u0000\u0000\u030e"+
		"\u0309\u0001\u0000\u0000\u0000\u030e\u030a\u0001\u0000\u0000\u0000\u030e"+
		"\u030b\u0001\u0000\u0000\u0000\u030e\u030c\u0001\u0000\u0000\u0000\u030e"+
		"\u030d\u0001\u0000\u0000\u0000\u030f\u00a5\u0001\u0000\u0000\u0000\u0310"+
		"\u0311\u0003\u00b2Y\u0000\u0311\u0312\u0003\u00b8\\\u0000\u0312\u0313"+
		"\u0003\u00b2Y\u0000\u0313\u00a7\u0001\u0000\u0000\u0000\u0314\u0315\u0003"+
		"\u00b2Y\u0000\u0315\u0316\u0005^\u0000\u0000\u0316\u0317\u0003\u00b2Y"+
		"\u0000\u0317\u0318\u0005p\u0000\u0000\u0318\u0319\u0003\u00b2Y\u0000\u0319"+
		"\u0323\u0001\u0000\u0000\u0000\u031a\u031b\u0003\u00b2Y\u0000\u031b\u031c"+
		"\u0005^\u0000\u0000\u031c\u031d\u0005j\u0000\u0000\u031d\u031e\u0003\u00b2"+
		"Y\u0000\u031e\u031f\u0005m\u0000\u0000\u031f\u0320\u0003\u00b2Y\u0000"+
		"\u0320\u0321\u0005k\u0000\u0000\u0321\u0323\u0001\u0000\u0000\u0000\u0322"+
		"\u0314\u0001\u0000\u0000\u0000\u0322\u031a\u0001\u0000\u0000\u0000\u0323"+
		"\u00a9\u0001\u0000\u0000\u0000\u0324\u0325\u0003\u00b2Y\u0000\u0325\u0326"+
		"\u0005_\u0000\u0000\u0326\u0327\u0003\u00b2Y\u0000\u0327\u00ab\u0001\u0000"+
		"\u0000\u0000\u0328\u0329\u0003\u00b2Y\u0000\u0329\u032c\u0005`\u0000\u0000"+
		"\u032a\u032d\u0003\u00d6k\u0000\u032b\u032d\u0005~\u0000\u0000\u032c\u032a"+
		"\u0001\u0000\u0000\u0000\u032c\u032b\u0001\u0000\u0000\u0000\u032d\u00ad"+
		"\u0001\u0000\u0000\u0000\u032e\u032f\u0003\u00b2Y\u0000\u032f\u0330\u0005"+
		"a\u0000\u0000\u0330\u0331\u0005~\u0000\u0000\u0331\u00af\u0001\u0000\u0000"+
		"\u0000\u0332\u0333\u0003\u00b2Y\u0000\u0333\u00b1\u0001\u0000\u0000\u0000"+
		"\u0334\u0335\u0003\u00b4Z\u0000\u0335\u0336\u0005o\u0000\u0000\u0336\u0337"+
		"\u0003\u00b6[\u0000\u0337\u033a\u0001\u0000\u0000\u0000\u0338\u033a\u0003"+
		"\u00b6[\u0000\u0339\u0334\u0001\u0000\u0000\u0000\u0339\u0338\u0001\u0000"+
		"\u0000\u0000\u033a\u00b3\u0001\u0000\u0000\u0000\u033b\u033c\u0007\u0003"+
		"\u0000\u0000\u033c\u00b5\u0001\u0000\u0000\u0000\u033d\u0340\u0005~\u0000"+
		"\u0000\u033e\u0340\u0003\u00d4j\u0000\u033f\u033d\u0001\u0000\u0000\u0000"+
		"\u033f\u033e\u0001\u0000\u0000\u0000\u0340\u00b7\u0001\u0000\u0000\u0000"+
		"\u0341\u0342\u0007\u0004\u0000\u0000\u0342\u00b9\u0001\u0000\u0000\u0000"+
		"\u0343\u0344\u0003\u00bc^\u0000\u0344\u00bb\u0001\u0000\u0000\u0000\u0345"+
		"\u034a\u0003\u00be_\u0000\u0346\u0347\u0007\u0005\u0000\u0000\u0347\u0349"+
		"\u0003\u00be_\u0000\u0348\u0346\u0001\u0000\u0000\u0000\u0349\u034c\u0001"+
		"\u0000\u0000\u0000\u034a\u0348\u0001\u0000\u0000\u0000\u034a\u034b\u0001"+
		"\u0000\u0000\u0000\u034b\u00bd\u0001\u0000\u0000\u0000\u034c\u034a\u0001"+
		"\u0000\u0000\u0000\u034d\u0352\u0003\u00c0`\u0000\u034e\u034f\u0007\u0006"+
		"\u0000\u0000\u034f\u0351\u0003\u00c0`\u0000\u0350\u034e\u0001\u0000\u0000"+
		"\u0000\u0351\u0354\u0001\u0000\u0000\u0000\u0352\u0350\u0001\u0000\u0000"+
		"\u0000\u0352\u0353\u0001\u0000\u0000\u0000\u0353\u00bf\u0001\u0000\u0000"+
		"\u0000\u0354\u0352\u0001\u0000\u0000\u0000\u0355\u0356\u0007\u0005\u0000"+
		"\u0000\u0356\u0359\u0003\u00c0`\u0000\u0357\u0359\u0003\u00c2a\u0000\u0358"+
		"\u0355\u0001\u0000\u0000\u0000\u0358\u0357\u0001\u0000\u0000\u0000\u0359"+
		"\u00c1\u0001\u0000\u0000\u0000\u035a\u0361\u0003\u00d4j\u0000\u035b\u0361"+
		"\u0003\u00b2Y\u0000\u035c\u035d\u0005h\u0000\u0000\u035d\u035e\u0003\u00ba"+
		"]\u0000\u035e\u035f\u0005i\u0000\u0000\u035f\u0361\u0001\u0000\u0000\u0000"+
		"\u0360\u035a\u0001\u0000\u0000\u0000\u0360\u035b\u0001\u0000\u0000\u0000"+
		"\u0360\u035c\u0001\u0000\u0000\u0000\u0361\u00c3\u0001\u0000\u0000\u0000"+
		"\u0362\u0363\u0005\u0002\u0000\u0000\u0363\u0364\u0003\u00d6k\u0000\u0364"+
		"\u0365\u0003\u00c6c\u0000\u0365\u00c5\u0001\u0000\u0000\u0000\u0366\u036a"+
		"\u0005f\u0000\u0000\u0367\u0369\u0003\u00c8d\u0000\u0368\u0367\u0001\u0000"+
		"\u0000\u0000\u0369\u036c\u0001\u0000\u0000\u0000\u036a\u0368\u0001\u0000"+
		"\u0000\u0000\u036a\u036b\u0001\u0000\u0000\u0000\u036b\u036d\u0001\u0000"+
		"\u0000\u0000\u036c\u036a\u0001\u0000\u0000\u0000\u036d\u036e\u0005g\u0000"+
		"\u0000\u036e\u00c7\u0001\u0000\u0000\u0000\u036f\u0373\u0003\u00cae\u0000"+
		"\u0370\u0373\u0003.\u0017\u0000\u0371\u0373\u0003,\u0016\u0000\u0372\u036f"+
		"\u0001\u0000\u0000\u0000\u0372\u0370\u0001\u0000\u0000\u0000\u0372\u0371"+
		"\u0001\u0000\u0000\u0000\u0373\u00c9\u0001\u0000\u0000\u0000\u0374\u0375"+
		"\u0005\u0003\u0000\u0000\u0375\u0379\u0005f\u0000\u0000\u0376\u0378\u0003"+
		"\u00ccf\u0000\u0377\u0376\u0001\u0000\u0000\u0000\u0378\u037b\u0001\u0000"+
		"\u0000\u0000\u0379\u0377\u0001\u0000\u0000\u0000\u0379\u037a\u0001\u0000"+
		"\u0000\u0000\u037a\u037c\u0001\u0000\u0000\u0000\u037b\u0379\u0001\u0000"+
		"\u0000\u0000\u037c\u037d\u0005g\u0000\u0000\u037d\u00cb\u0001\u0000\u0000"+
		"\u0000\u037e\u0381\u0005\u0004\u0000\u0000\u037f\u0382\u0003\u00d6k\u0000"+
		"\u0380\u0382\u0005~\u0000\u0000\u0381\u037f\u0001\u0000\u0000\u0000\u0381"+
		"\u0380\u0001\u0000\u0000\u0000\u0382\u00cd\u0001\u0000\u0000\u0000\u0383"+
		"\u0384\u0005f\u0000\u0000\u0384\u0389\u0003\u00d0h\u0000\u0385\u0386\u0005"+
		"m\u0000\u0000\u0386\u0388\u0003\u00d0h\u0000\u0387\u0385\u0001\u0000\u0000"+
		"\u0000\u0388\u038b\u0001\u0000\u0000\u0000\u0389\u0387\u0001\u0000\u0000"+
		"\u0000\u0389\u038a\u0001\u0000\u0000\u0000\u038a\u038c\u0001\u0000\u0000"+
		"\u0000\u038b\u0389\u0001\u0000\u0000\u0000\u038c\u038d\u0005g\u0000\u0000"+
		"\u038d\u00cf\u0001\u0000\u0000\u0000\u038e\u038f\u0005~\u0000\u0000\u038f"+
		"\u0390\u0005n\u0000\u0000\u0390\u0391\u0003\u00ba]\u0000\u0391\u00d1\u0001"+
		"\u0000\u0000\u0000\u0392\u0393\u0007\u0007\u0000\u0000\u0393\u00d3\u0001"+
		"\u0000\u0000\u0000\u0394\u0395\u0007\b\u0000\u0000\u0395\u00d5\u0001\u0000"+
		"\u0000\u0000\u0396\u0397\u0005u\u0000\u0000\u0397\u00d7\u0001\u0000\u0000"+
		"\u0000\u0398\u0399\u0005v\u0000\u0000\u0399\u00d9\u0001\u0000\u0000\u0000"+
		"\u039a\u039b\u0005\u001b\u0000\u0000\u039b\u039c\u0003\u00d8l\u0000\u039c"+
		"\u00db\u0001\u0000\u0000\u0000H\u00de\u00e0\u00ed\u0101\u0108\u010b\u011e"+
		"\u0127\u0136\u0145\u0155\u0159\u0162\u016b\u0174\u0181\u018b\u0193\u0198"+
		"\u019d\u01a2\u01a8\u01ad\u01b5\u01c3\u01db\u01e7\u01f3\u0206\u020c\u0212"+
		"\u021e\u022b\u0236\u0248\u024e\u0257\u025f\u026d\u0275\u027d\u0280\u0286"+
		"\u028b\u0291\u0295\u029a\u029f\u02a8\u02ab\u02b2\u02bb\u02c6\u02df\u02e3"+
		"\u02f4\u02fc\u0302\u030e\u0322\u032c\u0339\u033f\u034a\u0352\u0358\u0360"+
		"\u036a\u0372\u0379\u0381\u0389";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}