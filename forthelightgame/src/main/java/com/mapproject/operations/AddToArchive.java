package com.mapproject.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.mapproject.enums.Location;
import com.mapproject.resources.events.Enemy;
import com.mapproject.resources.events.JugPuzzle;
import com.mapproject.resources.events.PacificEncounter;
import com.mapproject.resources.items.Item;

public class AddToArchive {

        public static void addList() {
                List<String> list = new ArrayList<>();
                list.add("bestiario");
                list.add("affilatore");
                list.add("monocolo del cacciatore");
                list.add("libro");
                list.add("arco");
                list.add("maglio");
                list.add("pugnale");

                Gson gson = new Gson();
                String json = gson.toJson(list);
                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\StartsWithIl.json");
                        file.write(json);
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

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

        public static void addEnemy() {
                JSONObject itemJson = new JSONObject();
                itemJson.put("name", "Cerbero");
                itemJson.put("eventId", 2453);
                itemJson.put("presentation", "Al centro della stanza vedi una bestia gigantesca!\n"
                                + "Cerbero, il leggendario cane a tre teste, ti si para davanti.\n"
                                + "L'ultima battaglia del tuo viaggio sta per avere inizio!\n");
                itemJson.put("location", Location.EVERYWHERE);
                itemJson.put("isSkippable", true);

                Map<String, Map<String, Integer>> attacks = new HashMap<>();
                Map<String, Integer> attackStats = new HashMap<>();
                attackStats.put("damage", 40);
                attackStats.put("accuracy", 100);
                attackStats.put("specialEffect", 0);
                attacks.put("Morso Feroce", attackStats);
                attackStats = new HashMap<>();
                attackStats.put("damage", 0);
                attackStats.put("accuracy", 100);
                attackStats.put("specialEffect", 9);
                attacks.put("Ruggito Minaccioso", attackStats);
                attackStats = new HashMap<>();
                attackStats.put("damage", 60);
                attackStats.put("accuracy", 60);
                attackStats.put("specialEffect", 3);
                attacks.put("Palla di fuoco", attackStats);
                attackStats = new HashMap<>();
                attackStats.put("damage", 0);
                attackStats.put("accuracy", 100);
                attackStats.put("specialEffect", 10);
                attacks.put("Sensi acuti", attackStats);

                itemJson.put("attacks", attacks);

                itemJson.put("healthPoints", 150);
                itemJson.put("isFlying", false);
                itemJson.put("baseAttack", 2);
                itemJson.put("baseDefense", 2);

                itemJson.put("manualDescription", "Cerbero:\n"
                                + "Non è in grado di volare\n"
                                + "Punti salute: 10\n"
                                + "Attacchi:\n"
                                + "Morso Feroce: danno alto, nessun effetto speciale;\n"
                                + "Ruggito Minaccioso: nessun danno, ma riduce il prossimo danno dell'avversario;\n"
                                + "Palla di fuoco: danno molto alto, precisione ridotta, probabilità di infliggere bruciatura;\n"
                                + "Sensi acuti: nessun danno, salta il prossimo turno, e l'attacco successivo colpirà sicuramente;\n");
                /*
                 * private Map<String, List<Integer>> attacks;
                 * 
                 * private int healthPoints;
                 * private boolean isFlying;
                 * private int baseAttack;
                 * private int baseAgility;
                 * 
                 * private String manualDescription;
                 */

                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\enemies\\"
                                                        + itemJson.get("name") + ".json");
                        file.write(itemJson.toString());
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                Enemy danger = Loader.loadEnemy(itemJson.get("name").toString());
                System.out.println(danger.getEventId());
                System.out.println(danger.getName());
                System.out.println(danger.getPresentation());
                System.out.println(danger.isSkippable());
                System.out.println(danger.getLocation());
                System.out.println(danger.getHealthPoints());
                System.out.println(danger.isFlying());
                System.out.println(danger.getBaseAttack());
                System.out.println(danger.getBaseDefense());
                System.out.println(danger.getManualDescription());
                System.out.println(danger.getAttacks());

        }

        public static void addItem(String element) {

                FileReader reader = null;
                try {
                        reader = new FileReader(
                                        new File("forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\enemies\\"
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

        public static void addPacificEncounter() {
                JSONObject itemJson = new JSONObject();
                itemJson.put("name", "Fontana divina");
                itemJson.put("presentation",
                                "Nell'angolo della stanza vedi una fontana. Sembra essere un qualche luogo sacro...\n");
                itemJson.put("eventId", 2504);
                itemJson.put("isSkippable", true);
                itemJson.put("location", Location.SOUTH_WEST);
                itemJson.put("description", "Ti avvicini alla fontana.\n"
                                + "Accanto ad essa trovi un'incisione su una lastra\n"
                                + "\"La sacra fontana di Legrejoux fu costruita dai monaci del dio Sole molti secoli fa.\n"
                                + "Da tempo immemore concede grazie a chi si ferma per pregare il dio Sole.\n");
                itemJson.put("itemGivenResponse", "Decidi di fermarti a pregare vicino alla fontana...\n");
                itemJson.put("itemNotGivenResponse", "Abbandoni la fontana e continui per la tua strada...\n");
                List<Integer> itemIds = new ArrayList<>();
                itemIds.add(-1);
                itemJson.put("requestedItemId", itemIds);
                itemIds = new ArrayList<>();
                itemIds.add(-1);
                itemJson.put("giftedItemId", itemIds);

                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\pacific encounters\\"
                                                        + itemJson.get("name") + ".json");
                        file.write(itemJson.toString());
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                PacificEncounter vP2 = Loader.loadPacificEncounter(itemJson.get("name").toString());
                System.out.println(vP2.getEventId());
                System.out.println(vP2.getName());
                System.out.println(vP2.getPresentation());
                System.out.println(vP2.getLocation());
                System.out.println(vP2.isSkippable());
                System.out.println(vP2.getDescription());
                System.out.println(vP2.getItemGivenResponse());
                System.out.println(vP2.getItemNotGivenResponse());
                System.out.println(vP2.getRequestedItemId());
                System.out.println(vP2.getGiftedItemId());

        }
}
