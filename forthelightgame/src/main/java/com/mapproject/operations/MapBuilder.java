package com.mapproject.operations;

import java.util.HashSet;
import java.util.Set;

import com.mapproject.resources.Map;
import com.mapproject.resources.Room;
import com.mapproject.resources.items.Item;
import com.mapproject.resources.items.Weapon;

public class MapBuilder {

    private final int BOSS_BASE_ID = 2450;
    private final int TEXT_PUZZLE_BASE_ID = 2200;
    private final int DANGER_BASE_ID = 2100;
    private final int ENEMIES_BASE_ID = 2400;
    private final int VISUAL_PUZZLE_BASE_ID = 2300;
    private final int PACIFIC_ENCOUNTER_BASE_ID = 2500;
    private final int ITEM_BASE_ID = 1000;
    private final int WEAPON_BASE_ID = 1100;
    private final int ROOMNUMBER = 16;
    private final int ROW = 4;
    private final int COLUMN = 4;

    private Map map = new Map();
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

        int bossId = map.getPhase() + BOSS_BASE_ID;

        Room tempRoom = map.getRoom(map.getEndRoomId());

        // add the enemy to the room
        tempRoom.setEvent(Loader.loadEnemy(bossId));
        map.addRoom(map.getEndRoomId(), tempRoom);

    }

    private void addTextPuzzles() {

        // choose a random puzzle
        int puzzleId;
        do {
            puzzleId = (int) (Math.random() * 10) + TEXT_PUZZLE_BASE_ID + 1; // puzzle id is between 2201 and 2211
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
                    (int) (Math.random() * map.getVisitableRooms().size() + 1), map.getVisitableRooms());

        } while (map.getRoom(roomId).getEvent() != null && map.getStartingRoomId() != roomId);

        // add the puzzle to the room
        Room tempRoom = map.getRoom(roomId);
        if (puzzleId == TEXT_PUZZLE_BASE_ID + 5
                || puzzleId == TEXT_PUZZLE_BASE_ID + 12
                || puzzleId == TEXT_PUZZLE_BASE_ID + 14) {
            tempRoom.setEvent(Loader.loadJugPuzzle(puzzleId));
        } else
            tempRoom.setEvent(Loader.loadTextPuzzle(puzzleId));

        map.addRoom(roomId, tempRoom);

    }

    private void addDanger() {

        // choose a random danger
        int dangerId;
        do {
            dangerId = (int) (Math.random() * 4) + DANGER_BASE_ID + 1; // danger id is between 2101 and 2105
        } while (placedDangers.contains(dangerId));
        placedDangers.add(dangerId);

        // choose a random room
        int roomId;
        do {
            roomId = Utilities.selectRoomFromSet(
                    (int) (Math.random() * map.getVisitableRooms().size() + 1), map.getVisitableRooms());
        } while (map.getRoom(roomId).getEvent() != null && map.getStartingRoomId() != roomId);

        // add the danger to the room
        Room tempRoom = map.getRoom(roomId);
        tempRoom.setEvent(Loader.loadDanger(dangerId));
        map.addRoom(roomId, tempRoom);

    }

    private void addEnemies() {

        // choose a random enemy
        int enemyId = (int) (Math.random() * 4) + ENEMIES_BASE_ID + 1; // enemy id is between 2401 and 2404

        // choose a random room
        int roomId;
        do {
            roomId = Utilities.selectRoomFromSet(
                    (int) (Math.random() * map.getVisitableRooms().size() + 1), map.getVisitableRooms());
        } while (map.getRoom(roomId).getEvent() != null && map.getStartingRoomId() != roomId);

        // add the enemy to the room
        Room tempRoom = map.getRoom(roomId);
        tempRoom.setEvent(Loader.loadEnemy(enemyId));

        map.addRoom(roomId, tempRoom);

    }

    private void addVisualPuzzles() {
        // choose a random puzzle
        int puzzleId;
        do {
            puzzleId = (int) (Math.random() * 3) + VISUAL_PUZZLE_BASE_ID + 1; // puzzle id is between 2201 and 2203
        } while (placedVisualPuzzles.contains(puzzleId));

        placedVisualPuzzles.add(puzzleId);

        // choose a random room
        int roomId;
        do {
            roomId = Utilities.selectRoomFromSet(
                    (int) (Math.random() * map.getVisitableRooms().size() + 1), map.getVisitableRooms());

        } while (map.getRoom(roomId).getEvent() != null && map.getStartingRoomId() != roomId);

        // add the puzzle to the room
        Room tempRoom = map.getRoom(roomId);
        tempRoom.setEvent(Loader.loadVisualPuzzle(puzzleId));
        map.addRoom(roomId, tempRoom);
    }

    private void addPacificEncounter() {
        // choose a random encounter
        int encounterId;
        do {
            encounterId = (int) (Math.random() * 4) + PACIFIC_ENCOUNTER_BASE_ID + 1; // encounter id is between 2201 and
                                                                                     // 2202
        } while (placedPacificEncounters.contains(encounterId));
        placedPacificEncounters.add(encounterId);

        // choose a random room
        int roomId;
        do {
            roomId = Utilities.selectRoomFromSet(
                    (int) (Math.random() * map.getVisitableRooms().size() + 1), map.getVisitableRooms());

        } while (map.getRoom(roomId).getEvent() != null && map.getStartingRoomId() != roomId);

        // add the encounter to the room
        Room tempRoom = map.getRoom(roomId);
        tempRoom.setEvent(Loader.loadPacificEncounter(encounterId));
        map.addRoom(roomId, tempRoom);
    }

    private void addItems() {
        // choose a random item
        int itemId;
        itemId = (int) (Math.random() * 19) + ITEM_BASE_ID + 1; // item id is between 1001 and 1020
        Item item = Loader.loadItem(itemId);

        // choose a random room
        int roomId;
        do {
            roomId = Utilities.selectRoomFromSet(
                    (int) (Math.random() * map.getVisitableRooms().size() + 1), map.getVisitableRooms());
        } while (map.getRoom(roomId).getItems().size() != 0);
        // add the item to the room
        Room tempRoom = map.getRoom(roomId);
        tempRoom.addItem(item);
        map.addRoom(roomId, tempRoom);

        if (Math.random() < 0.5) {
            itemId = (int) (Math.random() * 19) + ITEM_BASE_ID + 1; // item id is between 1001 and 1020
            item = Loader.loadItem(itemId);

            tempRoom = map.getRoom(roomId);
            tempRoom.addItem(item);
            map.addRoom(roomId, tempRoom);
        }
    }

    private void addWeapons() {
        // choose a random weapon
        int weaponId;

        // in phase 1, only weapons 1-3 and 6-8 are available
        if (map.getPhase() == 1) {
            weaponId = (int) (Math.random() * 6) + 1;
            if (weaponId > 3) {
                weaponId += 2; // 4-6 become 6-8
            }
            weaponId += WEAPON_BASE_ID;

            // in phase 2-3, weapons 4, 5, 9, 10 are more likely to be placed (3 to 2)
        } else {
            weaponId = (int) (Math.random() * 24);
            if (weaponId < 6) { // 0-5 -> weapons 1-3
                weaponId = (weaponId) / 2 + WEAPON_BASE_ID + 1;
            } else if (weaponId >= 6 && weaponId < 12) { // 6 - 11 -> weapons 4 or 5
                weaponId = weaponId / 3 + WEAPON_BASE_ID + 2;
            } else if (weaponId >= 12 && weaponId < 18) { // 12 - 17 -> weapons 6-8
                weaponId = weaponId / 2 + WEAPON_BASE_ID;
            } else { // 18 - 23 -> weapons 9 or 10
                weaponId = weaponId / 3 + WEAPON_BASE_ID + 3;
            }
        }
        Weapon weapon = Loader.loadWeapon(weaponId);

        // choose a random room
        int roomId;
        do {
            roomId = Utilities.selectRoomFromSet(
                    (int) (Math.random() * map.getVisitableRooms().size() + 1), map.getVisitableRooms());

        } while (map.getRoom(roomId).getItems().contains(weapon) || map.getStartingRoomId() == roomId);

        // add the weapon to the room
        Room tempRoom = map.getRoom(roomId);
        tempRoom.addItem(weapon);
        map.addRoom(roomId, tempRoom);
    }

    private void addWeaponsToStartRoom() {
        int weaponId;
        Weapon weapon;
        int roomId = map.getStartingRoomId();

        // choose a hand to hand weapon
        // in phase 1, only weapons 1-3 are available
        if (map.getPhase() == 1) {
            weaponId = (int) (Math.random() * 3) + WEAPON_BASE_ID + 1;

        } else {// in phase 2-3, weapons 7-8 are more likely to be placed (3 to 2)
            weaponId = (int) (Math.random() * 12);
            if (weaponId < 2) {
                weaponId = WEAPON_BASE_ID + 1;
            } else if (weaponId >= 2 && weaponId < 4) {
                weaponId = WEAPON_BASE_ID + 2;
            } else if (weaponId >= 4 && weaponId < 6) {
                weaponId = WEAPON_BASE_ID + 3;
            } else if (weaponId >= 6 && weaponId < 9) {
                weaponId = WEAPON_BASE_ID + 7;
            } else if (weaponId >= 9 && weaponId < 12) {
                weaponId = WEAPON_BASE_ID + 8;
            }
        }
        weapon = Loader.loadWeapon(weaponId);
        // add the weapon to the room
        Room tempRoom = map.getRoom(roomId);
        tempRoom.addItem(weapon);
        map.addRoom(roomId, tempRoom);

        // choose a ranged weapon
        // in phase 1, only weapons 4-6 are available
        if (map.getPhase() == 1) {
            weaponId = (int) (Math.random() * 3) + WEAPON_BASE_ID + 4;

        } else { // in phase 2-3, weapons 9-10 are more likely to be placed (3 to 2)
            weaponId = (int) (Math.random() * 12);
            if (weaponId < 2) {
                weaponId = WEAPON_BASE_ID + 4;
            } else if (weaponId >= 2 && weaponId < 4) {
                weaponId = WEAPON_BASE_ID + 5;
            } else if (weaponId >= 4 && weaponId < 6) {
                weaponId = WEAPON_BASE_ID + 6;
            } else if (weaponId >= 6 && weaponId < 9) {
                weaponId = WEAPON_BASE_ID + 9;
            } else if (weaponId >= 9 && weaponId < 12) {
                weaponId = WEAPON_BASE_ID + 10;
            }
        }
        weapon = Loader.loadWeapon(weaponId);
        // add the weapon to the room
        tempRoom = map.getRoom(roomId);
        tempRoom.addItem(weapon);
        map.addRoom(roomId, tempRoom);

        // choose a random weapon
        // in phase 1, only weapons 1-6 are available
        do {
            if (map.getPhase() == 1) {
                weaponId = (int) (Math.random() * 6) + 1 + WEAPON_BASE_ID;

            } else {// in phase 2-3, weapons 7-10 are more likely to be placed (3 to 2)
                weaponId = (int) (Math.random() * 24);
                if (weaponId < 2) {
                    weaponId = WEAPON_BASE_ID + 1;
                } else if (weaponId >= 2 && weaponId < 4) {
                    weaponId = WEAPON_BASE_ID + 2;
                } else if (weaponId >= 4 && weaponId < 6) {
                    weaponId = WEAPON_BASE_ID + 3;
                } else if (weaponId >= 6 && weaponId < 8) {
                    weaponId = WEAPON_BASE_ID + 4;
                } else if (weaponId >= 9 && weaponId < 10) {
                    weaponId = WEAPON_BASE_ID + 5;
                } else if (weaponId >= 10 && weaponId < 12) {
                    weaponId = WEAPON_BASE_ID + 6;
                } else if (weaponId >= 12 && weaponId < 15) {
                    weaponId = WEAPON_BASE_ID + 7;
                } else if (weaponId >= 15 && weaponId < 18) {
                    weaponId = WEAPON_BASE_ID + 8;
                } else if (weaponId >= 18 && weaponId < 21) {
                    weaponId = WEAPON_BASE_ID + 9;
                } else if (weaponId >= 21 && weaponId < 24) {
                    weaponId = WEAPON_BASE_ID + 10;
                }
            }
            weapon = Loader.loadWeapon(weaponId);
        } while (map.getRoom(roomId).getItems().contains(weapon));
        // add the weapon to the room
        tempRoom = map.getRoom(roomId);
        tempRoom.addItem(weapon);
        map.addRoom(roomId, tempRoom);
    }

    private void fillMap() {
        // add the boss
        addBoss();

        // choose the number of puzzles to place
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
        int enemyNumber = (map.getVisitableRooms().size() - 1) / 2; // 4 enemies for 9 or 10 rooms, 5 enemies for 11 or
                                                                    // 12 rooms and so on.
        // choose if there will be a danger room
        if (map.getVisitableRooms().size() > 10 && map.getPhase() > 1) {
            if (Math.random() < 0.5) {
                addDanger();
                enemyNumber--;
            }
        }
        // fill the map with enemies
        for (int i = 0; i < enemyNumber; i++) {
            addEnemies();
        }

        // add a pacific encounter if the map is large enough
        if (map.getVisitableRooms().size() > 10) {
            addPacificEncounter();
        }

        // add a visual puzzle if the map is large enough
        if (map.getVisitableRooms().size() > 12 && map.getPhase() > 1) {
            addVisualPuzzles();
        }

        // choose how many rooms will have an item
        int itemRoomsNumber = (map.getVisitableRooms().size() - 1) / 2 + 2; // 6 items for 9 or 10 rooms, 7 items for 11
                                                                            // or 12 rooms and so on.
        // fill the map with items
        for (int i = 0; i < itemRoomsNumber; i++) {
            addItems();
        }

        // add weapons to the starting room
        addWeaponsToStartRoom();

        // choose how many rooms will have a weapon
        int weaponRoomsNumber = (map.getVisitableRooms().size() - 1) / 2 - 3; // 1 weapon for 9 or 10 rooms, 2 weapons
                                                                              // for 11 or 12 rooms and so on.
        // fill the map with weapons
        for (int i = 0; i < weaponRoomsNumber; i++) {
            addWeapons();
        }

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

    public Set<Integer> getPlacedDangers() {
        return placedDangers;
    }

    public Set<Integer> getPlacedVisualPuzzles() {
        return placedVisualPuzzles;
    }

    public Set<Integer> getPlacedPacificEncounters() {
        return placedPacificEncounters;
    }

}