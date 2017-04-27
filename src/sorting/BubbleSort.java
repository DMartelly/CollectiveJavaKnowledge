package sorting;

import java.util.Random;

/**
 * Created by Dominick Martelly on 5/31/2016.
 * <p>
 * The bubble sorting algorithm
 */
public class BubbleSort {

    private static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int numberOfSwaps = 0;

            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    numberOfSwaps++;
                }
            }

            if (numberOfSwaps == 0) {
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int sizeOfArray = 10;
        int maxInt = 50;

        if (args.length == 2) {
            sizeOfArray = Integer.valueOf(args[0]);
            maxInt = Integer.valueOf(args[1]);
        }

        int[] randomArray = new int[sizeOfArray];
        Random r = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = r.nextInt(maxInt);
        }
        System.out.println("The random array");
        for (int i : randomArray) {
            System.out.print(i + " ");
        }
        System.out.print("\n\n");

        randomArray = bubbleSort(randomArray);

        System.out.println("After bubble Sorting");
        for (int i : randomArray)
            System.out.print(i + " ");
    }
}
