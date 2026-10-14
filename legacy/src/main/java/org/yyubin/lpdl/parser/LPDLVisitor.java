// Generated from LPDL.g4 by ANTLR 4.13.1
package org.yyubin.lpdl.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LPDLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LPDLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LPDLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LPDLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#personaDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersonaDecl(LPDLParser.PersonaDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#personaBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersonaBody(LPDLParser.PersonaBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#personaStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersonaStmt(LPDLParser.PersonaStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#gradeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGradeStmt(LPDLParser.GradeStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#gradeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGradeValue(LPDLParser.GradeValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#sinStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinStmt(LPDLParser.SinStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#sinAffinityType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinAffinityType(LPDLParser.SinAffinityTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#releaseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReleaseStmt(LPDLParser.ReleaseStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#maxLevelStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxLevelStmt(LPDLParser.MaxLevelStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#defenseLevelStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefenseLevelStmt(LPDLParser.DefenseLevelStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#sinnerStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinnerStmt(LPDLParser.SinnerStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#resistanceStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResistanceStmt(LPDLParser.ResistanceStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#resistancePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResistancePair(LPDLParser.ResistancePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#speedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpeedStmt(LPDLParser.SpeedStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#speedPair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpeedPair(LPDLParser.SpeedPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#healthStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHealthStmt(LPDLParser.HealthStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#healthField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHealthField(LPDLParser.HealthFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#seasonStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeasonStmt(LPDLParser.SeasonStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#seasonField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeasonField(LPDLParser.SeasonFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#imageDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImageDecl(LPDLParser.ImageDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#imageField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImageField(LPDLParser.ImageFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#metaStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetaStmt(LPDLParser.MetaStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#synergyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynergyBlock(LPDLParser.SynergyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#synergyStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynergyStmt(LPDLParser.SynergyStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#synergyDetail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynergyDetail(LPDLParser.SynergyDetailContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#skillDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkillDecl(LPDLParser.SkillDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#skillBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkillBody(LPDLParser.SkillBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#skillStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkillStmt(LPDLParser.SkillStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#categoryStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCategoryStmt(LPDLParser.CategoryStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#skillSinStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkillSinStmt(LPDLParser.SkillSinStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#attackStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttackStmt(LPDLParser.AttackStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#defenseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefenseStmt(LPDLParser.DefenseStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#quantityStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantityStmt(LPDLParser.QuantityStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#keywordStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordStmt(LPDLParser.KeywordStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#imageStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImageStmt(LPDLParser.ImageStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#syncDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyncDecl(LPDLParser.SyncDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#syncLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyncLevel(LPDLParser.SyncLevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#syncBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyncBody(LPDLParser.SyncBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#syncStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyncStmt(LPDLParser.SyncStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#basePowerStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasePowerStmt(LPDLParser.BasePowerStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#coinPowerStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoinPowerStmt(LPDLParser.CoinPowerStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#coinCountStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoinCountStmt(LPDLParser.CoinCountStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#weightStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightStmt(LPDLParser.WeightStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#levelStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelStmt(LPDLParser.LevelStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#effectDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffectDecl(LPDLParser.EffectDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#effectHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffectHeader(LPDLParser.EffectHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#effectBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffectBody(LPDLParser.EffectBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#effectStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffectStmt(LPDLParser.EffectStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#triggerStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerStmt(LPDLParser.TriggerStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#whenStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenStmt(LPDLParser.WhenStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#branchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchBlock(LPDLParser.BranchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#branchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchStmt(LPDLParser.BranchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#orderStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderStmt(LPDLParser.OrderStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#stopOnMatchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopOnMatchStmt(LPDLParser.StopOnMatchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#coinDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoinDecl(LPDLParser.CoinDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#coinBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoinBody(LPDLParser.CoinBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#effectInlineDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffectInlineDecl(LPDLParser.EffectInlineDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#effectInlineHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffectInlineHeader(LPDLParser.EffectInlineHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#passiveDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassiveDecl(LPDLParser.PassiveDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#passiveBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassiveBody(LPDLParser.PassiveBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#passiveStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassiveStmt(LPDLParser.PassiveStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#passiveConditionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassiveConditionStmt(LPDLParser.PassiveConditionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#passiveSyncLevelStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassiveSyncLevelStmt(LPDLParser.PassiveSyncLevelStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#actionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionStmt(LPDLParser.ActionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#actionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionClause(LPDLParser.ActionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#actionSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionSimple(LPDLParser.ActionSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#targetSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetSpec(LPDLParser.TargetSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#verbSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerbSpec(LPDLParser.VerbSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#policySpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolicySpec(LPDLParser.PolicySpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#statSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatSpec(LPDLParser.StatSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#valueSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueSpec(LPDLParser.ValueSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#actionDetail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionDetail(LPDLParser.ActionDetailContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#actionOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionOptions(LPDLParser.ActionOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#unitType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitType(LPDLParser.UnitTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#timingType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimingType(LPDLParser.TimingTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#selectorType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorType(LPDLParser.SelectorTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#coinSelectorType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoinSelectorType(LPDLParser.CoinSelectorTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionExpr(LPDLParser.ConditionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#conditionOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionOr(LPDLParser.ConditionOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#conditionAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionAnd(LPDLParser.ConditionAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#conditionNot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionNot(LPDLParser.ConditionNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#conditionAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionAtom(LPDLParser.ConditionAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(LPDLParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#rangeCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeCheck(LPDLParser.RangeCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#divisibilityCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivisibilityCheck(LPDLParser.DivisibilityCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#tagCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagCheck(LPDLParser.TagCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#statusCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatusCheck(LPDLParser.StatusCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#presenceCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPresenceCheck(LPDLParser.PresenceCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#side}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSide(LPDLParser.SideContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#sidePrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSidePrefix(LPDLParser.SidePrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#sideCore}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSideCore(LPDLParser.SideCoreContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(LPDLParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LPDLParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(LPDLParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(LPDLParser.MultiplicativeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(LPDLParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(LPDLParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#deckDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeckDecl(LPDLParser.DeckDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#deckBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeckBody(LPDLParser.DeckBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#deckStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeckStmt(LPDLParser.DeckStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#personasBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersonasBlock(LPDLParser.PersonasBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#personasStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersonasStmt(LPDLParser.PersonasStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#objectLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteral(LPDLParser.ObjectLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#objectPair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectPair(LPDLParser.ObjectPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(LPDLParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(LPDLParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(LPDLParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#tripleStringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTripleStringLiteral(LPDLParser.TripleStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LPDLParser#textDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextDecl(LPDLParser.TextDeclContext ctx);
}