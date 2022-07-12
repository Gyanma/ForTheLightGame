package com.mapproject.operations;

import java.util.ArrayList;
import java.util.List;

import com.mapproject.resources.Session;
import com.mapproject.resources.items.Item;

public class InventoryHandler {

    private static List<String> singleUseItems = new ArrayList<String>();

    public static int useItem(Session gameSession, String command) {
        boolean itemFound = false;
        boolean weaponFound = false;
        if (command.contains("+")) {

        } else {

            for (Item item : gameSession.getInventory()) {
                if (command.equals(item.getName().toLowerCase())) {
                    itemFound = true;
                    // single use item case
                    if (singleUseItems.contains(item.getName())) {
                        if (item.isUsed()) {
                            System.out.println("Hai già usato " + item.getNameWithDetArticle() + "!");

                        } else {
                            item.setUsed(true);
                            // TODO libro della forza
                            // TODO libro della destrezza
                            // TODO libro dell'agilità
                            // TODO fiala del sangue
                            // TODO acchiappasogni
                            System.out.println("Hai usato " + item.getNameWithDetArticle() + "!");
                        }
                    } else {

                    }
                }
            }
            if (!itemFound) {
                System.out.println("Non capisco di che oggetto parli...");
            }
        }

        return 1;
    }

    public static void examineItem(Session gameSession, String command) {
        boolean found = false;
        for (Item item : gameSession.getInventory()) {
            if (command.equals(item.getName().toLowerCase())) {
                System.out.println(item.getName());
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

    public static void initSingleUseItems() {
        singleUseItems = Loader.loadList("singleUseItems");
    }

}