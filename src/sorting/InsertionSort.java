package sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * See (https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html)
 *
 * @author Dominick Martelly
 */
public class InsertionSort {

    public static int[] Sort(int[] A)
    {
        // If the array is larger than size one
        if (A.length > 1)
        {
            int[] newArray = new int[A.length];
            newArray[0] = A[0];
            
            // O(n), since we are going though each array element
            for (int current = 1; current < A.length; current++)
            {
                int i = current;
                newArray[i] = A[i];
                
                // Worst Case is O(n log(n)) if each element is less than the previous
                // array element
                while ((i != 0) && (newArray[i] < newArray[i - 1]))
                {
                    int temp = newArray[i];
                    newArray[i] = newArray[i - 1];
                    newArray[i - 1] = temp;
                    i--;
                }
            }
            return newArray;
        }
        // If the array is size one, then it is already sorted
        else
            return A;
    }

    public static void main(String[] argc)
    {
        final int N = 10000;
        Random R = new Random();
        int[] A = new int[N];
        int[] B = new int[N];
        
        long startTime, endTime;
        
        for (int i = 0; i < N; i++)
        {
            A[i] = R.nextInt(N);
        }
        
        System.out.println("A = " + Arrays.toString(A));
        
        startTime = System.nanoTime();
        B = Sort(A);
        endTime = System.nanoTime();
        long InsertionSortTime = endTime - startTime;
        
        startTime = System.nanoTime();
        B = Sort(A);
        endTime = System.nanoTime();
        long JavaSortTime = endTime - startTime;

        System.out.println("B = " + Arrays.toString(B));
        System.out.println("Sorting took " + 
                (InsertionSortTime / 1.0e6) + " milliseconds\n");
        
        System.out.println("B = " + Arrays.toString(B));
        System.out.println("Sorting took " + 
                (JavaSortTime / 1.0e6) + " milliseconds");
    }
}
