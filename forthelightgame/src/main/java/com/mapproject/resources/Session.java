package com.mapproject.resources;

import java.util.ArrayList;
import java.util.List;

import com.mapproject.resources.items.Item;
import com.mapproject.enums.Status;

public class Session {

    private int MAX_HEALTH = 100;

    private List<Item> inventory;

    private Map sessionMapPhase1;

    private Map sessionMapPhase2;

    private Map sessionMapPhase3;

    private int currentPhase;

    private int currentRoomId;

    private Status currentStatus;

    private int healthPoints;

    private boolean isPlayerAlive;

    public Session() {
        this.sessionMapPhase1 = new Map(1);
        System.out.println("Phase 1 map loaded");
        this.sessionMapPhase2 = new Map(2);
        System.out.println("Phase 2 map loaded");
        this.sessionMapPhase3 = new Map(3);
        System.out.println("Phase 3 map loaded");

        this.inventory = new ArrayList<Item>();
        this.currentPhase = 1;
        this.currentStatus = Status.EXPLORING;
        this.healthPoints = MAX_HEALTH;
        this.isPlayerAlive = true;
    }

    public void setSessionMap(int mapNumber, Map map) {
        if (mapNumber == 1) {
            this.sessionMapPhase1 = map;
        } else if (mapNumber == 2) {
            this.sessionMapPhase2 = map;
        } else if (mapNumber == 3) {
            this.sessionMapPhase3 = map;
        }
    }

    public Map getSessionMap(int mapNumber) {
        if (mapNumber == 1) {
            return this.sessionMapPhase1;
        } else if (mapNumber == 2) {
            return this.sessionMapPhase2;
        } else if (mapNumber == 3) {
            return this.sessionMapPhase3;
        }
        return null;
    }

    public Map getCurrentMap() {
        return this.getSessionMap(this.currentPhase);
    }

    public Room getCurrentRoom() {
        return this.getCurrentMap().getRoom(this.currentRoomId);
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setCurrentPhase(int currentPhase) {
        this.currentPhase = currentPhase;
    }

    public int getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentRoomId(int currentRoom) {
        this.currentRoomId = currentRoom;
    }

    public int getCurrentRoomId() {
        return currentRoomId;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setIsPlayerAlive(boolean isPlayerAlive) {
        this.isPlayerAlive = isPlayerAlive;
    }

    public boolean isPlayerAlive() {
        return isPlayerAlive;
    }
}
