package com.mapproject.resources.items;

import java.util.List;

public class Item {

    private final int id;
    private String name;
    private String description;
    private List<String> alias;

    private boolean pickupable = true;
    private boolean throwable = true;
    private boolean used = false;

    private String manualDescription;

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name, String description, List<String> alias,
            String manualDescription) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.alias = alias;
        this.manualDescription = manualDescription;
        this.pickupable = true;
        this.throwable = true;
        this.used = false;
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

    public String getManualDescription() {
        return manualDescription;
    }

    public void setManualDescription(String manualDescription) {
        this.manualDescription = manualDescription;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
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
