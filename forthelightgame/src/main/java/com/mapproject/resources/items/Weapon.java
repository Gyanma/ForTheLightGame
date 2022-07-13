package com.mapproject.resources.items;

public class Weapon extends Item {

    private int usage;
    private double damage;
    private double agility;
    private double accuracy;

    public Weapon(int id) {
        super(id);
    }

    public Weapon(int id, String name, String nameWithDetArticle, String nameWithIndetArticle,
            String description, String manualDescription,
            int usage, double damage, double agility, double accuracy) {
        super(id, name, nameWithDetArticle, nameWithIndetArticle, description, manualDescription);
        this.usage = usage;
        this.damage = damage;
        this.agility = agility;
        this.accuracy = accuracy;

    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getDamage() {
        return this.damage;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getAgility() {
        return this.agility;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getAccuracy() {
        return this.accuracy;
    }
}
