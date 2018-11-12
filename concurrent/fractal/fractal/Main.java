package fractal;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        for (; ; ) {
            int choice = choice();
            switch (choice) {
                case 1:
                    calculate();
                    break;
                case 0:
                    return;
            }
        }
    }

    static void calculate() {
        int number = number();
        BigInteger result = BigInteger.ONE;
        final int FACTORIAL = start(number);
        int step = FACTORIAL / number;
        List<Future<BigInteger>> results = new ArrayList<Future<BigInteger>>();
        ExecutorService executor = Executors.newFixedThreadPool(number);

        try {
            if (number == FACTORIAL) {
                results = calculateIfStepEqualsFactorial(number, FACTORIAL, executor, results);
            } else {
                results = calculateFactorial(number, step, FACTORIAL, executor, results);
            }

            for (Future<BigInteger> res : results) {
                try {
                    result = result.multiply(res.get());
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println(result);
    }

    static int number() {
        System.out.println("Enter a number of threads:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }

    static int start(int number) {
        Scanner scanner = new Scanner(System.in);
        int start;
        for (; ; ) {
            System.out.println("Enter a number of factorial:");
            start = scanner.nextInt();
            if (number <= start)
                break;
        }
        return start;
    }

    static int choice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter:\n1-Calculate factofial;\n0-Exit;");
        return scanner.nextInt();
    }

    static List<Future<BigInteger>> calculateIfStepEqualsFactorial(int number, int FACTORIAL, ExecutorService executor, List<Future<BigInteger>> results) {
        int start = FACTORIAL;
        int end;
        for (int i = 0; i < number; i++) {
            end = start;
            Future<BigInteger> future = executor.submit(new Factorial(BigInteger.valueOf(start), BigInteger.valueOf(end)));
            results.add(future);
            start--;
        }
        return results;
    }

    static List<Future<BigInteger>> calculateFactorial(int number, int step, int FACTORIAL, ExecutorService executor, List<Future<BigInteger>> results) {
        int start = FACTORIAL;
        int end;
        for (int i = 0; i < number; i++) {
            if (i == number - 1) {
                end = 1;
            } else end = FACTORIAL - (i + 1) * step;
            Future<BigInteger> future = executor.submit(new Factorial(BigInteger.valueOf(start), BigInteger.valueOf(end)));
            results.add(future);
            start = end - 1;
        }
        return results;
    }
}
