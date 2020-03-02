/*
 * Given a string? sort it in decreasing order based on frequency of characters
 * Example 1:
 * Input:
 *  "tree"
 * Output:
 *  "eert"
 *
 * Example 2:
 * Input:
 *  "cccaaa"
 * Output:
 *  "cccaaa" or "aaaccc"
 *
 * Example 3:
 * Input:
 *  "Aabb"
 * Output:
 *  "bbAa" or "bbaA"
 */
package sortstring;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author AKravchuk
 */
public class SortString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(frequencySort("tree")); // eert
        System.out.println(frequencySort("cccaaa")); // aaaccc
        System.out.println(frequencySort("Aabb"));  // bbAa
    }
    
    public static String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        if (s == null || s.length() == 0) {
            return result.toString();
        }
        
        Map<Character, Integer> charCount = new HashMap();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        //PriorityQueue<Character> maxHeap = new PriorityQueue((a, b) -> charCount.get(a) - charCount.get(b));
        // меняем порядок постройки слов
        PriorityQueue<Character> maxHeap = new PriorityQueue((a, b) -> charCount.get(b) - charCount.get(a));
        for (char c : charCount.keySet()) {
            maxHeap.add(c);
        }
        
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.remove();
            int count = charCount.get(current);
            for (int i = 0; i < count; i++) {
                result.append(current);
            }
        }
        return result.toString();
    }
    
}
