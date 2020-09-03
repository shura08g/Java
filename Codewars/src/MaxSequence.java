/*
The maximum sum subarray problem consists in finding the maximum sum of a 
contiguous subsequence in an array or list of integers:

Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
// should be 6: {4, -1, 2, 1}
Easy case is when the list is made up of only positive numbers and the maximum 
sum is the sum of the whole array. If the list is made up of only negative 
numbers, return 0 instead.

Empty list is considered to have zero greatest sum. Note that the empty list or 
array is also a valid sublist/subarray.
 */

public class MaxSequence {

    public static int sequence(int[] arr) {
        int cur = 0, max = 0;
        for (int i : arr) {
            cur = Math.max(0, cur + i);
            max = Math.max(max, cur);
        }
        return max;
    }

    public static int sequence2(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = i + 1; j < arr.length; j++) {
                temp = sum(arr, i, j);
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    static int sum(int[] arr, int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(MaxSequence.sequence(new int[]{}));  //0
        System.out.println(MaxSequence.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));  //6
    }
}
