/*
 * Input [1, 2, 3, 4]
 * Output [24, 12, 8, 6]
 * 2 * 3 * 4 = 24
 * 1 * 3 * 4 = 12
 * 1 * 2 * 4 = 8
 * 1 * 2 * 3 = 6
 */
package productofarrayexceptself;

import java.util.Arrays;

/**
 *
 * @author AKravchuk
 */
public class ProductOfArrayExceptSelf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        
        System.out.println(Arrays.toString(productExcdeptSelf(arr)));
        
        int[] arr2 = new int[] {};
        System.out.println(Arrays.toString(productExcdeptSelf(arr2)));
        
        int[] arr3 = {1, 5, 3, 9};
        System.out.println(Arrays.toString(productExcdeptSelf(arr3)));
        
        int[] arr4 = {-5, 2, -4};
        System.out.println(Arrays.toString(productExcdeptSelf(arr4)));
        
        System.out.println(Arrays.toString(productExcdeptSelf2(arr)));
        System.out.println(Arrays.toString(productExcdeptSelf2(arr3)));
        System.out.println(Arrays.toString(productExcdeptSelf2(arr4)));
        
        System.out.println(Arrays.toString(productExcdeptSelf3(arr)));
        System.out.println(Arrays.toString(productExcdeptSelf3(arr3)));
        System.out.println(Arrays.toString(productExcdeptSelf3(arr4)));
        
    }
    
    public static int[] productExcdeptSelf(int[] arr) {
        if (arr.length == 0) return null;
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int temp = 1;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    temp *= arr[j];
                }
            }
            result[i] = temp;
        }
        return result;
    }
    
    public static int[] productExcdeptSelf2(int[] arr) {
        int N = arr.length;
        int[] left_product = new int[N];
        int[] right_product = new int[N];
        int[] output_arr = new int[N];
        
        left_product[0] = 1;
        right_product[N-1] = 1;
        
        for (int i = 1; i < N; i++) {
            left_product[i] = arr[i - 1] * left_product[i - 1];
        }

        for (int i = N - 2; i >= 0; i--) {
            right_product[i] = arr[i + 1] * right_product[i + 1];
        }

        for (int i = 0; i < N; i++) {
            output_arr[i] = left_product[i] * right_product[i];
        }
        
        return output_arr;
    }
    
    public static int[] productExcdeptSelf3(int[] arr) {
        int N = arr.length;
        int[] output_arr = new int[N];
        
        output_arr[0] = 1;
        
        for (int i = 1; i < N; i++) {
            output_arr[i] = arr[i - 1] * output_arr[i - 1];
        }
        
        int R = 1;
        for (int i = N - 1; i >= 0; i--) {
            output_arr[i] = output_arr[i] * R;
            R = R * arr[i];
        }
        
        return output_arr;
    }
}
