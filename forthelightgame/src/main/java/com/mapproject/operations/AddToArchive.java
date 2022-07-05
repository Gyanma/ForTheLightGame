package com.mapproject.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.mapproject.enums.Location;

import com.mapproject.resources.events.TextPuzzle;
import com.mapproject.resources.events.JugPuzzle;
import com.mapproject.resources.items.Item;

public class AddToArchive {

        public static void addTextPuzzle() {

                JSONObject itemJson = new JSONObject();

                itemJson.put("name", "L'ascia rubata");
                itemJson.put("presentation", "Nella stanza si ergono tre oni, che stanno discutendo di fronte\n"
                                + "a cinque forzieri con diversi ornamenti.\n"
                                + "Sembrano tipi con cui è meglio non avere a che fare.\n"
                                + "A poca distanza, c'è un folletto che li osserva con furtività.\n");
                itemJson.put("eventId", 2210);
                itemJson.put("isSkippable", true);
                itemJson.put("location", Location.NORTH_WEST);
                itemJson.put("question", "Cercando di non attirare l'attenzione degli oni, ti avvicini al folletto\n"
                                + "e gli chiedi perché sta osservando gli oni.\n"
                                + "\"Quei bruti mi hanno rubato un ciondolo molto prezioso.\n"
                                + "Dicevano che sarebbe uno splendido ornamento per le loro asce.\n"
                                + "Li ho sentiti conversare prima, ma non ho potuto vedere i loro volti.\n"
                                + "Ho scoperto che hanno un modo molto particolare di lasciare il loro\n"
                                + "equipaggiamento nei forzieri.\n"
                                + "Uno di loro lascia lo scudo nel forziere dorato, l'ascia nel forziere di legno e l'arco nel forziere di pietra.\n"
                                + "Il secondo lascia l'arco nel forziere di pietra e il resto nel forziere di ferro.\n"
                                + "L'ultimo lascia lo scudo nel forziere di legno e il resto nel forziere d'avorio.\n"
                                + "Ora sto provando ad aspettare un momento propizio per riprendermi il ciondolo.\"\n"
                                + "Il folletto si interrompe e ti fa segno di rimanere in silenzio.\n"
                                + "Ascolti il discorso degli oni:\n"
                                + "\"Pronti allora? Tu vuoi davvero lasciare il tuo scudo?\"\n"
                                + "\"Sì, non mi servirà. Del resto anche tu stai lasciando la tua ascia e lui sta lasciando l'arco.\"\n"
                                + "\"D'accordo allora, andiamo\"\n"
                                + "Il folletto esclama: \"Guarda! I due oni con l'ascia non hanno ciondoli appesi all'ascia;\n"
                                + "il mio sarà sicuramente appeso all'ascia che hanno lasciato!\n"
                                + "Devo andare a recuperarlo!\"\n"
                                + "Insieme al folletto vi avvicinate ai forzieri. Per qualche motivo gli oni non si sono curati di chiuderli.\n"
                                + "\"Tu apri il forziere di pietra, io aprirò quello di legno.\"\n"
                                + "Esegui il comando, ma entrambe le casse sono vuote.\n"
                                + "Prima che possiate dirvi altro, sentite una voca tuonare.\n"
                                + "\"Va bene, vado a chiuderli io, ma sappi che toccava a te.\"\n"
                                + "\"Oh miseria, stanno tornando!\"\n"
                                + "Il tempo stringe, puoi aprire un solo forziere!\n"
                                + "Riesci a capire in che forziere si trova l'ascia con il ciondolo?\n");
                itemJson.put("isSingleAnswer", true);
                itemJson.put("answer", "forziere di ferro");
                itemJson.put("correctReply", "Ti lanci verso il forziere di ferro.\n"
                                + "Lo apri con tutta la forza che hai in corpo e\n"
                                + "dentro trovi proprio l'ascia con il ciondolo!\n"
                                + "Afferri il ciondolo e fai segno al folletto di svignarvela.\n"
                                + "Tornate al riparo e osservate l'oni chiudere i forzieri.\n"
                                + "Non sembra notare l'assenza del ciondolo.\n"
                                + "Una volta che si è allontanato per tornare dai suoi compagni, il folleto ti dice:\n"
                                + "\"Grazie infinite, senza la tua prontezza di riflessi non sarei mai riuscito a recuperarlo!\n"
                                + "Tieni questo, ti servirà nel tuo viaggio. A presto!\"\n"
                                + "Il folletto ti lascia una punta in titanio e vola via.\n");
                itemJson.put("incorrectReply", "Con gran fretta apri il forziere,\n"
                                + "ma sfortunatamente l'ascia non sembra essere lì.\n"
                                + "Il folletto ti incita: \"Non c'è tempo, torniamo al riparo!\"\n"
                                + "Vi nascondete in fretta e furia e osservate l'oni richiudere i forzieri.\n"
                                + "Dopo che l'oni lascia la stanza, il folletto ti dice:\n"
                                + "\"C'è mancato davvero poco. Dovrò aspettare che tornino.\n"
                                + "Grazie dell'aiuto, viandante. Almeno ho potuto scartare due forzieri.\n"
                                + "A presto e buona fortuna nelle tue avventure.\"\n"
                                + "Lasci il folletto alla sua vedetta.\n");
                itemJson.put("tryAgainReply", "");
                itemJson.put("surrenderReply", "");
                itemJson.put("rewardId", Loader.loadItem("punta in titanio").getId());
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
                                                        + itemJson.get("name") + ".json");
                        file.write(itemJson.toString());
                        file.flush();
                        file.close();
                } catch (Exception e) {
                        System.out.println("Error while writing item JSON");
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
