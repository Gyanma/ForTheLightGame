package com.mapproject;

import java.util.List;

import com.mapproject.operations.AddToArchive;
import com.mapproject.operations.GameHandler;
import com.mapproject.operations.Loader;
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

        AddToArchive.addList();
        List<String> list = Loader.loadList("StartsWithLo");
        for (String s : list) {
            System.out.println(s);
        }

        // System.out.println("\t\tFor The Light\n");
        // System.out.println("\tA game by Gianmarco Rutigliano\n");

        // App app = new App();
        // app.start();

    }
}
