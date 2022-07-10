package com.mapproject.operations.parser;

import java.util.List;
import java.util.Map;

import com.mapproject.enums.Location;
import com.mapproject.enums.Status;
import com.mapproject.operations.Loader;
import com.mapproject.operations.visualHandler.VisualHandler;
import com.mapproject.resources.Session;
import com.mapproject.resources.items.Item;

public class Interpreter {

    private static Map<String, List<String>> dictionary;

    public Interpreter() {
        dictionary = Loader.loadDictionary();
    }

    public static boolean decide(String command, Session gameSession) {

        // comandi di esplorazione
        if (command.startsWith("Esplora stanza")) {
            if (command.equals("Esplora stanza")) {
                exploreRoom(gameSession);
            } else {

                if (command.contains("nord")) {
                    if (command.contains("ovest")) {
                        exploreRoomNW(gameSession);
                    } else {
                        exploreRoomNE(gameSession);
                    }

                } else if (command.contains("sud")) {
                    if (command.contains("ovest")) {
                        exploreRoomSW(gameSession);
                    } else {
                        exploreRoomSE(gameSession);
                    }
                }
            }
            return true;

            // TODO AGGIUSTA NOMI ITEM
            // comando di ricerca Item
        } else if (command.startsWith("Cerca item")) {
            exploreRoomForItems(gameSession);
            return true;

        } else if (command.startsWith("Spostati a")) {
            if (command.contains("nord")) {
                moveToNorth(gameSession);
            } else if (command.contains("sud")) {
                moveToSouth(gameSession);
            } else if (command.contains("ovest")) {
                moveToWest(gameSession);
            } else if (command.contains("est")) {
                moveToEast(gameSession);
            }
            return true;

        } else if (command.startsWith("Raccogli")) {
            getItem(gameSession, command);

            return true;
        } else if (command.startsWith("Apri mappa")) {
            try {
                VisualHandler.drawMap(gameSession.getCurrentMap(), gameSession.getCurrentRoomId());
            } catch (Exception e) {
                e.printStackTrace();
            }

            return true;
        } else {
            return false;
        }
    }

    private static void getItem(Session gameSession, String command) {
        boolean found = false;
        String itemName = command;
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {

            itemName.replace("Raccogli", " ");
            itemName.trim();
            for (Item item : gameSession.getCurrentRoom().getItems()) {
                if (itemName.contains(item.getName())) {
                    gameSession.addObjectToInventory(item);
                    gameSession.getCurrentRoom().removeItem(item);
                    found = true;
                    System.out.println("Hai raccolto l'item " + item.getName());
                    break;
                }
            }
            if (!found) {
                System.out.println("Non c'è nessun item con questo nome");
            }
        } else {
            System.out.println("Non mi sembra un buon momento per raccogliere oggetti.");
        }
    }

    private static void moveToWest(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            int currentRoomId = gameSession.getCurrentRoomId();
            if (gameSession.getCurrentMap().getRoom(currentRoomId).getWest() != null) {
                gameSession.setCurrentRoomId(
                        gameSession.getCurrentMap().getRoom(currentRoomId).getWest().getId());
                System.out.println("Ti sposti verso la stanza a ovest.");
            } else {
                System.out.println("Non ci sono stanze a ovest!");
            }
        } else {
            System.out.println("Non mi sembra un buon momento per spostarti.");
        }
    }

    private static void moveToEast(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            int currentRoomId = gameSession.getCurrentRoomId();
            if (gameSession.getCurrentMap().getRoom(currentRoomId).getEast() != null) {
                gameSession.setCurrentRoomId(
                        gameSession.getCurrentMap().getRoom(currentRoomId).getEast().getId());
                System.out.println("Ti sposti verso la stanza a est.");
            } else {
                System.out.println("Non ci sono stanze a est!");
            }
        } else {
            System.out.println("Non mi sembra un buon momento per spostarti.");
        }
    }

    private static void moveToSouth(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            int currentRoomId = gameSession.getCurrentRoomId();
            if (gameSession.getCurrentMap().getRoom(currentRoomId).getSouth() != null) {
                gameSession.setCurrentRoomId(
                        gameSession.getCurrentMap().getRoom(currentRoomId).getSouth().getId());
                System.out.println("Ti sposti verso la stanza a sud.");
            } else {
                System.out.println("Non ci sono stanze a sud!");
            }
        } else {
            System.out.println("Non mi sembra un buon momento per spostarti.");
        }
    }

    private static void moveToNorth(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            int currentRoomId = gameSession.getCurrentRoomId();
            if (gameSession.getCurrentMap().getRoom(currentRoomId).getNorth() != null) {
                gameSession.setCurrentRoomId(
                        gameSession.getCurrentMap().getRoom(currentRoomId).getNorth().getId());
                System.out.println("Ti sposti verso la stanza a nord.");
            } else {
                System.out.println("Non ci sono stanze a ovest!");
            }
        } else {
            System.out.println("Non mi sembra un buon momento per spostarti.");
        }

    }

    private static void exploreRoom(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getEvent() != null) {
                System.out.println(gameSession.getCurrentRoom().getEvent().getPresentation());
                switch (gameSession.getCurrentRoom().getEvent().getLocation()) {
                    case NORTH_EAST:
                        System.out.println("Ti conviene raggiungere l'angolo a nord-est della stanza.");
                        break;
                    case NORTH_WEST:
                        System.out.println("Ti conviene raggiungere l'angolo a nord-ovest della stanza.");
                        break;
                    case SOUTH_EAST:
                        System.out.println("Ti conviene raggiungere l'angolo a sud-est della stanza.");
                        break;
                    case SOUTH_WEST:
                        System.out.println("Ti conviene raggiungere l'angolo a sud-ovest della stanza.");
                        break;
                    default:
                        break;
                }

            }
        }
    }

    private static void exploreRoomForItems(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getItems() != null) {
                for (Item item : gameSession.getCurrentRoom().getItems()) {

                    System.out.println("Nella stanza vedi "
                            + (item.getName()) + "!");
                }
            }
        }
    }

    private static void exploreRoomSE(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getEvent() != null &&
                    gameSession.getCurrentRoom().getEvent().getLocation() == Location.SOUTH_EAST) {
                System.out.println(gameSession.getCurrentRoom().getEvent().getPresentation());
            } else
                System.out.println("Nell'angolo a sud-est della stanza sembra tutto tranquillo...");
        } else
            System.out.println("Non puoi esplorare la stanza in questo momento!");
    }

    private static void exploreRoomSW(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getEvent() != null &&
                    gameSession.getCurrentRoom().getEvent().getLocation() == Location.SOUTH_WEST) {
                System.out.println(gameSession.getCurrentRoom().getEvent().getPresentation());
            } else
                System.out.println("Nell'angolo a sud-ovest della stanza sembra tutto tranquillo...");
        } else
            System.out.println("Non puoi esplorare la stanza in questo momento!");
    }

    private static void exploreRoomNE(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getEvent() != null &&
                    gameSession.getCurrentRoom().getEvent().getLocation() == Location.NORTH_EAST) {
                System.out.println(gameSession.getCurrentRoom().getEvent().getPresentation());
            } else
                System.out.println("Nell'angolo a nord-est della stanza sembra tutto tranquillo...");
        } else
            System.out.println("Non puoi esplorare la stanza in questo momento!");
    }

    private static void exploreRoomNW(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getEvent() != null &&
                    gameSession.getCurrentRoom().getEvent().getLocation() == Location.NORTH_WEST) {
                System.out.println(gameSession.getCurrentRoom().getEvent().getPresentation());
            } else
                System.out.println("Nell'angolo a nord-ovest della stanza sembra tutto tranquillo...");
        } else
            System.out.println("Non puoi esplorare la stanza in questo momento!");
    }

}
