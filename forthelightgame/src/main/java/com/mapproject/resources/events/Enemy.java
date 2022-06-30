package com.mapproject.resources.events;

import java.util.List;

import com.mapproject.enums.Location;

public class Enemy extends Event {

    private List<Integer> actions;

    private String manualDescription;

    public Enemy(int eventId, String name, String description, Location location,
            String manualDescription, List<Integer> actions) {
        super(eventId, name, description, true, location);
        this.actions = actions;
        this.manualDescription = manualDescription;
    }

    public List<Integer> getActions() {
        return actions;
    }

    public void setActions(List<Integer> actions) {
        this.actions = actions;
    }

    public String getManualDescription() {
        return manualDescription;
    }

    public void setManualDescription(String description) {
        this.manualDescription = description;
    }
}
