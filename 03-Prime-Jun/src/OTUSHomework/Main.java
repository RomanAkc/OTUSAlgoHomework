package OTUSHomework;

public class Main {

    public static void main(String[] args) {
        PrimeEnumeration primes = new PrimeEnumeration();
        long res = primes.CountPrimes(100000);
        System.out.println(res);
    }
}
