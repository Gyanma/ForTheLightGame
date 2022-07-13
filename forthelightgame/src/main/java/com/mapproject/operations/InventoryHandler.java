package com.mapproject.operations;

import java.util.ArrayList;
import java.util.List;

import com.mapproject.resources.Session;
import com.mapproject.resources.events.Enemy;
import com.mapproject.resources.items.Item;
import com.mapproject.resources.items.Weapon;

public class InventoryHandler {

    private static final int ITEM_BASE_ID = 1000;
    private static List<String> singleUseItems = new ArrayList<String>();

    public static int useItem(Session gameSession, String command) {
        boolean itemFound = false;
        boolean weaponFound = false;
        Item chosenItem = null;
        Weapon chosenWeapon = null;
        if (command.contains("+")) { // apply item to weapon
            String[] newCommand = command.split("\\+");
            for (Item item : gameSession.getInventory()) {
                if (item.getName().equals(newCommand[0])) {
                    itemFound = true;
                    chosenItem = item;
                }
                if (item.getName().equals(newCommand[1])) {
                    weaponFound = true;
                    chosenWeapon = (Weapon) item;
                }
            }
            if (itemFound && weaponFound) {
                for (Item item : gameSession.getInventory()) {
                    if (item == chosenWeapon) {
                        switch (chosenItem.getName()) {
                            case "Affilatore":
                                if (chosenWeapon.getUsage() == 2) {

                                    chosenWeapon.setDamage(chosenWeapon.getDamage() + 5);
                                    gameSession.removeItemFromInventory(item);
                                    gameSession.addItemToInventory(chosenWeapon);
                                    System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + ".");
                                    System.out.println(
                                            "Ora " + chosenWeapon.getNameWithDetArticle() + " infliggerà più danni.");
                                } else {
                                    System.out.println("Non puoi usare " + chosenItem.getNameWithDetArticle()
                                            + " con " + chosenWeapon.getNameWithDetArticle() + ".");
                                }
                                break;
                            case "Punta in titanio":
                                if (chosenWeapon.getUsage() == 1) {
                                    chosenWeapon.setDamage(chosenWeapon.getDamage() + 5);
                                    gameSession.removeItemFromInventory(item);
                                    gameSession.addItemToInventory(chosenWeapon);
                                    System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + ".");
                                    System.out.println(
                                            "Ora " + chosenWeapon.getNameWithDetArticle() + " infliggerà più danni.");
                                } else {
                                    System.out.println("Non puoi usare " + chosenItem.getNameWithDetArticle()
                                            + " con " + chosenWeapon.getNameWithDetArticle() + ".");
                                }
                                break;
                            default:
                                System.out.println("Non capisco come intendi usarlo...");
                        }
                    }
                }
            } else if (!itemFound) {
                System.out.println("Non capisco di che oggetto parli.");
            } else if (!weaponFound) {
                System.out.println("Non capisco di che arma parli.");
            }
            return 1;

        } else {// use item on self

            for (Item item : gameSession.getInventory()) {
                if (command.equals(item.getName().toLowerCase())) {
                    itemFound = true;
                    // single use item case
                    if (singleUseItems.contains(item.getName())) {
                        if (item.isUsed()) {
                            System.out.println("Hai già usato " + item.getNameWithDetArticle() + "!");

                        } else {
                            item.setUsed(true);
                            if (item.getName() == "Acchiappasogni") {
                                for (Integer i : gameSession.getCurrentMap().getVisitableRooms()) {
                                    if (gameSession.getCurrentMap().getRoom(i).getEvent() != null &&
                                            gameSession.getCurrentMap().getRoom(i).getEvent().getClass() == Enemy.class)
                                        gameSession.getCurrentMap().getRoom(i).getEvent().setSkippable(true);
                                }
                            }

                            // TODO libro della forza
                            // TODO libro della destrezza
                            // TODO libro dell'agilità
                            // TODO fiala del sangue

                            System.out.println("Hai usato " + item.getNameWithDetArticle() + ".");
                        }
                        // other cases
                    } else {

                        switch (item.getName()) {
                            case "Vanga":
                                if (!gameSession.getCurrentRoom().wasSpadeUsed()) {
                                    gameSession.getCurrentRoom().setWasSpadeUsed(true);
                                    System.out.println("Hai usato " + item.getNameWithDetArticle() + ".");
                                    if (Math.random() < 0.3) {
                                        Item foundItem;
                                        do {
                                            foundItem = Loader.loadItem((int) (Math.random() * 19) + ITEM_BASE_ID + 1);
                                            gameSession.getCurrentRoom().addItem(foundItem);
                                        } while (gameSession.getCurrentRoom().getItems().contains(foundItem));

                                        System.out.println("Hai trovato " + foundItem.getNameWithIndetArticle() + "!");
                                    } else
                                        System.out.println("Purtroppo non hai trovato nulla.");
                                    if (Math.random() < 0.1) {
                                        gameSession.removeItemFromInventory(item);
                                        System.out.println("Oh, no! La vanga si è spezzata!");
                                    }

                                    break;
                                } else
                                    System.out.println("Hai già provato a cercare tesori in questa stanza!");
                                break;
                            case "Borsa":
                                gameSession.setInventoryCapacity(gameSession.getInventoryCapacity() + 8);
                                System.out.println("Hai usato " + item.getNameWithDetArticle() + ".");
                                System.out.println("Ora il tuo inventario può contenere "
                                        + gameSession.getInventoryCapacity() + " oggetti.");
                                gameSession.getInventory().remove(item);
                                break;
                            case "Armatura":
                                gameSession.setArmorHits(gameSession.getArmorHits() + 10);
                                System.out.println("Hai usato " + item.getNameWithDetArticle() + ".");
                                System.out.println("Ora la tua armatura può difendere da " + gameSession.getArmorHits()
                                        + " colpi.");
                                gameSession.getInventory().remove(item);
                                break;
                            case "Calzari magici":
                                gameSession.setAgilityModifier(gameSession.getAgilityModifier() + 0.25);
                                System.out.println("Hai usato " + item.getNameWithDetArticle() + ".");
                                System.out.println("Ora sarà più semplice schivare i colpi!");
                                gameSession.getInventory().remove(item);
                                break;
                            case "Monocolo del cacciatore":
                                gameSession.setAccuracyModifier(gameSession.getAccuracyModifier() + 0.25);
                                System.out.println("Hai usato " + item.getNameWithDetArticle() + "!");
                                System.out.println("Ora sarà più facile colpire!");
                                gameSession.getInventory().remove(item);
                                break;
                            case "Pitture di guerra":
                                gameSession.setAttackModifier(gameSession.getAttackModifier() + 0.25);
                                System.out.println("Hai usato " + item.getNameWithDetArticle() + "!");
                                System.out.println("I tuoi colpi saranno più potenti!");
                                gameSession.getInventory().remove(item);
                            default:
                                System.out.println("Non capisco come intendi usarlo...");
                                break;

                        }

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
                if (!item.isUsed())
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