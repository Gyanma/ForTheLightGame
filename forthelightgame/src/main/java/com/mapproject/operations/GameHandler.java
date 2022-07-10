package com.mapproject.operations;

import java.util.Scanner;

import com.mapproject.operations.parser.Interpreter;
import com.mapproject.operations.parser.Parser;
import com.mapproject.resources.Session;

public class GameHandler {

    Session gameSession;
    Scanner gameScanner = new Scanner(System.in);
    Interpreter interpreter = new Interpreter();

    public GameHandler(Session session) {
        this.gameSession = session;
        gameSession.setCurrentRoomId(gameSession.getCurrentMap().getStartingRoomId());
    }

    public void runGame(Session newSession) {

        Printer.printFromTxt("Presentazione");
        // String input = gameScanner.nextLine();
        // if (input.equals("sì")) {
        // Printer.printFromTxt("Regole");
        // }
        Printer.printFromTxt("Inizio");
        boolean action = true;
        String command;
        String parsedCommand;

        System.out.println("Cosa vuoi fare?");
        do {
            command = gameScanner.nextLine();
            parsedCommand = Parser.parseCommand(command);
            if (!parsedCommand.equals("Chiudi il gioco")) {
                action = Interpreter.decide(parsedCommand, gameSession);
                if (action) {
                    System.out.println("Cosa vuoi fare?");
                } else {
                    System.out.println("Non ho ben capito cosa vuoi fare...");
                }
            }

        } while (!parsedCommand.equals("Chiudi il gioco") && gameSession.isPlayerAlive());

        System.out.println("Arrivederci!");
    }

}
