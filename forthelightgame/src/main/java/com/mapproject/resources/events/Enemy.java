package com.mapproject.resources.events;

import java.util.List;

import com.mapproject.enums.Location;

public class Enemy extends Event {

    private List<Integer> attacks;

    private int healthPoints;
    private boolean isFlying;

    private String manualDescription;

    public Enemy(int eventId, String name, String description, Location location, boolean isSkippable,
            String manualDescription, List<Integer> attacks, int healthPoints, boolean isFlying) {
        super(eventId, name, description, isSkippable, location);
        this.attacks = attacks;
        this.manualDescription = manualDescription;
        this.healthPoints = healthPoints;
        this.isFlying = isFlying;
    }

    public List<Integer> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Integer> attacks) {
        this.attacks = attacks;
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

}
