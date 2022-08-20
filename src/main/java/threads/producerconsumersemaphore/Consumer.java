package threads.producerconsumersemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Shirt> store;
    private String name;
    private Semaphore semaForProducer;
    private Semaphore semaForConsumer;

    public Consumer(Queue<Shirt> store, String name, Semaphore semaForProducer, Semaphore semaForConsumer) {
        this.store = store;
        this.name = name;
        this.semaForConsumer = semaForConsumer;
        this.semaForProducer = semaForProducer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaForConsumer.acquire();
                store.remove();
                System.out.println(name + " consumed. Left shirts count = " + store.size());
                semaForProducer.release();
            } catch (Exception e) {
                throw new RuntimeException(e + Integer.toString(store.size()) + semaForProducer.toString() + semaForConsumer.toString());
            }
        }
    }
}
