package OTUSHomework;

public class QuickSort extends BaseSort {

    public QuickSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        int N = A.length;
        internal_sort(0, N - 1);
    }

    private void internal_sort(int L, int R) {
        if(L >= R)
            return;

        int M = split(L, R);

        internal_sort(L, M - 1);
        internal_sort(M + 1, R);
    }

    private int split(int L, int R) {
        int pivot = A[R];
        int M = L - 1;

        for(int j = L; j <= R; j++) {
            if(A[j] <= pivot)
                swap(++M, j);
        }

        return M;
    }
}
