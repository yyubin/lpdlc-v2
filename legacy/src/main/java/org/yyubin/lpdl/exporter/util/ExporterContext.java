package org.yyubin.lpdl.exporter.util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Exporter 실행 컨텍스트 관리
 *
 * AST 순회 중 부모-자식 관계를 추적하기 위한 스택 기반 컨텍스트.
 * 외래키 설정 시 부모 엔티티의 ID를 참조할 수 있도록 합니다.
 */
public class ExporterContext {

    // RDB용 ID 스택
    private final Deque<Long> personaIdStack;
    private final Deque<Long> skillIdStack;
    private final Deque<Long> syncIdStack;
    private final Deque<Long> effectIdStack;
    private final Deque<Long> branchIdStack;
    private final Deque<Long> coinIdStack;
    private final Deque<Long> passiveIdStack;

    // Season 설정 추적
    private final Map<Long, Boolean> seasonSetMap;

    // Neo4j용 변수명 스택 (향후 사용)
    private final Deque<String> personaVarStack;
    private final Deque<String> skillVarStack;

    public ExporterContext() {
        this.personaIdStack = new ArrayDeque<>();
        this.skillIdStack = new ArrayDeque<>();
        this.syncIdStack = new ArrayDeque<>();
        this.effectIdStack = new ArrayDeque<>();
        this.branchIdStack = new ArrayDeque<>();
        this.coinIdStack = new ArrayDeque<>();
        this.passiveIdStack = new ArrayDeque<>();
        this.personaVarStack = new ArrayDeque<>();
        this.skillVarStack = new ArrayDeque<>();
        this.seasonSetMap = new HashMap<>();
    }

    // ─── Persona ───
    public void enterPersona(long id) {
        personaIdStack.push(id);
    }

    public void exitPersona() {
        if (personaIdStack.isEmpty()) {
            throw new IllegalStateException("Cannot exit persona: stack is empty");
        }
        personaIdStack.pop();
    }

    public long getCurrentPersonaId() {
        if (personaIdStack.isEmpty()) {
            throw new IllegalStateException("No current persona");
        }
        return personaIdStack.peek();
    }

    public boolean hasPersona() {
        return !personaIdStack.isEmpty();
    }

    // ─── Skill ───
    public void enterSkill(long id) {
        skillIdStack.push(id);
    }

    public void exitSkill() {
        if (skillIdStack.isEmpty()) {
            throw new IllegalStateException("Cannot exit skill: stack is empty");
        }
        skillIdStack.pop();
    }

    public long getCurrentSkillId() {
        if (skillIdStack.isEmpty()) {
            throw new IllegalStateException("No current skill");
        }
        return skillIdStack.peek();
    }

    public boolean hasSkill() {
        return !skillIdStack.isEmpty();
    }

    // ─── Sync ───
    public void enterSync(long id) {
        syncIdStack.push(id);
    }

    public void exitSync() {
        if (syncIdStack.isEmpty()) {
            throw new IllegalStateException("Cannot exit sync: stack is empty");
        }
        syncIdStack.pop();
    }

    public long getCurrentSyncId() {
        if (syncIdStack.isEmpty()) {
            throw new IllegalStateException("No current sync");
        }
        return syncIdStack.peek();
    }

    public boolean hasSync() {
        return !syncIdStack.isEmpty();
    }

    // ─── Effect ───
    public void enterEffect(long id) {
        effectIdStack.push(id);
    }

    public void exitEffect() {
        if (effectIdStack.isEmpty()) {
            throw new IllegalStateException("Cannot exit effect: stack is empty");
        }
        effectIdStack.pop();
    }

    public long getCurrentEffectId() {
        if (effectIdStack.isEmpty()) {
            throw new IllegalStateException("No current effect");
        }
        return effectIdStack.peek();
    }

    public Long getCurrentEffectIdOrNull() {
        return effectIdStack.isEmpty() ? null : effectIdStack.peek();
    }

    public boolean hasEffect() {
        return !effectIdStack.isEmpty();
    }

    // ─── Branch ───
    public void enterBranch(long id) {
        branchIdStack.push(id);
    }

    public void exitBranch() {
        if (branchIdStack.isEmpty()) {
            throw new IllegalStateException("Cannot exit branch: stack is empty");
        }
        branchIdStack.pop();
    }

    public long getCurrentBranchId() {
        if (branchIdStack.isEmpty()) {
            throw new IllegalStateException("No current branch");
        }
        return branchIdStack.peek();
    }

    public Long getCurrentBranchIdOrNull() {
        return branchIdStack.isEmpty() ? null : branchIdStack.peek();
    }

    public boolean hasBranch() {
        return !branchIdStack.isEmpty();
    }

    // ─── Coin ───
    public void enterCoin(long id) {
        coinIdStack.push(id);
    }

    public void exitCoin() {
        if (coinIdStack.isEmpty()) {
            throw new IllegalStateException("Cannot exit coin: stack is empty");
        }
        coinIdStack.pop();
    }

    public long getCurrentCoinId() {
        if (coinIdStack.isEmpty()) {
            throw new IllegalStateException("No current coin");
        }
        return coinIdStack.peek();
    }

    public boolean hasCoin() {
        return !coinIdStack.isEmpty();
    }

    // ─── Passive ───
    public void enterPassive(long id) {
        passiveIdStack.push(id);
    }

    public void exitPassive() {
        if (passiveIdStack.isEmpty()) {
            throw new IllegalStateException("Cannot exit passive: stack is empty");
        }
        passiveIdStack.pop();
    }

    public long getCurrentPassiveId() {
        if (passiveIdStack.isEmpty()) {
            throw new IllegalStateException("No current passive");
        }
        return passiveIdStack.peek();
    }

    public boolean hasPassive() {
        return !passiveIdStack.isEmpty();
    }

    // ─── Neo4j 변수 (향후 사용) ───
    public void enterPersonaVar(String var) {
        personaVarStack.push(var);
    }

    public void exitPersonaVar() {
        personaVarStack.pop();
    }

    public String getCurrentPersonaVar() {
        return personaVarStack.peek();
    }

    // ─── Season 설정 추적 ───
    public void setSeasonSet(long personaId) {
        seasonSetMap.put(personaId, true);
    }

    public boolean isSeasonSet(long personaId) {
        return seasonSetMap.getOrDefault(personaId, false);
    }

    public void reset() {
        personaIdStack.clear();
        skillIdStack.clear();
        syncIdStack.clear();
        effectIdStack.clear();
        branchIdStack.clear();
        coinIdStack.clear();
        passiveIdStack.clear();
        personaVarStack.clear();
        skillVarStack.clear();
        seasonSetMap.clear();
    }
}
