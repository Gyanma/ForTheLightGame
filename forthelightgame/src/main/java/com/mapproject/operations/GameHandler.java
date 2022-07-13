package com.mapproject.operations;

import java.util.Scanner;

import com.mapproject.enums.Status;
import com.mapproject.resources.Session;

public class GameHandler {

    Session gameSession;
    Scanner gameScanner = new Scanner(System.in);
    Interpreter interpreter = new Interpreter();

    public GameHandler(Session session) {
        this.gameSession = session;
        gameSession.setCurrentRoomId(gameSession.getCurrentMap().getStartingRoomId());
        gameSession.addItemToInventory(Loader.loadItem("mappa"));
        gameSession.addItemToInventory(Loader.loadItem("pergamena magica"));

        InventoryHandler.initSingleUseItems();
    }

    public void runGame(Session newSession) {

        Printer.printFromTxt("Presentazione");
        // String input = gameScanner.nextLine();
        // if (input.equals("Sì")) {
        // Printer.printFromTxt("Regole");
        // }
        Printer.printFromTxt("Inizio");
        int action = 1;
        String command;
        String parsedCommand;

        System.out.println("\nCosa vuoi fare?");
        do {
            command = gameScanner.nextLine();
            parsedCommand = Parser.parseCommand(command);
            if (!parsedCommand.equals("Chiudi il gioco")) {
                action = Interpreter.decide(parsedCommand, gameSession);
                if (action == 1 && gameSession.getCurrentStatus() != Status.PUZZLE_SOLVING) {
                    System.out.println("\nCosa vuoi fare?");
                } else if (action == 2) {
                    System.out.println("\nNon ho ben capito cosa vuoi fare...");
                }
            } else
                action = 0;
            if (action == 0) {
                System.out.println("Sei sicuro? (sì/no)");
                if (!gameScanner.nextLine().equals("sì")) {
                    action = 1;
                    System.out.println("\nCosa vuoi fare?");
                }
            }

            if (action == 3) {
                action = 0;
            }

        } while (action != 0 && gameSession.isPlayerAlive());

        System.out.println("Arrivederci!");
    }

}
