package com.mapproject.operations;

import java.util.HashSet;
import java.util.Set;

import com.mapproject.resources.Map;
import com.mapproject.resources.Room;

public class MapBuilder {

    private final int ROOMNUMBER = 16;
    private final int ROW = 4;
    private final int COLUMN = 4;

    private Map map = new Map();

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
        int bossId = (int) (Math.random() * 6) + 2451; // boss id is between 2451 and 2457
        Room tempRoom = map.getRoom(map.getEndRoomId());
        try {
            tempRoom.setEvent(Loader.loadEnemy(bossId));
        } catch (Exception e) {
            tempRoom.setEvent(null);
        }
        map.addRoom(map.getEndRoomId(), tempRoom);

    }

    private void addTextPuzzles() {

        int puzzleNumber;
        Set<Integer> puzzleIdSet = new HashSet<>();

        // count how many puzzles the map will have
        if (map.getVisitableRooms().size() <= 12) {
            puzzleNumber = 2;
        } else {
            puzzleNumber = 3;
        }

        // fill the map with puzzles
        for (int i = 0; i < puzzleNumber; i++) {
            // choose a random puzzle
            int puzzleId;
            do {
                puzzleId = (int) (Math.random() * 10) + 2201; // puzzle id is between 2201 and 2211
            } while (puzzleIdSet.contains(puzzleId));
            puzzleIdSet.add(puzzleId);

            if (puzzleId == 4 || puzzleId == 5) {
                if (map.getPhase() == 2) {
                    puzzleId += 7; // switch to phase 2 puzzle
                }
                if (map.getPhase() == 3) {
                    puzzleId += 9; // switch to phase 3 puzzle
                }

            }

            // choose a random room
            int roomId;
            do {
                roomId = (int) (Math.random() * map.getVisitableRooms().size()) + 1;
                roomId = Utilities.selectRoomFromSet(roomId, map.getVisitableRooms());

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

    }

    private void addTrap() {
        // TODO add trap
    }

    private void addEnemies() {

        // count how many enemies the map will have

        int enemyNumber = (map.getVisitableRooms().size() - 1) / 2;
        // 4 enemies for 9 or 10 rooms, 5 enemies for 11 or 12 rooms and so on.

        // choose if there will be a trap
        if (map.getVisitableRooms().size() > 10 && map.getPhase() > 1) {
            if (Math.random() < 0.5) {
                addTrap();
                enemyNumber--;
            }
        }

        // fill the map with enemies
        for (int i = 0; i < enemyNumber; i++) {
            // TODO add enemies
        }

    }

    private void fillMap() {

        addBoss();

        addTextPuzzles();

        addEnemies();

        // TODO: add the rest of the elements to the map
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

        /*
         * int rand = (int) (Math.random()* mainMap.getVisitableRooms().size());
         * int counter = 0;
         * int current = 0;
         * for (int i : mainMap.getVisitableRooms()){
         * 
         * if(counter==rand){
         * current = i;
         * }
         * counter++;
         * }
         */
        return map;
    }

}