package threads.addersubtractor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) {
        Count count = new Count();
        Lock lockForCount = new ReentrantLock();


        Adder adder = new Adder(count, lockForCount);
        Subtractor subtractor = new Subtractor(count, lockForCount);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(adder);
        executor.execute(subtractor);

        executor.shutdown();
        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Something wrong happened");
        }

        System.out.println(count.getValue());
    }
}
