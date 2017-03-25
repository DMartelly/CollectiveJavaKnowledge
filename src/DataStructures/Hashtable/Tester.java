package DataStructures.Hashtable;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Dominick Martelly on 3/25/2017 at 1:51 AM.
 *
 * @author Dominick Martelly
 */
public class Tester {
    public static void main(String[] args) {
        final int MAX = 20;
        Random r = new Random();

        //Create int array a
        int[] a = new int[30];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(MAX);
        }
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(MyHashTable.removeDuplicates(a, MAX)));
    }
}
