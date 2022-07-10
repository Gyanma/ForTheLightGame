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
import com.mapproject.resources.events.Enemy;
import com.mapproject.resources.events.JugPuzzle;
import com.mapproject.resources.events.PacificEncounter;
import com.mapproject.resources.items.Item;

public class AddToArchive {

        public static void addMap() {
                Map<String, List<String>> map = new HashMap<String, List<String>>();
                List<String> list = new ArrayList<String>();
                list.add("l'acchiappasogni");
                list.add("un acchiappasogni");
                map.put("Acchiappasogni", list);
                list = new ArrayList<String>();
                list.add("l'otre");
                list.add("un otre");
                list.add("l'acqua");
                list.add("dell'acqua");
                list.add("il fiasco");
                list.add("un fiasco");
                list.add("la borraccia");
                list.add("una borraccia");
                map.put("Acqua", list);
                list = new ArrayList<String>();
                list = new ArrayList<String>();
                list.add("l'affilatore");
                list.add("un affilatore");
                map.put("Affilatore", list);
                list = new ArrayList<String>();
                list.add("l'armatura");
                list.add("un armatura");
                map.put("Armatura", list);
                list = new ArrayList<String>();
                list.add("il bestiario");
                map.put("Bestiario", list);
                list = new ArrayList<String>();
                list.add("la bomba fumogena");
                list.add("una bomba fumogena");
                list.add("il fumogeno");
                list.add("un fumogeno");
                map.put("Bomba fumogena", list);
                list = new ArrayList<String>();
                list.add("i calzari magici");
                list.add("dei calzari magici");
                list.add("i calzari");
                list.add("dei calzari");
                list.add("gli stivali magici");
                list.add("degli stivali magici");
                list.add("gli stivali");
                list.add("degli stivali");
                list.add("le scarpe magiche");
                list.add("delle scarpe magiche");
                list.add("le scarpe");
                list.add("delle scarpe");
                map.put("Calzari magici", list);
                list = new ArrayList<String>();
                list.add("il cibo");
                list.add("del cibo");
                list.add("il pane");
                list.add("del pane");
                list.add("la pagnotta");
                list.add("una pagnotta");
                list.add("un tozzo di pane");
                list.add("il tozzo di pane");
                map.put("Cibo", list);
                list = new ArrayList<String>();
                list.add("la fiala");
                list.add("una fiala");
                list.add("la fiala del sangue");
                list.add("una fiala del sangue");
                map.put("Fiala del sangue", list);
                list = new ArrayList<String>();
                list.add("la fune");
                list.add("una fune");
                list.add("la corda");
                list.add("una corda");
                list.add("il lazo");
                list.add("un lazo");
                map.put("Fune", list);
                list = new ArrayList<String>();
                list.add("il libro dell'agilità");
                list.add("un libro dell'agilità");
                list.add("il manuale dell'agilità");
                list.add("un manuale dell'agilità");
                list.add("il tomo dell'agilità");
                list.add("un tomo dell'agilità");
                map.put("Libro dell'agilità", list);
                list = new ArrayList<String>();
                list.add("il libro della destrezza");
                list.add("un libro della destrezza");
                list.add("il manuale della destrezza");
                list.add("un manuale della destrezza");
                list.add("il tomo della destrezza");
                list.add("un tomo della destrezza");
                map.put("Libro della destrezza", list);
                list = new ArrayList<String>();
                list.add("il libro delle maledizioni");
                list.add("un libro delle maledizioni");
                list.add("il manuale delle maledizioni");
                list.add("un manuale delle maledizioni");
                list.add("il tomo delle maledizioni");
                list.add("un tomo delle maledizioni");
                map.put("Libro delle maledizioni", list);
                list = new ArrayList<String>();
                list.add("il libro mastro");
                list.add("un libro mastro");
                map.put("Libro mastro", list);
                list = new ArrayList<String>();
                list.add("la mappa mistica");
                list.add("una mappa mistica");
                list.add("la mappa");
                list.add("una mappa");
                map.put("Mappa mistica", list);
                list = new ArrayList<String>();
                list.add("la mappa");
                list.add("una mappa");
                map.put("Mappa", list);
                list = new ArrayList<String>();
                list.add("il monocolo del cacciatore");
                list.add("un monocolo del cacciatore");
                list.add("il monocolo");
                list.add("un monocolo");
                list.add("la lente del cacciatore");
                list.add("una lente del cacciatore");
                list.add("la lente");
                list.add("una lente");
                map.put("Monocolo del cacciatore", list);
                list = new ArrayList<String>();
                list.add("le pitture di guerra");
                list.add("delle pitture di guerra");
                list.add("le pitture");
                list.add("delle pitture");
                map.put("Pitture di guerra", list);
                list = new ArrayList<String>();
                list.add("la pozione del fulmine");
                list.add("una pozione del fulmine");
                list.add("la pozione");
                list.add("una pozione");
                map.put("Pozione del fulmine", list);
                list = new ArrayList<String>();
                list.add("la pozione di cura");
                list.add("una pozione di cura");
                list.add("la pozione");
                list.add("una pozione");
                map.put("Pozione di cura", list);
                list = new ArrayList<String>();
                list.add("la pozione del gelo");
                list.add("una pozione del gelo");
                list.add("la pozione");
                list.add("una pozione");
                map.put("Pozione del gelo", list);
                list = new ArrayList<String>();
                list.add("la pozione del veleno");
                list.add("una pozione del veleno");
                list.add("la pozione");
                list.add("una pozione");
                map.put("Pozione del veleno", list);
                list = new ArrayList<String>();
                list.add("la pozione del fuoco");
                list.add("una pozione del fuoco");
                list.add("la pozione");
                list.add("una pozione");
                map.put("Pozione del fuoco", list);
                list = new ArrayList<String>();
                list.add("la sacca di perle");
                list.add("una sacca di perle");
                list.add("le perle");
                list.add("delle perle");
                map.put("Sacca di perle", list);
                list = new ArrayList<String>();
                list.add("la sacca di diamanti");
                list.add("una sacca di diamanti");
                list.add("i diamanti");
                list.add("dei diamanti");
                map.put("Sacca di diamanti", list);
                list = new ArrayList<String>();
                list.add("la sacca");
                list.add("una sacca");
                list.add("la borsa");
                list.add("una borsa");
                list.add("la bisaccia");
                list.add("una bisaccia");
                map.put("Sacca", list);
                list = new ArrayList<String>();
                list.add("la punta in titanio");
                list.add("una punta in titanio");
                list.add("la punta");
                list.add("una punta");
                map.put("Punta in titanio", list);

                list = new ArrayList<String>();
                list.add("la vanga");
                list.add("una vanga");
                list.add("la pala");
                list.add("una pala");
                map.put("Vanga", list);

                list = new ArrayList<String>();
                list.add("la torcia");
                list.add("una torcia");
                list.add("la fiaccola");
                list.add("una fiaccola");
                map.put("Torcia", list);

                list = new ArrayList<String>();
                list.add("l'ascia");
                list.add("un'ascia");
                list.add("l'accetta");
                list.add("un'accetta");
                list.add("la scure");
                list.add("una scure");
                map.put("Ascia", list);

                list = new ArrayList<String>();
                list.add("l'arco");
                list.add("un arco");
                map.put("Arco", list);

                list = new ArrayList<String>();
                list.add("la katana");
                list.add("una katana");
                list.add("la spada");
                list.add("una spada");
                map.put("Katana", list);

                list = new ArrayList<String>();
                list.add("la fionda");
                list.add("una fionda");
                map.put("Fionda", list);
                list = new ArrayList<String>();
                list.add("la balestra");
                list.add("una balestra");
                map.put("Balestra", list);

                list = new ArrayList<String>();
                list.add("il pugnale");
                list.add("un pugnale");
                list.add("il coltello");
                list.add("un coltello");
                map.put("Pugnale", list);

                list = new ArrayList<String>();
                list.add("il maglio");
                list.add("un maglio");
                list.add("il martello");
                list.add("un martello");
                map.put("Maglio", list);
                list = new ArrayList<String>();
                list.add("la lancia");
                list.add("una lancia");
                list.add("l'asta");
                list.add("un'asta");
                list.add("il giavellotto");
                list.add("un giavellotto");
                map.put("Lancia", list);
                list = new ArrayList<String>();
                list.add("gli shuriken");
                list.add("degli shuriken");
                map.put("Shuriken", list);

                list = new ArrayList<String>();
                list.add("la spada");
                list.add("una spada");
                list.add("la lama");
                list.add("una lama");
                map.put("Spada", list);

                Gson gson = new Gson();
                String json = gson.toJson(map);
                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\dictionary.json");
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
                System.out.println(vP2.isSkippable());
                System.out.println(vP2.getDescription());
                System.out.println(vP2.getItemGivenResponse());
                System.out.println(vP2.getItemNotGivenResponse());
                System.out.println(vP2.getRequestedItemId());
                System.out.println(vP2.getGiftedItemId());

        }
}
