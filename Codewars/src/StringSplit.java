
import java.util.Arrays;

/*
Complete the solution so that it splits the string into pairs of two characters. 
If the string contains an odd number of characters then it should replace the 
missing second character of the final pair with an underscore ('_').

Examples:

StringSplit.solution("abc") // should return {"ab", "c_"}
StringSplit.solution("abcdef") // should return {"ab", "cd", "ef"}
 */

public class StringSplit {
    
    public static String[] solution(String s) {
        if (s.length() % 2 == 1)
            s = s + "_";
        int steps = s.length() / 2;
        String[] result = new String[steps];
        for (int i = 0; i < steps; i++) {
            result[i] = "" + s.charAt(i * 2) + s.charAt(1 + i * 2);
        }
        return result;
    }
    
    public static String[] solution2(String s) {
        s = (s.length() % 2 == 0) ? s : s + "_";
        return s.split("(?<=\\G.{2})");
    }

    public static String[] solution3(String s) {
        char[] chars = s.toCharArray();
        int steps = 0;
        boolean odd;
        if (chars.length % 2 == 0){
            steps = chars.length - 1;
            odd = false;
        }
        else {
            steps = chars.length;
            odd = true;
        }
        final int SIZE;
        if (odd)
            SIZE = s.length()/2 + 1;
        else
            SIZE = s.length()/2;
        String[] results = new String[SIZE];
        int position = 0;
        for (int i = 0; i <= steps; i += 2) {
            String temp;
            if (odd && i == steps - 1)
                temp = "" + chars[i] + "_";
            else
                temp = "" + chars[i] + chars[i + 1];
            results[position] = temp;
            position++;
        }
        return results;
    }
    
    public static void main(String[] args) {
        String[] test1 = StringSplit.solution("abcdef");
        String[] test2 = StringSplit.solution("HelloWorld");
        String[] test3 = StringSplit.solution("abcde");
        String[] test4 = StringSplit.solution("LovePizza");
        
        for (String s : test1)
            System.out.print(s + " ");
        
        System.out.println();
        
        for (String s : test2)
            System.out.print(s + " ");
        
        System.out.println();
        
        for (String s : test3)
            System.out.print(s + " ");
        
        System.out.println();
        
        for (String s : test4)
            System.out.print(s + " ");
    }
}
