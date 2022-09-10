package OTUSHomework;

public class RadixSort extends BaseSort {
    public RadixSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        int N = A.length;

        int max = findMaxElement();

        int digit = 1;
        while((max / digit) > 0) {
            //use counting sort to sort by digit
            int[] D = new int[10];

            //counting elements
            for(int i = 0; i < N; ++i) {
                D[getNumberDigit(A[i], digit)]++;
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
                T[--D[getNumberDigit(A[i], digit)]] = A[i];
            }

            //move elements from temp array to A
            for(int i = 0; i < N; i++) {
                A[i] = T[i];
            }

            digit *= 10;
        }
    }

    private int getNumberDigit(int num, int numberDigit) {
        //(789 / 1) % 10 = 9
        //(789 / 10) % 10 = 8
        //(789 / 100) % 10 = 7
        //...
        return (num / numberDigit) % 10;
    }
}
