package sorting;

import java.util.Arrays;

/**
 * A class containing the MergeSort method.
 * To merge Sorting, each element must be in its own array. Then each array is
 * sorted into a new list. So for an array of 8 elements, we have 8 arrays
 * with 1 element each sorted, then 4 arrays with 2 elements each sorted, then
 * eventually 1 array with 8 elements sorted
 * <p>
 * See https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html
 *
 * @author Dominick Martelly
 */
public class MergeSort {

    private int[] array;
    private int[] tempMergeArr;
    private int length;

    public static void main(String[] argc) {
        int[] A = {3, 2, 1, 4};

        InsertionSort.Sort(A);

        System.out.println(Arrays.toString(A));
    }

    /**
     * Merge sorts an array
     *
     * @param inputArr The array to be sorted
     */
    public void mergeSort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergeArr = new int[length];
        doMergeSort(0, length - 1);
    }

    /**
     * @param lowerIndex  The start index value
     * @param higherIndex The end index value
     */
    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergeArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergeArr[i] <= tempMergeArr[j]) {
                array[k] = tempMergeArr[i];
                i++;
            } else {
                array[k] = tempMergeArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergeArr[i];
            k++;
            i++;
        }
    }
}
