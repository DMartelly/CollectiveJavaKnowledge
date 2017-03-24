package Parallelism;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dominick Martelly on 4/20/2016 at 4:48 PM.
 *
 * @author Dominick Martelly
 */
public class main {
    public static void main(String[] arg) throws InterruptedException {
        final int PATHS = 2, SIZE = 10;

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of available Processors: " + processors);

        int[][] a = new int[SIZE][SIZE];
        Random random = new Random();
        int val;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                val = random.nextInt(2);
                if (i != j) {
                    a[i][j] = a[j][i] = val;
                }
            }
        }

        System.out.println("Random Adjacency Matrix");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        //Parallelism
        ParallelMultiplyMatrix r1 = new ParallelMultiplyMatrix(a);
        double startTime, endTime;
        startTime = System.nanoTime();
        ExecutorService pool;
        for (int c = 0; c < PATHS - 1; c++) {
            pool = Executors.newFixedThreadPool(processors);
            for (int i = 0; i < processors; i++)
                pool.execute(r1);
            pool.shutdown();
            pool.awaitTermination(5, TimeUnit.SECONDS);
        }
        endTime = System.nanoTime();
        System.out.println("\nTotal Time in Milliseconds: " + ((endTime - startTime) /1000000));
        System.out.println("Multiplied Matrix");
        int[][] b = r1.getResultMatrix();
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
