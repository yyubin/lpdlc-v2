// Generated from LPDL.g4 by ANTLR 4.13.1
package org.yyubin.lpdl.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LPDLParser}.
 */
public interface LPDLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LPDLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LPDLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LPDLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#personaDecl}.
	 * @param ctx the parse tree
	 */
	void enterPersonaDecl(LPDLParser.PersonaDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#personaDecl}.
	 * @param ctx the parse tree
	 */
	void exitPersonaDecl(LPDLParser.PersonaDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#personaBody}.
	 * @param ctx the parse tree
	 */
	void enterPersonaBody(LPDLParser.PersonaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#personaBody}.
	 * @param ctx the parse tree
	 */
	void exitPersonaBody(LPDLParser.PersonaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#personaStmt}.
	 * @param ctx the parse tree
	 */
	void enterPersonaStmt(LPDLParser.PersonaStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#personaStmt}.
	 * @param ctx the parse tree
	 */
	void exitPersonaStmt(LPDLParser.PersonaStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#gradeStmt}.
	 * @param ctx the parse tree
	 */
	void enterGradeStmt(LPDLParser.GradeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#gradeStmt}.
	 * @param ctx the parse tree
	 */
	void exitGradeStmt(LPDLParser.GradeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#gradeValue}.
	 * @param ctx the parse tree
	 */
	void enterGradeValue(LPDLParser.GradeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#gradeValue}.
	 * @param ctx the parse tree
	 */
	void exitGradeValue(LPDLParser.GradeValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#sinStmt}.
	 * @param ctx the parse tree
	 */
	void enterSinStmt(LPDLParser.SinStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#sinStmt}.
	 * @param ctx the parse tree
	 */
	void exitSinStmt(LPDLParser.SinStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#sinAffinityType}.
	 * @param ctx the parse tree
	 */
	void enterSinAffinityType(LPDLParser.SinAffinityTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#sinAffinityType}.
	 * @param ctx the parse tree
	 */
	void exitSinAffinityType(LPDLParser.SinAffinityTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#releaseStmt}.
	 * @param ctx the parse tree
	 */
	void enterReleaseStmt(LPDLParser.ReleaseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#releaseStmt}.
	 * @param ctx the parse tree
	 */
	void exitReleaseStmt(LPDLParser.ReleaseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#maxLevelStmt}.
	 * @param ctx the parse tree
	 */
	void enterMaxLevelStmt(LPDLParser.MaxLevelStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#maxLevelStmt}.
	 * @param ctx the parse tree
	 */
	void exitMaxLevelStmt(LPDLParser.MaxLevelStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#defenseLevelStmt}.
	 * @param ctx the parse tree
	 */
	void enterDefenseLevelStmt(LPDLParser.DefenseLevelStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#defenseLevelStmt}.
	 * @param ctx the parse tree
	 */
	void exitDefenseLevelStmt(LPDLParser.DefenseLevelStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#sinnerStmt}.
	 * @param ctx the parse tree
	 */
	void enterSinnerStmt(LPDLParser.SinnerStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#sinnerStmt}.
	 * @param ctx the parse tree
	 */
	void exitSinnerStmt(LPDLParser.SinnerStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#resistanceStmt}.
	 * @param ctx the parse tree
	 */
	void enterResistanceStmt(LPDLParser.ResistanceStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#resistanceStmt}.
	 * @param ctx the parse tree
	 */
	void exitResistanceStmt(LPDLParser.ResistanceStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#resistancePair}.
	 * @param ctx the parse tree
	 */
	void enterResistancePair(LPDLParser.ResistancePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#resistancePair}.
	 * @param ctx the parse tree
	 */
	void exitResistancePair(LPDLParser.ResistancePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#speedStmt}.
	 * @param ctx the parse tree
	 */
	void enterSpeedStmt(LPDLParser.SpeedStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#speedStmt}.
	 * @param ctx the parse tree
	 */
	void exitSpeedStmt(LPDLParser.SpeedStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#speedPair}.
	 * @param ctx the parse tree
	 */
	void enterSpeedPair(LPDLParser.SpeedPairContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#speedPair}.
	 * @param ctx the parse tree
	 */
	void exitSpeedPair(LPDLParser.SpeedPairContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#healthStmt}.
	 * @param ctx the parse tree
	 */
	void enterHealthStmt(LPDLParser.HealthStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#healthStmt}.
	 * @param ctx the parse tree
	 */
	void exitHealthStmt(LPDLParser.HealthStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#healthField}.
	 * @param ctx the parse tree
	 */
	void enterHealthField(LPDLParser.HealthFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#healthField}.
	 * @param ctx the parse tree
	 */
	void exitHealthField(LPDLParser.HealthFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#seasonStmt}.
	 * @param ctx the parse tree
	 */
	void enterSeasonStmt(LPDLParser.SeasonStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#seasonStmt}.
	 * @param ctx the parse tree
	 */
	void exitSeasonStmt(LPDLParser.SeasonStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#seasonField}.
	 * @param ctx the parse tree
	 */
	void enterSeasonField(LPDLParser.SeasonFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#seasonField}.
	 * @param ctx the parse tree
	 */
	void exitSeasonField(LPDLParser.SeasonFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#imageDecl}.
	 * @param ctx the parse tree
	 */
	void enterImageDecl(LPDLParser.ImageDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#imageDecl}.
	 * @param ctx the parse tree
	 */
	void exitImageDecl(LPDLParser.ImageDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#imageField}.
	 * @param ctx the parse tree
	 */
	void enterImageField(LPDLParser.ImageFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#imageField}.
	 * @param ctx the parse tree
	 */
	void exitImageField(LPDLParser.ImageFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#metaStmt}.
	 * @param ctx the parse tree
	 */
	void enterMetaStmt(LPDLParser.MetaStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#metaStmt}.
	 * @param ctx the parse tree
	 */
	void exitMetaStmt(LPDLParser.MetaStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#synergyBlock}.
	 * @param ctx the parse tree
	 */
	void enterSynergyBlock(LPDLParser.SynergyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#synergyBlock}.
	 * @param ctx the parse tree
	 */
	void exitSynergyBlock(LPDLParser.SynergyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#synergyStmt}.
	 * @param ctx the parse tree
	 */
	void enterSynergyStmt(LPDLParser.SynergyStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#synergyStmt}.
	 * @param ctx the parse tree
	 */
	void exitSynergyStmt(LPDLParser.SynergyStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#synergyDetail}.
	 * @param ctx the parse tree
	 */
	void enterSynergyDetail(LPDLParser.SynergyDetailContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#synergyDetail}.
	 * @param ctx the parse tree
	 */
	void exitSynergyDetail(LPDLParser.SynergyDetailContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#skillDecl}.
	 * @param ctx the parse tree
	 */
	void enterSkillDecl(LPDLParser.SkillDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#skillDecl}.
	 * @param ctx the parse tree
	 */
	void exitSkillDecl(LPDLParser.SkillDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#skillBody}.
	 * @param ctx the parse tree
	 */
	void enterSkillBody(LPDLParser.SkillBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#skillBody}.
	 * @param ctx the parse tree
	 */
	void exitSkillBody(LPDLParser.SkillBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#skillStmt}.
	 * @param ctx the parse tree
	 */
	void enterSkillStmt(LPDLParser.SkillStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#skillStmt}.
	 * @param ctx the parse tree
	 */
	void exitSkillStmt(LPDLParser.SkillStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#categoryStmt}.
	 * @param ctx the parse tree
	 */
	void enterCategoryStmt(LPDLParser.CategoryStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#categoryStmt}.
	 * @param ctx the parse tree
	 */
	void exitCategoryStmt(LPDLParser.CategoryStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#skillSinStmt}.
	 * @param ctx the parse tree
	 */
	void enterSkillSinStmt(LPDLParser.SkillSinStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#skillSinStmt}.
	 * @param ctx the parse tree
	 */
	void exitSkillSinStmt(LPDLParser.SkillSinStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#attackStmt}.
	 * @param ctx the parse tree
	 */
	void enterAttackStmt(LPDLParser.AttackStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#attackStmt}.
	 * @param ctx the parse tree
	 */
	void exitAttackStmt(LPDLParser.AttackStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#defenseStmt}.
	 * @param ctx the parse tree
	 */
	void enterDefenseStmt(LPDLParser.DefenseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#defenseStmt}.
	 * @param ctx the parse tree
	 */
	void exitDefenseStmt(LPDLParser.DefenseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#quantityStmt}.
	 * @param ctx the parse tree
	 */
	void enterQuantityStmt(LPDLParser.QuantityStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#quantityStmt}.
	 * @param ctx the parse tree
	 */
	void exitQuantityStmt(LPDLParser.QuantityStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#keywordStmt}.
	 * @param ctx the parse tree
	 */
	void enterKeywordStmt(LPDLParser.KeywordStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#keywordStmt}.
	 * @param ctx the parse tree
	 */
	void exitKeywordStmt(LPDLParser.KeywordStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#imageStmt}.
	 * @param ctx the parse tree
	 */
	void enterImageStmt(LPDLParser.ImageStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#imageStmt}.
	 * @param ctx the parse tree
	 */
	void exitImageStmt(LPDLParser.ImageStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#syncDecl}.
	 * @param ctx the parse tree
	 */
	void enterSyncDecl(LPDLParser.SyncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#syncDecl}.
	 * @param ctx the parse tree
	 */
	void exitSyncDecl(LPDLParser.SyncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#syncLevel}.
	 * @param ctx the parse tree
	 */
	void enterSyncLevel(LPDLParser.SyncLevelContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#syncLevel}.
	 * @param ctx the parse tree
	 */
	void exitSyncLevel(LPDLParser.SyncLevelContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#syncBody}.
	 * @param ctx the parse tree
	 */
	void enterSyncBody(LPDLParser.SyncBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#syncBody}.
	 * @param ctx the parse tree
	 */
	void exitSyncBody(LPDLParser.SyncBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#syncStmt}.
	 * @param ctx the parse tree
	 */
	void enterSyncStmt(LPDLParser.SyncStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#syncStmt}.
	 * @param ctx the parse tree
	 */
	void exitSyncStmt(LPDLParser.SyncStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#basePowerStmt}.
	 * @param ctx the parse tree
	 */
	void enterBasePowerStmt(LPDLParser.BasePowerStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#basePowerStmt}.
	 * @param ctx the parse tree
	 */
	void exitBasePowerStmt(LPDLParser.BasePowerStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#coinPowerStmt}.
	 * @param ctx the parse tree
	 */
	void enterCoinPowerStmt(LPDLParser.CoinPowerStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#coinPowerStmt}.
	 * @param ctx the parse tree
	 */
	void exitCoinPowerStmt(LPDLParser.CoinPowerStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#coinCountStmt}.
	 * @param ctx the parse tree
	 */
	void enterCoinCountStmt(LPDLParser.CoinCountStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#coinCountStmt}.
	 * @param ctx the parse tree
	 */
	void exitCoinCountStmt(LPDLParser.CoinCountStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#weightStmt}.
	 * @param ctx the parse tree
	 */
	void enterWeightStmt(LPDLParser.WeightStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#weightStmt}.
	 * @param ctx the parse tree
	 */
	void exitWeightStmt(LPDLParser.WeightStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#levelStmt}.
	 * @param ctx the parse tree
	 */
	void enterLevelStmt(LPDLParser.LevelStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#levelStmt}.
	 * @param ctx the parse tree
	 */
	void exitLevelStmt(LPDLParser.LevelStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#effectDecl}.
	 * @param ctx the parse tree
	 */
	void enterEffectDecl(LPDLParser.EffectDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#effectDecl}.
	 * @param ctx the parse tree
	 */
	void exitEffectDecl(LPDLParser.EffectDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#effectHeader}.
	 * @param ctx the parse tree
	 */
	void enterEffectHeader(LPDLParser.EffectHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#effectHeader}.
	 * @param ctx the parse tree
	 */
	void exitEffectHeader(LPDLParser.EffectHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#effectBody}.
	 * @param ctx the parse tree
	 */
	void enterEffectBody(LPDLParser.EffectBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#effectBody}.
	 * @param ctx the parse tree
	 */
	void exitEffectBody(LPDLParser.EffectBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#effectStmt}.
	 * @param ctx the parse tree
	 */
	void enterEffectStmt(LPDLParser.EffectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#effectStmt}.
	 * @param ctx the parse tree
	 */
	void exitEffectStmt(LPDLParser.EffectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#triggerStmt}.
	 * @param ctx the parse tree
	 */
	void enterTriggerStmt(LPDLParser.TriggerStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#triggerStmt}.
	 * @param ctx the parse tree
	 */
	void exitTriggerStmt(LPDLParser.TriggerStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#whenStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhenStmt(LPDLParser.WhenStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#whenStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhenStmt(LPDLParser.WhenStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#branchBlock}.
	 * @param ctx the parse tree
	 */
	void enterBranchBlock(LPDLParser.BranchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#branchBlock}.
	 * @param ctx the parse tree
	 */
	void exitBranchBlock(LPDLParser.BranchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#branchStmt}.
	 * @param ctx the parse tree
	 */
	void enterBranchStmt(LPDLParser.BranchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#branchStmt}.
	 * @param ctx the parse tree
	 */
	void exitBranchStmt(LPDLParser.BranchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#orderStmt}.
	 * @param ctx the parse tree
	 */
	void enterOrderStmt(LPDLParser.OrderStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#orderStmt}.
	 * @param ctx the parse tree
	 */
	void exitOrderStmt(LPDLParser.OrderStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#stopOnMatchStmt}.
	 * @param ctx the parse tree
	 */
	void enterStopOnMatchStmt(LPDLParser.StopOnMatchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#stopOnMatchStmt}.
	 * @param ctx the parse tree
	 */
	void exitStopOnMatchStmt(LPDLParser.StopOnMatchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#coinDecl}.
	 * @param ctx the parse tree
	 */
	void enterCoinDecl(LPDLParser.CoinDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#coinDecl}.
	 * @param ctx the parse tree
	 */
	void exitCoinDecl(LPDLParser.CoinDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#coinBody}.
	 * @param ctx the parse tree
	 */
	void enterCoinBody(LPDLParser.CoinBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#coinBody}.
	 * @param ctx the parse tree
	 */
	void exitCoinBody(LPDLParser.CoinBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#effectInlineDecl}.
	 * @param ctx the parse tree
	 */
	void enterEffectInlineDecl(LPDLParser.EffectInlineDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#effectInlineDecl}.
	 * @param ctx the parse tree
	 */
	void exitEffectInlineDecl(LPDLParser.EffectInlineDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#effectInlineHeader}.
	 * @param ctx the parse tree
	 */
	void enterEffectInlineHeader(LPDLParser.EffectInlineHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#effectInlineHeader}.
	 * @param ctx the parse tree
	 */
	void exitEffectInlineHeader(LPDLParser.EffectInlineHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#passiveDecl}.
	 * @param ctx the parse tree
	 */
	void enterPassiveDecl(LPDLParser.PassiveDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#passiveDecl}.
	 * @param ctx the parse tree
	 */
	void exitPassiveDecl(LPDLParser.PassiveDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#passiveBody}.
	 * @param ctx the parse tree
	 */
	void enterPassiveBody(LPDLParser.PassiveBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#passiveBody}.
	 * @param ctx the parse tree
	 */
	void exitPassiveBody(LPDLParser.PassiveBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#passiveStmt}.
	 * @param ctx the parse tree
	 */
	void enterPassiveStmt(LPDLParser.PassiveStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#passiveStmt}.
	 * @param ctx the parse tree
	 */
	void exitPassiveStmt(LPDLParser.PassiveStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#passiveConditionStmt}.
	 * @param ctx the parse tree
	 */
	void enterPassiveConditionStmt(LPDLParser.PassiveConditionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#passiveConditionStmt}.
	 * @param ctx the parse tree
	 */
	void exitPassiveConditionStmt(LPDLParser.PassiveConditionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#passiveSyncLevelStmt}.
	 * @param ctx the parse tree
	 */
	void enterPassiveSyncLevelStmt(LPDLParser.PassiveSyncLevelStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#passiveSyncLevelStmt}.
	 * @param ctx the parse tree
	 */
	void exitPassiveSyncLevelStmt(LPDLParser.PassiveSyncLevelStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#actionStmt}.
	 * @param ctx the parse tree
	 */
	void enterActionStmt(LPDLParser.ActionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#actionStmt}.
	 * @param ctx the parse tree
	 */
	void exitActionStmt(LPDLParser.ActionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#actionClause}.
	 * @param ctx the parse tree
	 */
	void enterActionClause(LPDLParser.ActionClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#actionClause}.
	 * @param ctx the parse tree
	 */
	void exitActionClause(LPDLParser.ActionClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#actionSimple}.
	 * @param ctx the parse tree
	 */
	void enterActionSimple(LPDLParser.ActionSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#actionSimple}.
	 * @param ctx the parse tree
	 */
	void exitActionSimple(LPDLParser.ActionSimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#targetSpec}.
	 * @param ctx the parse tree
	 */
	void enterTargetSpec(LPDLParser.TargetSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#targetSpec}.
	 * @param ctx the parse tree
	 */
	void exitTargetSpec(LPDLParser.TargetSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#verbSpec}.
	 * @param ctx the parse tree
	 */
	void enterVerbSpec(LPDLParser.VerbSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#verbSpec}.
	 * @param ctx the parse tree
	 */
	void exitVerbSpec(LPDLParser.VerbSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#policySpec}.
	 * @param ctx the parse tree
	 */
	void enterPolicySpec(LPDLParser.PolicySpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#policySpec}.
	 * @param ctx the parse tree
	 */
	void exitPolicySpec(LPDLParser.PolicySpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#statSpec}.
	 * @param ctx the parse tree
	 */
	void enterStatSpec(LPDLParser.StatSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#statSpec}.
	 * @param ctx the parse tree
	 */
	void exitStatSpec(LPDLParser.StatSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#valueSpec}.
	 * @param ctx the parse tree
	 */
	void enterValueSpec(LPDLParser.ValueSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#valueSpec}.
	 * @param ctx the parse tree
	 */
	void exitValueSpec(LPDLParser.ValueSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#actionDetail}.
	 * @param ctx the parse tree
	 */
	void enterActionDetail(LPDLParser.ActionDetailContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#actionDetail}.
	 * @param ctx the parse tree
	 */
	void exitActionDetail(LPDLParser.ActionDetailContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#actionOptions}.
	 * @param ctx the parse tree
	 */
	void enterActionOptions(LPDLParser.ActionOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#actionOptions}.
	 * @param ctx the parse tree
	 */
	void exitActionOptions(LPDLParser.ActionOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#unitType}.
	 * @param ctx the parse tree
	 */
	void enterUnitType(LPDLParser.UnitTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#unitType}.
	 * @param ctx the parse tree
	 */
	void exitUnitType(LPDLParser.UnitTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#timingType}.
	 * @param ctx the parse tree
	 */
	void enterTimingType(LPDLParser.TimingTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#timingType}.
	 * @param ctx the parse tree
	 */
	void exitTimingType(LPDLParser.TimingTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#selectorType}.
	 * @param ctx the parse tree
	 */
	void enterSelectorType(LPDLParser.SelectorTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#selectorType}.
	 * @param ctx the parse tree
	 */
	void exitSelectorType(LPDLParser.SelectorTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#coinSelectorType}.
	 * @param ctx the parse tree
	 */
	void enterCoinSelectorType(LPDLParser.CoinSelectorTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#coinSelectorType}.
	 * @param ctx the parse tree
	 */
	void exitCoinSelectorType(LPDLParser.CoinSelectorTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void enterConditionExpr(LPDLParser.ConditionExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void exitConditionExpr(LPDLParser.ConditionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#conditionOr}.
	 * @param ctx the parse tree
	 */
	void enterConditionOr(LPDLParser.ConditionOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#conditionOr}.
	 * @param ctx the parse tree
	 */
	void exitConditionOr(LPDLParser.ConditionOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#conditionAnd}.
	 * @param ctx the parse tree
	 */
	void enterConditionAnd(LPDLParser.ConditionAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#conditionAnd}.
	 * @param ctx the parse tree
	 */
	void exitConditionAnd(LPDLParser.ConditionAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#conditionNot}.
	 * @param ctx the parse tree
	 */
	void enterConditionNot(LPDLParser.ConditionNotContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#conditionNot}.
	 * @param ctx the parse tree
	 */
	void exitConditionNot(LPDLParser.ConditionNotContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#conditionAtom}.
	 * @param ctx the parse tree
	 */
	void enterConditionAtom(LPDLParser.ConditionAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#conditionAtom}.
	 * @param ctx the parse tree
	 */
	void exitConditionAtom(LPDLParser.ConditionAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(LPDLParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(LPDLParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#rangeCheck}.
	 * @param ctx the parse tree
	 */
	void enterRangeCheck(LPDLParser.RangeCheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#rangeCheck}.
	 * @param ctx the parse tree
	 */
	void exitRangeCheck(LPDLParser.RangeCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#divisibilityCheck}.
	 * @param ctx the parse tree
	 */
	void enterDivisibilityCheck(LPDLParser.DivisibilityCheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#divisibilityCheck}.
	 * @param ctx the parse tree
	 */
	void exitDivisibilityCheck(LPDLParser.DivisibilityCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#tagCheck}.
	 * @param ctx the parse tree
	 */
	void enterTagCheck(LPDLParser.TagCheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#tagCheck}.
	 * @param ctx the parse tree
	 */
	void exitTagCheck(LPDLParser.TagCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#statusCheck}.
	 * @param ctx the parse tree
	 */
	void enterStatusCheck(LPDLParser.StatusCheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#statusCheck}.
	 * @param ctx the parse tree
	 */
	void exitStatusCheck(LPDLParser.StatusCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#presenceCheck}.
	 * @param ctx the parse tree
	 */
	void enterPresenceCheck(LPDLParser.PresenceCheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#presenceCheck}.
	 * @param ctx the parse tree
	 */
	void exitPresenceCheck(LPDLParser.PresenceCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#side}.
	 * @param ctx the parse tree
	 */
	void enterSide(LPDLParser.SideContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#side}.
	 * @param ctx the parse tree
	 */
	void exitSide(LPDLParser.SideContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#sidePrefix}.
	 * @param ctx the parse tree
	 */
	void enterSidePrefix(LPDLParser.SidePrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#sidePrefix}.
	 * @param ctx the parse tree
	 */
	void exitSidePrefix(LPDLParser.SidePrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#sideCore}.
	 * @param ctx the parse tree
	 */
	void enterSideCore(LPDLParser.SideCoreContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#sideCore}.
	 * @param ctx the parse tree
	 */
	void exitSideCore(LPDLParser.SideCoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(LPDLParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(LPDLParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LPDLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LPDLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(LPDLParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(LPDLParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(LPDLParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(LPDLParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(LPDLParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(LPDLParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(LPDLParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(LPDLParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#deckDecl}.
	 * @param ctx the parse tree
	 */
	void enterDeckDecl(LPDLParser.DeckDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#deckDecl}.
	 * @param ctx the parse tree
	 */
	void exitDeckDecl(LPDLParser.DeckDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#deckBody}.
	 * @param ctx the parse tree
	 */
	void enterDeckBody(LPDLParser.DeckBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#deckBody}.
	 * @param ctx the parse tree
	 */
	void exitDeckBody(LPDLParser.DeckBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#deckStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeckStmt(LPDLParser.DeckStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#deckStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeckStmt(LPDLParser.DeckStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#personasBlock}.
	 * @param ctx the parse tree
	 */
	void enterPersonasBlock(LPDLParser.PersonasBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#personasBlock}.
	 * @param ctx the parse tree
	 */
	void exitPersonasBlock(LPDLParser.PersonasBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#personasStmt}.
	 * @param ctx the parse tree
	 */
	void enterPersonasStmt(LPDLParser.PersonasStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#personasStmt}.
	 * @param ctx the parse tree
	 */
	void exitPersonasStmt(LPDLParser.PersonasStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(LPDLParser.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(LPDLParser.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#objectPair}.
	 * @param ctx the parse tree
	 */
	void enterObjectPair(LPDLParser.ObjectPairContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#objectPair}.
	 * @param ctx the parse tree
	 */
	void exitObjectPair(LPDLParser.ObjectPairContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(LPDLParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(LPDLParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(LPDLParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(LPDLParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(LPDLParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(LPDLParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#tripleStringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTripleStringLiteral(LPDLParser.TripleStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#tripleStringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTripleStringLiteral(LPDLParser.TripleStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LPDLParser#textDecl}.
	 * @param ctx the parse tree
	 */
	void enterTextDecl(LPDLParser.TextDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LPDLParser#textDecl}.
	 * @param ctx the parse tree
	 */
	void exitTextDecl(LPDLParser.TextDeclContext ctx);
}