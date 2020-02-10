/*
 * 
 */
package firstduplicate;

import java.util.HashSet;

/**
 *
 * @author AKravchuk
 */
public class FirstDuplicate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 5, 3, 5};
        int[] arr3 = {2, 1, 3, 5, 6, 3, 2};
        
        System.out.println("firstDuplicate");
        int dup = firstDuplicate(arr1);
        System.out.println(dup);
        
        dup = firstDuplicate(arr2);
        System.out.println(dup);
        
        dup = firstDuplicate(arr3);
        System.out.println(dup);
        
        System.out.println("firstDuplicate2");
        dup = firstDuplicate2(arr1);
        System.out.println(dup);
        
        dup = firstDuplicate2(arr2);
        System.out.println(dup);
        
        dup = firstDuplicate2(arr3);
        System.out.println(dup);
        
        System.out.println("firstDuplicateMinIndex");
        dup = firstDuplicateMinIndex(arr1);
        System.out.println(dup);
        
        dup = firstDuplicateMinIndex(arr2);
        System.out.println(dup);
        
        dup = firstDuplicateMinIndex(arr3);
        System.out.println(dup);
        
        int[] arr_n1 = {1, 2, 3, 4};
        int[] arr_n2 = {1, 2, 5, 3, 5};
        int[] arr_n3 = {2, 1, 3, 5, 6, 3, 2};
        System.out.println("firstDuplicateNegativeIndex");
        dup = firstDuplicateNegativeIndex(arr_n1);
        System.out.println(dup);
        
        dup = firstDuplicateNegativeIndex(arr_n2);
        System.out.println(dup);
        
        dup = firstDuplicateNegativeIndex(arr_n3);
        System.out.println(dup);
        
        System.out.println("firstDuplicateSet");
        dup = firstDuplicateSet(arr1);
        System.out.println(dup);
        
        dup = firstDuplicateSet(arr2);
        System.out.println(dup);
        
        dup = firstDuplicateSet(arr3);
        System.out.println(dup);
        
        System.out.println("firstDuplicateTemplate");
        dup = firstDuplicateTemplate(arr1);
        System.out.println(dup);
        
        dup = firstDuplicateTemplate(arr2);
        System.out.println(dup);
        
        dup = firstDuplicateTemplate(arr3);
        System.out.println(dup);
    }
    
    public static Integer firstDuplicate(int[] data) {
        
        for (int i = 0; i < data.length; ++i) {
            boolean isDup = false;
            //for (int j = 0; j < data.length; ++j) {  // Возвращает дубликат по первому числу,
            for (int j = 0; j <= i; ++j) {
                if ((i != j) && data[i] == data[j]) {
                    isDup = true;
                    break;
                }
            }
            if (isDup) {
                return data[i];
            }
        }
        return -1;
    }
    
    public static Integer firstDuplicate2(int[] data) {
        int[] num = new int[data.length];
        for (int i = 0; i < data.length; ++i) {
            boolean isDup = false;
            for (int j = 0; j < num.length; ++j) {
                if (num[j] == data[i]) {
                    isDup = true;
                    break;
                }
            }
            if (isDup) {
                return data[i];
            }
            num[i] = data[i];
        }
        return -1;
    }
    
        public static Integer firstDuplicateMinIndex(int[] data) {
        int min_second_index = data.length;
        for (int i = 0; i < data.length; ++i) {
            for (int j = i + 1; j < data.length; ++j) {
                if (data[i] == data[j]) {
                    min_second_index = Math.min(min_second_index, j);
                }
            }
        }
        
        if (min_second_index == data.length) {
            return -1;
        }
        else {
            return data[min_second_index];
        }
    }
        
    public static Integer firstDuplicateNegativeIndex(int[] data) {
        //Проводит мзменения в миссиве
        for (int i = 0; i < data.length; ++i) {
            System.out.print(data[Math.abs(data[i]) - 1] + " ");
            if (data[Math.abs(data[i]) - 1] < 0) {
                return Math.abs(data[i]);
            }
            else {
                data[Math.abs(data[i]) - 1] = -data[Math.abs(data[i]) - 1];
            }
            System.out.print(data[Math.abs(data[i]) - 1] + " ");
        }
        return -1;
    }
    
    public static Integer firstDuplicateSet(int[] data) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < data.length; ++i) {
            if (seen.contains(data[i])) {
                return data[i];
            }
            seen.add(data[i]);
        }
        return -1;
    }
    
    public static Integer firstDuplicateTemplate(int[] data) {
        // Возвращает наименший дубликат, а не порядке появления
        int[] template = new int[100];
        for (int i = 0; i < data.length; ++i) {
            ++template[data[i]];
        }
        for (int i = 0; i < template.length; ++i) {
            if (template[i] > 1) {
                return i;
            }
        }
        return -1;
    }
    
}
