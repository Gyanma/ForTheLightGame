package com.mapproject.resources.items;

import java.util.List;

enum SpawnOdds {
    SINGLE, DOUBLE, TRIPLE
}

enum Weight {
    LIGHT, MEDIUM, HEAVY
}

enum Damage {
    LOW, MEDIUM, HIGH
}

enum Accuracy {
    LOW, MEDIUM, HIGH

}

enum Usage {
    THROW_FIRE, SWING
}

public class Weapon extends Item {

    private int usage;

    private int damage;

    private int weight;

    private int accuracy;

    public Weapon(int id) {
        super(id);
    }

    public Weapon(int id, String name, String description, List<String> alias,
            int spawnOdds1, int spawnOdds2, int spawnOdds3,
            boolean pickupable, boolean throwable,
            int usage, int damage, int weight, int accuracy) {
        super(id, name, description, alias, spawnOdds1, spawnOdds2, spawnOdds3, pickupable, throwable);

    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public void setDamage(int damage) throws Exception {
        if (damage < 4 && damage > 0) {
            this.damage = damage;
        } else {
            throw new Exception("Damage must be between 1 and 3");
        }

    }

    public int getDamage() throws Exception {
        return this.damage;
    }

    public void setWeight(int weight) throws Exception {
        if (weight < 4 && weight > 0) {
            this.weight = weight;
        } else {
            throw new Exception("Weight must be between 1 and 3");
        }

    }

    public int getWeight() throws Exception {
        return this.weight;
    }

    public void setAccuracy(int accuracy) throws Exception {
        if (accuracy < 4 && accuracy > 0) {
            this.accuracy = accuracy;
        } else {
            throw new Exception("Accuracy must be between 1 and 3");
        }

    }

    public int getAccuracy() throws Exception {
        return this.accuracy;
    }
}
