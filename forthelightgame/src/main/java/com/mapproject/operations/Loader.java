package com.mapproject.operations;

import com.mapproject.resources.events.Danger;
import com.mapproject.resources.events.Enemy;
import com.mapproject.resources.events.PacificEncounter;
import com.mapproject.resources.events.TextPuzzle;
import com.mapproject.resources.events.VisualPuzzle;
import com.mapproject.resources.events.JugPuzzle.Jug;
import com.mapproject.resources.events.JugPuzzle.JugSet;
import com.mapproject.resources.events.JugPuzzle;
import com.mapproject.resources.items.Item;
import com.mapproject.resources.items.Weapon;
import com.google.gson.Gson;
import java.io.IOException;

import java.io.File;
import java.io.FileReader;

public class Loader {
    public static Weapon loadWeapon(String element) {

        try {
            FileReader reader = new FileReader(
                    new File("forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\weapons\\"
                            + element + ".json"));
            Weapon weapon = new Gson().fromJson(reader, Weapon.class);
            return weapon;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Weapon loadWeapon(int i) {
        return loadWeapon(recognizeElement(i));
    }

    public static Enemy loadEnemy(String element) {

        try {
            FileReader reader = new FileReader(
                    new File("forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\enemies\\"
                            + element + ".json"));
            Enemy enemy = new Gson().fromJson(reader, Enemy.class);
            return enemy;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Enemy loadEnemy(int i) {
        return loadEnemy(recognizeElement(i));
    }

    public static TextPuzzle loadTextPuzzle(String element) {

        try {
            FileReader reader = new FileReader(
                    new File("forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\"
                            + element + ".json"));
            TextPuzzle textPuzzle = new Gson().fromJson(reader, TextPuzzle.class);
            return textPuzzle;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static TextPuzzle loadTextPuzzle(int i) {
        return loadTextPuzzle(recognizeElement(i));
    }

    public static JugPuzzle loadJugPuzzle(String element) {

        try {

            JugPuzzle jugPuzzle = new Gson().fromJson(new FileReader(
                    new File(
                            "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                    + element + "\\" + element + ".json")),
                    JugPuzzle.class);

            Jug jug1 = new Gson().fromJson(new FileReader(
                    new File(
                            "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                    + element + "\\jug1.json")),
                    Jug.class);

            Jug jug2 = new Gson().fromJson(new FileReader(
                    new File(
                            "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                    + element + "\\jug2.json")),
                    Jug.class);

            Jug jug3 = new Gson().fromJson(new FileReader(
                    new File(
                            "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                    + element + "\\jug3.json")),
                    Jug.class);

            jugPuzzle.setPlayerJugSet(new JugSet(jug1, jug2, jug3));

            Jug correctJug1 = new Gson().fromJson(new FileReader(
                    new File(
                            "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                    + element + "\\correctJug1.json")),
                    Jug.class);

            Jug correctJug2 = new Gson().fromJson(new FileReader(
                    new File(
                            "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                    + element + "\\correctJug2.json")),
                    Jug.class);

            Jug correctJug3 = new Gson().fromJson(new FileReader(
                    new File(
                            "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                    + element + "\\correctJug3.json")),
                    Jug.class);

            jugPuzzle.setCorrectJugSet(new JugSet(correctJug1, correctJug2, correctJug3));
            return jugPuzzle;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JugPuzzle loadJugPuzzle(int i) {
        return loadJugPuzzle(recognizeElement(i));
    }

    public static Danger loadDanger(String element) {

        try {
            FileReader reader = new FileReader(
                    new File("forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\dangers\\"
                            + element + ".json"));
            Danger danger = new Gson().fromJson(reader, Danger.class);
            return danger;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Danger loadDanger(int i) {
        return loadDanger(recognizeElement(i));
    }

    public static VisualPuzzle loadVisualPuzzle(String element) {

        try {
            FileReader reader = new FileReader(
                    new File("forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\visual puzzles\\"
                            + element + ".json"));
            VisualPuzzle visualPuzzle = new Gson().fromJson(reader, VisualPuzzle.class);
            return visualPuzzle;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static VisualPuzzle loadVisualPuzzle(int i) {
        return loadVisualPuzzle(recognizeElement(i));
    }

    public static PacificEncounter loadPacificEncounter(String element) {

        try {
            FileReader reader = new FileReader(new File(
                    "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\pacific encounters\\"
                            + element + ".json"));
            PacificEncounter pacificEncounter = new Gson().fromJson(reader, PacificEncounter.class);
            return pacificEncounter;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PacificEncounter loadPacificEncounter(int i) {
        return loadPacificEncounter(recognizeElement(i));
    }

    public static Item loadItem(String element) {

        try {
            FileReader reader = new FileReader(
                    new File("forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\items\\" + element
                            + ".json"));
            Item item = new Gson().fromJson(reader, Item.class);
            return item;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Item loadItem(int i) {
        return loadItem(recognizeElement(i));
    }

    private static String recognizeElement(int i) {
        switch (i / 100) {// check the first digit to get if it's event or item
            case 10:// it's an item
                switch (i % 100) {
                    case 0:
                        return "mappa";
                    case 1:
                        return "fune";
                    case 2:
                        return "cibo";
                    case 3:
                        return "acqua";
                    case 4:
                        return "vanga";
                    case 5:
                        return "sacca";
                    case 6:
                        return "torcia";
                    case 7:
                        return "acchiappasogni";
                    case 8:
                        return "pitture di guerra";
                    case 9:
                        return "monocolo del cacciatore";
                    case 10:
                        return "calzari magici";
                    case 11:
                        return "libro della forza";
                    case 12:
                        return "libro dell'agilità";
                    case 13:
                        return "libro della destrezza";
                    case 14:
                        return "libro delle maledizioni";
                    case 15:
                        return "bomba fumogena";
                    case 16:
                        return "armatura";
                    case 17:
                        return "fiala del sangue";
                    case 18:
                        return "affilatore";
                    case 19:
                        return "punta in titanio";
                    case 20:
                        return "sacca di perle";
                    case 21:
                        return "pozione di cura";
                    case 22:
                        return "pozione del fuoco";
                    case 23:
                        return "pozione del fulmine";
                    case 24:
                        return "pozione del gelo";
                    case 25:
                        return "pozione del veleno";
                    case 26:
                        return "libro mastro";
                    case 27:
                        return "bestiario";
                    case 28:
                        return "mappa mistica";
                    case 29:
                        return "sacca di diamanti";
                    default:
                        return "";
                }
            case 11:// it's a weapon
                switch (i % 100) {
                    case 1:
                        return "spada";
                    case 2:
                        return "ascia";
                    case 3:
                        return "pugnale";
                    case 4:
                        return "arco";
                    case 5:
                        return "lancia";
                    case 6:
                        return "fionda";
                    case 7:
                        return "katana";
                    case 8:
                        return "maglio";
                    case 9:
                        return "balestra";
                    case 10:
                        return "shuriken";
                    default:
                        return "";
                }
            case 21:// it's a danger
                i = i % 100;
                switch (i % 100) {
                    case 1:
                        return "incendio";
                    case 2:
                        return "stanza allagata";
                    case 3:
                        return "spettri";
                    case 4:
                        return "animali aggressivi";
                    default:
                        return "";
                }
            case 22: // it's a text puzzle
                i = i % 100;
                switch (i % 100) {
                    case 1:
                        return "carte da gioco";
                    case 2:
                        return "bottino da pirati";
                    case 3:
                        return "500 perle";
                    case 4:
                        return "i centauri";
                    case 5:
                        return "brocche di acqua";
                    case 6:
                        return "la spedizione";
                    case 7:
                        return "il premio";
                    case 8:
                        return "fila di mattoni";
                    case 9:
                        return "inscatolamento";
                    case 10:
                        return "il ciondolo rubato";
                    case 11:
                        return "i sospettati";
                    case 12:
                        return "brocche di latte";
                    case 13:
                        return "il furto";
                    case 14:
                        return "brocche di vino";
                    default:
                        return "";
                }
            case 23: // it's a visual puzzle
                i = i % 100;
                switch (i % 100) {
                    case 1:
                        return "33333!";
                    case 2:
                        return "combinazione criptica";
                    case 3:
                        return "gli zeri";
                    default:
                        return "";
                }
            case 24: // it's an enemy
                i = i % 100;
                switch (i % 100) {
                    case 1:
                        return "lupo mannaro";
                    case 2:
                        return "draghetto";
                    case 3:
                        return "melma";
                    case 4:
                        return "gargoyle";
                    case 51:
                        return "idra";
                    case 52:
                        return "guardiano alato";
                    case 53:
                        return "cerbero";
                    default:
                        return "";
                }
            case 25: // it's a pacific encounter
                i = i % 100;
                switch (i % 100) {
                    case 1:
                        return "bibilioteca segreta";
                    case 2:
                        return "esploratore";
                    case 3:
                        return "venditore di pozioni";
                    case 4:
                        return "fontana divina";
                    default:
                        return "";
                }
            default:
                return "";
        }
    }
}
