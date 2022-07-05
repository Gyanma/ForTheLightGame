package com.mapproject.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.mapproject.enums.Location;
import com.mapproject.resources.events.Danger;
import com.mapproject.resources.events.JugPuzzle;
import com.mapproject.resources.items.Item;

public class AddToArchive {

        public static void addTextPuzzle() {

                JSONObject itemJson = new JSONObject();

                itemJson.put("name", "Brocche di vino");
                itemJson.put("presentation", "Nell'angolo della stanza trovi un vecchio seduto a un tavolo.\n"
                                + "Ha tre brocche di fronte a sé. Non sai perché, ma\n"
                                + "hai come la sensazione di averlo già visto...\n");
                itemJson.put("eventId", 2214);
                itemJson.put("isSkippable", true);
                itemJson.put("location", Location.SOUTH_EAST);
                itemJson.put("question", "Una volta avvicinato al tavolo, il vecchio ti chiama.\n"
                                + "\"Bentornato giovane. Ti va di giocare?\n"
                                + "Le regole le conosci. Adesso la brocca da 16 decilitri è piena,\n"
                                + "e quelle da 9 e 7 decilitri sono vuote.\n"
                                + "Devi versare il vino tra le brocche in modo che\n"
                                + "le brocche da 16 e 9 decilitri abbiano entrambe 8 decilitri di vino.\n"
                                + "Naturalmente, puoi solo versare il vino da una\n"
                                + "brocca a un'altra finché la seconda non è piena.\n"
                                + "Non provare a improvvisare una misura.\n"
                                + "Accetti?\"\n");
                itemJson.put("isSingleAnswer", true);
                itemJson.put("answer", "");
                itemJson.put("correctReply", "\"Ben fatto ragazzo\n"
                                + "A te il tuo premio.\"\n"
                                + "Il vecchio ti consegna una balestra, e rimette il vino nella brocca iniziale.\n"
                                + "Saluti il vecchio e ti allontani.\n");
                itemJson.put("incorrectReply", "");
                itemJson.put("tryAgainReply", "");
                itemJson.put("surrenderReply", "\"Nessun problema. A presto, ragazzo.\"\n"
                                + "Saluti il vecchio e ti allontani.\n");
                itemJson.put("rewardId", Loader.loadWeapon("balestra").getId());
                /*
                 * (int eventId, String name, String presentation, Location location,
                 * String question, String answer, boolean isSingleAnswer,
                 * String correctReply, String incorrectReply, String tryAgainReply, String
                 * surrenderReply,
                 * Item reward)
                 */

                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                                        + itemJson.get("name") + "\\" + itemJson.get("name") + ".json");
                        file.write(itemJson.toString());
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                JSONObject jugObject = new JSONObject();
                jugObject.put("jugContent", 16);
                jugObject.put("jugCapacity", 16);

                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                                        + itemJson.get("name") + "\\jug1.json");
                        file.write(jugObject.toString());
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                jugObject = new JSONObject();
                jugObject.put("jugContent", 0);
                jugObject.put("jugCapacity", 9);

                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                                        + itemJson.get("name") + "\\jug2.json");
                        file.write(jugObject.toString());
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                jugObject = new JSONObject();
                jugObject.put("jugContent", 0);
                jugObject.put("jugCapacity", 7);

                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                                        + itemJson.get("name") + "\\jug3.json");
                        file.write(jugObject.toString());
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                jugObject = new JSONObject();
                jugObject.put("jugContent", 8);
                jugObject.put("jugCapacity", 16);

                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                                        + itemJson.get("name") + "\\correctJug1.json");
                        file.write(jugObject.toString());
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                jugObject = new JSONObject();
                jugObject.put("jugContent", 8);
                jugObject.put("jugCapacity", 9);

                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                                        + itemJson.get("name") + "\\correctJug2.json");
                        file.write(jugObject.toString());
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                jugObject = new JSONObject();
                jugObject.put("jugContent", 0);
                jugObject.put("jugCapacity", 7);

                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                                        + itemJson.get("name") + "\\correctJug3.json");
                        file.write(jugObject.toString());
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                JugPuzzle vP2 = Loader.loadJugPuzzle(itemJson.get("name").toString());
                System.out.println(vP2.getEventId());
                System.out.println(vP2.getName());
                System.out.println(vP2.getPresentation());
                System.out.println(vP2.getLocation());
                System.out.println(vP2.getQuestion());
                System.out.println(vP2.getAnswer());
                System.out.println(vP2.isSingleAnswer());
                System.out.println(vP2.getCorrectReply());
                System.out.println(vP2.getIncorrectReply());
                System.out.println(vP2.getTryAgainReply());
                System.out.println(vP2.getSurrenderReply());
                System.out.println(vP2.getRewardId());
        }

        public static void addDanger() {
                JSONObject itemJson = new JSONObject();
                itemJson.put("name", "Incendio");
                itemJson.put("eventId", 2101);
                itemJson.put("presentation", "Ti dirigi verso il centro della stanza\n"
                                + "quando all'improvviso un muro di fiamme ti avvolge!\n"
                                + "La stanza era una trappola! Presto, pensa a un modo per spegnere l'incendio");
                Map<Integer, String> countdown = new HashMap<Integer, String>();
                countdown.put(1, "Le fiamme si continuano ad alzare.\n");
                countdown.put(2, "Un pilastro comincia a vacillare!\n");
                countdown.put(3, "Il pilastro crolla, e per un pelo riesci a schivarlo.\n");
                countdown.put(4, "Il calore diventa insostenibile...");
                countdown.put(5, "Non c'è via di scampo... Intossicato dal fumo, svieni..\n");
                itemJson.put("countdown", countdown);
                itemJson.put("timeLimit", 75000);
                itemJson.put("solution", Loader.loadItem("acqua").getId());
                itemJson.put("prize", Loader.loadItem("armatura").getId());

                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\dangers\\"
                                                        + itemJson.get("name") + ".json");
                        file.write(itemJson.toString());
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                Danger danger = Loader.loadDanger(itemJson.get("name").toString());
                System.out.println(danger.getEventId());
                System.out.println(danger.getName());
                System.out.println(danger.getPresentation());
                System.out.println(danger.getCountdown());
                System.out.println(danger.getTimeLimit());
                System.out.println(danger.getSolution());
                System.out.println(danger.getPrize());

        }

        public static void addItem(String element) {

                FileReader reader = null;
                try {
                        reader = new FileReader(
                                        new File("forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\items\\"
                                                        + element
                                                        + ".json"));
                } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                }
                Item item = new Gson().fromJson(reader, Item.class);

                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\items\\"
                                                        + item.getName() + ".json");
                        file.write(new Gson().toJson(item));
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        System.out.println("Error while writing item JSON");
                }

        }
}
