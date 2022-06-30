package com.mapproject.resources.events;

import java.util.List;

public class Enemy extends Event {

    private List<Integer> actions;

    private String manualDescription;

    public Enemy(int eventId, String name, String description, boolean skippable, List<Integer> actions,
            String manualDescription) {
        super(eventId, name, description, skippable);
        setActions(actions);
        setManualDescription(manualDescription);
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
