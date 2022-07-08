package com.mapproject.operations;

import java.util.Scanner;

import com.mapproject.operations.parser.Interpreter;
import com.mapproject.operations.parser.Parser;
import com.mapproject.resources.Session;

public class GameHandler {

    Session gameSession;
    Scanner gameScanner = new Scanner(System.in);

    public GameHandler(Session session) {
        this.gameSession = session;
        gameSession.setCurrentRoom(gameSession.getSessionMapPhase1().getStartingRoomId());
    }

    public void runGame(Session newSession) {

        Printer.printFromTxt("Presentazione");
        String input = gameScanner.nextLine();
        if (input.equals("sì")) {
            Printer.printFromTxt("Regole");
        }
        Printer.printFromTxt("Inizio");

        String command = "";
        String parsedCommand;
        do {
            System.out.println("Cosa vuoi fare?");
            command = gameScanner.nextLine();
            parsedCommand = Parser.parseCommand(command);
            if (!parsedCommand.equals("Chiudi il gioco")) {
                Interpreter.decide(parsedCommand, gameSession);
            }

        } while (!parsedCommand.equals("Chiudi il gioco") && gameSession.isPlayerAlive());

        System.out.println("Arrivederci!");
    }

}
