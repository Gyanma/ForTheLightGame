package com.mapproject.resources.events;

import java.util.List;
import java.util.Map;

public class Enemy extends Event {

    private Map<String, Map<String, Integer>> attacks;
    private List<String> attacksNames;

    private int healthPoints;
    private boolean isFlying;
    private int baseAttack;
    private int baseDefense;

    private String manualDescription;

    public Enemy(int eventId, String name, String description, boolean isSkippable,
            String manualDescription, Map<String, Map<String, Integer>> attacks,
            int healthPoints, boolean isFlying, int baseAttack, int baseDefense) {
        super(eventId, name, description, isSkippable);
        this.attacks = attacks;
        this.manualDescription = manualDescription;
        this.healthPoints = healthPoints;
        this.isFlying = isFlying;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;

        for (String s : attacks.keySet()) {
            attacksNames.add(s);
        }

    }

    public Map<String, Map<String, Integer>> getAttacks() {
        return attacks;
    }

    public void setAttacks(Map<String, Map<String, Integer>> attacks) {
        this.attacks = attacks;
    }

    public Map<String, Integer> getAttackStats(String attackName) {
        return attacks.get(attackName);
    }

    public String getManualDescription() {
        return manualDescription;
    }

    public void setManualDescription(String description) {
        this.manualDescription = description;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean isFlying) {
        this.isFlying = isFlying;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

}
