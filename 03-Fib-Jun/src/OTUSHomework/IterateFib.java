package OTUSHomework;

public class IterateFib {
    long FindFib(int N) {
        if(N == 0)
            return 0;

        if(N == 1)
            return 1;

        long FN_2 = 0;
        long FN_1 = 1;
        long FN = 0;

        for(int i = 2; i <= N; ++i) {
            FN = FN_1 + FN_2;
            FN_2 = FN_1;
            FN_1 = FN;
        }

        return FN;
    }
}
