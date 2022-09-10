package OTUSHomework;

public class CountingSort extends BaseSort{
    public CountingSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        int maxElement = findMaxElement();
        //index of D is element in A
        int[] D = new int[maxElement + 1]; //+1 because we need use maxElement as index

        int N = A.length;

        //counting elements
        for(int i = 0; i < N; ++i) {
            D[A[i]]++;
        }

        //write cumulative sum to D elements
        int sum = 0;
        for(int i = 0; i < D.length; ++i) {
            sum += D[i];
            D[i] = sum;
        }

        //write sorted elements to temp array
        int [] T = new int[N];
        for(int i = N - 1; i >= 0; i--) {
            T[--D[A[i]]] = A[i];
        }

        //move elements from temp array to A
        for(int i = 0; i < N; i++) {
            A[i] = T[i];
        }
    }
}
