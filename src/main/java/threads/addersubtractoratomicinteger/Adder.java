package threads.addersubtractoratomicinteger;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 100; ++i) {
            count.getValue().getAndAdd(i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("Something wrong happened");
            }
        }

    }
}
