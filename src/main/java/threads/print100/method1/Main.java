package threads.print100.method1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 100; ++i) {
            if (i == 50) {
                System.out.println("Wait");
            }

            PrintNumber printNumber = new PrintNumber(i);

            Thread thread = new Thread(printNumber);
            thread.start();

            threads.add(thread);
        }
    }
}
