package crackingTheCode;

/**
 * Binary to String: Given a real number between 8 and 1 (e.g., 0.72) that is passed in as a double,
 * print the binary representation. If the number cannot be represented accurately in binary with at
 * most 32 characters, print "ERROR:'
 *
 * @author Dominick Martelly
 */
public class Question5_2 {
    public static void main(String[] args) {
        System.out.println(BinToStr(0.125));
    }

    private static String BinToStr(double f){
        if (f >= 1 || f <= 0) {
            return "ERROR";
        }

        StringBuilder s = new StringBuilder();
        s.append(".");

        while(f > 0){
            if (s.length() >= 32){
                return "ERROR";
            }

            double r = f * 2;
            if (r >= 1) {
                s.append(1);
                f = r - 1;
            } else {
                s.append(0);
                f = r;
            }
        }

        return s.toString();
    }
}
