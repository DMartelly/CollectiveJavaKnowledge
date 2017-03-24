package DataStructures.Hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Dominick Martelly on 9/15/2016 at 1:22 PM.
 *
 * @author Dominick Martelly
 */
public class removeDuplicates {
    public static void main(String arg[]) {
        final int MAX = 80;
        Random r = new Random();

        //Create int array a
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(MAX);
        }
        System.out.println(Arrays.toString(a));

        //Create a hast table, counting the elements of a
        int[] hashTable = new int[MAX];
        for (int i : a) {
            hashTable[i]++;
        }
        System.out.println(Arrays.toString(hashTable));

        //Make a new array
        ArrayList<Integer> new_a = new ArrayList<>();
        int count = 0;
        for (int i : hashTable) {
            if (i != 0) {
                new_a.add(count);
            }
            count++;
        }

        System.out.println(new_a.toString());
    }
}
