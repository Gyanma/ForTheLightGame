package com.mapproject.operations;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

import com.mapproject.resources.GameMap;
import com.mapproject.resources.Room;
import com.mapproject.resources.events.Danger;
import com.mapproject.resources.events.Event;
import com.mapproject.resources.events.PacificEncounter;
import com.mapproject.resources.events.TextPuzzle;
import com.mapproject.resources.events.VisualPuzzle;
import com.mapproject.resources.items.Weapon;

public class Utilities {

    private final static int DANGER_BASE_ID = 2100;
    private final static int TEXT_PUZZLE_BASE_ID = 2200;
    private final static int VISUAL_PUZZLE_BASE_ID = 2300;
    private final static int ENEMIES_BASE_ID = 2400;
    private final static int BOSS_BASE_ID = 2450;
    private final static int PACIFIC_ENCOUNTER_BASE_ID = 2500;
    private final static int ITEM_BASE_ID = 1000;
    private final static int WEAPON_BASE_ID = 1100;
    private final static int ROOMNUMBER = 16;

    private static Set<TextPuzzle> placedTextPuzzles = new HashSet<>();
    private static Set<Danger> placedDangers = new HashSet<>();
    private static Set<VisualPuzzle> placedVisualPuzzles = new HashSet<>();
    private static Set<PacificEncounter> placedPacificEncounters = new HashSet<>();
    private static Set<Weapon> placedWeapons = new HashSet<>();

    public static Set<Integer> findVisitableRooms(int start, int end, GameMap newMap) {
        HashMap<Integer, Boolean> marked = new HashMap<>();
        Queue<Integer> lastMarked = new LinkedList<>();
        Set<Integer> visitableRooms = new HashSet<>();
        Room tempRoom;

        // Map initialized: every room is unmarked
        for (int i = 1; i <= ROOMNUMBER; i++) {
            marked.put(i, false);
        }

        // mark the rooms near to the starting room if there is a passage
        marked.put(start, true);
        tempRoom = newMap.getRoom(start);
        lastMarked.offer(start);
        visitableRooms.add(start);

        if (tempRoom.getNorth() != null) {
            marked.put(tempRoom.getNorth().getId(), true);
            lastMarked.offer(tempRoom.getNorth().getId());
            visitableRooms.add(tempRoom.getNorth().getId());
        }

        if (tempRoom.getSouth() != null) {
            marked.put(tempRoom.getSouth().getId(), true);
            lastMarked.offer(tempRoom.getSouth().getId());
            visitableRooms.add(tempRoom.getSouth().getId());
        }

        if (tempRoom.getEast() != null) {
            marked.put(tempRoom.getEast().getId(), true);
            lastMarked.offer(tempRoom.getEast().getId());
            visitableRooms.add(tempRoom.getEast().getId());
        }

        if (tempRoom.getWest() != null) {
            marked.put(tempRoom.getWest().getId(), true);
            lastMarked.offer(tempRoom.getWest().getId());
            visitableRooms.add(tempRoom.getWest().getId());
        }

        // mark the unmarked rooms that connect to already marked rooms

        while (!(lastMarked.peek() == null)) { // stop if there's no more
                                               // marked rooms to check

            int i = lastMarked.poll();
            tempRoom = newMap.getRoom(i);

            if (tempRoom.getNorth() != null && !marked.get(tempRoom.getNorth().getId())) {
                marked.put(tempRoom.getNorth().getId(), true);
                lastMarked.offer(tempRoom.getNorth().getId());
                visitableRooms.add(tempRoom.getNorth().getId());
            }

            if (tempRoom.getSouth() != null && !marked.get(tempRoom.getSouth().getId())) {
                marked.put(tempRoom.getSouth().getId(), true);
                lastMarked.offer(tempRoom.getSouth().getId());
                visitableRooms.add(tempRoom.getSouth().getId());
            }

            if (tempRoom.getEast() != null && !marked.get(tempRoom.getEast().getId())) {
                marked.put(tempRoom.getEast().getId(), true);
                lastMarked.offer(tempRoom.getEast().getId());
                visitableRooms.add(tempRoom.getEast().getId());
            }

            if (tempRoom.getWest() != null && !marked.get(tempRoom.getWest().getId())) {
                marked.put(tempRoom.getWest().getId(), true);
                lastMarked.offer(tempRoom.getWest().getId());
                visitableRooms.add(tempRoom.getWest().getId());
            }

        }

        if (!visitableRooms.contains(end)) {
            return null;
        } else if (visitableRooms.size() <= 8) {
            return null;
        } else {
            return visitableRooms;
        }

    }

    public static int selectRoomFromSet(int randomNumber, Set<Integer> visitableRooms) {
        int roomId = 0;
        int i = 1;
        for (Integer room : visitableRooms) {
            if (i == randomNumber) {
                roomId = room;
                break;
            }
            i++;
        }
        return roomId;
    }

    public static String recognizeEvent(Event event) {
        if (event.getEventId() < DANGER_BASE_ID)
            return "danger";
        else if (event.getEventId() < TEXT_PUZZLE_BASE_ID)
            return "textPuzzle";
        else if (event.getEventId() < VISUAL_PUZZLE_BASE_ID)
            return "visualPuzzle";
        else if (event.getEventId() < ENEMIES_BASE_ID)
            return "enemies";
        else if (event.getEventId() < BOSS_BASE_ID)
            return "boss";
        else if (event.getEventId() < PACIFIC_ENCOUNTER_BASE_ID)
            return "pacificEncounter";
        else
            return "";

    }

    public static String recognizeItem(int itemId) {
        if (itemId < ITEM_BASE_ID)
            return "item";
        else if (itemId < WEAPON_BASE_ID)
            return "weapon";
        else
            return "";
    }

    public static void addTextPuzzles(TextPuzzle tP) {
        placedTextPuzzles.add(tP);
    }

    public static void addDangers(Danger d) {
        placedDangers.add(d);
    }

    public static void addVisualPuzzles(VisualPuzzle vP) {
        placedVisualPuzzles.add(vP);
    }

    public static void addPacificEncounters(PacificEncounter pE) {
        placedPacificEncounters.add(pE);
    }

    public static void addWeapons(Weapon w) {
        placedWeapons.add(w);
    }

    public static Set<TextPuzzle> getPlacedTextPuzzles() {
        return placedTextPuzzles;
    }

    public static Set<Danger> getPlacedDangers() {
        return placedDangers;
    }

    public static Set<VisualPuzzle> getPlacedVisualPuzzles() {
        return placedVisualPuzzles;
    }

    public static Set<PacificEncounter> getPlacedPacificEncounters() {
        return placedPacificEncounters;
    }

    public static Set<Weapon> getPlacedWeapons() {
        return placedWeapons;
    }

}
