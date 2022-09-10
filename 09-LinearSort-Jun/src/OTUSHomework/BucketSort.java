package OTUSHomework;

import java.util.ArrayList;

public class BucketSort extends BaseSort {
    public BucketSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        int N = A.length;

        int max = findMaxElement();

        //T - temp array with buckets
        ArrayList<Integer>[] T = new ArrayList[N];
        for(int i = 0; i < N; ++i) {
            int index = (int)(((double)A[i] / (double)(max + 1)) * (double)N);
            if(T[index] == null)
                T[index] = new ArrayList<>();
            T[index].add(A[i]);
        }

        //move elements from T to A
        int k = 0;
        for(int i = 0; i < N; ++i) {
            if(T[i] == null)
                continue;

            for(int j = 0; j < T[i].size(); ++j)
                A[k++] = T[i].get(j);
        }
    }
}
