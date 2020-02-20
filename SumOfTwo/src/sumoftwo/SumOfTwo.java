/*
 * a = [1, 2, 3]
 * b = [10, 20, 30, 40]
 * v = 42
 * 40 + 2 = 42
 * sumOfTwo(a, b, v) = true
 */
package sumoftwo;

import java.util.HashSet;

/**
 *
 * @author AKravchuk
 */
public class SumOfTwo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {10, 20, 30, 40};
        int v = 42;
        int[] a2 = {0, 0, -5, 30212};
        int[] b2 = {-10, 40, -3, 9};
        
        //long start = System.nanoTime();
        //start = System.currentTimeMillis();
        System.out.println("sumOfTwo(a, b, v)");
        System.out.println(sumOfTwo(a, b, v));  //true
        System.out.println(sumOfTwo(a, b, 55)); //false
        System.out.println(sumOfTwo(a2, b2, -8));  //true
        System.out.println(sumOfTwo(a2, b2, -9));  //false
       
        System.out.println("-----------------");
        System.out.println("sumOfTwo2(a, b, v)");
        System.out.println(sumOfTwo2(a, b, 42));  //true
        System.out.println(sumOfTwo2(a, b, 55)); //false
        System.out.println(sumOfTwo2(a2, b2, -8));  //true
        System.out.println(sumOfTwo2(a2, b2, -9));  //false
        
        System.out.println("-----------------------");
        System.out.println("sumOfTwoHashSet(a, b, v)");
        System.out.println(sumOfTwoHashSet(a, b, 42));  //true
        System.out.println(sumOfTwoHashSet(a, b, 55)); //false
        System.out.println(sumOfTwoHashSet(a2, b2, -8));  //true
        System.out.println(sumOfTwoHashSet(a2, b2, -9));  //false
        
        
        int[] a3 = {0, 0, -5, 30212, 325, 548, 6, 47, 4, 8, 7, 7, 89, 7, 8, 4, 7, 6, 4, 7, 9, 6594, 65, 78488, 48};
        int[] b3 = {-10, 40, -3, 9, -5, 3, 5, 4, 96, -87, -566, 54, 4, -654487, -6594, -5648, -6594, -654484 ,-254, 6548, 484 ,567, 74989};
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sumOfTwo(a3, b3, 42);
        }
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
        
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sumOfTwo2(a3, b3, 42);
        }
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
        
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sumOfTwoHashSet(a3, b3, 42);
        }
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
        
        
        
    }
    
    public static boolean sumOfTwo(int[] a, int[] b, int v){
        for (int ai : a){
            for (int bi : b){
                if (ai + bi == v) {
                    //System.out.println(ai + " + " + bi + " = " + v);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean sumOfTwo2(int[] a, int[] b, int v){
        for (int i = 0; i < a.length; i++){
            int needed_value = v - a[i];
            for (int j = 0; j < b.length; j++){
                if (b[j] == needed_value) {
                    //System.out.println(a[i] + " + " + b[j] + " = " + v);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean sumOfTwoHashSet(int[] a, int[] b, int v){
        HashSet<Integer> differences = new HashSet();
        for (int i = 0; i < a.length; i++){
            int difference = v - a[i];
            differences.add(difference);
        }
        for (int i = 0; i < b.length; i++) {
            if (differences.contains(b[i])) {
                return true;
            }
        }
        return false;
    }
    
}
