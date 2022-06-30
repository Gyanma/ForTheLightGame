package com.mapproject.operations.visualHandler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class VisualHandler {

    public static int selectVisual(int visualId) throws Exception {
        if (visualId == 1 || visualId == 2 || visualId == 3 || visualId == 4) {
            return buildQueueVisual(visualId);
        } else {
            throw new Exception("Visual not found");
        }

    }

    public static int buildQueueVisual(int i) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1024);

        VisualProducer producer = new VisualProducer(queue, i);
        VisualConsumer consumer = new VisualConsumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        try {
            while (consumer.returnedValue == -2) { // -2 is the default value
                Thread.sleep(10);

            }
            return consumer.getReturnedValue();
        } catch (InterruptedException e) {

            e.printStackTrace();
            return consumer.getReturnedValue();
        }

    }

}
