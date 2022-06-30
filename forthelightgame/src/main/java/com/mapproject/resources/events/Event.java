package com.mapproject.resources.events;

public class Event {

    private final int eventId;

    private String name;

    private String presentation;

    private boolean isSkippable;

    public Event(int eventId) {
        this.eventId = eventId;
    }

    public Event(int eventId, String name, String presentation, boolean isSkippable) {
        this.eventId = eventId;
        setName(name);
        setPresentation(presentation);
        setSkippable(isSkippable);

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

}
