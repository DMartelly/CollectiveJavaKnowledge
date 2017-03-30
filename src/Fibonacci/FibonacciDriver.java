/**
 * 
 */
package Fibonacci;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author Dominick
 *
 */
public class FibonacciDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime, endTime;
        long fib1, fib2, fib3;
        long fib1Time, fib2Time, fib3Time;

        System.out.println("Input a number");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        in.close();

        startTime = System.nanoTime();
        fib1 = Fibonacci.fib1(x);
        endTime = System.nanoTime();
        fib1Time = (endTime - startTime);

        startTime = System.nanoTime();
        fib2 = Fibonacci.fib2(x);
        endTime = System.nanoTime();
        fib2Time = (endTime - startTime);

        startTime = System.nanoTime();
        fib3 = Fibonacci.fib3(x);
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
