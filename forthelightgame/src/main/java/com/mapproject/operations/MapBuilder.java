package com.mapproject.operations;

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

    public Map createMap(int phase) {

        do {

            map.setPhase(phase);

            initializeMap();

            randomizeDoors();

            chooseStartAndEndRoom();

            map.setVisitableRooms(Utilities.findVisitableRooms(map.getStartingRoomId(), map.getEndRoomId(), map));

        } while (map.getVisitableRooms() == null);

        printMap();

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

    public void printMap() {
        Room tempRoom;
        for (int i = 1; i <= ROOMNUMBER; i++) {
            tempRoom = map.getRoom(i);
            System.out.print("\n Room = " + tempRoom.getId());
            if (tempRoom.getEast() != null) {
                System.out.print("\t East ");
            } else if (tempRoom.getEast() == null) {
                System.out.print("\t null ");
            }
            if (tempRoom.getSouth() != null) {
                System.out.print("\t South ");
            } else if (tempRoom.getSouth() == null) {
                System.out.print("\t null ");
            }

        }

        System.out.print("\n Partenza = " + map.getStartingRoomId() + "\n Arrivo = " + map.getEndRoomId() + "\n");
    }

}