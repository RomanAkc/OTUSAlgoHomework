package OTUSHomework;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5,2,0,8,1,3,6,7,4,9};
        BubbleSort objSort = new BubbleSort(arr);
        objSort.sort();
        System.out.println(Arrays.toString(arr));
    }
}
