/*
 * Imput type - String
 * Input string contain only lowercase English letters
 * Input string length 1 <= N <= 100000
 */

package firstnonrepeatingcharacter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AKravchuk
 */
public class FirstNonRepeatingCharacter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String st1 = "aaabcccdeeef";
        String st2 = "abcbad";
        String st3 = "abcabcabc";
        
        char fast_ch = fast(st1);
        System.out.println(fast_ch);
        
        fast_ch = fast(st2);
        System.out.println(fast_ch);
        
        fast_ch = fast(st3);
        System.out.println(fast_ch);
        
        fast_ch = fast2(st1);
        System.out.println(fast_ch);
        
        fast_ch = fast2(st2);
        System.out.println(fast_ch);
        
        fast_ch = fast2(st3);
        System.out.println(fast_ch);
        
        char ch = firstNonRepeatingCharacter(st1);
        System.out.println(ch);
        
        ch = firstNonRepeatingCharacter(st2);
        System.out.println(ch);
        
        ch = firstNonRepeatingCharacter(st3);
        System.out.println(ch);
            
        String f_ch = firstNonRepeatingCharacter2(st1);
        System.out.println(f_ch);
        
        f_ch = firstNonRepeatingCharacter2(st2);
        System.out.println(f_ch);
        
        f_ch = firstNonRepeatingCharacter2(st3);
        System.out.println(f_ch);
        
        char first_ch = firstNonRepeatingCharacter3(st1);
        System.out.println(first_ch);
        
        first_ch = firstNonRepeatingCharacter3(st2);
        System.out.println(first_ch);
        
        first_ch = firstNonRepeatingCharacter3(st3);
        System.out.println(first_ch);
        
    }
    
    public static char fast(String data) {
        int[] char_counts = new int[26];

        for (char c : data.toCharArray()) {
            char_counts[c - 'a']++;
        }
        
        for (char c : data.toCharArray()) {
            if (char_counts[c - 'a'] == 1) {
                return c;
            }
        }
        return '_';
    }
    
    public static char fast2(String data) {

        for (int i = 0; i < data.length(); ++i) {
            if (data.indexOf(data.charAt(i)) == data.lastIndexOf(data.charAt(i))){
                return data.charAt(i);
            }
        }

        return '_';
    }
    
    public static char firstNonRepeatingCharacter(String data) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < data.length(); ++i) {
            char c = data.charAt(i);
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }
        for (int i = 0; i < data.length(); ++i) {
            char c = data.charAt(i);
            if (charMap.get(c) == 1) return c;
        }
        return '_';
    }
    
    
    public static String firstNonRepeatingCharacter2(String data) {
        String ch = "";
        char[] chars = data.toCharArray();
        Map<String, Integer> charMap = new HashMap<>();

        for (char c : chars) {
            String st = String.valueOf(c);
            if (!charMap.containsKey(st)) {
                charMap.put(st, 1);
            }
            else {
                charMap.put(st, charMap.get(st) + 1);
            }
        }

        charMap.entrySet().forEach((entry) -> {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
            
        });
        
        for (Map.Entry<String, Integer> entry : charMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1) {
                ch = key;
                break;
            }
        }
        if (ch == "") {
            return "Non repeated character not found";
        }
        return ch;
    }
    
    public static char firstNonRepeatingCharacter3(String data) {
        for (int i = 0; i < data.length(); ++i) {
            boolean seenDuplicate = false;
            for (int j = 0; j < data.length(); ++j) {
                if (data.charAt(i) == data.charAt(j) && (i != j)) {
                    seenDuplicate = true;
                    break;
                }
            }
            if (!seenDuplicate) return data.charAt(i);
        }
        return '_';
    }
        
}
