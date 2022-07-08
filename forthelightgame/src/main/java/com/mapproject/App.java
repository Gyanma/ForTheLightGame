package com.mapproject;

import java.util.Scanner;

import com.mapproject.operations.GameHandler;
import com.mapproject.operations.Printer;
import com.mapproject.resources.Session;

public final class App {

    private Session newSession;

    public App(int mode) {
        newSession = new Session();
    }

    public void start() {
        Printer.printFromTxt("Presentazione");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("sì")) {
            Printer.printFromTxt("Regole");
        }
        Printer.printFromTxt("Inizio");
        scanner.close();

        GameHandler.startGame(newSession);
    }

    public static void main(String[] args) {

        System.out.println("\t\tFor The Light\n");
        System.out.println("\tA game by Gianmarco Rutigliano\n");

        App app = new App(0);
        app.start();

    }
}
