package OTUSHomework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int arr[] = {9,8,7,6,5,4,3,2,1};

        InsertionSort obj = new InsertionSort(arr);
        obj.sort();

        System.out.println(Arrays.toString(arr));
    }
}
