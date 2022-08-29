package OTUSHomework;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] arr = {5,1,0,8,9,6,4,2,7,3};
        ShellSort obj = new ShellSort(arr);
        obj.sort_Sedgewick();
        System.out.println(Arrays.toString(arr));
    }
}
