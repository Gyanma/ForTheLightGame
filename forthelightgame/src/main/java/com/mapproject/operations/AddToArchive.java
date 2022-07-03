package com.mapproject.operations;

import java.io.FileWriter;

import org.json.JSONObject;

import com.mapproject.enums.Location;
import com.mapproject.resources.events.VisualPuzzle;

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

    /*
     * public static void addWeapon() {
     * List<String> alias = new ArrayList<>();
     * 
     * alias.add("shuriken");
     * 
     * JSONObject weaponJson = new JSONObject();
     * weaponJson.put("id", 1109);
     * weaponJson.put("name", "Shuriken");
     * weaponJson.put("description", "Shuriken trovati nel labirinto. "
     * + "Lame piccole ma acuminate, eredit\u00e0 di guerrieri di epoche passate.");
     * weaponJson.put("alias", alias);
     * weaponJson.put("manualDescription",
     * "Un'arma a distanza. Danni intermedi, peso basso e precisione alta.");
     * weaponJson.put("pickupable", true);
     * weaponJson.put("throwable", true);
     * weaponJson.put("damage", 2);
     * weaponJson.put("accuracy", 3);
     * weaponJson.put("weight", 1);
     * weaponJson.put("usage", 1);
     * 
     * try {
     * FileWriter file = new FileWriter(
     * "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\weapons\\"
     * + weaponJson.get("name") + ".json");
     * file.write(weaponJson.toString());
     * file.flush();
     * file.close();
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     * 
     * 
     * 
     * (String name, String presentation, int eventId, Location location,
     * int visualId, String description)
     */

    public static void addVisualPuzzle() {

        VisualPuzzle vP;
        JSONObject itemJson = new JSONObject();
        itemJson.put("name", "33333!");
        itemJson.put("presentation",
                "La porta sembra bloccata da un qualche meccanismo. Esaminalo e scopri come aprirla.");
        itemJson.put("eventId", 4001);
        itemJson.put("location", Location.EVERYWHERE);
        itemJson.put("description",
                "Una semplice sottrazione. Il primo numero meno il secondo deve dare 33333. \nPer\u00f2 puoi usare ogni cifra da 1 a 9 una volta sola. Pensi di farcela?");
        itemJson.put("visualId", 1);

        vP = new VisualPuzzle((String) itemJson.get("name"),
                (String) itemJson.get("presentation"),
                (int) itemJson.get("eventId"),
                (Location) itemJson.get("location"),
                (int) itemJson.get("visualId"),
                (String) itemJson.get("description"));

        System.out.println(vP.getDescription());
        System.out.println(vP.getEventId());
        System.out.println(vP.getLocation());
        System.out.println(vP.getName());
        System.out.println(vP.getPresentation());
        System.out.println(vP.getVisualId());

        try {
            FileWriter file = new FileWriter(
                    "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\visual puzzles\\"
                            + itemJson.get("name") + ".json");
            file.write(itemJson.toString());
            file.flush();
            file.close();
        } catch (Exception e) {
            System.out.println("Error while writing item JSON");
        }

        VisualPuzzle vP2 = Loader.loadVisualPuzzle(itemJson.get("name").toString());
        System.out.println(vP2.getDescription());
        System.out.println(vP2.getEventId());
        System.out.println(vP2.getLocation());
        System.out.println(vP2.getName());
        System.out.println(vP2.getPresentation());
        System.out.println(vP2.getVisualId());
        System.out.println(vP2.isSkippable());
        System.out.println(vP2.isSolved());

    }
}
