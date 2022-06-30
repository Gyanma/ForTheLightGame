package com.mapproject;

import com.mapproject.operations.MapBuilder;

import com.mapproject.resources.events.VisualPuzzle;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        checkMap();

        // Puzzle puzzle = new Puzzle("Puzzle 1", "Puzzle 1", 3, 3, "Puzzle 1");
        // checkPuzzle(puzzle);

    }

    public static void checkMap() {
        new MapBuilder().createMap(1);

    }

    public static void checkPuzzle(VisualPuzzle puzzle) {
        System.out.println(puzzle.loadPuzzle());

    }
}
