package com.mapproject.resources;

import java.util.ArrayList;
import java.util.List;

import com.mapproject.resources.items.Item;
import com.mapproject.enums.Status;
import com.mapproject.operations.jframes.VisualMap;

public class Session {

    private int MAX_HEALTH = 100;

    private List<Item> inventory;

    private int inventoryCapacity = 16;

    private GameMap sessionMapPhase1;

    private GameMap sessionMapPhase2;

    private GameMap sessionMapPhase3;

    private int currentPhase;

    private int currentRoomId;

    private Status currentStatus;

    private int healthPoints;

    private double attackModifier = 1;

    private double armorModifier = 1;

    public Session() {
        this.sessionMapPhase1 = new GameMap(1);
        this.sessionMapPhase2 = new GameMap(2);
        this.sessionMapPhase3 = new GameMap(3);

        this.inventory = new ArrayList<Item>();
        this.currentPhase = 1;
        this.currentStatus = Status.EXPLORING;
        this.healthPoints = MAX_HEALTH;
    }

    public void setSessionMap(int mapNumber, GameMap map) {
        if (mapNumber == 1) {
            this.sessionMapPhase1 = map;
        } else if (mapNumber == 2) {
            this.sessionMapPhase2 = map;
        } else if (mapNumber == 3) {
            this.sessionMapPhase3 = map;
        }
    }

    public GameMap getSessionMap(int mapNumber) {
        if (mapNumber == 1) {
            return this.sessionMapPhase1;
        } else if (mapNumber == 2) {
            return this.sessionMapPhase2;
        } else if (mapNumber == 3) {
            return this.sessionMapPhase3;
        }
        return null;
    }

    public GameMap getCurrentMap() {
        return this.getSessionMap(this.currentPhase);
    }

    public Room getCurrentRoom() {
        return this.getCurrentMap().getRoom(this.currentRoomId);
    }

    public void addItemToInventory(Item item) {
        this.inventory.add(item);
    }

    public void removeItemFromInventory(Item item) {
        this.inventory.remove(item);
    }

    public void drawVisualMap(boolean isMystic) {
        VisualMap currentMap = new VisualMap();
        currentMap.main(getCurrentMap(), getCurrentRoomId(), isMystic);
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

    public boolean isPlayerAlive() {
        if (this.healthPoints > 0)
            return true;
        else
            return false;

    }

    public int getMaxHealthPoints() {
        return MAX_HEALTH;
    }

    public void setAttackModifier(double attackModifier) {
        this.attackModifier = attackModifier;
    }

    public double getAttackModifier() {
        return attackModifier;
    }

    public void setArmorModifier(double armorModifier) {
        this.armorModifier = armorModifier;
    }

    public double getArmorModifier() {
        return armorModifier;
    }

    public int getInventoryCapacity() {
        return inventoryCapacity;
    }

    public void setInventoryCapacity(int inventoryCapacity) {
        this.inventoryCapacity = inventoryCapacity;
    }

}
