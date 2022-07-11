package com.mapproject.resources.events;

import com.mapproject.operations.visualHandler.VisualHandler;

public class VisualPuzzle extends Event {
    private int visualId;

    private String description;

    private boolean isSolved;

    public VisualPuzzle(String name, String presentation, int eventId,
            int visualId, String description) {

        super(eventId, name, presentation, false);
        this.visualId = visualId;
        this.description = description;
        this.isSolved = false;
    }

    public int loadPuzzle() {
        try {
            return VisualHandler.selectVisual(this.visualId);
        } catch (Exception e) {
            return -1;
        }
    }

    public int getVisualId() {
        return visualId;
    }

    public void setVisualId(int visualId) {
        this.visualId = visualId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }

}
