package org.hunter.threads;

public class Producer extends Thread {

    public static void main(String[] args) {
        Buffer<String> buffer = new Buffer<>(100);

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Buffer<String> buffer = null;

    public Producer(Buffer<String> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            int counter = buffer.size();
            buffer.add(String.valueOf(counter));
            System.out.println("Produced " + counter);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
