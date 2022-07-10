package com.mapproject.resources.events;

import java.util.HashMap;

public class Danger extends Event {

    private HashMap<Integer, String> countdown;
    private int timeLimit;
    private int solutionId;
    private int prizeId;

    public Danger(int eventId) {
        super(eventId);

    }

    public Danger(int eventId, String name, String presentation) {
        super(eventId, name, presentation, false);

    }

    public Danger(int eventId, String name, String presentation, HashMap<Integer, String> countdown, int timeLimit,
            int solutionId, int prizeId) {
        super(eventId, name, presentation, false);

        this.countdown = countdown;
        this.timeLimit = timeLimit;
        this.solutionId = solutionId;
        this.prizeId = prizeId;
    }

    public HashMap<Integer, String> getCountdown() {
        return countdown;
    }

    public void setCountdown(HashMap<Integer, String> countdown) {
        this.countdown = countdown;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getSolution() {
        return solutionId;
    }

    public void setSolution(int solutionId) {
        this.solutionId = solutionId;
    }

    public int getPrize() {
        return prizeId;
    }

    public void setPrize(int prizeId) {
        this.prizeId = prizeId;
    }

}
