package com.mapproject.resources;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.mapproject.operations.MapBuilder;

public class GameMap {
    private int phase; // fase nel gioco della mappa: parte da 0, aumenta al completamento di una mappa
    private HashMap<Integer, Room> map = new HashMap<>(16);
    private int startingRoomId; // id della stanza iniziale
    private int endRoomId; // id della stanza finale
    private Set<Integer> visitableRooms = new HashSet<>(); // id delle stanze visitabili

    public GameMap() {
        setPhase(0);
        setStartingRoomId(0);
        setEndRoomId(0);
        setMap(new HashMap<>(16));
        setVisitableRooms(new HashSet<>());
    }

    public GameMap(int phase) {
        this.phase = phase;
        MapBuilder mapBuilder = new MapBuilder();
        GameMap tempMap = mapBuilder.createMap(phase);

        this.map = tempMap.getMap();
        this.startingRoomId = tempMap.getStartingRoomId();
        this.endRoomId = tempMap.getEndRoomId();
        this.visitableRooms = tempMap.getVisitableRooms();
    }

    public int getPhase() {
        return phase;
    }

    public int getStartingRoomId() {
        return startingRoomId;
    }

    public int getEndRoomId() {
        return endRoomId;
    }

    public HashMap<Integer, Room> getMap() {
        return map;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public void setStartingRoomId(int startingRoomId) {
        this.startingRoomId = startingRoomId;
    }

    public void setEndRoomId(int endRoomId) {
        this.endRoomId = endRoomId;
    }

    public void setMap(HashMap<Integer, Room> map) {
        this.map = map;
    }

    public void addRoom(int id, Room room) {
        this.map.put(id, room);
    }

    public Room getRoom(int id) {
        return this.map.get(id);
    }

    public Set<Integer> getVisitableRooms() {
        return visitableRooms;
    }

    public void setVisitableRooms(Set<Integer> visitableRooms) {
        this.visitableRooms = visitableRooms;
    }
}
