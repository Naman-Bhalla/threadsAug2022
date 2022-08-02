package threads.mergesort;

import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = List.of(
                23, 21, 27, 19, 44, 33
        );

        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(arrayToSort, executorService);

        Future<List<Integer>> sortedArrayFuture =
                executorService.submit(sorter);

        List<Integer> sortedArray = sortedArrayFuture.get();

        for (Integer ints: sortedArray) {
            System.out.println(ints);
        }

    }
}
