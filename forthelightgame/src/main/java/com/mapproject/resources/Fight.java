package com.mapproject.resources;

import java.util.HashMap;
import java.util.Map;

import com.mapproject.resources.events.Enemy;
import com.mapproject.resources.items.Item;
import com.mapproject.resources.items.Weapon;

public class Fight {
    private Enemy opponent;

    private Map<String, Boolean> opponentDebuff = new HashMap<>();
    private Map<String, Boolean> playerDebuff = new HashMap<>();
    private int cantMissStatus = 0; // some attacks make the opponent unable to miss
    private int burnCounter = 0;
    private int playerPoisonCounter = 0;
    private int opponentPoisonCounter = 0;
    private int curseCounter = 0;

    public Fight() {
        opponentDebuff.put("Fatica", false);
        opponentDebuff.put("Tossina", false);
        opponentDebuff.put("Maledetto", false);
        opponentDebuff.put("Fulmine", false);
        opponentDebuff.put("Gelo", false);
        opponentDebuff.put("Fuoco", false);

        playerDebuff.put("Bruciatura", false);
        playerDebuff.put("Tossina", false);
        playerDebuff.put("Melma", false);
        playerDebuff.put("Intimorito", false);

    }

    public void opponentsTurn(Session gameSession, Weapon chosenWeapon) {
        String chosenAttackName = "";
        int chosenAttack = (int) (Math.random() * opponent.getAttacks().keySet().size());
        int counter = 0;
        boolean fatigue = false;
        boolean bookOfAgility = false;
        boolean didAttackMiss = false;

        for (Item item : gameSession.getInventory()) {
            if (item.getName().equals("Libro della destrezza")
                    && item.isUsed())
                bookOfAgility = true;
        }
        for (String attackName : opponent.getAttacks().keySet()) {
            if (counter == chosenAttack) {
                chosenAttackName = attackName;
                System.out.println(chosenAttackName);
            }
            counter++;
        }

        System.out.println("Il nemico usa " + chosenAttackName);
        Map<String, Integer> attackStats = opponent.getAttackStats(chosenAttackName);
        double damage = attackStats.get("damage");

        damage *= opponent.getBaseAttack();
        if (opponentDebuff.get("Fuoco")) {
            damage *= 0.85;
            opponentDebuff.put("Fuoco", false);
        }

        if (opponentDebuff.get("Fatica")) {
            opponentDebuff.put("Fatica", false);
            fatigue = true;
            System.out.println("Il nemico è affaticato, non riesce ad attaccare.");
        }

        double dodgeChance;
        dodgeChance = chosenWeapon.getAgility();
        if (bookOfAgility)
            dodgeChance *= gameSession.getAgilityModifier();
        else
            dodgeChance *= gameSession.getAgilityModifier();

        if (cantMissStatus != 1 && !fatigue) {
            double accuracy = attackStats.get("accuracy");
            if (opponentDebuff.get("Gelo")) {
                accuracy *= 0.85;
                opponentDebuff.put("Gelo", false);
            }
            if (damage > 0) {
                if (Math.random() * 100 < dodgeChance
                        || Math.random() + 100 > accuracy) {

                    System.out.println("Sei riuscito a schivare l'attacco!");
                    didAttackMiss = true;

                }
            }
        }

        if (!didAttackMiss && !fatigue) {
            gameSession.setHealthPoints(gameSession.getHealthPoints() - (int) damage);
            System.out.println("Hai subito " + damage + " danni!");
            if (gameSession.isPlayerAlive())
                applyEffects(attackStats);

            if (gameSession.isPlayerAlive()) {
                if (playerDebuff.get("Bruciatura")) {
                    gameSession.setHealthPoints(gameSession.getHealthPoints() - 5);
                    System.out.println("Hai subito 5 danni a causa della bruciatura!");
                    burnCounter--;
                    if (burnCounter == 0 && gameSession.isPlayerAlive()) {
                        playerDebuff.put("Bruciatura", false);
                        System.out.println("La bruciatura si è calmata!");
                    }
                }
                if (playerDebuff.get("Tossina") && gameSession.isPlayerAlive()) {
                    gameSession.setHealthPoints(gameSession.getHealthPoints() - 10);
                    System.out.println("Hai subito 10 danni a causa della tossina!");
                    playerPoisonCounter--;
                    if (playerPoisonCounter == 0 && gameSession.isPlayerAlive()) {
                        playerDebuff.put("Tossina", false);
                        System.out.println("Sei riuscito a sopravvivere al veleno!");
                    }

                }

                if (opponentDebuff.get("Tossina")) {
                    opponent.setHealthPoints(opponent.getHealthPoints() - 10);
                    System.out.println("Il nemico ha subito 10 danni a causa della tossina!");
                    opponentPoisonCounter--;
                    if (opponentPoisonCounter == 0 && opponent.isAlive()) {
                        opponentDebuff.put("Tossina", false);
                        System.out.println("Il nemico è riuscito a sopravvivere al veleno!");
                    }
                }

                if (opponentDebuff.get("Maledetto")) {
                    double curseResult = Math.random();
                    if (curseResult < 0.33) {
                        opponent.setHealthPoints(opponent.getHealthPoints() - 20);
                        System.out.println("Il nemico ha subito 20 danni a causa della maledizione!");
                    } else if (curseResult < 0.66) {
                        opponentDebuff.put("Fatica", true);
                        System.out.println("Il nemico viene affaticato dalla maledizione!");
                    } else {
                        opponentDebuff.put("Tossina", true);
                        System.out.println("Il nemico viene intossicato dalla maledizione!");
                        opponentPoisonCounter = 5;
                    }

                    if (Math.random() < 0.25) {
                        gameSession.setHealthPoints(gameSession.getHealthPoints() - 10);
                        System.out.println("La maledizione colpisce anche te! Hai subito 10 danni!");
                    }
                    curseCounter--;

                    if (curseCounter == 0 && opponent.isAlive()) {
                        opponentDebuff.put("Maledetto", false);
                        System.out.println("La maledizione si placa...");
                    }
                }
            }

        }

        if (cantMissStatus > 0)
            cantMissStatus--;
    }

    private void applyEffects(Map<String, Integer> attackStats) {
        switch (attackStats.get("specialEffect")) {
            case 1:
                opponent.setBaseAttack(opponent.getBaseAttack() * 1.1);
                System.out.println("Il nemico ha aumentato il suo attacco!");
                break;
            case 2:
                opponent.setBaseDefense(opponent.getBaseDefense() * 1.1);
                System.out.println("Il nemico ha aumentato la sua difesa!");
                break;
            case 3:
                if (burnCounter != 0) {
                    if (Math.random() < 0.3) {
                        playerDebuff.put("Bruciatura", true);
                        System.out.println("Il nemico ti ha inflitto una scottatura!");
                        burnCounter = 5;
                    }
                }
                break;
            case 4:
                playerDebuff.put("Melma", true);
                System.out.println("L'attacco nemico ti ha coperto di melma!");
                break;
            case 5:
                opponentDebuff.put("Fatica", true);
                System.out.println("Dopo questo attacco, il nemico sembra affaticato...");
                break;
            case 6:
                if (Math.random() < 0.1) {
                    playerDebuff.put("Tossina", true);
                    System.out.println("Il nemico ti ha avvelenato!");
                    playerPoisonCounter = 10;
                }
                break;
            case 7:
                if (opponent.getHealthPoints() <= 50)
                    opponent.setHealthPoints(100);
                else
                    opponent.setHealthPoints(opponent.getHealthPoints() + 50);
                System.out.println("Il nemico si è curato di 50 punti vita!");
                opponentDebuff.put("Fatica", true);
                break;
            case 8:
                opponent.setBaseAttack(opponent.getBaseAttack() * 1.1);
                opponent.setBaseDefense(opponent.getBaseDefense() * 1.1);
                System.out.println("Il nemico ha aumentato il suo attacco e la sua difesa!");
                opponentDebuff.put("Fatica", true);
                break;
            case 9:
                playerDebuff.put("Intimorito", true);
                System.out.println("La ferocia del nemico ti spaventa! Difficile combattere al proprio meglio");
                break;
            case 10:
                cantMissStatus = 3;
                opponentDebuff.put("Fatica", true);
                System.out.println("Il prossimo attacco del nemico non potrà mancare!");
                break;
        }

    }

    public void playersTurn(Session gameSession, Weapon chosenWeapon) {
        double damage;
        boolean bookOfStrength = false;
        boolean bookOfDexterity = false;
        boolean bloodVial = false;

        damage = chosenWeapon.getDamage();

        for (Item item : gameSession.getInventory()) {
            if (item.getName().equals("Libro della forza")
                    && item.isUsed())
                bookOfStrength = true;
            else if (item.getName().equals("Libro dell'accuratezza")
                    && item.isUsed())
                bookOfDexterity = true;
            else if (item.getName().equals("Fiala del sangue")
                    && item.isUsed())
                bloodVial = true;
        }
        if (bookOfStrength) {
            damage *= (gameSession.getAttackModifier() + 1);
        } else
            damage *= gameSession.getAttackModifier();

        // accuracy
        double accuracy;
        accuracy = chosenWeapon.getAccuracy();

        if (bookOfDexterity)
            accuracy *= (gameSession.getAgilityModifier() + 1);
        else
            accuracy *= gameSession.getAgilityModifier();

        if (chosenWeapon.getUsage() == 1 && opponent.isFlying())
            damage += 10;
        else if (chosenWeapon.getUsage() == 2 && !opponent.isFlying())
            damage += 10;

        if (!opponentDebuff.get("Fulmine"))
            damage *= (2 - opponent.getBaseDefense()); // dmg = dmg - (basedef - 1) * dmg
        else {
            damage *= (2 - (opponent.getBaseDefense() - 0.2)); // dmg = dmg - (basedef - 1.2) * dmg
            opponentDebuff.put("Fulmine", false);
        }
        if (playerDebuff.get("Intimorito")) {
            playerDebuff.put("Intimorito", false);
            damage -= 20;
        }

        if (Math.random() * 100 > accuracy) {
            damage = 0;
            System.out.println("Hai mancato il nemico!");
        }
        if (playerDebuff.get("Melma") && damage > 0) {
            if (Math.random() < 0.1) {
                damage = 0;
                System.out.println("La melma ti rallenta e il nemico riesce a schivare!");
            }
        }

        opponent.setHealthPoints(opponent.getHealthPoints() - (int) damage);
        if (damage > 0)
            System.out.println("Hai inflitto " + damage + " danni!");
        if (bloodVial) {
            gameSession.setHealthPoints(gameSession.getHealthPoints() + (int) damage / 5);
        }

    }

    public void setOpponent(Enemy opponent) {
        this.opponent = opponent;
    }

    public Enemy getOpponent() {
        return opponent;
    }

    public void addOpponentDebuff(String debuff) {
        opponentDebuff.put(debuff, true);
    }

    public void addPlayerDebuff(String debuff) {
        playerDebuff.put(debuff, true);
    }

    public void removeOpponentDebuff(String debuff) {
        opponentDebuff.put(debuff, false);
    }

    public void removePlayerDebuff(String debuff) {
        playerDebuff.put(debuff, false);
    }

    public void setCantMissStatus(int cantMissStatus) {
        this.cantMissStatus = cantMissStatus;
    }

    public int getCantMissStatus() {
        return cantMissStatus;
    }

    public Map<String, Boolean> getOpponentDebuff() {
        return opponentDebuff;
    }

    public Map<String, Boolean> getPlayerDebuff() {
        return playerDebuff;
    }

    public void setOpponentDebuff(Map<String, Boolean> opponentDebuff) {
        this.opponentDebuff = opponentDebuff;
    }

    public void setPlayerDebuff(Map<String, Boolean> playerDebuff) {
        this.playerDebuff = playerDebuff;
    }

    public int getBurnCounter() {
        return burnCounter;
    }

    public void setBurnCounter(int burnCounter) {
        this.burnCounter = burnCounter;
    }

    public int getPlayerPoisonCounter() {
        return playerPoisonCounter;
    }

    public void setPlayerPoisonCounter(int poisonCounter) {
        this.playerPoisonCounter = poisonCounter;
    }

    public int getCurseCounter() {
        return curseCounter;
    }

    public void setCurseCounter(int curseCounter) {
        this.curseCounter = curseCounter;
    }

    public void setOpponentPoisonCounter(int i) {
        this.opponentPoisonCounter = i;
    }

}
