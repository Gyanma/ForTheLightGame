package com.mapproject.operations;

import java.util.ArrayList;
import java.util.List;

import com.mapproject.enums.Status;
import com.mapproject.resources.Session;
import com.mapproject.resources.events.Enemy;
import com.mapproject.resources.items.Item;
import com.mapproject.resources.items.Weapon;

public class InventoryHandler {

    private static final int ITEM_BASE_ID = 1000;
    private static List<String> temporaryItems = new ArrayList<String>();

    public static void useItem(Session gameSession, String command) {
        boolean itemFound = false;
        boolean weaponFound = false;
        Item chosenItem = null;
        Weapon chosenWeapon = null;
        if (command.contains("+")) { // use item on item or enemy
            String[] newCommand = command.split("+");
            for (Item item : gameSession.getInventory()) {
                if (newCommand[0].equals(item.getName())) {
                    itemFound = true;
                    chosenItem = item;
                }
            }
            if (itemFound) {
                switch (chosenItem.getName()) {
                    case "Punta in titanio":
                        for (Item weapon : gameSession.getInventory()) {
                            if (weapon.getName().equals(newCommand[1])
                                    && weapon.getClass() == Weapon.class) {
                                weaponFound = true;
                                chosenWeapon = (Weapon) weapon;
                                gameSession.removeItemFromInventory(weapon);
                                break;
                            }
                        }
                        if (weaponFound) {
                            if (chosenWeapon.getUsage() == 1) {
                                chosenWeapon.setDamage(chosenWeapon.getDamage() + 5);
                                gameSession.removeItemFromInventory(chosenItem);
                                gameSession.addItemToInventory(chosenWeapon);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + ".");
                                System.out.println(
                                        "Ora " + chosenWeapon.getNameWithDetArticle() + " infliggerà più danni.");
                            } else {
                                System.out.println("Non puoi usare " + chosenItem.getNameWithDetArticle()
                                        + " con " + chosenWeapon.getNameWithDetArticle() + ".");
                            }
                        } else
                            System.out.println("Non capisco di che arma parli.");

                        break;
                    case "Affilatore":
                        for (Item weapon : gameSession.getInventory()) {
                            if (weapon.getName().equals(newCommand[1])
                                    && weapon.getClass() == Weapon.class) {
                                weaponFound = true;
                                chosenWeapon = (Weapon) weapon;
                                gameSession.removeItemFromInventory(weapon);
                                break;
                            }
                        }
                        if (weaponFound) {
                            if (chosenWeapon.getUsage() == 2) {

                                chosenWeapon.setDamage(chosenWeapon.getDamage() + 5);
                                gameSession.removeItemFromInventory(chosenItem);
                                gameSession.addItemToInventory(chosenWeapon);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + ".");
                                System.out.println(
                                        "Ora " + chosenWeapon.getNameWithDetArticle() + " infliggerà più danni.");
                            } else {
                                System.out.println("Non puoi usare " + chosenItem.getNameWithDetArticle()
                                        + " con " + chosenWeapon.getNameWithDetArticle() + ".");
                            }
                        } else
                            System.out.println("Non capisco di che arma parli.");
                        break;
                    case "Bestiario":
                        if (Loader.loadEnemy(newCommand[1]) != null) {
                            System.out.println(Loader.loadEnemy(newCommand[1]).getManualDescription());
                        } else {
                            System.out.println("Non capisco di che nemico parli.");
                        }
                        break;
                    case "Libro mastro":
                        if (Loader.loadItem(newCommand[1]) != null) {
                            if (Loader.loadItem(newCommand[1]).getManualDescription() != "" &&
                                    Loader.loadItem(newCommand[1]).getManualDescription() != null) {
                                System.out.println(Loader.loadItem(newCommand[1]).getManualDescription());
                            } else {
                                System.out.println("Non trovi niente di più sul manuale.");
                            }
                        } else {
                            System.out.println("Non capisco di che oggetto parli.");
                        }
                        break;
                    case "Pozione del fulmine":
                        if (Loader.loadEnemy(newCommand[1]) != null) {
                            if (gameSession.getCurrentStatus() == Status.FIGHTING
                                    && gameSession.getCurrentFighting().getOpponent().getName()
                                            .equals(newCommand[1])) {
                                gameSession.getCurrentFighting().addOpponentDebuff("Fulmine");
                                gameSession.getCurrentFighting().getOpponent().setHealthPoints(
                                        gameSession.getCurrentFighting().getOpponent().getHealthPoints() - 15);
                                gameSession.getInventory().remove(chosenItem);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            } else
                                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora");
                        } else
                            System.out.println("Su chi vorresti usarlo di grazia?");
                        break;
                    case "Pozione del fuoco":
                        if (Loader.loadEnemy(newCommand[1]) != null) {
                            if (gameSession.getCurrentStatus() == Status.FIGHTING
                                    && gameSession.getCurrentFighting().getOpponent().getName()
                                            .equals(newCommand[1])) {
                                gameSession.getCurrentFighting().addOpponentDebuff("Fuoco");
                                gameSession.getCurrentFighting().getOpponent().setHealthPoints(
                                        gameSession.getCurrentFighting().getOpponent().getHealthPoints() - 15);
                                gameSession.getInventory().remove(chosenItem);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            } else
                                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora");
                        } else
                            System.out.println("Su chi vorresti usarlo di grazia?");
                        break;
                    case "Pozione del gelo":
                        if (Loader.loadEnemy(newCommand[1]) != null) {
                            if (gameSession.getCurrentStatus() == Status.FIGHTING
                                    && gameSession.getCurrentFighting().getOpponent().getName()
                                            .equals(newCommand[1])) {
                                gameSession.getCurrentFighting().addOpponentDebuff("Gelo");
                                gameSession.getCurrentFighting().getOpponent().setHealthPoints(
                                        gameSession.getCurrentFighting().getOpponent().getHealthPoints() - 15);
                                gameSession.getInventory().remove(chosenItem);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            } else
                                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora");
                        } else
                            System.out.println("Su chi vorresti usarlo di grazia?");
                        break;
                    case "Pozione del veleno":
                        if (Loader.loadEnemy(newCommand[1]) != null) {
                            if (gameSession.getCurrentStatus() == Status.FIGHTING
                                    && gameSession.getCurrentFighting().getOpponent().getName()
                                            .equals(newCommand[1])) {
                                gameSession.getCurrentFighting().addOpponentDebuff("Tossina");
                                gameSession.getCurrentFighting().setOpponentPoisonCounter(5);
                                gameSession.getInventory().remove(chosenItem);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            } else
                                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora");
                        } else
                            System.out.println("Su chi vorresti usarlo di grazia?");
                        break;
                    case "Libro delle maledizioni":
                        if (Loader.loadEnemy(newCommand[1]) != null) {
                            if (gameSession.getCurrentStatus() == Status.FIGHTING
                                    && gameSession.getCurrentFighting().getOpponent().getName()
                                            .equals(newCommand[1])) {
                                gameSession.getCurrentFighting().addOpponentDebuff("Maledetto");
                                gameSession.getCurrentFighting().setCurseCounter(3);
                                gameSession.getInventory().remove(chosenItem);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            } else
                                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora");
                        } else
                            System.out.println("Su chi vorresti usarlo di grazia?");
                        break;
                    default:
                        System.out.println("Non capisco come intendi usarlo.");
                        break;
                }
            } else
                System.out.println("Non capisco di che oggetto parli.");

        } else {// use item by itself
            for (Item item : gameSession.getInventory()) {
                if (command.equals(item.getName())) {
                    itemFound = true;
                    chosenItem = item;
                }
            }

            if (itemFound) {
                // single use item case
                if (temporaryItems.contains(chosenItem.getName())) {
                    if (chosenItem.isUsed()) {
                        System.out.println("Hai già usato " + chosenItem.getNameWithDetArticle() + "!");

                    } else {
                        chosenItem.setUsed(true);
                        System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + ".");
                    }
                    // other cases
                } else {

                    switch (chosenItem.getName()) {
                        case "Acchiappasogni":
                            for (Integer i : gameSession.getCurrentMap().getVisitableRooms()) {
                                if (gameSession.getCurrentMap().getRoom(i).getEvent() != null &&
                                        gameSession.getCurrentMap().getRoom(i).getEvent()
                                                .getClass() == Enemy.class)
                                    gameSession.getCurrentMap().getRoom(i).getEvent().setSkippable(true);
                            }
                            gameSession.removeItemFromInventory(chosenItem);
                            break;
                        case "Vanga":
                            if (!gameSession.getCurrentRoom().wasSpadeUsed()) {
                                gameSession.getCurrentRoom().setWasSpadeUsed(true);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + ".");
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
                                    gameSession.removeItemFromInventory(chosenItem);
                                    System.out.println("Oh, no! La vanga si è spezzata!");
                                }

                                break;
                            } else
                                System.out.println("Hai già provato a cercare tesori in questa stanza!");
                            break;
                        case "Pergamena magica":
                            System.out.println("Hai " + gameSession.getHealthPoints() + "punti salute.");
                            System.out.println(
                                    "La tua forza d'attacco è al " + gameSession.getAttackModifier() * 100 + "%.");
                            System.out.println(
                                    "La tua agilità è al " + gameSession.getAgilityModifier() * 100 + "%.");
                            System.out.println(
                                    "La tua accuratezza è al " + gameSession.getAccuracyModifier() * 100 + "%.");
                            if (gameSession.getCurrentStatus() == Status.FIGHTING &&
                                    gameSession.getCurrentFighting() != null) {
                                for (String string : gameSession.getCurrentFighting().getPlayerDebuff().keySet()) {
                                    if (gameSession.getCurrentFighting().getPlayerDebuff().get(string) == true) {
                                        System.out.println("Sei sotto effetto dello status: " + string + "!");
                                    }
                                }
                                System.out.println("Il nemico ha " + gameSession.getCurrentFighting().getOpponent()
                                        .getHealthPoints() + " punti salute.");
                            }
                            break;
                        case "Borsa":
                            gameSession.setInventoryCapacity(gameSession.getInventoryCapacity() + 8);
                            System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + ".");
                            System.out.println("Ora il tuo inventario può contenere "
                                    + gameSession.getInventoryCapacity() + " oggetti.");
                            gameSession.getInventory().remove(chosenItem);
                            break;
                        case "Armatura":
                            gameSession.setArmorHits(gameSession.getArmorHits() + 10);
                            System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + ".");
                            System.out.println("Ora la tua armatura può difendere da " + gameSession.getArmorHits()
                                    + " colpi.");
                            gameSession.getInventory().remove(chosenItem);
                            break;
                        case "Calzari magici":
                            gameSession.setAgilityModifier(gameSession.getAgilityModifier() + 0.25);
                            System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + ".");
                            System.out.println("Ora sarà più semplice schivare i colpi!");
                            gameSession.getInventory().remove(chosenItem);
                            break;
                        case "Monocolo del cacciatore":
                            gameSession.setAccuracyModifier(gameSession.getAccuracyModifier() + 0.25);
                            System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            System.out.println("Ora sarà più facile colpire!");
                            gameSession.getInventory().remove(chosenItem);
                            break;
                        case "Pitture di guerra":
                            gameSession.setAttackModifier(gameSession.getAttackModifier() + 0.25);
                            System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            System.out.println("I tuoi colpi saranno più potenti!");
                            gameSession.getInventory().remove(chosenItem);
                            break;
                        case "Bomba fumogena":
                            if (gameSession.getCurrentStatus() == Status.FIGHTING
                                    && gameSession.getCurrentRoomId() != gameSession.getCurrentMap()
                                            .getEndRoomId()) {
                                gameSession.setCurrentStatus(Status.EXPLORING);
                                gameSession.getCurrentRoom().setEvent(null);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                                System.out.println("Sei riuscito a fuggire dal combattimento!");
                                gameSession.getInventory().remove(chosenItem);
                            } else
                                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora");
                            break;
                        case "Pozione del fulmine":
                            if (gameSession.getCurrentStatus() == Status.FIGHTING) {
                                gameSession.getCurrentFighting().addOpponentDebuff("Fulmine");
                                gameSession.getCurrentFighting().getOpponent().setHealthPoints(
                                        gameSession.getCurrentFighting().getOpponent().getHealthPoints() - 15);
                                gameSession.getInventory().remove(chosenItem);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            } else
                                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora");

                            break;
                        case "Pozione del fuoco":
                            if (gameSession.getCurrentStatus() == Status.FIGHTING) {
                                gameSession.getCurrentFighting().addOpponentDebuff("Fuoco");
                                gameSession.getCurrentFighting().getOpponent().setHealthPoints(
                                        gameSession.getCurrentFighting().getOpponent().getHealthPoints() - 15);
                                gameSession.getInventory().remove(chosenItem);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            } else
                                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora");
                            break;
                        case "Pozione del gelo":
                            if (gameSession.getCurrentStatus() == Status.FIGHTING) {
                                gameSession.getCurrentFighting().addOpponentDebuff("Gelo");
                                gameSession.getCurrentFighting().getOpponent().setHealthPoints(
                                        gameSession.getCurrentFighting().getOpponent().getHealthPoints() - 15);
                                gameSession.getInventory().remove(chosenItem);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            } else
                                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora");
                            break;
                        case "Pozione del veleno":
                            if (gameSession.getCurrentStatus() == Status.FIGHTING) {
                                gameSession.getCurrentFighting().addOpponentDebuff("Tossina");
                                gameSession.getCurrentFighting().setOpponentPoisonCounter(5);
                                gameSession.getInventory().remove(chosenItem);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            } else
                                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora");

                            break;
                        case "Pozione di cura":
                            if (gameSession.getHealthPoints() * 1.5 > gameSession.getMaxHealthPoints()) {
                                gameSession.setHealthPoints(gameSession.getMaxHealthPoints());
                            } else {
                                gameSession.setHealthPoints((int) (gameSession.getHealthPoints() * 1.5));
                            }
                            System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            System.out.println("Ora hai " + gameSession.getHealthPoints() + " punti vita.");
                            gameSession.getInventory().remove(chosenItem);
                            break;
                        case "Libro delle maledizioni":
                            if (gameSession.getCurrentStatus() == Status.FIGHTING) {
                                gameSession.getCurrentFighting().addOpponentDebuff("Maledetto");
                                gameSession.getCurrentFighting().setCurseCounter(3);
                                gameSession.getInventory().remove(chosenItem);
                                System.out.println("Hai usato " + chosenItem.getNameWithDetArticle() + "!");
                            } else
                                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora");
                            break;
                        default:
                            System.out.println("Non capisco come intendi usarlo...");
                            break;

                    }

                }

            }
            if (!itemFound) {
                System.out.println("Non capisco di che oggetto parli...");
            }
        }

    }

    public static void examineItem(Session gameSession, String command) {
        boolean found = false;
        for (Item item : gameSession.getInventory()) {
            if (command.equals(item.getName())) {
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
            if (command.equals(item.getName())) {

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
        temporaryItems = Loader.loadList("temporaryItems");
    }

}