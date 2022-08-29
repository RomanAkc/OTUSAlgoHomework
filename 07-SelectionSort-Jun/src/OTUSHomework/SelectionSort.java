package OTUSHomework;

public class SelectionSort {
    int [] A;

    public SelectionSort(int[] arr) {
        A = arr;
    }

    void sort() {
        int N = A.length;

        for(int i = 1; i < N; ++i) {
            for(int j = i - 1; j >= 0 && A[j] > A[j + 1]; j--)
                swap(j, j + 1);
        }
    }

    void sort_optimize() {
        int N = A.length;

        int j;
        for(int i = 1; i < N; ++i) {
            int K = A[i];
            for(j = i - 1; j >= 0 && A[j] > A[j + 1]; j--)
                swap(j, j + 1);
            A[j + 1] = K;
        }
    }

    void swap(int L, int R) {
        int tmp = A[L];
        A[L] = A[R];
        A[R] = tmp;
    }
}
