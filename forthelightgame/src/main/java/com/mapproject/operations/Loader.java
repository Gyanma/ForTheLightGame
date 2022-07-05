package com.mapproject.operations;

import com.mapproject.resources.events.Danger;
import com.mapproject.resources.events.Enemy;
import com.mapproject.resources.events.PacificEncounter;
import com.mapproject.resources.events.TextPuzzle;
import com.mapproject.resources.events.VisualPuzzle;
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

    public static JugPuzzle loadJugPuzzle(int i) {
        return loadJugPuzzle(recognizeElement(i));
    }

    public static JugPuzzle loadJugPuzzle(String element) {

        try {
            FileReader reader = new FileReader(
                    new File(
                            "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\text puzzles\\jug puzzles\\"
                                    + element + ".json"));
            JugPuzzle jugPuzzle = new Gson().fromJson(reader, JugPuzzle.class);
            return jugPuzzle;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
        // TODO return strings
        switch (i / 1000) {// check the first digit to get if it's event or item
            case 1: // it's an item

                i = i % 1000;
                switch (i / 100) {// check the second digit to get if it's weapon or item

                    case 1: // it's a weapon

                        i = i % 100;
                        switch (i) {
                            case 1:
                                return "spada";
                            case 2:
                                return "ascia";
                            case 3:
                                return "pugnale";
                            case 4:
                                return "katana";
                            case 5:
                                return "maglio";
                            case 6:
                                return "arco";
                            case 7:
                                return "lancia";
                            case 8:
                                return "fionda";
                            case 9:
                                return "balestra";
                            case 10:
                                return "shuriken";
                            default:
                                return "";
                        }

                    case 2: // it's an item
                        i = i % 100;
                        switch (i) {
                            case 1:
                                return "fune";
                            default:
                                return "";
                        }
                    default:
                        return "";
                }

            case 2: // it's an event

                i = i % 1000;
                switch (i / 100) { // check the second digit to get the type of event

                    case 1: // it's a danger event
                        i = i % 100;
                        switch (i) {
                            case 1:
                                return "Incendio";
                            default:
                                return "";
                        }
                    case 2: // it's a TextPuzzle event
                        i = i % 100;
                        switch (i) {
                            case 1:
                                return "TextPuzzle";
                            default:
                                return "";
                        }
                    case 3: // it's a VisualPuzzle event
                        i = i % 100;
                        switch (i) {
                            case 1:
                                return "VisualPuzzle";
                            default:
                                return "";
                        }
                    case 4: // it's an Enemy event
                        i = i % 100;

                        switch (i / 50) { // check if it's a normal evemy or a boss

                            case 1: // it's a normal enemy
                                i = i % 50;
                                switch (i) {
                                    case 1:
                                        return "Enemy";
                                    default:
                                        return "";
                                }
                            case 2: // it's a boss
                                i = i % 50;
                                switch (i) {
                                    case 1:
                                        return "Boss";
                                    default:
                                        return "";
                                }
                        }
                    case 5: // it's a Pacific event
                        i = i % 100;
                        switch (i) {
                            case 1:
                                return "Pacific";
                            default:
                                return "";
                        }
                }
            default:
                return "";
        }
    }
}
