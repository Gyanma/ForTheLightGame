package com.mapproject.operations;

import java.util.List;
import java.util.Map;

public class Parser {
    private static Map<String, List<String>> nounDictionary;
    private static Map<String, List<String>> completeActionsDictionary;
    private static Map<String, List<String>> incompleteActionsDictionary;
    private static Map<String, List<String>> puzzleSolutionsDictionary;
    private static String directionPattern = "(nord)|(sud)|(est)|(ovest)";
    private static String jugPattern = "(prima brocca)|(seconda brocca)|(terza brocca)";

    public Parser() {
        nounDictionary = Loader.loadDictionary("nounDictionary");
        completeActionsDictionary = Loader.loadDictionary("completeActionsDictionary");
        incompleteActionsDictionary = Loader.loadDictionary("incompleteActionsDictionary");
        puzzleSolutionsDictionary = Loader.loadDictionary("puzzleSolutionsDictionary");
    }

    public static String parseCommand(String command) {

        // if the command can be traced to a correct puzzle
        // solution, the standard solution is returned
        for (String key : puzzleSolutionsDictionary.keySet()) {
            for (String string : puzzleSolutionsDictionary.get(key)) {
                if (command.equals(string))
                    return key;
            }
        }

        // if the command can be traced back to a complete action,
        // the standard command is returned
        for (String key : completeActionsDictionary.keySet()) {
            for (String string : completeActionsDictionary.get(key)) {
                if (command.equals(string))
                    return key;
            }
        }

        // if the command can be traced back to an incomplete action,
        // the command is further analyzed to parse the action and the objects

        boolean sentenceFound = false;
        String action = "";
        String newCommand = "";
        String firstNoun = "";
        String secondNoun = "";
        for (String key : incompleteActionsDictionary.keySet()) {
            for (String string : incompleteActionsDictionary.get(key)) {
                if (command.startsWith(string)) {
                    action = key;
                    sentenceFound = true;
                    newCommand = command.replaceFirst(string, "");
                    newCommand = newCommand.trim();
                    break;
                }
            }
        }
        if (!sentenceFound) {
            return command;
        } else
            sentenceFound = false;

        switch (action) {
            case "Spostati":
                if (newCommand.contains("la stanza a"))
                    newCommand = newCommand.replaceFirst("la stanza a", "");
                newCommand = newCommand.trim();
                if (newCommand.matches(directionPattern)) {
                    firstNoun = newCommand;
                    sentenceFound = true;
                }
                break;
            case "Raccogli":
                for (String key : nounDictionary.keySet()) {
                    for (String string : nounDictionary.get(key)) {
                        if (newCommand.startsWith(string)) {
                            firstNoun = key;
                            sentenceFound = true;
                            newCommand = newCommand.replaceFirst(string, "");
                            newCommand = newCommand.trim();
                            break;
                        }
                    }
                }
                break;
            case "Raggiungi":
                for (String key : nounDictionary.keySet()) {
                    for (String string : nounDictionary.get(key)) {
                        if (newCommand.startsWith(string)) {
                            firstNoun = key;
                            sentenceFound = true;
                            newCommand = newCommand.replaceFirst(string, "");
                            newCommand = newCommand.trim();

                            break;
                        }
                    }
                }
                break;
            case "Usa":
                for (String key : nounDictionary.keySet()) {
                    for (String string : nounDictionary.get(key)) {
                        if (newCommand.startsWith(string)) {

                            firstNoun = key;
                            sentenceFound = true;
                            newCommand = newCommand.replaceFirst(string, "");
                            newCommand = newCommand.trim();
                            break;
                        }
                    }
                }
                if (newCommand.contains("su")) {
                    newCommand = newCommand.replaceFirst("su", "");
                    newCommand = newCommand.trim();
                    for (String key : nounDictionary.keySet()) {
                        for (String string : nounDictionary.get(key)) {
                            if (newCommand.startsWith(string)) {
                                secondNoun = key;
                                sentenceFound = true;
                                newCommand = newCommand.replaceFirst(string, "");
                                newCommand = newCommand.trim();
                                break;
                            }
                        }
                    }
                }
                break;
            case "Cerca":
                for (String key : nounDictionary.keySet()) {
                    for (String string : nounDictionary.get(key)) {
                        if (newCommand.startsWith(string)) {
                            firstNoun = key;
                            sentenceFound = true;
                            newCommand = newCommand.replaceFirst(string, "");
                            newCommand = newCommand.trim();
                            break;
                        }
                    }
                }
                if (newCommand.contains("su")) {
                    newCommand = newCommand.replaceFirst("su", "");
                    newCommand = newCommand.trim();
                    for (String key : nounDictionary.keySet()) {
                        for (String string : nounDictionary.get(key)) {
                            if (newCommand.startsWith(string)) {
                                secondNoun = key;
                                sentenceFound = true;
                                newCommand = newCommand.replaceFirst(string, "");
                                newCommand = newCommand.trim();
                                break;
                            }
                        }
                    }
                    action = "Usa";
                    String tempString = secondNoun;
                    secondNoun = firstNoun;
                    firstNoun = tempString;

                } else
                    sentenceFound = false;
                break;
            case "Esamina":
                for (String key : nounDictionary.keySet()) {
                    for (String string : nounDictionary.get(key)) {
                        if (newCommand.startsWith(string)) {
                            firstNoun = key;
                            sentenceFound = true;
                            newCommand = newCommand.replaceFirst(string, "");
                            newCommand = newCommand.trim();
                            break;
                        }
                    }
                }
                break;
            case "Getta":
                for (String key : nounDictionary.keySet()) {
                    for (String string : nounDictionary.get(key)) {
                        if (newCommand.startsWith(string)) {
                            firstNoun = key;
                            sentenceFound = true;
                            newCommand = newCommand.replaceFirst(string, "");
                            newCommand = newCommand.trim();
                            break;
                        }
                    }
                }
                break;
            case "Consegna":
                for (String key : nounDictionary.keySet()) {
                    for (String string : nounDictionary.get(key)) {
                        if (newCommand.startsWith(string)) {
                            firstNoun = key;
                            sentenceFound = true;
                            newCommand = newCommand.replaceFirst(string, "");
                            newCommand = newCommand.trim();
                            break;
                        }
                    }
                }
                if (newCommand.contains("per")
                        || newCommand.contains("in cambio di")) {
                    newCommand = newCommand.replaceFirst("in cambio di", "");
                    newCommand = newCommand.replaceFirst("per", "");
                    newCommand = newCommand.trim();
                    for (String key : nounDictionary.keySet()) {
                        for (String string : nounDictionary.get(key)) {
                            if (newCommand.startsWith(string)) {
                                secondNoun = key;
                                sentenceFound = true;
                                newCommand = newCommand.replaceFirst(string, "");
                                newCommand = newCommand.trim();
                                break;
                            }
                        }
                    }
                }
                break;

            case "Svuota":
                if (newCommand.contains("brocca")) {
                    String[] newStrings = newCommand.split(jugPattern);
                    for (String string : newStrings) {
                        newCommand.replaceFirst(string, "");
                    }
                    newCommand = newCommand.trim();
                    if (newCommand.startsWith("la prima brocca")) {
                        firstNoun = "brocca1";
                        newCommand = newCommand.replaceFirst("la prima brocca", "");
                        sentenceFound = true;
                    } else if (newCommand.startsWith("la seconda brocca")) {
                        firstNoun = "brocca2";
                        newCommand = newCommand.replaceFirst("la seconda brocca", "");
                        sentenceFound = true;
                    } else if (newCommand.startsWith("la terza brocca")) {
                        firstNoun = "brocca3";
                        newCommand = newCommand.replaceFirst("la terza brocca", "");
                        sentenceFound = true;
                    } else
                        sentenceFound = false;
                    newCommand = newCommand.trim();
                    if (sentenceFound && newCommand.startsWith("nella")) {
                        newCommand = newCommand.replaceFirst("nella", "");
                        newCommand = newCommand.trim();
                        if (newCommand.startsWith("la prima brocca")) {
                            secondNoun = "brocca1";
                            newCommand = newCommand.replaceFirst("la prima brocca", "");
                            sentenceFound = true;
                        } else if (newCommand.startsWith("la seconda brocca")) {
                            secondNoun = "brocca2";
                            newCommand = newCommand.replaceFirst("la seconda brocca", "");
                            sentenceFound = true;
                        } else if (newCommand.startsWith("la terza brocca")) {
                            secondNoun = "brocca3";
                            newCommand = newCommand.replaceFirst("la terza brocca", "");
                            sentenceFound = true;
                        } else
                            sentenceFound = false;
                    }
                }
                break;
            case "Attacca":
                if (newCommand.startsWith("con")) {
                    newCommand = newCommand.replaceFirst("con", "");
                    newCommand = newCommand.trim();
                    for (String key : nounDictionary.keySet()) {
                        for (String string : nounDictionary.get(key)) {
                            if (newCommand.startsWith(string)) {
                                firstNoun = key;
                                sentenceFound = true;
                                newCommand = newCommand.replaceFirst(string, "");
                                newCommand = newCommand.trim();
                                break;
                            }
                        }
                    }
                } else {
                    for (String key : nounDictionary.keySet()) {
                        for (String string : nounDictionary.get(key)) {
                            if (newCommand.startsWith(string)) {
                                secondNoun = key;
                                sentenceFound = true;
                                newCommand = newCommand.replaceFirst(string, "");
                                newCommand = newCommand.trim();
                                break;
                            }
                        }
                    }
                    if (sentenceFound) {
                        sentenceFound = false;
                        if (newCommand.startsWith("con")) {
                            newCommand = newCommand.replaceFirst("con", "");
                            newCommand = newCommand.trim();
                            for (String key : nounDictionary.keySet()) {
                                for (String string : nounDictionary.get(key)) {
                                    if (newCommand.startsWith(string)) {
                                        firstNoun = key;
                                        sentenceFound = true;
                                        newCommand = newCommand.replaceFirst(string, "");
                                        newCommand = newCommand.trim();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            default:
                break;
        }

        if (!sentenceFound)
            return command;
        else if (secondNoun != "")
            return action + " " + firstNoun + "+" + secondNoun;
        else
            return action + " " + firstNoun;

    }
}
