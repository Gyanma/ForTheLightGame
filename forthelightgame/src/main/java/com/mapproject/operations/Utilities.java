package com.mapproject.operations;

import java.io.File;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.mapproject.resources.Map;
import com.mapproject.resources.Room;
//import resources.items.Item;
import com.mapproject.resources.items.Weapon;

public class Utilities {

    private final static int ROOMNUMBER = 16;

    public static Set<Integer> findVisitableRooms(int start, int end, Map newMap) {
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

    public static Weapon loadWeapon(String item) throws Exception {

        try {
            FileReader reader = new FileReader(new File("src/resources/items/" + item + ".json"));
            Weapon weapon = new Gson().fromJson(reader, Weapon.class);
            return weapon;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
