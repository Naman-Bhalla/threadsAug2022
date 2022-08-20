package threads.producerconsumersemaphore;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Queue<Shirt> store = new ConcurrentLinkedDeque<>();
        int maxSizeOfStore = 20;

        Semaphore semaForProducer = new Semaphore(maxSizeOfStore);
        Semaphore semaForConsumer = new Semaphore(0);

        Producer p1 = new Producer(store, maxSizeOfStore, "p1", semaForProducer, semaForConsumer);
        Producer p2 = new Producer(store, maxSizeOfStore, "p2", semaForProducer, semaForConsumer);
        Producer p3 = new Producer(store, maxSizeOfStore, "p3", semaForProducer, semaForConsumer);

        Consumer c1 = new Consumer(store, "c1", semaForProducer, semaForConsumer);
        Consumer c2 = new Consumer(store, "c2", semaForProducer, semaForConsumer);
        Consumer c3 = new Consumer(store, "c3", semaForProducer, semaForConsumer);
        Consumer c4 = new Consumer(store, "c4", semaForProducer, semaForConsumer);

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
        new Thread(c4).start();

    }
}
