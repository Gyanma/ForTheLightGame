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

        alias.add("torcia");
        alias.add("fiaccola");
        // alias.add("bisaccia");
        // alias.add("pala");
        // alias.add("pala");
        // alias.add("pala");

        JSONObject itemJson = new JSONObject();
        itemJson.put("id", 2006);
        itemJson.put("name", "Torcia");
        itemJson.put("description", "Una torcia trovata nel labirinto. "
                + "C'è anche un acciarino; ora il buio non è più un problema.");
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
