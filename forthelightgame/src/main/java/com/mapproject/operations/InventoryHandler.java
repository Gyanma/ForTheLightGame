package com.mapproject.operations;

import com.mapproject.resources.Session;
import com.mapproject.resources.items.Item;

public class InventoryHandler {

    public static int useItem(Session gameSession, String command) {
        return 2;
    }

    public static void examineItem(Session gameSession, String command) {
        boolean found = false;
        for (Item item : gameSession.getInventory()) {
            System.out.println(item.getName());
            if (command.equals(item.getName().toLowerCase())) {
                System.out.println(item.getDescription());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Non ho capito di che oggetto parli.");
        }

    }

    public static void throwItem(Session gameSession, String command) {
        boolean found = false;
        for (Item item : gameSession.getInventory()) {
            System.out.println(item.getName());
            if (command.equals(item.getName().toLowerCase())) {
                gameSession.removeItemFromInventory(item);
                gameSession.getCurrentRoom().addItem(item);
                System.out.println("Hai gettato via " + item.getNameWithDetArticle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Non ho capito di che oggetto parli.");
        }

    }

}