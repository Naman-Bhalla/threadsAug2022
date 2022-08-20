package threads.addersubtractorsynchronizedmethod;

import java.util.concurrent.Semaphore;

public class Count {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public synchronized void incrementValue(int offset) {
        this.value += offset;
        //lockForA.lock()
        // lockForB.lock()
        // lockForC.lock()

        

//        int currentValue = this.value;
//        int nextValue = currentValue + offset;
//        try {
//            Thread.sleep(50);
//        } catch (Exception e) {
//            System.out.println("Something wrong happened");
//        }
//        this.value = nextValue;
    }

}
