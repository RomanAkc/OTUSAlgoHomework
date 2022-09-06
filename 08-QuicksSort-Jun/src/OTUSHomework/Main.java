package OTUSHomework;

public class Main {

    public static void main(String[] args) {
        int iMax = (int)Math.pow(10, 8);
        for(int i = 10; i <= iMax; i *= 10) {
            int[] A = generateRandomArray(i);

            QuickSort quick = new QuickSort(A.clone());
            System.out.println("Quick sort of " + A.length + " elements is " + testSortTime(quick) + " ms ");

            MergeSort merge = new MergeSort(A.clone());
            System.out.println("Merge sort of " + A.length + " elements is " + testSortTime(merge) + " ms ");
        }
    }

    static private int[] generateRandomArray(int size) {
        int[] A = new int[size];
        for(int i = 0; i < size; ++i) {
            A[i] = (int)(Math.random() * size);
        }
        return A;
    }

    static private long testSortTime(BaseSort sortObj) {
        long start = System.currentTimeMillis();
        sortObj.sort();
        return System.currentTimeMillis() - start;
    }

    static private boolean checkArrayIsSorted(int[] A) {
        int N = A.length;
        for(int i = 1; i < N; i++) {
            if(A[i] < A[i - 1])
                return  false;
        }
        return true;
    }
}
