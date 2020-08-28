
import java.util.Arrays;

/*
Write a function, persistence, that takes in a positive parameter num and returns
its multiplicative persistence, which is the number of times you must multiply the digits in num until you reach a single digit.

For example:

 persistence(39) == 3 // because 3*9 = 27, 2*7 = 14, 1*4=4
                      // and 4 has only one digit

 persistence(999) == 4 // because 9*9*9 = 729, 7*2*9 = 126,
                       // 1*2*6 = 12, and finally 1*2 = 2

 persistence(4) == 0 // because 4 is already a one-digit number
 */
public class PersistentBugger {

    public static int persistence(long n) {
        int result = 0;
        String num_str = Long.toString(n);
        while (num_str.length() > 1) {
            int temp = 1;
            for (int i = 0; i < num_str.length(); i++) {
                temp *= Integer.valueOf("" + num_str.charAt(i));
            }
            num_str = Integer.toString(temp);
            result++;
        }
        return result;
    }

    public static int persistence2(long n) {
        long m = 1, r = n;

        if (r / 10 == 0) {
            return 0;
        }

        for (r = n; r != 0; r /= 10) {
            m *= r % 10;
        }

        return persistence(m) + 1;

    }

    public static void main(String[] args) {
        System.out.println(PersistentBugger.persistence(39));
        System.out.println(PersistentBugger.persistence(999));
        System.out.println(PersistentBugger.persistence(4));
        System.out.println(PersistentBugger.persistence(25));
        
        System.out.println(PersistentBugger.persistence2(39));
        System.out.println(PersistentBugger.persistence2(999));
        System.out.println(PersistentBugger.persistence2(4));
        System.out.println(PersistentBugger.persistence2(25));
    }
}
