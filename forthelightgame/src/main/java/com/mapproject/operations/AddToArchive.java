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

                itemJson.put("name", "500 perle");
                itemJson.put("presentation",
                                "Vedi un avventuriero parecchio affaccendato. Sembra esaminare un forziere.\n");
                itemJson.put("eventId", 2203);
                itemJson.put("isSkippable", true);
                itemJson.put("location", Location.NORTH_EAST);
                itemJson.put("question", "L'avventuriero ti nota e immediatamente ti rivolge la parola\n"
                                + "\"Oh, che gioia incontrare un altro viaggiatore. Guarda, questo \u00e8\n"
                                + "il forziere incantato di Adhara. Sul muro \u00e8 inciso un messaggio, ma non riesco a decifrarlo.\n"
                                + "Hai tu forse idea di cosa ci sa scritto?\"\n"
                                + "In effetti, riesci a leggere la scritta, cos\u00ec la traduci al viaggiatore.\n"
                                + "\"Questo forziere contiene 500 perle. Chiunque voglia prenderle, \u00e8 libero di farlo.\n"
                                + "Ma se il numero di perle prese \u00e8 diverso dal numero preferito del leggendario\n"
                                + "Adhara, le perle torneranno nel forziere in men che non si dica, e chiunque\n"
                                + "le abbia toccate subir\u00e0 un terribile sortilegio.\n"
                                + "Adhara \u00e8 sempre stato un'anima generosa. Ogni volta che tornava da una spedizione,\n"
                                + "divideva i suoi ritrovamenti con tutti gli altri abitanti del suo villaggio.\n"
                                + "In particolare, teneva sempre da parte uno solo di qualsiasi oggetto ritrovava\n"
                                + "e poi divideva equamente il resto. E quando tornava con il suo numero preferito di perle,\n"
                                + "non importava quante persone si trovava davanti; due, tre, quattro, cinque,\n"
                                + "sei o sette, riusciva sempre a dividerle senza fare danno a nessuno.\"\n"
                                + "Una volta concluso, l'avventuriero riprende a parlare.\n"
                                + "\"Ora \u00e8 tutto chiaro. Basta trovare questo numero speciale e le perle saranno nostre!\n"
                                + "Pensiamoci su. Quando hai qualche idea avvisami. Ma pensaci bene!\n"
                                + "Con quella maledizione non possiamo permetterci errori.\"\n"
                                + "Ebbene? Quante perle vuoi prendere?\n");
                itemJson.put("isSingleAnswer", true);
                itemJson.put("answer", "421");
                itemJson.put("correctReply", "\"Ma certo. Tutto torna!\"\n"
                                + "Insieme all'avventuriero, raccogli 421 perle dal baule.\n"
                                + "Dopo aver atteso qualche minuto, la stanza inizia a tremare.\n"
                                + "Dal baule fuoriesce una luce intensa, che vi toglie la vista.\n"
                                + "D'un tratto, la luce si interrompe. Il baule \u00e8 scomparso, e una nuova incisione ha sostituito\n"
                                + "la precedente sul muro. \"Ben fatto. Le perle sono vostre. Fatene buon uso e ricordate\n"
                                + "le gesta del grande Adhara.\"\n"
                                + "\"Senza di te non sarei mai riuscito a prendere le perle. Per ringraziarti, ti lascer\u00f2\n"
                                + "la parte pi\u00f9 grande.\" L'avventuriero prende 150 perle e le mette nella sua bisaccia.\n"
                                + "\"Bene, ho preso la mia parte. A presto, e ancora grazie!\" aggiunge, per poi allontanarsi nell'oscurit\u00e0\n"
                                + "Prendi le tue perle, le infili nella tua borsa e ti guardi nuovamente intorno.\n");
                itemJson.put("incorrectReply", "");
                itemJson.put("tryAgainReply", "\"Dici? No, non mi convince.\" ti risponde l'avventuriero\n"
                                + "\"Riflettiamo ancora, prima di fare mosse avventate\"");
                itemJson.put("surrenderReply", "\"Oh, d'accordo; se vuoi allontanarti non ti fermer\u00f2\n"
                                + "Grazie ancora per l'aiuto, non lo dimenticher\u00f2!\"\n");
                itemJson.put("reward", Loader.loadItem("Sacca di perle").getId());

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
