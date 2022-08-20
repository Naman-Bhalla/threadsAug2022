package threads.producerconsumer;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Shirt> store = new ArrayDeque<>();
        int maxSizeOfStore = 20;

        Producer p1 = new Producer(store, maxSizeOfStore, "p1");
        Producer p2 = new Producer(store, maxSizeOfStore, "p2");
        Producer p3 = new Producer(store, maxSizeOfStore, "p3");

        Consumer c1 = new Consumer(store, "c1");
        Consumer c2 = new Consumer(store, "c2");
        Consumer c3 = new Consumer(store, "c3");
        Consumer c4 = new Consumer(store, "c4");

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
        new Thread(c4).start();

    }
}
