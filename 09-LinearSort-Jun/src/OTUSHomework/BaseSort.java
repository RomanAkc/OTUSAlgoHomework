package OTUSHomework;

public abstract class BaseSort {
    int[] A;

    public BaseSort(int[] arr) {
        A = arr;
    }
    public int[] getArray() { return A; }

    public abstract void sort();

    protected void swap(int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    protected int findMaxElement() {
        int max = A[0];
        for(int i = 1; i < A.length; ++i) {
            if(A[i] > max)
                max = A[i];
        }
        return  max;
    }
}
