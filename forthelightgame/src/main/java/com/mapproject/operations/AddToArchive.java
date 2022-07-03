package com.mapproject.operations;

import java.io.FileWriter;

import org.json.JSONObject;

import com.mapproject.enums.Location;
import com.mapproject.resources.events.VisualPuzzle;

public class AddToArchive {

    public static void addVisualPuzzle() {

        VisualPuzzle vP;
        JSONObject itemJson = new JSONObject();

        itemJson.put("name", "Gli Zeri");
        itemJson.put("presentation",
                "La porta sembra bloccata da un qualche meccanismo. Esaminalo e scopri come aprirla.");
        itemJson.put("eventId", 4003);
        itemJson.put("description",
                "Quattro pannelli, quattro pulsanti. Quando i pannelli mostreranno tutti 0, la via sar\u00e0 libera.");
        itemJson.put("visualId", 3);

        itemJson.put("location", Location.EVERYWHERE);
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
