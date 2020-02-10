/*
 * You have a sorted array of integers.
 * Write a function that returns a sorted array containing the squares of
 * this integer.
 */
package sortedsquaredarray;

import java.util.Arrays;

/**
 *
 * @author AKravchuk
 */
public class SortedSquaredArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        //int[] empty = {};
        int[] squared;
        
        //sortedSquaredArrayOnPlace(empty);
        
        squared = sortedSquaredArray(arr1);
        System.out.println(Arrays.toString(squared));
        
        sortedSquaredArrayOnPlace(squared);
        System.out.println(Arrays.toString(squared));
        
        int[] arr2 = {-7, -3, -1, 4, 8, 12};
        
        squared = sortedSquaredArray(arr2);
        System.out.println(Arrays.toString(squared));
        
        sortedSquaredArrayOnPlace(squared);
        System.out.println(Arrays.toString(squared));
        
        int[] arr3 = {-7, -3, -1, 4, 8, 12};
        squared = squaredArray(arr3);
        System.out.println(Arrays.toString(squared));
        
        int[] arr4 = {-10, -9, -7, -5, -4, -4};
        squared = squaredArray(arr4);
        System.out.println(Arrays.toString(squared));
    }
    
    public static int[] sortedSquaredArray(int[] data) {
        int[] squared = new int[data.length];
        for (int i = 0; i < data.length; ++i) {
            squared[i] = data[i] * data[i];
        }
        Arrays.sort(squared);
        return squared;
    }
    
    public static void sortedSquaredArrayOnPlace(int[] data) {
        if (data.length == 0) {
            System.out.println("INVALID INPUT");
            System.exit(-1);
        }
        for (int i = 0; i < data.length; ++i) {
            data[i] = data[i] * data[i];
        }
        Arrays.sort(data);
    }
    
    public static int[] squaredArray(int[] data) {
        int[] result = new int[data.length];
        int left = 0;
        int right = data.length - 1;
        for (int i = data.length - 1; i >= 0; --i) {
            if (Math.abs(data[left]) > data[right]) {
                result[i] = data[left] * data[left];
                left++;
            } else {
                result[i] = data[right] * data[right];
                right--;
            }
        }
        return result;
    }
    
}
