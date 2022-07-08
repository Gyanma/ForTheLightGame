package com.mapproject.operations.parser;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.mapproject.enums.Location;
import com.mapproject.enums.Status;
import com.mapproject.operations.Loader;
import com.mapproject.resources.Session;
import com.mapproject.resources.items.Item;

public class Interpreter {

    Map<String, List<String>> dictionary;
    static String directionPattern = "a\\s(nord|sud)-(est|ovest)$";

    public Interpreter() {
        this.dictionary = Loader.loadDictionary();
    }

    public static void decide(String command, Session gameSession) {
        String newCommand = command;
        if (newCommand.startsWith("Esplora la stanza")) {
            if (newCommand.equals("Esplora la stanza")) {
                exploreRoomNW(gameSession);
                exploreRoomNE(gameSession);
                exploreRoomSW(gameSession);
                exploreRoomSE(gameSession);
            } else {
                Pattern p = Pattern.compile(directionPattern);
                newCommand = newCommand.replace("Esplora la stanza", " ");
                newCommand = newCommand.trim();

                if (p.matcher(newCommand).matches()) {
                    if (newCommand.contains("nord")) {
                        if (newCommand.contains("ovest")) {
                            exploreRoomNW(gameSession);
                        } else {
                            exploreRoomNE(gameSession);
                        }

                    } else if (newCommand.contains("sud")) {
                        if (newCommand.contains("ovest")) {
                            exploreRoomSW(gameSession);
                        } else {
                            exploreRoomSE(gameSession);
                        }

                    }

                } else {
                    System.out.println("Comando non riconosciuto");
                }
            }
        }

    }

    private static void exploreRoomForItems(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getItems() != null) {
                for (Item item : gameSession.getCurrentRoom().getItems()) {
                    System.out.println("Nella stanza vedi anche un"
                            + item.getName());
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
