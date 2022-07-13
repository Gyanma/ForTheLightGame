package com.mapproject.resources;

import java.util.ArrayList;
import java.util.List;

import com.mapproject.resources.events.Event;
import com.mapproject.resources.items.Item;

public class Room {

    private final int id;

    private final int phase;

    private String description = "";

    private Room south = null;

    private Room north = null;

    private Room east = null;

    private Room west = null;

    private Event event = null;

    private boolean eventConcluded = false;

    private List<Item> items = new ArrayList<>();

    private boolean wasSpadeUsed = false;

    public Room(int id, int phase) {
        this.id = id;
        this.phase = phase;

    }

    public int getId() {
        return id;
    }

    public int getPhase() {
        return phase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Event getEvent() {
        if (event == null) {
            return null;
        } else {
            return event;
        }
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isEventConcluded() {
        return eventConcluded;
    }

    public void setEventConcluded(boolean eventConcluded) {
        this.eventConcluded = eventConcluded;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item object) {
        this.items.add(object);
    }

    public void removeItem(Item item) {
        this.items.remove(items.indexOf(item));
    }

    public boolean wasSpadeUsed() {
        return wasSpadeUsed;
    }

    public void setWasSpadeUsed(boolean wasSpadeUsed) {
        this.wasSpadeUsed = wasSpadeUsed;
    }

}
