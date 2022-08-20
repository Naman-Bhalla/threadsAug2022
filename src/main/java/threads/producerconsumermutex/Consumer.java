package threads.producerconsumermutex;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Shirt> store;
    private String name;

    public Consumer(Queue<Shirt> store, String name) {
        this.store = store;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (store) {
                if (store.size() > 0) {
                    store.remove();
                    System.out.println(name + " consumed. Left shirts count = " + store.size());
                }
            }
        }
    }
}
