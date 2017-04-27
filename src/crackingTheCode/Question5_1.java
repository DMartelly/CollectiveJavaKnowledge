package crackingTheCode;

/**
 * Created by Dominick Martelly on 2/8/2017 at 7:37 PM.
 *
 * @author Dominick Martelly
 */
public class Question5_1 {
    public static void main(String[] args) {
        System.out.printf("Answer: %16s\n", Integer.toBinaryString(insertion(0b10110100001, 0b10011, 2, 7)).replace(" ", "0"));
    }

    private static int insertion(int n, int m, int i, int j) {
        System.out.println("N:" + Integer.toBinaryString(n).replace(" ", "0"));
        int allOnes = ~0;
        System.out.println(Integer.toBinaryString(allOnes).replace(" ", "0"));
        int left = allOnes << (j +1);
        System.out.println(Integer.toBinaryString(left).replace(" ", "0"));
        int right = ((1 << i) - 1);
        System.out.println(Integer.toBinaryString(right).replace(" ", "0"));
        int mask = left | right;
        System.out.println(Integer.toBinaryString(mask).replace(" ", "0"));
        n = n & mask;
        System.out.println("N:" + Integer.toBinaryString(n).replace(" ", "0"));

        //Sign Extend M
        System.out.println("M:" + Integer.toBinaryString(m).replace(" ", "0"));
        m = m << i;
        System.out.println("M:" + Integer.toBinaryString(m).replace(" ", "0"));
        return n | m;
    }
}
