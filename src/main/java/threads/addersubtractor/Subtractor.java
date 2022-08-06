package threads.addersubtractor;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {
    private Count count;
    private Lock lockForCount;

    public Subtractor(Count count, Lock lockForCount) {
        this.count = count;
        this.lockForCount = lockForCount;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 100; ++i) {
            lockForCount.lock();
            System.out.println("Subtractor has the lock " + i);
            int currentValue = count.getValue();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println("Something wrong happened");
            }

            int nextValue = currentValue - i;
            count.setValue(nextValue);
            System.out.println("Subtractor has unlocked " + i);
            lockForCount.unlock();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("Something wrong happened");
            }

            for (int j = 0; j < 10000; ++j) {
                // do something
            }
        }

    }
}
