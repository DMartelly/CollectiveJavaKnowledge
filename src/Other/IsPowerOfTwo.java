package other;

/**
 * Created by Dominick Martelly on 2/7/2017 at 12:12 PM.
 *
 * @author Dominick Martelly
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(64));
        System.out.println(isPowerOf2(55));
        System.out.println(isPowerOf2(16));
        System.out.println(isPowerOf2(8));
        System.out.println(isPowerOf2(9));
    }

    static boolean isPowerOf2(int num){
        return 0 == (num & (num - 1));
    }
}
