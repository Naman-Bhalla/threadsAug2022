package threads.print100.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 100; ++i) {
            if (i == 4 || i == 8 || i == 15 || i == 50) {
                System.out.println("Wait");
            }

            PrintNumber printNumber = new PrintNumber(i);
            executor.execute(printNumber);

//            List<Integer> ints = new ArrayList<>();
        }
    }
}

// Break till 10:27 PM
// After Break:
// Thread Pools
// Callables: Implement Multi Threaded Merge Sort