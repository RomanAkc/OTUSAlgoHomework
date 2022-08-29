package OTUSHomework;

import java.util.ArrayList;
import java.util.Collections;

public class ShellSort extends BaseSort {
    public ShellSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        int N = A.length;

        for(int gap = N/2; gap > 0; gap /=2) {
            for(int i = gap; i < N; i++) {
                for(int j = i; j >= gap && A[j - gap] > A[j]; j -= gap)
                    swap(j - gap, j);
            }
        }
    }

    public void sort_Sedgewick() {
        int N = A.length;
        ArrayList<Integer> gaps = getGapsSedgewick();

        for(int gap : gaps) {
            for(int i = gap; i < N; i++) {
                for(int j = i; j >= gap && A[j - gap] > A[j]; j -= gap)
                    swap(j - gap, j);
            }
        }

    }

    private ArrayList<Integer> getGapsSedgewick() {
        int N = A.length;

        ArrayList<Integer> gaps = new ArrayList<>();
        for(int k = 0; ; k++) {
            int gap;
            if(k % 2 == 0)
                gap = (int)(9 * (Math.pow(2, k) - Math.pow(2, k / 2)) + 1);
            else
                gap = (int)(8 * Math.pow(2, k) - 6 * Math.pow(2, (k + 1) / 2 ) + 1);

            if(gap < N)
                gaps.add(gap);
            else
                break;
        }

        Collections.reverse(gaps);
        return gaps;
    }
}
