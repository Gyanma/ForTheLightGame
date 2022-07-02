package com.mapproject.operations;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class AddToArchive {

    public static void addDanger() {
        // (int eventId, String name, String description, String presentation, int
        // timeLimit, Item solution,
        // Item prize);
        /*
         * int eventId;
         * String name;
         * String description;
         * String presentation;
         * int timeLimit;
         * Item solution;
         * Item prize;
         */ }

    public static void addItem() {
        List<String> alias = new ArrayList<>();

        alias.add("Mappa");
        // alias.add("perle");
        // alias.add("tomo della destrezza");
        // alias.add("scarpe");
        // alias.add("pala");

        JSONObject itemJson = new JSONObject();
        itemJson.put("id", 2026);
        itemJson.put("name", "Mappa");
        itemJson.put("description", "La mappa con cui hai cominciato la tua avventura. "
                + "Avere un'idea delle stanze che puoi raggiungere aiuta.");
        itemJson.put("alias", alias);
        itemJson.put("manualDescription", "Usala per vedere tutte le stanze raggiungibili e la stanza di partenza.");
        itemJson.put("pickupable", true);
        itemJson.put("throwable", true);

        try {
            FileWriter file = new FileWriter(
                    "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\items\\"
                            + itemJson.get("name") + ".json");
            file.write(itemJson.toString());
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addEnemy() {

        // (int eventId, String name, String description, Location location,
        // String manualDescription, List<Integer> actions)

        List<String> alias = new ArrayList<>();

        alias.add("Mappa");
        // alias.add("perle");
        // alias.add("tomo della destrezza");
        // alias.add("scarpe");
        // alias.add("pala");

        JSONObject itemJson = new JSONObject();
        itemJson.put("id", 2026);
        itemJson.put("name", "Mappa");
        itemJson.put("description", "La mappa con cui hai cominciato la tua avventura. "
                + "Avere un'idea delle stanze che puoi raggiungere aiuta.");
        itemJson.put("alias", alias);

        itemJson.put("pickupable", true);
        itemJson.put("throwable", true);

        try {
            FileWriter file = new FileWriter(
                    "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\items\\"
                            + itemJson.get("name") + ".json");
            file.write(itemJson.toString());
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
