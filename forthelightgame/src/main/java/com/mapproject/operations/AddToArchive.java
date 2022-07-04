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

                itemJson.put("name", "Inscatolamento");
                itemJson.put("presentation", "C'è un elfo che guarda con insistenza due casse vuote...\n");
                itemJson.put("eventId", 2209);
                itemJson.put("isSkippable", true);
                itemJson.put("location", Location.NORTH_WEST);
                itemJson.put("question", "Quando approcci l'elfo, lui ti saluta con aria di superiorità \"Oh, salve.\n"
                                + "Stavo giusto cercando qualcuno con cui lamentarmi di quell'idiota del mio capo.\n"
                                + "Queste casse misurano 30 cm per ogni dimensione.\n"
                                + "Posso utilizzare una coppia di scatole per trasportare queste scatole\n"
                                + "che invece misurano 20x20x10.\n"
                                + "Anche un bambino vedrebbe che con due casse posso trasportare non più di 10 scatole\n"
                                + "e invece il mio capo dice che \"sono troppo poche\"!\n"
                                + "Come se ci fosse un modo per trasportarne di più che\n"
                                + "IO non sono riuscito a trovare. Bah\"\n"
                                + "Inizi a riflettere sulle parole dell'elfo... chissà se...\n"
                                + "L'elfo interrompe il tuo flusso di pensieri.\n"
                                + "Cosa ti turba? Pensi forse che abbia ragione lui?\n"
                                + "Sentiamo dunque, quante scatole riusciresti a trasportare?\"\n");
                itemJson.put("isSingleAnswer", true);
                itemJson.put("answer", "12");
                itemJson.put("correctReply", "Spieghi all'elfo come posizionare le scatole e le casse\n"
                                + "per trasportarne 12.\n"
                                + "L'elfo ti risponde:\"Tsk, certo. Lo sapevo anche io.\n"
                                + "Ora levati di mezzo. C'è del lavoro da fare qui.\"\n"
                                + "Mentre si allontana, dalla bisaccia dell'elfo casca un otre di acqua.\n"
                                + "Decidi di prenderlo, come... ringraziamento, e ti allontani.\n");
                itemJson.put("incorrectReply", "");
                itemJson.put("tryAgainReply",
                                "Spieghi la tua idea all'elfo, ma lui ti risponde in malo modo\n"
                                                + "Oh, che assurdità. Sapevo di non podermi affidare a te.\n");
                itemJson.put("surrenderReply", "\"Ecco. Ora spero che ti renda conto che ho ragione. Addio.\"\n"
                                + "Ti allontani dall'elfo prima di passare alla violenza.\n");
                itemJson.put("rewardId", Loader.loadItem("acqua").getId());
                // TODO Enigma dei clown + enigmi delle brocche
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
                                (int) itemJson.get("rewardId"));

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
                System.out.println(vP2.getAnswer());
                System.out.println(vP2.isSingleAnswer());
                System.out.println(vP2.getCorrectReply());
                System.out.println(vP2.getIncorrectReply());
                System.out.println(vP2.getTryAgainReply());
                System.out.println(vP2.getSurrenderReply());
                System.out.println(vP2.getRewardId());
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
