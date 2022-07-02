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

        alias.add("vanga");
        alias.add("pala");

        JSONObject itemJson = new JSONObject();
        itemJson.put("id", 2004);
        itemJson.put("name", "Vanga");
        itemJson.put("description", "Una vanga trovata nel labirinto. "
                + "L'attrezzo fondamentale di un esploratore preparato.");
        itemJson.put("alias", alias);
        itemJson.put("spawnOddsPhase1", 3);
        itemJson.put("spawnOddsPhase2", 3);
        itemJson.put("spawnOddsPhase3", 2);

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
