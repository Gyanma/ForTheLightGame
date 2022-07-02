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

        alias.add("libro delle maledizioni");
        alias.add("manuale delle maledizioni");
        alias.add("tomo delle maledizioni");
        // alias.add("scarpe");
        // alias.add("pala");

        JSONObject itemJson = new JSONObject();
        itemJson.put("id", 2014);
        itemJson.put("name", "Libro delle maledizioni");
        itemJson.put("description", "Un antico volume trovato nel labirinto. "
                + "Contiene maledizioni molto potenti; in pochi hanno saputo domarle.");
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
