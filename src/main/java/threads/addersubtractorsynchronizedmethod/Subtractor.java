package threads.addersubtractorsynchronizedmethod;

public class Subtractor implements Runnable {
    private Count count;

    public Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10000; ++i) {
            System.out.println("Subtractor has the lock " + i);

//            synchronized (count) {
                count.incrementValue(-i);
//            }
            System.out.println("Subtractor has unlocked " + i);

//            try {
//                Thread.sleep(10);
//            } catch (Exception e) {
//                System.out.println("Something wrong happened");
//            }

        }

    }
}
