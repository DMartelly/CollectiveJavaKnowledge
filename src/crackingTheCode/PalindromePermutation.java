package crackingTheCode;

/**
 * Created by Dominick Martelly on 2/6/2017 at 10:03 PM.
 *
 * @author Dominick Martelly
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Tact Coa"));
    }

    private static boolean isPalindrome(String s) {
        if (s.length() == 0){
            return false;
        }
        char[] myCharArr = s.toLowerCase().toCharArray();
        int[] counter = new int[26];
        for (char a: myCharArr) {
            if (a >= 'a' && a <= 'z')
                counter[a - 'a']++;
        }
        boolean first = false;
        for (int i: counter){
            if (i % 2 == 1){
                if (first){
                    return false;
                } else {
                    first = !first;
                }
            }
        }
        return true;
    }
}
