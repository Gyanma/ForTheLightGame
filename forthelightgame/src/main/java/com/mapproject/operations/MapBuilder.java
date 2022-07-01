package com.mapproject.operations;

import java.util.HashSet;
import java.util.Set;

import com.mapproject.resources.Map;
import com.mapproject.resources.Room;
import com.mapproject.resources.items.Item;

public class MapBuilder {

    private final int ROOMNUMBER = 16;
    private final int ROW = 4;
    private final int COLUMN = 4;

    private Map map = new Map();
    boolean isElitePresent = false;
    private static Set<Integer> placedBosses = new HashSet<>();
    private static Set<Integer> placedTextPuzzles = new HashSet<>();
    private static Set<Integer> placedDangers = new HashSet<>();
    private static Set<Integer> placedVisualPuzzles = new HashSet<>();
    private static Set<Integer> placedPacificEncounters = new HashSet<>();

    private void initializeMap() {
        map.setEndRoomId(0);
        map.setStartingRoomId(0);

        for (int i = 1; i <= ROOMNUMBER; i++) {
            map.addRoom(i, new Room(i, map.getPhase()));
        }
    }

    private void randomizeDoors() {
        for (int i = 1; i < ROOMNUMBER; i++) { // works on all room except the last one
                                               // since the last one will be already connected.
            Room tempRoom = map.getRoom(i);

            if (i < ROOMNUMBER - ROW) { // room can have a door to the south
                int random = (int) (Math.random() * 5) + 1;
                if (random < 4) {

                    tempRoom.setSouth(map.getRoom(i + ROW));
                    map.getRoom(i + ROW).setNorth(tempRoom);
                }
            }

            if (i % COLUMN != 0) { // room can have a door to the east
                int random = (int) (Math.random() * 5) + 1;
                if (random < 4) {

                    tempRoom.setEast(map.getRoom(i + 1));
                    map.getRoom(i + 1).setWest(tempRoom);
                }
            }
        }
    }

    private void chooseStartAndEndRoom() {
        int start = (int) (Math.random() * ROOMNUMBER) + 1;
        map.setStartingRoomId(map.getRoom(start).getId());

        int end;
        do {
            end = (int) (Math.random() * ROOMNUMBER) + 1;
        } while (end == start);

        map.setEndRoomId(map.getRoom(end).getId());
    }

    private void addBoss() {

        // choose a random boss
        int bossId = (int) (Math.random() * 6) + 2451; // boss id is between 2451 and 2457

        // choose a random room
        Room tempRoom = map.getRoom(map.getEndRoomId());

        // add the enemy to the room
        try {
            tempRoom.setEvent(Loader.loadEnemy(bossId));
        } catch (Exception e) {
            tempRoom.setEvent(null);
        }
        map.addRoom(map.getEndRoomId(), tempRoom);
        placedBosses.add(map.getEndRoomId());

    }

    private void addTextPuzzles() {

        // choose a random puzzle
        int puzzleId;
        do {
            puzzleId = (int) (Math.random() * 10) + 2201; // puzzle id is between 2201 and 2211
        } while (placedTextPuzzles.contains(puzzleId));

        if (puzzleId == 4 || puzzleId == 5) {
            if (map.getPhase() == 2) {
                puzzleId += 7; // switch to phase 2 puzzle
            }
            if (map.getPhase() == 3) {
                puzzleId += 9; // switch to phase 3 puzzle
            }

        }
        placedTextPuzzles.add(puzzleId);

        // choose a random room
        int roomId;
        do {
            roomId = Utilities.selectRoomFromSet(
                    (int) (Math.random() * map.getVisitableRooms().size()) + 1, map.getVisitableRooms());

        } while (map.getRoom(roomId).getEvent() != null);

        // add the puzzle to the room
        Room tempRoom = map.getRoom(roomId);
        try {
            tempRoom.setEvent(Loader.loadTextPuzzle(puzzleId));
        } catch (Exception e) {
            tempRoom.setEvent(null);
        }

        map.addRoom(roomId, tempRoom);

    }

    private void addDanger() {

        // choose a random danger
        int dangerId;
        do {
            dangerId = (int) (Math.random() * 4) + 2101; // danger id is between 2101 and 2105
        } while (placedDangers.contains(dangerId));

        placedDangers.add(dangerId);

        // choose a random room
        int roomId;
        do {
            roomId = Utilities.selectRoomFromSet(
                    (int) (Math.random() * map.getVisitableRooms().size()) + 1, map.getVisitableRooms());

        } while (map.getRoom(roomId).getEvent() != null);

        // add the danger to the room
        Room tempRoom = map.getRoom(roomId);
        try {
            tempRoom.setEvent(Loader.loadDanger(dangerId));
        } catch (Exception e) {
            tempRoom.setEvent(null);
        }

        map.addRoom(roomId, tempRoom);

    }

    private void addEnemies() {

        // choose a random enemy
        int enemyId = 0;
        if (Math.random() < 0.8) {
            enemyId = (int) (Math.random() * 8) + 2401; // enemy id is between 2401 and 2409
        } else if (!isElitePresent) {
            enemyId = (int) (Math.random() * 5) + 2410; // elite enemy id is between 2411 and 2416
            isElitePresent = true;
        }

        // choose a random room
        int roomId;
        do {
            roomId = Utilities.selectRoomFromSet(
                    (int) (Math.random() * map.getVisitableRooms().size()) + 1, map.getVisitableRooms());

        } while (map.getRoom(roomId).getEvent() != null);

        // add the enemy to the room
        Room tempRoom = map.getRoom(roomId);
        try {
            tempRoom.setEvent(Loader.loadEnemy(enemyId));
        } catch (Exception e) {
            tempRoom.setEvent(null);
        }

        map.addRoom(roomId, tempRoom);

    }

    private void addVisualPuzzles() {
        // choose a random puzzle
        int puzzleId;
        do {
            puzzleId = (int) (Math.random() * 3) + 2201; // puzzle id is between 2201 and 2203
        } while (placedVisualPuzzles.contains(puzzleId));

        placedVisualPuzzles.add(puzzleId);

        // choose a random room
        int roomId;
        do {
            roomId = Utilities.selectRoomFromSet(
                    (int) (Math.random() * map.getVisitableRooms().size()) + 1, map.getVisitableRooms());

        } while (map.getRoom(roomId).getEvent() != null);

        // add the enemy to the room
        Room tempRoom = map.getRoom(roomId);
        try {
            tempRoom.setEvent(Loader.loadVisualPuzzle(puzzleId));
        } catch (Exception e) {
            tempRoom.setEvent(null);
        }

        map.addRoom(roomId, tempRoom);
    }

    private void addPacificEncounter() {
        // choose a random encounter
        int encounterId;
        do {
            encounterId = (int) (Math.random() * 2) + 2201; // encounter id is between 2201 and 2202
        } while (placedPacificEncounters.contains(encounterId));
        placedPacificEncounters.add(encounterId);

        // choose a random room
        int roomId;
        do {
            roomId = Utilities.selectRoomFromSet(
                    (int) (Math.random() * map.getVisitableRooms().size()) + 1, map.getVisitableRooms());

        } while (map.getRoom(roomId).getEvent() != null);

        // add the encounter to the room
        Room tempRoom = map.getRoom(roomId);
        try {
            tempRoom.setEvent(Loader.loadPacificEncounter(encounterId));
        } catch (Exception e) {
            tempRoom.setEvent(null);
        }

        map.addRoom(roomId, tempRoom);
    }

    private void addItems() {
        // choose a random item
        int itemId;

        itemId = (int) (Math.random() * 30) + 1001; // item id is between 1001 and 1030
        Item item = Loader.loadItem(itemId);

        // choose a random room
        int roomId;
        do {
            roomId = Utilities.selectRoomFromSet(
                    (int) (Math.random() * map.getVisitableRooms().size()) + 1, map.getVisitableRooms());

        } while (map.getRoom(roomId).getObjects().contains(item));

        // add the item to the room
        Room tempRoom = map.getRoom(roomId);
        try {
            tempRoom.addObject(item);
        } catch (Exception e) {
            tempRoom.addObject(null);
        }

        map.addRoom(roomId, tempRoom);
    }

    private void fillMap() {

        addBoss();

        int puzzleNumber;

        if (map.getVisitableRooms().size() <= 12) {
            puzzleNumber = 2;
        } else {
            puzzleNumber = 3;
        }

        // fill the map with puzzles
        for (int i = 0; i < puzzleNumber; i++) {
            addTextPuzzles();
        }

        // count how many enemies the map will have

        int enemyNumber = (map.getVisitableRooms().size() - 1) / 2;
        // 4 enemies for 9 or 10 rooms, 5 enemies for 11 or 12 rooms and so on.

        // choose if there will be a trap
        if (map.getVisitableRooms().size() > 10 && map.getPhase() > 1) {
            if (Math.random() < 0.5) {
                addDanger();
                enemyNumber--;
            }
        }

        for (int i = 0; i < enemyNumber; i++) {
            addEnemies();
        }

        if (map.getVisitableRooms().size() > 10) {
            addPacificEncounter();
        }

        if (map.getVisitableRooms().size() > 12 && map.getPhase() > 1) {

            addVisualPuzzles();

        }

        addItems();

    }

    public Map createMap(int phase) {

        do {

            map.setPhase(phase);

            initializeMap();

            randomizeDoors();

            chooseStartAndEndRoom();

            map.setVisitableRooms(Utilities.findVisitableRooms(map.getStartingRoomId(), map.getEndRoomId(), map));

        } while (map.getVisitableRooms() == null);

        fillMap();

        return map;
    }

    public Set<Integer> getPlacedTextPuzzles() {
        return placedTextPuzzles;
    }

    public void setPlacedTextPuzzles(Set<Integer> placedTextPuzzles) {
        MapBuilder.placedTextPuzzles = placedTextPuzzles;
    }

    public Set<Integer> getPlacedDangers() {
        return placedDangers;
    }

    public void setPlacedDangers(Set<Integer> placedDangers) {
        MapBuilder.placedDangers = placedDangers;
    }

    public Set<Integer> getPlacedVisualPuzzles() {
        return placedVisualPuzzles;
    }

    public void setPlacedVisualPuzzles(Set<Integer> placedVisualPuzzles) {
        MapBuilder.placedVisualPuzzles = placedVisualPuzzles;
    }

    public Set<Integer> getPlacedPacificEncounters() {
        return placedPacificEncounters;
    }

    public void setPlacedPacificEncounters(Set<Integer> placedPacificEncounters) {
        MapBuilder.placedPacificEncounters = placedPacificEncounters;
    }

    public Set<Integer> getPlacedBosses() {
        return placedBosses;
    }

    public void setPlacedBosses(Set<Integer> placedBosses) {
        MapBuilder.placedBosses = placedBosses;
    }

}