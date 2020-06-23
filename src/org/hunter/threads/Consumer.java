package org.hunter.threads;

public class Consumer extends Thread {

    private Buffer<String> buffer;

    public Consumer(Buffer<String> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            String s = buffer.getAndRemove();
            System.out.println("Consumed " + s);
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
