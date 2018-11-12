package fractal;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Factorial implements Callable {

    BigInteger num;
    BigInteger end;

    public Factorial(BigInteger num, BigInteger end) {
        this.num = num;
        this.end = end;
    }

    @Override
    public BigInteger call() throws Exception {
        BigInteger fact = fact(num, end);
        return fact;
    }

    private BigInteger fact(BigInteger start, BigInteger end) {
        if (start.equals(end))
            return end;
        else {
            return start.multiply(fact(start.subtract(BigInteger.ONE), end));
        }

    }
}
