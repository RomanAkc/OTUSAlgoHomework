package OTUSHomework;

public abstract class BaseSort {
    int[] A;

    public BaseSort(int[] arr) {
        A = arr;
    }

    public abstract void sort();

    protected void swap(int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
