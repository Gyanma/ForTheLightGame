package com.mapproject.operations.visualHandler;

import java.util.concurrent.BlockingQueue;

public class VisualConsumer implements Runnable {
    protected BlockingQueue<Integer> queue = null;

    int returnedValue = -2;

    public VisualConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            returnedValue = (int) queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getReturnedValue() {
        return returnedValue;
    }
}
