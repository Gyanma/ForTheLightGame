package com.mapproject.operations;

import com.mapproject.enums.Status;
import com.mapproject.operations.visualHandler.VisualHandler;
import com.mapproject.resources.Fight;
import com.mapproject.resources.Session;
import com.mapproject.resources.events.Danger;
import com.mapproject.resources.events.Enemy;
import com.mapproject.resources.events.JugPuzzle;
import com.mapproject.resources.events.PacificEncounter;
import com.mapproject.resources.events.TextPuzzle;
import com.mapproject.resources.events.VisualPuzzle;
import com.mapproject.resources.items.Item;
import com.mapproject.resources.items.Weapon;

public class Interpreter {

    public Interpreter() {
    }

    public static int decide(String command, Session gameSession) {

        // Exploring section

        // explore room command

        if (command.equals("Esplora stanza")) {
            exploreRoom(gameSession);
            return 1;

            // item search command
        } else if (command.startsWith("Cerca item")) {
            exploreRoomForItems(gameSession);
            return 1;

            // change room commands
        } else if (command.startsWith("Spostati")) {
            if (gameSession.getCurrentRoom().getEvent() == null ||
                    gameSession.getCurrentRoom().getEvent().isSkippable()) {
                command = command.replace("Spostati ", "");
                command = command.trim();
                if (command.equals("nord")) {
                    moveToNorth(gameSession);
                } else if (command.equals("sud")) {
                    moveToSouth(gameSession);
                } else if (command.equals("ovest")) {
                    moveToWest(gameSession);
                } else if (command.equals("est")) {
                    moveToEast(gameSession);
                } else {
                    return 2;
                }

                if (gameSession.getCurrentRoom().getEvent() != null &&
                        gameSession.getCurrentRoom().getEvent().getClass() == Danger.class)
                    launchDanger(gameSession);

                if (gameSession.getCurrentRoom().getEvent() != null &&
                        gameSession.getCurrentMap().getEndRoomId() == gameSession.getCurrentRoomId()) {
                    System.out.println("Senti una presenza inquietante... Dev'essere la stanza finale!");
                }
            } else {
                if (gameSession.getCurrentRoom().getEvent().getClass() == VisualPuzzle.class) {
                    System.out.println("Le porte sono bloccate!");
                } else if (gameSession.getCurrentRoom().getEvent().getClass() == Danger.class) {
                    System.out.println("Non si scappa!");
                } else if (gameSession.getCurrentRoom().getEvent().getClass() == Enemy.class) {
                    System.out.println("Un mostro ti sbarra la strada!");
                }

            }
            return 1;

            // get item commands
        } else if (command.startsWith("Raccogli")) {
            command = command.replace("Raccogli ", "");
            command = command.trim();
            getItem(gameSession, command);
            return 1;

            // open map command
        } else if (command.startsWith("Apri mappa")) {
            drawMap(gameSession);
            return 1;

            // reach an npc command
        } else if (command.startsWith("Raggiungi")) {
            command = command.replace("Raggiungi ", "");
            command = command.trim();
            if (gameSession.getCurrentRoom().getEvent() != null) {
                if (command.equals(gameSession.getCurrentRoom().getEvent().getName())) {
                    startEvent(gameSession);
                    return 1;
                } else if (command.equals("meccanismo") &&
                        gameSession.getCurrentRoom().getEvent().getClass() == VisualPuzzle.class) {
                    startVisualPuzzle(gameSession);
                    return 1;
                } else
                    return 2;
            } else
                return 2;

            // exit map command
        } else if (command.equals("Esci"))
            return changeToNextMap(gameSession);

        // Inventory section

        // open inventory command
        else if (command.equals("Apri inventario")) {
            openInventory(gameSession);
            return 1;

            // use item command
        } else if (command.startsWith("Usa")) {
            command = command.replace("Usa ", "");
            command = command.trim();
            if (gameSession.getCurrentStatus() == Status.IN_DANGER
                    && gameSession.getCurrentRoom().getEvent() != null) {
                checkEscape(gameSession, command);
                return 1;

            } else {
                InventoryHandler.useItem(gameSession, command);
                return 1;
            }
            // examine item command
        } else if (command.startsWith("Esamina")) {
            command = command.replace("Esamina ", "");
            command = command.trim();
            InventoryHandler.examineItem(gameSession, command);
            return 1;
            // throw item command
        } else if (command.startsWith("Getta")) {
            command = command.replace("Getta ", "");
            command = command.trim();
            InventoryHandler.throwItem(gameSession, command);
            return 1;

            // Event section

            // Pacific Encounter
            // donate item in pacific encounter command
        } else if (command.startsWith("Consegna")) {
            command = command.replace("Consegna ", "");
            command = command.trim();
            donateItem(gameSession, command);
            return 1;

            // pray command
        } else if (command.equals("Prega")) {
            pray(gameSession);
            return 1;

            // Jug Puzzle
            // pour jug command
        } else if (command.startsWith("Svuota")) {
            command = command.replace("Svuota ", "");
            command = command.trim();
            if (command.contains("brocca")) {
                solveJugPuzzle(gameSession, command);
                return 1;
            } else {
                return 2;
            }

            // leave event or battle command
        } else if (command.equals("Abbandona")) {
            if (gameSession.getCurrentStatus() == Status.FIGHTING) {
                escapeBattle(gameSession);
            } else
                leaveEncounter(gameSession);
            return 1;

            // Battle section
            // attack command
        } else if (command.startsWith("Attacca")) {
            return attack(gameSession, command);

            // possible response to text puzzle
        } else if (gameSession.getCurrentStatus() == Status.PUZZLE_SOLVING) {
            checkAnswer(gameSession, command);
            return 1;

            // Unrecognised command
        } else {
            return 2;
        }
    }

    private static void checkEscape(Session gameSession, String command) {
        Danger danger = (Danger) gameSession.getCurrentRoom().getEvent();
        if (command.equals(Loader.loadItem(danger.getSolution()).getName())
                && gameSession.getInventory().contains(Loader.loadItem(danger.getSolution()))) {
            System.out.println(danger.getSolved());
            gameSession.removeItemFromInventory(Loader.loadItem(danger.getSolution()));
            gameSession.setCurrentStatus(Status.EXPLORING);
            gameSession.getCurrentRoom().setEvent(null);
        } else if (!gameSession.getInventory().contains(Loader.loadItem(danger.getSolution()))) {
            System.out.println("Non hai quell'oggetto!");
        } else {
            System.out.println("Non funziona!");
        }
    }

    private static void escapeBattle(Session gameSession) {
        if (gameSession.getCurrentRoom().getEvent() != null) {
            if (gameSession.getCurrentRoom().getEvent().getClass() == Enemy.class) {
                Enemy enemy = (Enemy) gameSession.getCurrentRoom().getEvent();
                if (enemy.isSkippable()) {
                    System.out.println("Riesci a fuggire dalla battaglia!");
                    gameSession.setCurrentStatus(Status.EXPLORING);
                    if (gameSession.getCurrentRoomId() != gameSession.getCurrentMap().getEndRoomId()) {
                        gameSession.getCurrentRoom().setEvent(null);
                    }

                } else {
                    System.out.println("Non funziona!");
                }
            } else {
                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
            }

        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

    }

    private static int attack(Session gameSession, String command) {
        if (gameSession.getCurrentStatus() == Status.FIGHTING
                && gameSession.getCurrentRoom().getEvent() != null) {
            command = command.replace("Attacca ", "");
            command = command.trim();
            if (command.contains("+")) {
                String[] newCommand = command.split("\\+"); // player indicated target of attack
                if (newCommand[1].equals(gameSession.getCurrentRoom().getEvent().getName())) {
                    command = newCommand[0];
                } else
                    return 2;
            }

            Weapon chosenWeapon = null;

            for (Item item : gameSession.getInventory()) {
                if (command.equals(item.getName()) &&
                        item.getClass() == Weapon.class) {
                    chosenWeapon = (Weapon) item;
                }
            }
            if (chosenWeapon == null) {
                System.out.println("Non capisco come vuoi attaccare...");
                return 1;
            }
            gameSession.getCurrentFighting().playersTurn(gameSession, chosenWeapon);
            if (gameSession.getCurrentFighting().getOpponent().isAlive()) {
                gameSession.getCurrentFighting().opponentsTurn(gameSession, chosenWeapon);
            } else {
                System.out.println("Il nemico è sconfitto!");
                gameSession.setCurrentStatus(Status.EXPLORING);
                gameSession.getCurrentRoom().setEvent(null);
                gameSession.setCurrentFighting(null);
                gameSession.setHealthPoints(gameSession.getHealthPoints() + 10);
                gameSession.setMaxHealthPoints(gameSession.getMaxHealthPoints() + 10);
                for (Item item : gameSession.getInventory()) {
                    if (item.getName().equals("Libro della forza")
                            && item.isUsed())
                        gameSession.removeItemFromInventory(item);
                    if (item.getName().equals("Libro dell'accuratezza")
                            && item.isUsed())
                        gameSession.removeItemFromInventory(item);
                    else if (item.getName().equals("Libro della destrezza")
                            && item.isUsed())
                        gameSession.removeItemFromInventory(item);
                    else if (item.getName().equals("Fiala del sangue")
                            && item.isUsed())
                        gameSession.removeItemFromInventory(item);
                }

            }
            if (!gameSession.isPlayerAlive()) {
                System.out.println("Sei stato sconfitto. La tua prova si conclude qui...");
                return 0;
            } else {
                return 1;
            }
        } else if (gameSession.getCurrentRoom().getEvent() != null &&
                gameSession.getCurrentRoom().getEvent().getClass() == Enemy.class) {
            gameSession.setCurrentStatus(Status.FIGHTING);
            Fight newFight = new Fight();
            newFight.setOpponent((Enemy) gameSession.getCurrentRoom().getEvent());
            gameSession.setCurrentFighting(newFight);
            System.out.println("Inizia la battaglia!");
        } else
            System.out.println("Non c'è nessuno da attaccare!");

        return 1;
    }

    private static void solveJugPuzzle(Session gameSession, String command) {
        if (gameSession.getCurrentRoom().getEvent() != null &&
                gameSession.getCurrentRoom().getEvent().getClass() == JugPuzzle.class &&
                gameSession.getCurrentStatus() == Status.PUZZLE_SOLVING) {
            JugPuzzle jugPuzzle = (JugPuzzle) gameSession.getCurrentRoom().getEvent();

            // pour jugs
            if (command.startsWith("brocca 1")) {
                if (command.endsWith("brocca 2")) {
                    jugPuzzle.pourJug(jugPuzzle.getPlayerJugSet().getJug1(), jugPuzzle.getPlayerJugSet().getJug2());
                    System.out.println("Hai svuoltato la brocca 1 nella brocca 2.");
                } else if (command.endsWith("brocca 3")) {
                    jugPuzzle.pourJug(jugPuzzle.getPlayerJugSet().getJug1(), jugPuzzle.getPlayerJugSet().getJug3());
                    System.out.println("Hai svuoltato la brocca 1 nella brocca 3.");
                } else {
                    System.out.println("Non capisco quali brocche usare!");
                }

            } else if (command.startsWith("brocca 2")) {
                if (command.endsWith("brocca 1")) {
                    jugPuzzle.pourJug(jugPuzzle.getPlayerJugSet().getJug2(), jugPuzzle.getPlayerJugSet().getJug1());
                    System.out.println("Hai svuoltato la brocca 2 nella brocca 1.");
                } else if (command.endsWith("brocca 3")) {
                    jugPuzzle.pourJug(jugPuzzle.getPlayerJugSet().getJug2(), jugPuzzle.getPlayerJugSet().getJug3());
                    System.out.println("Hai svuoltato la brocca 2 nella brocca 3.");
                } else {
                    System.out.println("Non capisco quali brocche usare!");
                }

            } else if (command.startsWith("brocca 3")) {
                if (command.endsWith("brocca 1")) {
                    jugPuzzle.pourJug(jugPuzzle.getPlayerJugSet().getJug3(), jugPuzzle.getPlayerJugSet().getJug1());
                    System.out.println("Hai svuoltato la brocca 3 nella brocca 1.");
                } else if (command.endsWith("brocca 2")) {
                    jugPuzzle.pourJug(jugPuzzle.getPlayerJugSet().getJug3(), jugPuzzle.getPlayerJugSet().getJug2());
                    System.out.println("Hai svuoltato la brocca 3 nella brocca 2.");
                } else {
                    System.out.println("Non capisco quali brocche usare!");
                }
            } else {
                System.out.println("Non capisco quali brocche usare!");
            }

            // check if puzzle is solved
            if (jugPuzzle.isCorrect()) {
                System.out.println(jugPuzzle.getCorrectReply());
                gameSession.setCurrentStatus(Status.EXPLORING);
                if (Utilities.recognizeItem(jugPuzzle.getRewardId()) == "item") {
                    gameSession.addItemToInventory(Loader.loadItem(jugPuzzle.getRewardId()));
                    System.out.println(
                            "Hai ricevuto " + Loader.loadItem(jugPuzzle.getRewardId()).getNameWithIndetArticle() + ".");
                } else {
                    gameSession.addItemToInventory(Loader.loadWeapon(jugPuzzle.getRewardId()));
                    System.out.println(
                            "Hai ricevuto "
                                    + Loader.loadWeapon(jugPuzzle.getRewardId()).getNameWithIndetArticle() + ".");
                }
                gameSession.getCurrentRoom().setEvent(null);
            } else {
                System.out.println("Ora la brocca 1 contiene" + jugPuzzle.getPlayerJugSet().getJug1().getJugContent()
                        + " decilitri.");
                System.out.println("Ora la brocca 2 contiene" + jugPuzzle.getPlayerJugSet().getJug2().getJugContent()
                        + " decilitri.");
                System.out.println("Ora la brocca 3 contiene" + jugPuzzle.getPlayerJugSet().getJug3().getJugContent()
                        + " decilitri.");
                gameSession.getCurrentRoom().setEvent(jugPuzzle);
            }

        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

    }

    private static void leaveEncounter(Session gameSession) {
        if (gameSession.getCurrentRoom().getEvent() != null &&
                (gameSession.getCurrentStatus() == Status.IN_PACIFIC_ENCOUNTER
                        || gameSession.getCurrentStatus() == Status.PUZZLE_SOLVING)) {
            if (gameSession.getCurrentRoom().getEvent().getClass() == PacificEncounter.class) {
                PacificEncounter encounter = (PacificEncounter) gameSession.getCurrentRoom().getEvent();
                System.out.println(encounter.getItemNotGivenResponse());
                gameSession.setCurrentStatus(Status.EXPLORING);
                gameSession.getCurrentRoom().setEvent(null);
            } else if (gameSession.getCurrentRoom().getEvent().getClass() == JugPuzzle.class
                    || gameSession.getCurrentRoom().getEvent().getClass() == TextPuzzle.class) {
                TextPuzzle puzzle = (TextPuzzle) gameSession.getCurrentRoom().getEvent();
                System.out.println(puzzle.getSurrenderReply());
                gameSession.setCurrentStatus(Status.EXPLORING);
            } else
                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

    }

    private static void pray(Session gameSession) {
        if (gameSession.getCurrentRoom().getEvent() != null &&
                gameSession.getCurrentStatus() == Status.IN_PACIFIC_ENCOUNTER) {
            if (gameSession.getCurrentRoom().getEvent().getClass() == PacificEncounter.class) {
                PacificEncounter encounter = (PacificEncounter) gameSession.getCurrentRoom().getEvent();
                if (encounter.getRequestedItemId().size() == 1 && encounter.getRequestedItemId().contains(-1)) {
                    System.out.println(encounter.getItemGivenResponse());
                    EventHandler.selectBlessing(gameSession);
                    gameSession.setCurrentStatus(Status.EXPLORING);
                    gameSession.getCurrentRoom().setEvent(null);

                }
            } else {
                System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
            }
        } else {
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
        }
    }

    private static void donateItem(Session gameSession, String command) {
        if (gameSession.getCurrentRoom().getEvent() != null &&
                gameSession.getCurrentStatus() == Status.IN_PACIFIC_ENCOUNTER) {
            String itemRequestedByPlayerName = "";
            String itemGivenByPlayerName = "";
            Item itemReq = null;
            Item itemGiv = null;
            PacificEncounter encounter = (PacificEncounter) gameSession.getCurrentRoom().getEvent();
            boolean itemFound = false;
            boolean itemReqCorrect = false;
            boolean itemGivCorrect = false;
            boolean commandCompound = false;

            if (command.contains("+")) {
                commandCompound = true;
                String[] commandSplit = command.split("\\+");
                itemGivenByPlayerName = commandSplit[0];
                itemRequestedByPlayerName = commandSplit[1];
            }

            if (commandCompound) {
                for (Item item : gameSession.getInventory()) { // check if item given by player is in inventory
                    if (item.getName().equals(itemGivenByPlayerName)) {
                        itemGiv = item;
                        itemFound = true;
                        break;
                    }
                }

                for (Integer itemId : encounter.getRequestedItemId()) { // check if item given by player is in
                                                                        // encounter
                    if (itemId == -1) {
                        itemReqCorrect = false;
                        break;
                    }

                    if (itemId == -2) {
                        itemGivCorrect = true;
                        break;
                    }
                    if (Loader.loadItem(itemId).getName().equals(itemGivenByPlayerName)) {
                        itemGivCorrect = true;
                        break;
                    }
                }

                for (Integer itemId : encounter.getGiftedItemId()) { // check if item requested by player is in
                                                                     // encounter
                    if (itemId == -1) {
                        itemReqCorrect = false;
                        break;
                    }
                    if (Loader.loadItem(itemId).getName() == itemRequestedByPlayerName) {
                        itemReq = Loader.loadItem(itemId);
                        itemReqCorrect = true;
                        break;
                    }
                }
                if (itemFound && itemReqCorrect && itemGivCorrect) {
                    gameSession.removeItemFromInventory(itemGiv);
                    gameSession.addItemToInventory(itemReq);
                    System.out.println(encounter.getItemGivenResponse());
                    gameSession.setCurrentStatus(Status.EXPLORING);
                    gameSession.getCurrentRoom().setEvent(null);

                } else {
                    System.out.println("Non capisco di quali oggetti parli.");
                }

            } else {
                for (Item item : gameSession.getInventory()) { // check if item given by player is in inventory
                    if (item.getName().equals(command)) {
                        itemGiv = item;
                        itemFound = true;
                        break;
                    }
                }
                if (encounter.getGiftedItemId().size() == 1) {
                    for (Integer itemId : encounter.getRequestedItemId()) { // check if item given by player is in
                        // encounter
                        if (itemId == -1) {
                            itemReqCorrect = false;
                            break;
                        }

                        if (itemId == -2) {
                            itemGivCorrect = true;
                            break;
                        }
                        if (Loader.loadItem(itemId).getName().equals(command)) {
                            itemGivCorrect = true;
                            break;
                        }
                    }

                    for (Integer itemId : encounter.getGiftedItemId()) { // get item requested by player
                        if (itemId == -1) {
                            itemReqCorrect = false;

                        } else {
                            itemReq = Loader.loadItem(itemId);
                            itemReqCorrect = true;
                        }
                    }
                    if (itemFound && itemReqCorrect && itemGivCorrect) {
                        gameSession.removeItemFromInventory(itemGiv);
                        gameSession.addItemToInventory(itemReq);
                        System.out.println(encounter.getItemGivenResponse());
                        gameSession.setCurrentStatus(Status.EXPLORING);
                        gameSession.getCurrentRoom().setEvent(null);
                        if (gameSession.getInventory().contains(Loader.loadItem("mappa mistica"))
                                && gameSession.getInventory().contains(Loader.loadItem("mappa")))
                            gameSession.removeItemFromInventory(Loader.loadItem("mappa"));

                    } else {
                        System.out.println("Non capisco di quali oggetti parli.");
                    }
                } else
                    System.out.println("Non capisco di quali oggetti parli.");

            }
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

    }

    private static void checkAnswer(Session gameSession, String command) {
        if (gameSession.getCurrentRoom().getEvent() != null &&
                gameSession.getCurrentStatus() == Status.PUZZLE_SOLVING) {
            if (gameSession.getCurrentRoom().getEvent().getClass() == TextPuzzle.class) {
                TextPuzzle textPuzzle = (TextPuzzle) gameSession.getCurrentRoom().getEvent();
                if (textPuzzle.getAnswer().equals(command)) {
                    System.out.println(textPuzzle.getCorrectReply());
                    gameSession.addItemToInventory(Loader.loadItem(textPuzzle.getRewardId()));
                    gameSession.setCurrentStatus(Status.EXPLORING);
                    gameSession.getCurrentRoom().setEvent(null);
                } else {
                    if (textPuzzle.getTryAgainReply() == null) {
                        System.out.println(textPuzzle.getIncorrectReply());
                        gameSession.setCurrentStatus(Status.EXPLORING);
                        gameSession.getCurrentRoom().setEvent(null);
                    } else {
                        System.out.println(textPuzzle.getTryAgainReply());
                    }
                }
            }
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
    }

    private static void startVisualPuzzle(Session gameSession) {
        try {
            VisualPuzzle visualPuzzle = (VisualPuzzle) gameSession.getCurrentRoom().getEvent();
            System.out.println(visualPuzzle.getDescription());
            int result = VisualHandler.selectVisual(gameSession.getCurrentRoom().getEvent().getEventId());
            if (result == 1) {
                gameSession.getCurrentRoom().setEvent(null);
                System.out
                        .println(
                                "Senti i meccanismi che si attivano dietro i muri. Adesso le porte si possono aprire");
            } else if (result == 0) {
                System.out.println("Questo enigma è davvero ostico... bisogna pensarci meglio.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int changeToNextMap(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING &&
                gameSession.getCurrentRoom().getId() == gameSession.getCurrentMap().getEndRoomId()) {
            if (gameSession.getCurrentRoom().getEvent() == null) {
                switch (gameSession.getCurrentPhase()) {
                    case 1:
                        gameSession.setCurrentPhase(2);
                        gameSession.setCurrentRoomId(gameSession.getSessionMap(2).getStartingRoomId());
                        gameSession.setMaxHealthPoints(gameSession.getMaxHealthPoints() + 20);
                        gameSession.setHealthPoints(gameSession.getMaxHealthPoints());
                        System.out.println("Hai raggiunto la prima stanza del secondo labirinto! Buona fortuna!");
                        return 1;
                    case 2:
                        gameSession.setCurrentPhase(3);
                        gameSession.setCurrentRoomId(gameSession.getSessionMap(3).getStartingRoomId());
                        System.out.println("Hai raggiunto la prima stanza del terzo labirinto! Buona fortuna!");
                        gameSession.setMaxHealthPoints(gameSession.getMaxHealthPoints() + 20);
                        gameSession.setHealthPoints(gameSession.getMaxHealthPoints());
                        return 1;
                    case 3:
                        Printer.printFromTxt("Finale");
                        return 3;
                    default:
                        return 1;
                }
            } else
                System.out.println("Devi ancora sconfiggere il boss!");
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
        return 1;
    }

    private static void openInventory(Session gameSession) {
        if (gameSession.getInventory().size() == 0) {
            System.out.println("Al momento, l'inventario è vuoto.");
        } else {
            System.out.println("Nell'inventario hai:");
            int counter = 0;
            do {
                if (gameSession.getInventory().size() - counter >= 4) {
                    System.out.println(
                            gameSession.getInventory().get(counter).getName() + "\t"
                                    + gameSession.getInventory().get(counter + 1).getName() + "\t"
                                    + gameSession.getInventory().get(counter + 2).getName() + "\t"
                                    + gameSession.getInventory().get(counter + 3).getName());
                    counter += 4;
                } else if (gameSession.getInventory().size() - counter == 3) {
                    System.out.println(
                            gameSession.getInventory().get(counter).getName() + "\t"
                                    + gameSession.getInventory().get(counter + 1).getName() + "\t"
                                    + gameSession.getInventory().get(counter + 2).getName());
                    counter += 3;
                } else if (gameSession.getInventory().size() - counter == 2) {
                    System.out.println(
                            gameSession.getInventory().get(counter).getName() + "\t"
                                    + gameSession.getInventory().get(counter + 1).getName());
                    counter += 2;
                } else if (gameSession.getInventory().size() - counter == 1) {
                    System.out.println(
                            gameSession.getInventory().get(counter).getName());
                    counter += 1;
                }

            } while (counter < gameSession.getInventory().size());
        }
    }

    private static void launchDanger(Session gameSession) {
        gameSession.setCurrentStatus(Status.IN_DANGER);
        Danger danger = (Danger) gameSession.getCurrentRoom().getEvent();
        System.out.println(danger.getPresentation());
        class DangerQueue implements Runnable {

            @Override
            public void run() {
                for (int i = 1; i < 5; i++) {
                    if (gameSession.getCurrentStatus() != Status.IN_DANGER) {
                        break;
                    }

                    try {
                        Thread.sleep(danger.getTimeLimit() / 50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(danger.getCountdown().get(i));

                }
                if (gameSession.getCurrentStatus() == Status.IN_DANGER) {
                    try {
                        Thread.sleep(danger.getTimeLimit() / 5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(danger.getCountdown().get(5));
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (gameSession.getCurrentStatus() == Status.EXPLORING) {
                    gameSession.addItemToInventory(Loader.loadItem(danger.getPrize()));
                    gameSession.getCurrentRoom().setEvent(null);
                } else if (gameSession.getCurrentStatus() == Status.IN_DANGER) {
                    System.out.println("Ti risvegli. Chissà quanto tempo è passato.\n"
                            + "In qualche modo sei ancora tutto intero.");

                    gameSession.getCurrentRoom().setEvent(null);
                    gameSession.setCurrentStatus(Status.EXPLORING);
                    System.out.println(gameSession.getInventory().size());

                    if (gameSession.getInventory().size() > 2) {
                        Item item;
                        do {
                            item = gameSession.getInventory()
                                    .get((int) Math.random() * gameSession.getInventory().size());
                        } while (item.getName().equals("Mappa") ||
                                item.getName().equals("Pergamena magica"));

                        gameSession.removeItemFromInventory(item);
                        System.out.println(
                                "Ti controlli le tasche e noti di aver perso " + item.getNameWithIndetArticle());

                    }

                }
            }
        }

        new Thread(new DangerQueue()).start();
    }

    private static void startEvent(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getEvent().getClass() == TextPuzzle.class) {
                gameSession.setCurrentStatus(Status.PUZZLE_SOLVING);
                TextPuzzle textPuzzle = (TextPuzzle) gameSession.getCurrentRoom().getEvent();
                System.out.println(textPuzzle.getQuestion());

            } else if (gameSession.getCurrentRoom().getEvent().getClass() == PacificEncounter.class) {
                gameSession.setCurrentStatus(Status.IN_PACIFIC_ENCOUNTER);
                PacificEncounter encounter = (PacificEncounter) gameSession.getCurrentRoom().getEvent();
                System.out.println(encounter.getDescription());

            } else if (gameSession.getCurrentRoom().getEvent().getClass() == Enemy.class) {
                gameSession.setCurrentStatus(Status.FIGHTING);
                Fight newFight = new Fight();
                newFight.setOpponent((Enemy) gameSession.getCurrentRoom().getEvent());
                gameSession.setCurrentFighting(newFight);
                System.out.println("Inizia la battaglia!");

            }
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

    }

    private static void drawMap(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {

            if (gameSession.getInventory().contains(Loader.loadItem("mappa"))) {
                gameSession.drawVisualMap(false);

            } else if (gameSession.getInventory().contains(Loader.loadItem("mappa mistica"))) {
                gameSession.drawVisualMap(true);

            } else {
                System.out.println("Non hai una mappa!");
            }

        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

    }

    private static void getItem(Session gameSession, String command) {
        boolean found = false;
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getInventory().size() + 1 < gameSession.getInventoryCapacity()) {
                for (Item item : gameSession.getCurrentRoom().getItems()) {
                    if (command.equals(item.getName())) {
                        if (gameSession.getInventory().contains(item)) {
                            System.out.println("Hai già " + item.getNameWithIndetArticle() + "!");
                            found = true;
                            break;
                        } else {
                            gameSession.addItemToInventory(item);
                            gameSession.getCurrentRoom().removeItem(item);
                            found = true;
                            System.out.println("Hai raccolto " + item.getNameWithDetArticle() + ".");
                            break;
                        }
                    }
                }
                if (!found) {
                    System.out.println("Non c'è nessun item con questo nome...");
                }
            } else
                System.out.println("Non hai spazio per altri oggetti!");
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

    }

    private static void moveToWest(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            int currentRoomId = gameSession.getCurrentRoomId();
            if (gameSession.getCurrentMap().getRoom(currentRoomId).getWest() != null) {
                gameSession.setCurrentRoomId(
                        gameSession.getCurrentMap().getRoom(currentRoomId).getWest().getId());
                System.out.println("Ti sposti verso la stanza a ovest.");
            } else {
                System.out.println("Non ci sono stanze a ovest!");
            }
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
    }

    private static void moveToEast(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            int currentRoomId = gameSession.getCurrentRoomId();
            if (gameSession.getCurrentMap().getRoom(currentRoomId).getEast() != null) {
                gameSession.setCurrentRoomId(
                        gameSession.getCurrentMap().getRoom(currentRoomId).getEast().getId());
                System.out.println("Ti sposti verso la stanza a est.");
            } else {
                System.out.println("Non ci sono stanze a est!");
            }
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
    }

    private static void moveToSouth(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            int currentRoomId = gameSession.getCurrentRoomId();
            if (gameSession.getCurrentMap().getRoom(currentRoomId).getSouth() != null) {
                gameSession.setCurrentRoomId(
                        gameSession.getCurrentMap().getRoom(currentRoomId).getSouth().getId());
                System.out.println("Ti sposti verso la stanza a sud.");
            } else {
                System.out.println("Non ci sono stanze a sud!");
            }
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
    }

    private static void moveToNorth(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            int currentRoomId = gameSession.getCurrentRoomId();
            if (gameSession.getCurrentMap().getRoom(currentRoomId).getNorth() != null) {
                gameSession.setCurrentRoomId(
                        gameSession.getCurrentMap().getRoom(currentRoomId).getNorth().getId());
                System.out.println("Ti sposti verso la stanza a nord.");
            } else {
                System.out.println("Non ci sono stanze a nord!");
            }
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");

    }

    private static void exploreRoom(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getEvent() != null) {
                System.out.println("Che succede?");
                System.out.println(gameSession.getCurrentRoom().getEvent().getPresentation());

            } else
                System.out.println("Sembra tutto tranquillo qui...");
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
    }

    private static void exploreRoomForItems(Session gameSession) {
        if (gameSession.getCurrentStatus() == Status.EXPLORING) {
            if (gameSession.getCurrentRoom().getItems() != null
                    && gameSession.getCurrentRoom().getItems().size() > 0) {
                for (Item item : gameSession.getCurrentRoom().getItems()) {

                    System.out.println("Nella stanza vedi "
                            + (item.getNameWithIndetArticle()) + "!");
                }
            } else
                System.out.println("Non c'è nulla qui...");
        } else
            System.out.println("C'è un momento e un luogo per ogni cosa, ma non ora.");
    }

}
