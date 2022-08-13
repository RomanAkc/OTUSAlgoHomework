package OTUSHomework;

public class IterateExp {
    double Exp(double d, int degree) {
        if(degree == 0)
            return 1;

        if(degree == 1)
            return d;

        double res = d;
        for(int i = 2; i <= degree; ++i) {
            res *= d;
        }

        return res;
    }
}
