package com.mapproject.resources.events;

import com.mapproject.enums.Location;

public class Event {

    private final int eventId;

    private String name;

    private String presentation;

    private boolean isSkippable;

    private Location location; // sets the location of the event in the room;

    public Event(int eventId) {
        this.eventId = eventId;
    }

    public Event(int eventId, String name, String presentation, boolean isSkippable, Location location) {
        this.eventId = eventId;
        setName(name);
        setPresentation(presentation);
        setSkippable(isSkippable);
        setLocation(location);

    }

    public int getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public boolean isSkippable() {
        return isSkippable;
    }

    public void setSkippable(boolean skippable) {
        this.isSkippable = skippable;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
