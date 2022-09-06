package OTUSHomework;

public class MergeSort extends BaseSort {
    public MergeSort(int[] arr) {
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

        int M = (R + L) / 2;

        internal_sort(L, M);
        internal_sort(M + 1, R);

        merge(L, M, R);
    }

    void merge(int L, int M, int R) {
        int[] Tmp = new int[R - L + 1];

        int a = L;
        int b = M + 1;
        int t = 0;

        while(a <= M && b <= R) {
            if(A[a] < A[b])
                Tmp[t++] = A[a++];
            else
                Tmp[t++] = A[b++];
        }

        while(a <= M)
            Tmp[t++] = A[a++];

        while (b <= R)
            Tmp[t++] = A[b++];

        for(int i = L; i <=R; ++i)
            A[i] = Tmp[i - L];
    }
}
