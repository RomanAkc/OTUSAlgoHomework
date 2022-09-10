package OTUSHomework;

public class Main {

    public static void main(String[] args) {
        int iMax = (int)Math.pow(10, 8);
        for(int i = 100; i <= iMax; i *= 10) {
            int[] A = generateRandomArray(i);

            CountingSort counting = new CountingSort(A.clone());
            System.out.println("Counting sort of " + A.length + " elements is " + testSortTime(counting) + " ms ");
            System.out.println("Array is " + (checkArrayIsSorted(counting.getArray()) ? "sorted" : "not sorted"));

            RadixSort radix = new RadixSort(A.clone());
            System.out.println("Radix sort of " + A.length + " elements is " + testSortTime(radix) + " ms ");
            System.out.println("Array is " + (checkArrayIsSorted(radix.getArray()) ? "sorted" : "not sorted"));

            BucketSort bucket = new BucketSort(A.clone());
            System.out.println("Bucket sort of " + A.length + " elements is " + testSortTime(bucket) + " ms ");
            System.out.println("Array is " + (checkArrayIsSorted(bucket.getArray()) ? "sorted" : "not sorted"));
        }
    }

    static private int[] generateRandomArray(int size) {
        int[] A = new int[size];
        for(int i = 0; i < size; ++i) {
            A[i] = (int)(Math.random() * 1000000);
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
