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

    private Map sessionMap;

    private int currentRoom;

    private Status currentStatus;

    private final int mode; // 0 is the normal mode, 1 is the demo mode

    public Session(int mode) {
        this.mode = mode;
        setSessionMap(new Map());
        setInventory(new ArrayList<Item>());
        setCurrentRoom(0);
        setCurrentStatus(Status.EXPLORING);
    }

    public int getMode() {
        return mode;
    }

    public void setSessionMap(Map sessionMap) {
        this.sessionMap = sessionMap;
    }

    public Map getSessionMap() {
        return sessionMap;
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
