package com.mapproject.resources;

import java.util.ArrayList;
import java.util.List;

import com.mapproject.resources.events.Event;
import com.mapproject.resources.items.Chest;
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

    private List<Item> objects = new ArrayList<>();

    private Chest chest = null;

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
        return event;
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

    public List<Item> getObjects() {
        return objects;
    }

    public void setObjects(List<Item> objects) {
        this.objects = objects;
    }

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
