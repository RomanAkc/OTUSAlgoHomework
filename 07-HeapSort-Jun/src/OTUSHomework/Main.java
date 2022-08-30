package OTUSHomework;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] A = {9,8,7,6,5,4,3,2,1};
        HeapSort hs = new HeapSort(A);
        hs.sort();
        System.out.println(Arrays.toString(A));
    }
}
