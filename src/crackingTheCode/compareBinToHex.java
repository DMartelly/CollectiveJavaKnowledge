package crackingTheCode;

/**
 * Suppose you were asked to write a function to check if the value of a binary number (passed as a string)
 * equals the hexadecimal representation of a string. (pg 90)
 *
 * @author Dominick Martelly
 */
public class compareBinToHex {
    public static void main(String arg[]) {
        System.out.println(compareBinToHex("1110", "e"));
        System.out.println(compareBinToHex("101", "5"));
        System.out.println(compareBinToHex("111", "f"));
    }

    private static boolean compareBinToHex(String binary, String hex) {
        int a = getIntFromBool(binary);
        int b = getIntFromHex(hex);
        return !(a < 0 || b < 0) && a == b;
    }

    private static int getIntFromHex(String hex) {
        int ans = 0;
        long mul = 1;
        for (int i = hex.length()-1; i >= 0; i--){
            int c = digitToHexValue(hex.substring(i, i + 1));
            ans += mul * c;
            mul *= 16;
        }
        return ans;
    }

    private static int getIntFromBool(String binary) {
        int ans = 0;
        long mul = 1;
        for (int i = binary.length() - 1; i >= 0; i--) {
            int c = digitToHexValue(binary.substring(i, i + 1));
            if (c != 0 && c != 1){
                return -1;
            }
            ans += mul * c;
            mul *= 2;
        }
        return ans;
    }

    private static int digitToHexValue(String s) {
        switch(s){
            case "a":
                return 10;
            case "b":
                return 11;
            case "c":
                return 12;
            case "d":
                return 13;
            case "e":
                return 14;
            case "f":
                return 15;
            default:
                return Integer.parseInt(s);
        }
    }
}
