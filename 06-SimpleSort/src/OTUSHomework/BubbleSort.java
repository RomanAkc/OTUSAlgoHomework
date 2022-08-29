package OTUSHomework;

public class BubbleSort extends BaseSort{

    public BubbleSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        int N = A.length;

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < N - i; ++j) {
                if(A[j] > A[j + 1])
                    swap(j, j + 1);
            }
        }
    }
}
