package threads.producerconsumer;

import java.util.Queue;

public class Producer implements Runnable {
    private Queue<Shirt> store;
    private int maxSizeOfStore;
    private String name;

    public Producer(Queue<Shirt> store, int maxSizeOfStore, String name) {
        this.store = store;
        this.maxSizeOfStore = maxSizeOfStore;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (store.size() < maxSizeOfStore) {
                store.add(new Shirt());
                System.out.println(name + " produced. Left shirts count = " + store.size());
            }
        }
    }
}
