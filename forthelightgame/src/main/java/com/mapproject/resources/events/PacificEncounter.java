package com.mapproject.resources.events;

import com.mapproject.enums.Location;

public class PacificEncounter extends Event {

    public PacificEncounter(int eventId, String name, String presentation, boolean isSkippable, Location location) {
        super(eventId, name, presentation, isSkippable, location);
    }

}
