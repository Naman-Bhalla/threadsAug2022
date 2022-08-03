package threads.print100.method2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {

    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 100; ++i) {
            if (i == 50) {
                System.out.println("Wait");
            }

            PrintNumber printNumber = new PrintNumber(i);
            executor.execute(printNumber);
        }
        ((ExecutorService) executor).shutdown();
    }
}

// Break till 10:27 PM
// After Break:
// Thread Pools
// Callables: Implement Multi Threaded Merge Sort