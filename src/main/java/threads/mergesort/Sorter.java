package threads.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public Sorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        int n = arrayToSort.size();

        if (n <= 1) {
            return arrayToSort;
        }

        int mid = n/ 2;   // 0 -> 0 ; 1 -> 0; 2 -> 1; 3 -> 1

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for (int i = 0; i < mid; ++i) {
            leftArray.add(arrayToSort.get(i));
        }

        for (int i = mid; i < n; ++i) {
            rightArray.add(arrayToSort.get(i));
        }

        Sorter leftSorter = new Sorter(leftArray, executorService);
        Sorter rightSorter = new Sorter(rightArray, executorService);


        Future<List<Integer>> leftSortedFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightSortedFuture = executorService.submit(rightSorter);

        List<Integer> leftSorted = leftSortedFuture.get();
        List<Integer> rightSorted = rightSortedFuture.get();

        List<Integer> answer = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < leftSorted.size() && j < rightSorted.size()) {
            if (leftSorted.get(i) <= rightSorted.get(j)) {
                answer.add(leftSorted.get(i));
                ++i;
            } else {
                answer.add(rightSorted.get(j));
                ++j;
            }
        }

        while (i < leftSorted.size()) {
            answer.add(leftSorted.get(i));
            i++;
        }

        while (j < rightSorted.size()) {
            answer.add(rightSorted.get(j));
            j++;
        }

        return answer;
    }
}
