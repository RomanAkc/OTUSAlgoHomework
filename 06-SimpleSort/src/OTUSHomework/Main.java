package OTUSHomework;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000, 1000000, 10000000};
        for(int size : sizes) {
            System.out.println("Size = " + size);

            int[] A = generateRandomArray(size);

            if(size <= 100000) {
                BaseSort bubble = new BubbleSort(A.clone());
                System.out.println("Bubble sort = " + testSortTime(bubble));

                BaseSort insertion = new InsertionSort(A.clone());
                System.out.println("Insertion sort = " + testSortTime(insertion));
            }

            BaseSort shell = new ShellSort(A.clone());
            System.out.println("Shell sort = " + testSortTime(shell));
        }
    }

    static private int[] generateRandomArray(int size) {
        int[] A = new int[size];
        for(int i = 0; i < size; ++i) {
            A[i] = (int)(Math.random() * 50);
        }
        return A;
    }

    static private long testSortTime(BaseSort sortObj) {
        long start = System.currentTimeMillis();
        sortObj.sort();
        return System.currentTimeMillis() - start;
    }
}
