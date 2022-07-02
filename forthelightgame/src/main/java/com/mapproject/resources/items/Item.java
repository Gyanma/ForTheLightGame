package com.mapproject.resources.items;

import java.util.List;

public class Item {

    private final int id;

    private String name;

    private String description;

    private List<String> alias;

    private int spawnOddPhase1;

    private int spawnOddPhase2;

    private int spawnOddPhase3;

    private boolean pickupable = true;

    private boolean throwable = true;

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name, String description, List<String> alias,
            int spawnOdds1, int spawnOdds2, int spawnOdds3,
            boolean pickupable, boolean throwable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.alias = alias;
        this.spawnOddPhase1 = spawnOdds1;
        this.spawnOddPhase2 = spawnOdds2;
        this.spawnOddPhase3 = spawnOdds3;
        this.pickupable = pickupable;
        this.throwable = throwable;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSpawnOddPhase1(int spawnOdds1) {
        this.spawnOddPhase1 = spawnOdds1;
    }

    public int getSpawnOddPhase1() {
        return spawnOddPhase1;
    }

    public void setSpawnOddPhase2(int spawnOdds2) {
        this.spawnOddPhase2 = spawnOdds2;
    }

    public int getSpawnOddPhase2() {
        return spawnOddPhase2;
    }

    public void setSpawnOddPhase3(int spawnOdds3) {
        this.spawnOddPhase3 = spawnOdds3;
    }

    public int getSpawnOddPhase3() {
        return spawnOddPhase3;
    }

    public boolean isPickupable() {
        return pickupable;
    }

    public void setPickupable(boolean pickupable) {
        this.pickupable = pickupable;
    }

    public boolean isThrowable() {
        return throwable;
    }

    public void setThrowable(boolean throwable) {
        this.throwable = throwable;
    }

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    public void addAlias(String alias) {
        this.alias.add(alias);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
