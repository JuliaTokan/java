package fractal;

import java.math.BigInteger;

public class Factorial implements Runnable {

    BigInteger num;
    BigInteger end;
    Result result;

    public Factorial(BigInteger num, BigInteger end, Result result) {
        this.num = num;
        this.end = end;
        this.result = result;
    }

    @Override
    public void run() {
        BigInteger fact = fact(num, end);
        result.setValue(fact);
    }

    private BigInteger fact(BigInteger start, BigInteger end) {
        if (start.equals(end))
            return end;
        else{
            try {
                Thread.sleep(50);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            return start.multiply(fact(start.subtract(BigInteger.ONE),end));
        }

    }
}
