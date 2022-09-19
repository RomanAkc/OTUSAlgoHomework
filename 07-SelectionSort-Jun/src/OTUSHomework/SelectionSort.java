package OTUSHomework;

public class SelectionSort {
    int [] A;

    public SelectionSort(int[] arr) {
        A = arr;
    }

    void sort() {
        int N = A.length;

        int max = findMax(N);
        for(int i = N - 1; i > 0; --i) {
            swap(max, i);
            max = findMax(i);
        }
    }

    int findMax(int N) {
        int max = 0;
        for(int i = 1; i < N; i++) {
            if(A[i] > A[max])
                max = i;
        }
        return max;
    }

    void swap(int L, int R) {
        int tmp = A[L];
        A[L] = A[R];
        A[R] = tmp;
    }
}
