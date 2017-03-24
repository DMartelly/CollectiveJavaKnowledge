package CrackingTheCode;

/**
 * Created by Dominick Martelly on 2/9/2017 at 2:18 AM.
 *
 * @author Dominick Martelly
 */
public class Question5_3 {
    public static void main(String[] args) {
        System.out.println(FlipBitToWin(0b11011101111010101));
        //System.out.println(FlipBitToWin(1775));
    }

    private static int FlipBitToWin(int num) {
        if (num < 0) {
            return -1;
        }
        int max = 0;
        int curr = 0, next = 0;

        while (num % 2 == 1) {
            curr++;
            num >>= 1;
        }
        max = curr;
        num >>= 1;
        while (num > 0) {
            if (num % 2 == 1) {
                next++;
            } else {
                if (curr + next + 1 > max){
                    max = curr + next + 1;
                }
                curr = next;
                next = 0;
            }
            num >>= 1;
        }
        return max;
    }
}
