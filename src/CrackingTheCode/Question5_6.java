package CrackingTheCode;

/**
 * Created by Dominick Martelly on 2/9/2017 at 2:50 AM.
 *
 * @author Dominick Martelly
 */
public class Question5_6 {
    public static void main(String[] args) {
        System.out.println(Conversion(45, 27));
    }

    private static int Conversion(int a, int b) {
        int ans = 0;
        int c = a ^ b;
        while (c > 0){
            //if a and b share the same last bit
            c = c & (c-1);
            ans++;
        }
        return ans;
    }
}
