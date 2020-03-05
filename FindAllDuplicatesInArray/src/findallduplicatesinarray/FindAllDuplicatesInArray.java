/*
 * Find all the elements that appear rwice in this array.
 * Input:
 * [4, 3, 2, 7, 8, 2, 3, 1]
 * Output:
 * [2, 3]
 */
package findallduplicatesinarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author AKravchuk
 */
public class FindAllDuplicatesInArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        
        System.out.println(findDuplicates2(arr));  // [2, 3]
        System.out.println(findDuplicates3(arr));  // [3, 2]
        System.out.println(findDuplicates(arr));  // [2, 3]
    }
    
    public static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> lst = new ArrayList();
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            if (set.contains(num)) {
                lst.add(num);
            }
            else {
                set.add(num);
            }
        }
        return lst;
    }
    
    public static List<Integer> findDuplicates3(int[] nums) {
        List<Integer> lst = new ArrayList();
        List<Integer> copy_lst = new ArrayList(nums.length);
        for (int i : nums) {
            copy_lst.add(i);
        }
        for (int i : copy_lst) {
            int first = copy_lst.indexOf(i);
            int last = copy_lst.lastIndexOf(i);
            if (first != last && !lst.contains(i)) {
                lst.add(i);
            }
        }
        return lst;
    }
    
    // Without extraspace
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> lst = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            System.out.println(index);
            if (nums[index] < 0) {
                lst.add(index + 1);  // [2, 3]
                //lst.add(Math.abs(nums[index]));  // [3, 2]
            }
            nums[index] = -nums[index];
            System.out.println(lst);
        }
        return lst;
        
        /*[4, 3, 2, 7, 8, 2, 3, 1];  // lst = []
        nums[0] = 4;
        index = 4 - 1 = 3;
        nums[3] = 7;
        (7 < 0) = false;
        7 = -7;
        
        [4, 3, 2, -7, 8, 2, 3, 1];  // lst = []
        nums[1] = 3;
        index = 3 - 1 = 2;
        nums[2] = 2;
        (2 < 0) = false;
        2  = -2
        
        [4, 3, -2, -7, 8, 2, 3, 1];  // lst = []
        nums[2] = -2;
        index = 2 - 1 = 1;
        nums[1] = 3;
        (3 < 0) = false;
        3 = -3
        
        [4, -3, -2, -7, 8, 2, 3, 1];  // lst = []
        nums[3] = -7;
        index = 7 - 1 = 6;
        nums[6] = 3;
        (3 < 0) = false;
        3 = -3
        
        [4, -3, -2, -7, 8, 2, -3, 1];  // lst = []
        nums[4] = 8;
        index = 8 - 1 = 7;
        nums[7] = 1;
        (1 < 0) = false;
        1 = -1
        
        [4, -3, -2, -7, 8, 2, -3, -1];  // lst = []
        nums[5] = 2;
        index = 2 - 1 = 1;
        nums[1] = -3;
        (-3 < 0) = true;
        (index + 1) = 2
        -3 = 3
        
        [4, 3, -2, -7, 8, 2, -3, -1];  // lst = [2]
        nums[6] = -3;
        index = 3 - 1 = 2;
        nums[2] = -2;
        (-2 < 0) = true;
        (index + 1) = 3
        -2 = 2
        
        [4, 3, 2, -7, 8, 2, -3, -1];  // lst = [2, 3]
        nums[7] = -1;
        index = 1 - 1 = 0;
        nums[0] = 4;
        (4 < 0) = false;
        4 = -4
        
        [-4, 3, 2, -7, 8, 2, -3, -1];  // lst = [2, 3]

        */
    }
    
}
