package OTUSHomework;

public class PrimeEnumeration {
    long CountPrimes(long N) {
        long counter = 0;
        for(long i = 2; i <= N; ++i) {
            if(isPrime(i))
                counter++;
        }
        return counter;
    }

    private boolean isPrime(long N) {
        if(N == 2)
            return true;

        if(N % 2 == 0)
            return  false;

        for(long j = 2; j < N; ++j) {
            if(N % j == 0)
                return false;
        }

        return true;
    }
}
