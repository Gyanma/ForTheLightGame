package com.mapproject.resources.items;

import java.util.ArrayList;
import java.util.List;

public class Chest {
    private boolean openable = true;

    private boolean open = false;

    private List<Item> content = new ArrayList<>(); // register contents of chest

    private int counter; // register number of items in chest

    public Chest(boolean openable, boolean open, List<Item> content, int counter) {
        setOpenable(openable);
        setOpen(open);
        setContent(content);
        setCounter(counter);

    }

    public boolean isOpenable() {
        return openable;
    }

    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<Item> getContent() {
        return content;
    }

    public void setContent(List<Item> content) {
        this.content = content;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
