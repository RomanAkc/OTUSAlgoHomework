package OTUSHomework;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5,2,0,8,1,3,6,7,4,9};
        SelectionSort objSort = new SelectionSort(arr);
        objSort.sort_optimize();
        System.out.println(Arrays.toString(arr));
    }
}
