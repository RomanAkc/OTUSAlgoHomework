package OTUSHomework;

public class RecursiveFib {
    long FindFib(int N) {
        if(N == 0)
            return 0;

        if(N == 1)
            return 1;

        return FindFib(N - 1) + FindFib(N - 2);
    }
}
