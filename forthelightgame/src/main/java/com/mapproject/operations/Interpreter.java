package com.mapproject.operations;

import com.mapproject.enums.Status;
import com.mapproject.operations.visualHandler.VisualHandler;
import com.mapproject.resources.Session;
import com.mapproject.resources.events.Danger;
import com.mapproject.resources.events.PacificEncounter;
import com.mapproject.resources.events.TextPuzzle;
import com.mapproject.resources.events.VisualPuzzle;
import com.mapproject.resources.items.Item;

public class Interpreter {

    private static boolean isMapOpened = false;

    public Interpreter() {
    }

    public static int decide(String command, Session gameSession) {

        // Exploring section

        // explore room command
        if (command.equals("Esplora stanza")) {
            exploreRoom(gameSession);
            return 1;

            // item search command
        } else if (command.startsWith("Cerca item")) {
            exploreRoomForItems(gameSession);
            return 1;

            // change room commands
        } else if (command.startsWith("Spostati a")) {
            if (gameSession.getCurrentRoom().getEvent() == null ||
                    gameSession.getCurrentRoom().getEvent().isSkippable()) {
                command = command.replace("Spostati a", "");
                command = command.trim();
                if (command.contains("nord")) {
                    moveToNorth(gameSession);
                } else if (command.contains("sud")) {
                    moveToSouth(gameSession);
                } else if (command.contains("ovest")) {
                    moveToWest(gameSession);
                } else if (command.contains("est")) {
                    moveToEast(gameSession);
                } else {
                    return 2;
                }
                if (gameSession.getCurrentRoom().getEvent() != null &&
                        gameSession.getCurrentRoom().getEvent().getClass() == Danger.class)
                    launchDanger(gameSession);

                if (gameSession.getCurrentRoom().getEvent() != null &&
                        gameSession.getCurrentMap().getEndRoomId() == gameSession.getCurrentRoomId()) {
                    System.out.println("Senti una presenza inquietante... Dev'essere la stanza finale");
                }
            }
            return 1;

            // get item commands
        } else if (command.startsWith("Raccogli")) {
            getItem(gameSession, command);
            return 1;

            // open map command
        } else if (command.startsWith("Apri mappa")) {
            drawMap(gameSession);
            return 1;

            // reach an npc command
        } else if (command.startsWith("Raggiungi")) {
            command = command.replace("Raggiungi", "");
            command = command.trim();
            System.out.println(command);
            if (command.equals(gameSession.getCurrentRoom().getEvent().getName().toLowerCase())) {
                startEvent(gameSession);
                return 1;
            } else if (command.equals("meccanismo") &&
                    gameSession.getCurrentRoom().getEvent().getClass() == VisualPuzzle.class) {
                startVisualPuzzle(gameSession);
                return 1;
            } else
                return 2;

            // exit map command
        } else if (command.equals("Esci"))
            return changeToNextMap(gameSession);

        // Inventory section

        // open inventory command
        else if (command.equals("Apri inventario")) {
            openInventory(gameSession);
            return 1;

        } else if (command.startsWith("Usa")) {
            command = command.replace("Usa", "");
            return InventoryHandler.useItem(gameSession, command);

        } else if (command.equals("Chiudi inventario")) {
            closeInventory(gameSession);
            return 1;
            // Unrecognised command
        } else {
            return 2;
        }
    }

    private static void startVisualPuzzle(Session gameSession) {
        try {
            int result = VisualHandler.selectVisual(gameSession.getCurrentRoom().getEvent().getEventId());
            if (result == 1) {
                gameSession.getCurrentRoom().setEvent(null);
                System.out.println("Senti i meccanismi che si attivano dietro i muri. adesso loe porte si aprono!");
            } else if (result == 0) {
                System.out.println("Questo enigma è davvero ostico... bisogna pensarci meglio.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void launchDanger(Session gameSession) {

        // TODO set danger.
    }

    private static int changeToNextMap(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getId() == gameSession.getCurrentMap().getEndRoomId()) {
                if (gameSession.getCurrentRoom().getEvent() != null) {
                    switch (gameSession.getCurrentPhase()) {
                        case 1:
                            gameSession.setCurrentPhase(2);
                            gameSession.setCurrentRoomId(gameSession.getSessionMap(2).getStartingRoomId());
                            return 1;
                        case 2:
                            gameSession.setCurrentPhase(3);
                            gameSession.setCurrentRoomId(gameSession.getSessionMap(3).getStartingRoomId());
                            return 1;
                        case 3:
                            Printer.printFromTxt("Ending");
                            return 0;
                        default:
                            return 0;
                    }
                } else
                    System.out.println("Devi ancora sconfiggere il boss!");

            } else
                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
        return 1;
    }

    private static void closeInventory(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.LOOKING_INVENTORY) {
            gameSession.setCurrentStatus(Status.EXPLORING);
            System.out.println("Hai chiuso l'inventario.");
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
    }

    private static void openInventory(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            gameSession.setCurrentStatus(Status.LOOKING_INVENTORY);
            if (gameSession.getInventory().size() == 0) {
                System.out.println("Hai aperto l'inventario.\nAl momento, l'inventario è vuoto.");
            } else {
                System.out.println("Hai aperto l'inventario.\nNell'inventario hai:");
                int counter = 0;
                do {
                    if (gameSession.getInventory().size() - counter >= 4) {
                        System.out.println(
                                gameSession.getInventory().get(counter).getName() + "\t"
                                        + gameSession.getInventory().get(counter + 1).getName() + "\t"
                                        + gameSession.getInventory().get(counter + 2).getName() + "\t"
                                        + gameSession.getInventory().get(counter + 3).getName());
                        counter += 4;
                    } else if (gameSession.getInventory().size() - counter == 3) {
                        System.out.println(
                                gameSession.getInventory().get(counter).getName() + "\t"
                                        + gameSession.getInventory().get(counter + 1).getName() + "\t"
                                        + gameSession.getInventory().get(counter + 2).getName());
                        counter += 3;
                    } else if (gameSession.getInventory().size() - counter == 2) {
                        System.out.println(
                                gameSession.getInventory().get(counter).getName() + "\t"
                                        + gameSession.getInventory().get(counter + 1).getName());
                        counter += 2;
                    } else if (gameSession.getInventory().size() - counter == 1) {
                        System.out.println(
                                gameSession.getInventory().get(counter).getName());
                        counter += 1;
                    }

                } while (counter < gameSession.getInventory().size() - 1);
            }
        } else if (gameSession.getCurrentStatus() == Status.LOOKING_INVENTORY)
            System.out.println("Hai già aperto l'inventario!");
        else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
    }

    private static void startEvent(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getEvent().getClass() == TextPuzzle.class) {
                gameSession.setCurrentStatus(Status.PUZZLE_SOLVING);
                TextPuzzle textPuzzle = (TextPuzzle) gameSession.getCurrentRoom().getEvent();
                System.out.println(textPuzzle.getQuestion());

            } else if (gameSession.getCurrentRoom().getEvent().getClass() == PacificEncounter.class) {
                gameSession.setCurrentStatus(Status.IN_PACIFIC_ENCOUNTER);
                PacificEncounter encounter = (PacificEncounter) gameSession.getCurrentRoom().getEvent();
                System.out.println(encounter.getDescription());

            } else if (gameSession.getCurrentRoom().getEvent().getClass() == PacificEncounter.class) {
                gameSession.setCurrentStatus(Status.FIGHTING);

            }
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

    }

    private static void drawMap(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (true) {
                if (gameSession.getInventory().contains(Loader.loadItem("mappa"))) {
                    gameSession.drawVisualMap(false);
                    isMapOpened = true;

                } else if (gameSession.getInventory().contains(Loader.loadItem("mappa mistica"))) {
                    gameSession.drawVisualMap(true);
                    isMapOpened = true;

                } else {
                    System.out.println("Non hai una mappa!");
                }
            } else
                System.out.println("Hai già aperto la mappa!");
        } else if (gameSession.getCurrentStatus() == Status.LOOKING_INVENTORY)
            System.out.println("Non hai chiuso l'inventario!");
        else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

    }

    private static void getItem(Session gameSession, String command) {
        boolean found = false;
        String itemName = command;
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            itemName.replace("Raccogli", "");
            itemName.trim();
            for (Item item : gameSession.getCurrentRoom().getItems()) {
                if (itemName.contains(item.getName())) {
                    gameSession.addObjectToInventory(item);
                    gameSession.getCurrentRoom().removeItem(item);
                    found = true;
                    System.out.println("Hai raccolto " + item.getNameWithDetArticle() + ".");
                    break;
                }
            }
            if (!found) {
                System.out.println("Non c'è nessun item con questo nome...");
            }
        } else if (gameSession.getCurrentStatus() == Status.LOOKING_INVENTORY)
            System.out.println("Non hai chiuso l'inventario!");
        else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
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
        } else if (gameSession.getCurrentStatus() == Status.LOOKING_INVENTORY)
            System.out.println("Non hai chiuso l'inventario!");
        else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
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
        } else if (gameSession.getCurrentStatus() == Status.LOOKING_INVENTORY)
            System.out.println("Non hai chiuso l'inventario!");
        else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
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
        } else if (gameSession.getCurrentStatus() == Status.LOOKING_INVENTORY)
            System.out.println("Non hai chiuso l'inventario!");
        else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
    }

    private static void moveToNorth(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            int currentRoomId = gameSession.getCurrentRoomId();
            if (gameSession.getCurrentMap().getRoom(currentRoomId).getNorth() != null) {
                gameSession.setCurrentRoomId(
                        gameSession.getCurrentMap().getRoom(currentRoomId).getNorth().getId());
                System.out.println("Ti sposti verso la stanza a nord.");
            } else {
                System.out.println("Non ci sono stanze a nord!");
            }
        } else if (gameSession.getCurrentStatus() == Status.LOOKING_INVENTORY)
            System.out.println("Non hai chiuso l'inventario!");
        else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

    }

    private static void exploreRoom(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getEvent() != null) {
                System.out.println("Che succede?");

                System.out.println(gameSession.getCurrentRoom().getEvent().getPresentation());

            } else
                System.out.println("Sembra tutto tranquillo qui...");
        } else if (gameSession.getCurrentStatus() == Status.LOOKING_INVENTORY)
            System.out.println("Non hai chiuso l'inventario!");
        else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
    }

    private static void exploreRoomForItems(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getItems() != null) {
                for (Item item : gameSession.getCurrentRoom().getItems()) {

                    System.out.println("Nella stanza vedi "
                            + (item.getNameWithIndetArticle()) + "!");
                }
            } else
                System.out.println("Non c'è nulla qui...");
        } else if (gameSession.getCurrentStatus() == Status.LOOKING_INVENTORY)
            System.out.println("Non hai chiuso l'inventario!");
        else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
    }

}