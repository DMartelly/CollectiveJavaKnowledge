package DataStructures.Hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dominick Martelly on 9/15/2016 at 1:22 PM.
 *
 * @author Dominick Martelly
 */
public class MyHashTable {
    static Integer[] removeDuplicates(int[] input, int maxVal) {
        List<Integer> new_a = new ArrayList<>();
        int[] myTable = new int[maxVal];
        for (int i : input) {
            myTable[i]++;
        }
        for (int i1 = 0; i1 < myTable.length; i1++) {
            if (myTable[i1] != 0) {
                new_a.add(i1);
            }
        }
        return new_a.toArray(new Integer[0]);
    }
}
