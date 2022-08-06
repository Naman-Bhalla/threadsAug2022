package threads.addersubtractorsynchronizedobject;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 100; ++i) {
            synchronized (count) {  // lockForCount.lock()
                System.out.println("Adder has gthe lock " + i);
                int currentValue = count.getValue();
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    System.out.println("Something wrong happened");
                }
                int nextValue = currentValue + i;
                count.setValue(nextValue);
                System.out.println("Adder has unlocked " + i);
            }
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("Something wrong happened");
            }
        }

    }
}
