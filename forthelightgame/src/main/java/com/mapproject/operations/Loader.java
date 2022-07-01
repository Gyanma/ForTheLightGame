package com.mapproject.operations;

import com.mapproject.resources.events.Enemy;
import com.mapproject.resources.events.TextPuzzle;
import com.mapproject.resources.items.Weapon;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;

public class Loader {
    public static Weapon loadWeapon(String item) throws Exception {

        try {
            FileReader reader = new FileReader(new File("src/resources/" + item + ".json"));
            Weapon weapon = new Gson().fromJson(reader, Weapon.class);
            return weapon;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Weapon loadWeapon(int i) throws Exception {
        return loadWeapon(recognizeElement(i));
    }

    public static Enemy loadEnemy(String item) throws Exception {

        try {
            FileReader reader = new FileReader(new File("src/resources/" + item + ".json"));
            Enemy enemy = new Gson().fromJson(reader, Enemy.class);
            return enemy;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static TextPuzzle loadTextPuzzle(int i) throws Exception {
        return loadTextPuzzle(recognizeElement(i));
    }

    public static TextPuzzle loadTextPuzzle(String item) throws Exception {

        try {
            FileReader reader = new FileReader(new File("src/resources/" + item + ".json"));
            TextPuzzle enemy = new Gson().fromJson(reader, TextPuzzle.class);
            return enemy;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Enemy loadEnemy(int i) throws Exception {
        return loadEnemy(recognizeElement(i));
    }

    private static String recognizeElement(int i) {

        switch (i / 1000) {// check the first digit to get if it's event or item
            case 1: // it's an item

                i = i % 1000;
                switch (i / 100) {// check the second digit to get if it's weapon or item

                    case 1: // it's a weapon

                        i = i % 100;
                        switch (i) {
                            case 1:
                                return "spada";
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
