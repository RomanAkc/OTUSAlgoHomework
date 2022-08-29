package OTUSHomework;

public class BubbleSort {
    private final int[] A;

    public BubbleSort(int[] array) {
        A = array;
    }

    public void sort() {
        int N = A.length;
        for(int i = 1; i < N; ++i) {
            for(int j = 0; j < N - i; ++j) {
                if(A[j] > A[j+1])
                    swap(j, j+1);
            }
        }
    }

    private void swap(int L, int R) {
        int tmp = A[L];
        A[L] = A[R];
        A[R] = tmp;
    }
}
