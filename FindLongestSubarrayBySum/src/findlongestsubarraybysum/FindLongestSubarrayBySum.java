/*
 * arr = [1, 2, 3, 7, 5]
 * s = 12  (2 + 3 + 7)
 * r = [2, 4] (с второго по четвертый)
*/

package findlongestsubarraybysum;

import java.util.Arrays;

/**
 *
 * @author AKravchuk
 */
public class FindLongestSubarrayBySum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        System.out.println(Arrays.toString(findLongestSubarrayBySum(arr, 12))); // [2, 3, 7]
        System.out.println(Arrays.toString(findLongestSubarrayBySum(arr, 14))); // [-1]
        System.out.println(Arrays.toString(findLongestSubarrayBySum(arr, 17))); // [1, 2, 7, 5]
        
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr3 = {1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(findLongestSubarrayBySum(arr2, 15))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(findLongestSubarrayBySum(arr3, 15))); // [1, 2, 3, 4, 5, 0, 0, 0]
        
        System.out.println(Arrays.toString(findLongestSubarrayBySum2(12, arr))); // [2, 4]
        System.out.println(Arrays.toString(findLongestSubarrayBySum2(14, arr))); // [-1]
        System.out.println(Arrays.toString(findLongestSubarrayBySum2(17, arr))); // [2, 5]
        System.out.println(Arrays.toString(findLongestSubarrayBySum2(15, arr2))); // [1, 5]
        System.out.println(Arrays.toString(findLongestSubarrayBySum2(15, arr3))); // [1, 8]
        
    }
    
    public static int[] findLongestSubarrayBySum(int[] arr, int sum) {
        int start = 0, finish = 0;
        int result;
        int difference = 0;
        for (int i = 0; i < arr.length; i++) {
            result = arr[i];
            for (int j = 1 + i; j < arr.length; j++) {
                result += arr[j];
                if (result == sum && (j - i) > difference) {
                    start = i;
                    finish = j;
                    difference = finish - start;
                }
            }
        }
        if (difference == 0) return new int[] {-1};
//         int[] subarr = Arrays.copyOfRange(arr, start, finish + 1);
//         return subarr;
        return new int[] {start + 1, finish + 1};
    }
    
    public static int[] findLongestSubarrayBySum2(int s, int[] arr) {
        int[] result = new int[] {-1};
        
        int sum = 0;
        int left = 0;
        int right = 0;
        
        while (right < arr.length) {
            sum += arr[right];
            while (left < right && sum > s) {
                sum -= arr[left++];
            }
            if (sum == s && (result.length == 1 || result[1] - result[0] < right - left)){
                result = new int[] {left + 1, right + 1};
            }
            right++;
        }
        return result;
    }
    
}
