package OTUSHomework;

public class InsertionSort extends BaseSort {
    public InsertionSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        int N = A.length;

        for(int i = 1; i < N; ++i) {
            for(int j = i - 1; j >= 0 && A[j] > A[j + 1]; j--) {
                swap(j, j + 1);
            }
        }
    }
}
