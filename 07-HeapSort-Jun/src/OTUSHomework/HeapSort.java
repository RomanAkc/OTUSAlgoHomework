package OTUSHomework;

public class HeapSort {
    int[] A;

    public HeapSort(int[] a) {
        A = a;
    }

    public void sort() {
        int N = A.length;

        for(int i = N/2; i < N; i++)
            heapify(i, N);

        for(int j = N - 1; j > 0; j--) {
            swap(0, j);
            heapify(0, j);
        }
    }

    private void heapify(int pos, int size) {
        int X = pos;
        int L = 2 * X + 1;
        int R = 2 * X + 2;

        if(L < size && A[L] > A[X]) X = L;
        if(R < size && A[R] > A[X]) X = R;

        if(pos == X)
            return;

        swap(pos, X);
        heapify(X, size);
    }

    private void swap(int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
