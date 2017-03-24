package Fibonacci;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author Dominick Martelly
 */
public class Fibonacci {

    /**
     * Returns the fib number using dynamic programming
     *
     * @param x the fib number
     * @return the fib number at location x
     */
    public static long fib1(int x) {
        if (x < 0)
            throw new IndexOutOfBoundsException("Number must be natural");
        if (x <= 2)
            return 1;

        long[] f = new long[3];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < x; i++) {
            f[2] = f[1] + f[0];
            f[0] = f[1];
            f[1] = f[2];
        }
        return f[2];
    }

    /**
     * Returns the fib number in O(n^2)
     *
     * @param x the fib number
     * @return the fib number at position x
     */
    public static long fib2(int x) {
        if (x < 0)
            throw new IndexOutOfBoundsException("Number must be natural");
        if (x <= 2)
            return 1;
        return fib2(x - 1) + fib2(x - 2);
    }

    /**
     * Calculates the nth Fibonacci number in O(log n) time
     *
     * @param x which Fibonacci number
     * @return the nth Fibonacci number
     */
    public static long fib3(int x) {
        if (x < 0)
            throw new IndexOutOfBoundsException("Number must be natural");
        if (x <= 2)
            return 1;

        // Must use 2D array (Pascal's Triangle)
        // **Please note: I did use some help from the internet to explain how
        // to solve the fib sequence with a O(log(n)) approach**
        long[][] r =
                {
                        {
                                1, 0
                        },
                        {
                                0, 1
                        }
                };
        long[][] save =
                {
                        {
                                1, 1
                        },
                        {
                                1, 0
                        }
                };

        while (x > 0) {
            if (x % 2 == 1) { //If odd
                long a = r[0][0] * save[0][0] + r[0][1] * save[1][0];
                long b = r[0][0] * save[0][1] + r[0][1] * save[1][1];
                long c = r[1][0] * save[0][0] + r[1][1] * save[0][1];
                long d = r[1][0] * save[0][1] + r[1][1] * save[1][1];

                r[0][0] = a;
                r[0][1] = b;
                r[1][0] = c;
                r[1][1] = d;
            }

            x = x / 2;

            long a = save[0][0] * save[0][0] + save[0][1] * save[1][0];
            long b = save[0][0] * save[0][1] + save[0][1] * save[1][1];
            long c = save[1][0] * save[0][0] + save[1][1] * save[0][1];
            long d = save[1][0] * save[0][1] + save[1][1] * save[1][1];

            save[0][0] = a;
            save[0][1] = b;
            save[1][0] = c;
            save[1][1] = d;

        }
        return r[1][0];
    }

    public static void main(String[] args) {
        long startTime, endTime;
        long fib1, fib2, fib3;
        long fib1Time, fib2Time, fib3Time;
        int x;

        System.out.println("Input a number");
        Scanner in = new Scanner(System.in);
        x = in.nextInt();

        startTime = System.nanoTime();
        fib1 = fib1(x);
        endTime = System.nanoTime();
        fib1Time = (endTime - startTime);

        startTime = System.nanoTime();
        fib2 = 0;//fib2(x);
        endTime = System.nanoTime();
        fib2Time = (endTime - startTime);

        startTime = System.nanoTime();
        fib3 = fib3(x);
        endTime = System.nanoTime();
        fib3Time = (endTime - startTime);

        NumberFormat f = new DecimalFormat("#0.0000");

        System.out.println("Fibonacci of fib1: " + fib1
                + "\nRunning Time: " + f.format(fib1Time / 1000000d) + " Milliseconds\n");

        System.out.println("Fibonacci of fib2: " + fib2
                + "\nRunning Time: " + f.format(fib2Time / 1000000d) + " Milliseconds\n");

        System.out.println("Fibonacci of fib3: " + fib3
                + "\nRunning Time: " + f.format(fib3Time / 1000000d) + " Milliseconds\n");
    }
}
