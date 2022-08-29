package OTUSHomework;

public class IterateFib {
    long FindFib(int N) {
        if(N == 0)
            return 0;

        if(N == 1)
            return 1;

        //N-2 -е число Фибоначчи
        long FN_2 = 0;

        //N-1 -е число Фибоначчи
        long FN_1 = 1;

        //N -е число Фибоначчи
        long FN = 0;

        for(int i = 2; i <= N; ++i) {
            FN = FN_1 + FN_2;

            //Для последующих итераций:
            //Записываем в N-1 -е число - число Фибоначчи рассчитанное на текущем шаге
            //А в N-2 -е число - бывшее  N-1 -е.
            FN_2 = FN_1;
            FN_1 = FN;
        }

        return FN;
    }
}
