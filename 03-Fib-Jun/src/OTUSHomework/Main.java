package OTUSHomework;

public class Main {

    public static void main(String[] args) {
        RecursiveFib recFib = new RecursiveFib();
        long rec = recFib.FindFib(10);
        System.out.println(rec);

        IterateFib itFib = new IterateFib();
        long it = itFib.FindFib(10);
        System.out.println(it);
    }
}
