package com.mapproject.resources.events;

import com.mapproject.enums.Location;
import com.mapproject.resources.items.Item;

public class Danger extends Event {

    private String presentation;
    private int timeLimit;
    private Item solution;
    private Item prize;

    public Danger(int eventId) {
        super(eventId);

    }

    public Danger(int eventId, String name, String description) {
        super(eventId, name, description, false, Location.EVERYWHERE);

    }

    public Danger(int eventId, String name, String description, String presentation, int timeLimit, Item solution,
            Item prize) {
        super(eventId, name, description, false, Location.EVERYWHERE);

        this.presentation = presentation;
        this.timeLimit = timeLimit;
        this.solution = solution;
        this.prize = prize;

    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Item getSolution() {
        return solution;
    }

    public void setSolution(Item solution) {
        this.solution = solution;
    }

    public Item getPrize() {
        return prize;
    }

    public void setPrize(Item prize) {
        this.prize = prize;
    }

}
