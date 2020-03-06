/*
 * Input:
 * "babad"
 * Output:
 * "bab" or "aba"
 */
package longestpalindromicsubstring;

/**
 *
 * @author AKravchuk
 */
public class LongestPalindromicSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(longestPalindromic("babad"));  // aba
        System.out.println(longestPalindromic("bacad"));  // aca
        System.out.println(longestPalindromic("abba"));  // abba
        
        System.out.println(longestPalindromic2("babad"));  // bab
        System.out.println(longestPalindromic2("bacad"));  // aca
        System.out.println(longestPalindromic2("abba"));  // abba
    }
    
    
    public static String longestPalindromic(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len -1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end+ 1);
    }
    
    static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    public static String longestPalindromic2(String s) {
        if (s == null || s.length() < 1) return "";
        String result = "";
        int index = 0;
        while (index < s.length()) {
            for (int i = index + 1; i < s.length(); i++) {
               String temp = s.substring(index, i + 1); 
               if (isPolindrom(temp) && (result.length() < temp.length())) {
                   //System.out.println(temp); 
                   result = temp;
                }
            }
            index++;
        }
        return result;
    }
    
    static boolean isPolindrom(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String s1 = new String(sb);
        //System.out.println(s + " " + s1);
        return s.equals(s1);
    }
    
}
