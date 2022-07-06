package com.mapproject;

import com.mapproject.operations.AddToArchive;
import com.mapproject.operations.MapBuilder;
import com.mapproject.operations.jframes.MysticalMap;
import com.mapproject.resources.Map;
import com.mapproject.resources.events.VisualPuzzle;

public final class App {

    public App() {

    }

    public static void main(String[] args) {
        AddToArchive.addPacificEncounter();

        // Puzzle puzzle = new Puzzle("Puzzle 1", "Puzzle 1", 3, 3, "Puzzle 1");
        // checkPuzzle(puzzle);

    }

    public static void checkMap() {
        Map mainMap;
        mainMap = new MapBuilder().createMap(1);

        int rand = (int) (Math.random() * mainMap.getVisitableRooms().size());
        int counter = 0;
        int current = 0;
        for (int i : mainMap.getVisitableRooms()) {

            if (counter == rand) {
                current = i;
            }
            counter++;
        }
        MysticalMap.main(mainMap, current);
    }

    public static void checkPuzzle(VisualPuzzle puzzle) {
        System.out.println(puzzle.loadPuzzle());

    }
}
