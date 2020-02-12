/*
 * You are given an N x N 2D matrix that represents an image.
 * Rotate the image by 90 degrees (clockwise).
 * [[1, 2, 3],      [[7, 4, 1],
 *  [4, 5, 6],  ==>  [8, 5, 2],
 *  [7, 8, 9]]       [9, 6, 3]]
 *
 */
package rotateimage;

import java.util.Arrays;

/**
 *
 * @author AKravchuk
 */
public class RotateImage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] arr2D = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        System.out.println(Arrays.deepToString(arr2D));  // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        
        int[][] rotatedArr180 = rotateBy180(arr2D);   // [[9, 8, 7], [6, 5, 4], [3, 2, 1]]
        System.out.println(Arrays.deepToString(rotatedArr180));
        
        rotatedArr180 = rotateBy180(rotatedArr180);   // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        System.out.println(Arrays.deepToString(rotatedArr180));
        
        int[][] rotatedArr90 = rotateBy90(arr2D);
        System.out.println(Arrays.deepToString(rotatedArr90));  // [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
        
        rotatedArr90 = rotateBy90(rotatedArr90);
        System.out.println(Arrays.deepToString(rotatedArr90));  // [[9, 8, 7], [6, 5, 4], [3, 2, 1]]
        
        rotatedArr90 = rotateBy90(rotatedArr90);
        System.out.println(Arrays.deepToString(rotatedArr90));  // [[3, 6, 9], [2, 5, 8], [1, 4, 7]]
        
        rotatedArr90 = rotateBy90(rotatedArr90);
        System.out.println(Arrays.deepToString(rotatedArr90));  // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        rotateBy90OnPlace(arr);
        System.out.println("Rotate on place");
        System.out.println(Arrays.deepToString(arr));
        
        rotateImage(arr2D);
        System.out.println(Arrays.deepToString(arr2D));
        
        int[][] arr4x4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        
        System.out.println(Arrays.deepToString(arr4x4));
        rotatedArr90 = rotateBy90(arr4x4);
        System.out.println(Arrays.deepToString(rotatedArr90));
        
        rotateBy90OnPlace(arr4x4);
        System.out.println("Rotate on place");
        System.out.println(Arrays.deepToString(arr4x4));
        
        int[][] arr4x4_ = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateImage(arr4x4_);
        System.out.println(Arrays.deepToString(arr4x4_));
        
    }
   
    
    public static int[][] rotateBy180(int[][] arr2D) {
        int size = arr2D[0].length;
        int[][] newArr = new int[size][size];
        //System.out.println(arr2D[0].length);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newArr[size - i - 1][size - j - 1] = arr2D[i][j];
            }
        }
        return newArr;
    }
    
    public static int[][] rotateBy90(int[][] arr2D) {
        int size = arr2D[0].length;
        int[][] newArr = new int[size][size];
        //System.out.println(arr2D[0].length);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newArr[j][size - i - 1] = arr2D[i][j];
            }
        }
        return newArr;
    }
    
    public static void swap(int[][] arr, int left, int right) {
        int temp = arr[left][right];
        arr[left][right] = arr[right][left];
        arr[right][left] = temp;
    }
    
    public static void rotateBy90OnPlace(int[][] arr2D) {
        int size = arr2D[0].length;
        // Step 1 - Transpose matrix
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                swap(arr2D, i, j);
            }
        }
        // [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
        // Step 2 - replace column
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int temp = arr2D[i][j];
                arr2D[i][j] = arr2D[i][size - 1 - j];
                arr2D[i][size - 1 - j] = temp;
            }
        }
        // [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
    }
    
    public static void rotateImage(int[][] matrix) {
        int size = matrix.length;
        // Step 1 - Transpose matrix
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
        // Step 2 - flip horisontally
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - 1 - j];
                matrix[i][size - 1 - j] = temp;
            }
        }
        // [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
    }
    
}

