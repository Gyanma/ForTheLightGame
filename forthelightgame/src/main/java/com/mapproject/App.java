package com.mapproject;

import java.util.List;
import java.util.Map;

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

        AddToArchive.addMap();
        Map<String, List<String>> list = Loader.loadDictionary();
        for (String s : list.keySet()) {
            if (list.get(s).contains("un'ascia"))
                System.out.println(s);
            else
                System.out.println("no");
        }

        // System.out.println("\t\tFor The Light\n");
        // System.out.println("\tA game by Gianmarco Rutigliano\n");

        // App app = new App();
        // app.start();

    }
}
