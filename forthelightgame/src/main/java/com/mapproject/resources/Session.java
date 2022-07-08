package com.mapproject.resources;

import java.util.ArrayList;
import java.util.List;

import com.mapproject.resources.items.Item;

enum Status {
    EXPLORING,
    PUZZLE_SOLVING,
    FIGHTING;
}

public class Session {

    private int MAX_HEALTH = 100;

    private List<Item> inventory;

    private Map sessionMapPhase1;

    private Map sessionMapPhase2;

    private Map sessionMapPhase3;

    private int currentMap;

    private int currentRoom;

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
        this.currentMap = 1;
        this.currentStatus = Status.EXPLORING;
        this.healthPoints = MAX_HEALTH;
        this.isPlayerAlive = true;
    }

    public void setSessionMapPhase1(Map sessionMap) {
        this.sessionMapPhase1 = sessionMap;
    }

    public Map getSessionMapPhase1() {
        return sessionMapPhase1;
    }

    public void setSessionMapPhase2(Map sessionMap) {
        this.sessionMapPhase2 = sessionMap;
    }

    public Map getSessionMapPhase2() {
        return sessionMapPhase2;
    }

    public void setSessionMapPhase3(Map sessionMap) {
        this.sessionMapPhase3 = sessionMap;
    }

    public Map getSessionMapPhase3() {
        return sessionMapPhase3;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setCurrentMap(int currentMap) {
        this.currentMap = currentMap;
    }

    public int getCurrentMap() {
        return currentMap;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getCurrentRoom() {
        return currentRoom;
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
