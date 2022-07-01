package com.mapproject;

import java.util.ArrayList;
import java.util.List;

import com.mapproject.resources.Map;
import com.mapproject.resources.items.Item;

enum Status {
    EXPLORING,
    PUZZLE_SOLVING,
    FIGHTING;
}

public class Session {

    private List<Item> inventory;

    private Map sessionMapPhase1;

    private Map sessionMapPhase2;

    private Map sessionMapPhase3;

    private int currentRoom;

    private Status currentStatus;

    private final int mode; // 0 is the normal mode, 1 is the demo mode

    public Session(int mode) {
        this.mode = mode;

        this.sessionMapPhase1 = new Map(1);
        this.sessionMapPhase2 = new Map(2);
        this.sessionMapPhase3 = new Map(3);

        this.inventory = new ArrayList<Item>();
        this.currentRoom = 0;
        this.currentStatus = Status.EXPLORING;
    }

    public int getMode() {
        return mode;
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

}
