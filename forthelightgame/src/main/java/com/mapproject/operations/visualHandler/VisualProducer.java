package com.mapproject.operations.visualHandler;

import java.util.concurrent.BlockingQueue;

import com.mapproject.operations.jframes.Puzzle33333;
import com.mapproject.operations.jframes.PuzzleCombCrip;
import com.mapproject.operations.jframes.PuzzleZeri;

public class VisualProducer implements Runnable {
    protected BlockingQueue<Integer> queue = null;

    int visualId;

    public VisualProducer(BlockingQueue<Integer> queue, int visualId) {
        this.queue = queue;
        this.visualId = visualId;
    }

    public void run() {
        switch (this.visualId) {
            case 1:
                Puzzle33333 puzzle3 = new Puzzle33333();
                puzzle3.setVisible(true);
                try {

                    while (puzzle3.getSolved() == -1) {
                        Thread.sleep(50);
                    }
                    this.queue.put(puzzle3.getSolved());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
            case 2:
                PuzzleCombCrip puzzleCC = new PuzzleCombCrip();
                puzzleCC.setVisible(true);
                try {

                    while (puzzleCC.getSolved() == -1) {
                        Thread.sleep(50);
                    }
                    this.queue.put(puzzleCC.getSolved());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
            case 3:
                PuzzleZeri puzzleZ = new PuzzleZeri();
                puzzleZ.setVisible(true);
                try {

                    while (puzzleZ.getSolved() == -1) {
                        Thread.sleep(50);
                    }
                    this.queue.put(puzzleZ.getSolved());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            default:
                System.out.println("Visual not found");
                break;
        }

    }
}
