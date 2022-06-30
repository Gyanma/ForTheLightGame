package com.mapproject.resources.events;

import com.mapproject.enums.Location;

public class Danger extends Event {

    public Danger(int eventId) {
        super(eventId);

    }

    public Danger(int eventId, String name, String description) {
        super(eventId, name, description, false, Location.EVERYWHERE);

    }

}
