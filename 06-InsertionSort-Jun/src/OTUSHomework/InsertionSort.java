package OTUSHomework;

public class InsertionSort {
    int [] A;

    public InsertionSort(int[] arr) {
        A = arr;
    }

    public void sort() {
        int N = A.length;

        for(int i = 1; i < N; ++i) {
            for(int j = i - 1; j >= 0 && A[j] > A[j + 1]; j--) {
                swap(j, j + 1);
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
