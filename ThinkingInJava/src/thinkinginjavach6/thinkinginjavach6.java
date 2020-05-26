package thinkinginjavach6;

import java.util.Arrays;

/**
 *
 * @author AKravchuk
 */
public class thinkinginjavach6 {
    public static void main(String[] args) {
        int[] arr1 = Range.range(11);
        System.out.println(Arrays.toString(arr1));
        
        int[] arr2 = Range.range(11, 21);
        System.out.println(Arrays.toString(arr2));
        
        int[] arr3 = Range.range(2, 21, 2);
        System.out.println(Arrays.toString(arr3));
    }
}

class Range {
    //[0..n]
    public static int[] range(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;
    }
    
    //[start..end]
    public static int[] range(int start, int end) {
        int count = end - start;
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = start + i;
        }
        return result;
    }
    
    //[start..end, step]
    public static int[] range(int start, int end, int step) {
        int count = (end - start) / step;
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = start + (i * step);
        }
        return result;
    }
}