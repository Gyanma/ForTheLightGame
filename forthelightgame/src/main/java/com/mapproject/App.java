package com.mapproject;

import com.mapproject.operations.GameHandler;
import com.mapproject.resources.Session;

public final class App {

    private Session newSession;

    public App() {
        this.newSession = new Session();
    }

    public void start() {
        GameHandler gameHandler = new GameHandler(newSession);
        gameHandler.runGame(newSession);

    }

    public static void main(String[] args) {

        System.out.println("\t\tFor The Light\n");
        System.out.println("\tA game by Gianmarco Rutigliano\n");

        App app = new App();
        app.start();

    }
}
