package fractal;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = number();
        BigInteger result = BigInteger.ONE;
        final int FACTORIAL = start(number);
        int step = FACTORIAL / number;
        try {
            Result[] results = new Result[number];
            Thread[] threads = new Thread[number];

            for (int i = 0; i < number; i++) {
                results[i] = new Result();
            }

            if (number == FACTORIAL) {
                results = calculateIfStepEqualsFactorial(number, FACTORIAL, results, threads);
            } else {
                results = calculateFactorial(number, step, FACTORIAL, results, threads);
            }

            for (int i = 0; i < number; i++) {
                threads[i].join();
            }

            for (int i = 0; i < number; i++) {
                BigInteger calculation = results[i].getValue();
                result = result.multiply(calculation);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }

    static Thread runThreat(BigInteger start, BigInteger end, Result result1) {
        Factorial factorial1 = new Factorial(start, end, result1);

        Thread thread = new Thread(factorial1);
        thread.start();
        return thread;
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

    static Result[] calculateIfStepEqualsFactorial(int number, int FACTORIAL, Result[] results, Thread[] threads) {
        int start = FACTORIAL;
        int end;
        for (int i = 0; i < number; i++) {
            end = start;
            threads[i] = runThreat(BigInteger.valueOf(start), BigInteger.valueOf(end), results[i]);
            start--;
        }
        return results;
    }

    static Result[] calculateFactorial(int number, int step, int FACTORIAL, Result[] results, Thread[] threads) {
        int start = FACTORIAL;
        int end;
        for (int i = 0; i < number; i++) {
            if (i == number - 1) {
                end = 1;
            } else end = FACTORIAL - (i + 1) * step;
            threads[i] = runThreat(BigInteger.valueOf(start), BigInteger.valueOf(end), results[i]);
            start = end - 1;
        }
        return results;
    }
}
