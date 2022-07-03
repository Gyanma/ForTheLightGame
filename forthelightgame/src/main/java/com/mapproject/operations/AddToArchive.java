package com.mapproject.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.mapproject.enums.Location;
import com.mapproject.resources.events.TextPuzzle;
import com.mapproject.resources.items.Item;

public class AddToArchive {

        public static void addTextPuzzle() {

                TextPuzzle vP;
                JSONObject itemJson = new JSONObject();

                itemJson.put("name", "Carte da gioco");
                itemJson.put("presentation",
                                "Nell'angolo della stanza noti un'ombra che si agita. Ti avvicini e vedi un goblin dietro a un carretto.\n"
                                                + "Appena il goblin ti nota, inizia a urlare: \"Venghino, signori, venghino. Tutti possono giocare,\n "
                                                + "ma solo i pi\u00f9 furbi possono vincere.\"");
                itemJson.put("eventId", 2201);
                itemJson.put("isSkippable", true);
                itemJson.put("location", Location.NORTH_WEST);
                itemJson.put("question", "Il goblin si aggiusta il monocolo e comincia a spiegare le regole.\n"
                                + "\"Come pu\u00f2 vedere ho posizionato cinque carte da gioco coperte di fronte a me. \n"
                                + "Se vossignoria ha cuore di credermi, le posso garantire che sono 4 assi di semi diversi E un jolly.\n"
                                + "Ora, se usando le quattro regole che vedete accanto a voi riuscirete a indovinare \n"
                                + "quale carta sta dove, avrete vinto il premio segreto!\n"
                                + "Vi baster\u00e0 dirmele in ordine, da sinistra a destra.\"\n"
                                + "Dai un'occhiata alle regole, che recitano:\n"
                                + "1. I fiori sono immediatamente a destra dei cuori.\n"
                                + "2. Le picche non sono vicine al jolly o ai quadri.\n"
                                + "3. I fiori non sono vicini ai quadri o al jolly.\n"
                                + "4. I cuori non sono vicini ai quadri o alle picche.\n");
                itemJson.put("isSingleAnswer", false);
                itemJson.put("answer", "Quadri+Jolly+Cuori+Fiori+Picche");
                itemJson.put("correctReply", "Il goblin salta sul tavolo, costringedoti a indietreggiare\n"
                                + "\"Ben fatto! A voi il vostro premio!\"\n"
                                + "Il goblin ti porge una fiala a forma di saetta con un liquido semitrasparente dentro.\n"
                                + "Rialzi lo sguardo e sia il goblin sia il carretto sono spariti...\n");
                itemJson.put("incorrectReply", "\"Oh che peccato, forse non siete cos\u00ec sveglio come pensavo.\"\n"
                                + "Il goblin scopre le carte, e per un breve secondo riesci a intravedere le figure:\n"
                                + "i Quadri, poi il Jolly, i Cuori, i Fiori e infine le Picche...\n"
                                + "Ma in men che non si dica il goblin lancia un fumogeno a terra.\n"
                                + "Ti copri gli occhi e il naso e ti alliontani dalla nuvola. \n"
                                + "Dopo che il fumo si dissipa, noti che sia il goblin sia il carretto sono spariti...\n");
                itemJson.put("tryAgainReply", "\"Questa risposta \u00e8 sbagliata. Ma non si disperi!\n"
                                + "Ha ancora un'altra possibilit\u00e0\"\n");
                itemJson.put("surrenderReply", "\"Vuole arrendersi? Davvero?\n"
                                + "Che peccato. Sar\u00e0 per un'altra volta\"\n"
                                + "Il goblin fa un gesto con la mano e in un'istante sia lui che il carretto non si vedono pi\u00f9");
                itemJson.put("reward", Loader.loadItem("pozione del fulmine").getId());

                /*
                 * (int eventId, String name, String presentation, Location location,
                 * String question, String answer, boolean isSingleAnswer,
                 * String correctReply, String incorrectReply, String tryAgainReply, String
                 * surrenderReply,
                 * Item reward)
                 */
                vP = new TextPuzzle(
                                (int) itemJson.get("eventId"),
                                (String) itemJson.get("name"),
                                (String) itemJson.get("presentation"),
                                (Location) itemJson.get("location"),
                                (String) itemJson.get("question"),
                                (String) itemJson.get("answer"),
                                (boolean) itemJson.get("isSingleAnswer"),
                                (String) itemJson.get("correctReply"),
                                (String) itemJson.get("incorrectReply"),
                                (String) itemJson.get("tryAgainReply"),
                                (String) itemJson.get("surrenderReply"),
                                (int) itemJson.get("reward"));

                System.out.println(vP.getEventId());
                System.out.println(vP.getName());
                System.out.println(vP.getPresentation());
                System.out.println(vP.getLocation());
                System.out.println(vP.getQuestion());

                try {
                        FileWriter file = new FileWriter(
                                        "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\"
                                                        + itemJson.get("name") + ".json");
                        file.write(itemJson.toString());
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        System.out.println("Error while writing item JSON");
                }

                TextPuzzle vP2 = Loader.loadTextPuzzle(itemJson.get("name").toString());
                System.out.println(vP2.getEventId());
                System.out.println(vP2.getName());
                System.out.println(vP2.getPresentation());
                System.out.println(vP2.getLocation());
                System.out.println(vP2.getQuestion());
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
