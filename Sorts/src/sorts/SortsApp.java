/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

import java.util.Arrays;

/**
 *
 * @author AKravchuk
 */
public class SortsApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr1 = {15, 65, -47, 7, 35, 87, -94, 66, 87};
        int[] arr2 = {15, 65, -47, 7, 35, 87, -94, 66, 87};
        int[] arr3 = {15, 65, -47, 7, 35, 87, -94, 66, 87};
        int[] arr4 = {15, 65, -47, 7, 35, 87, -94, 66, 87};
        int[] arr5 = {15, 65, -47, 7, 35, 87, -94, 66, 87};
        
        selectionSort(arr1);
        selectionSortFaster(arr2);
        insertingSort(arr3);
        insertingSort2(arr4);
        insertingSortFaster(arr5);
        
        int[] tesMere = merge(arr1, arr2);
        System.out.println(Arrays.toString(tesMere));
        
    }
    
    public static void buubleSort(int[] arr) {
        System.out.println("--Bubble sort--");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int barier = arr.length - 1; barier >= 0; --barier) {
            for (int i = 0; i < barier; ++i) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
    
    public static void selectionSort(int[] arr) {
        System.out.println("--Selection sort--");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int barier = 0; barier < arr.length; ++barier) {
            for (int i = barier + 1; i < arr.length; ++i) {
                if (arr[i] < arr[barier]) {
                    int temp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = temp;
                }
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
    
    public static void selectionSortFaster(int[] arr) {
        System.out.println("--Selection sort faster--");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int barier = 0; barier < arr.length; ++barier) {
            int lastIndex = barier;
            for (int i = barier + 1; i < arr.length; ++i) {
                if (arr[i] < arr[barier] && arr[i] < arr[lastIndex]) {
                        lastIndex = i;
                }
            }
            if (lastIndex != barier) {
                int temp = arr[lastIndex];
                arr[lastIndex] = arr[barier];
                arr[barier] = temp;
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
    
    public static void insertingSort(int[] arr) {
        System.out.println("--Inserting sort #1--");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int barier = 1; barier < arr.length; ++barier) {
            int index = barier;
            while (index - 1 >= 0 && arr[index] < arr[index - 1]) {
                    int temp = arr[index];
                    arr[index] = arr[index - 1];
                    arr[index - 1] = temp;
                    --index;
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
    
    public static void insertingSort2(int[] arr) {
        System.out.println("--Inserting sort #2--");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int barier = 1; barier < arr.length; ++barier) {
            int newElement = arr[barier];
            int index = barier - 1;
            while (index >= 0 && arr[index] > newElement) {
                    arr[index + 1] = arr[index];
                    --index;
            }
            arr[index + 1] = newElement;
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
    
    public static void insertingSortFaster(int[] arr) {
        System.out.println("--Inserting sort faster with Arrays.binarySearch--");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int barier = 1; barier < arr.length; ++barier) {
            int newElement = arr[barier];
            // Find location to insert using binary search 
            int index = Math.abs(Arrays.binarySearch(arr, 0, barier, newElement) + 1); 
  
            //Shifting array to one location right 
            System.arraycopy(arr, index, arr, index+1, barier-index); 
  
            //Placing element at its correct location 
            arr[index] = newElement;
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
    
    // Слияние отсортированых массивов
    public static int[] merge(int[] a, int[] b) {
        System.out.println("--Merge two sorted arrays--");
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex + bIndex != result.length) {
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, aIndex + bIndex, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, aIndex + bIndex, a.length - aIndex);
                break;
            }
            //System.out.println(Arrays.toString(result));
            if (a[aIndex] < b[bIndex]) {
                result[aIndex + bIndex] = a[aIndex++];
            } else {
                result[aIndex + bIndex] = b[bIndex++];
            }
         
        }
        return result;
    }
    
}
