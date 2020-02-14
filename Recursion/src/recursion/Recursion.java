/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.util.Arrays;

/**
 *
 * @author AKravchuk
 */
public class Recursion {

    /**
     * @param args the command line arguments
     */
    static int count = 0;
    public static void main(String[] args) {
        // при выполнении циклов все локальные переменные создаются заново
        // при рекурсии мы можем использовать переменные из предыдущих вызовов
        // stackOverflow(1);  // вызвался 1024 дп переполнения стека
        // main(args); // или так
        f1(1);  // 1 2 4 8
        System.out.println();
        f2(1);  // 8 4 2 1
        System.out.println();
        f3(1);  // 1 2 4 8 8 4 2 1
        System.out.println();       
        
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // invert0(arr, 0);
        invert(arr);
        System.out.println(Arrays.toString(arr));
        //invert20(arr, 0);
        invert(arr);
        System.out.println(Arrays.toString(arr));
        
        //Factorial
        System.out.println(factorial(5));  // 120
        
        // Fibonacci
        System.out.println(fib(5));  // 8
        System.out.println(fibonacciRec(5));  // 8
        System.out.println(fibonacciRecSwitch(5));  // 8
        System.out.println(fibRecTern(5));  // 8
        fibRecTern2(5);  // 5 3 1 2 0 1 4 2 0 1 3 1 2 0 1
        /*
                              5
                     3|---------------|4
                1|-------|2      2|--------|3
                      0|---|1  0|---|1  1|---|2
                                           0|--|1      
        */
        System.out.println();
        fibRecTern3(5);  // 1 0 1 2 3 0 1 2 1 0 1 2 3 4 5
        /*
                             (15)5
                (5)3|-----------------------|4(14)
           (1)1|-------|2(4)      (8)2|-------------|3(13)
                 (2)0|---|1(3)  (6)0|---|1(7) (9)1|-----|2(12)
                                                  (10)0|--|1(11)      
        */
        System.out.println();
        fibTest(5);  // 3 2 5 2 4 3 2
    }
    
    //Stack overflow
    public static void stackOverflow(int arg) {
        System.out.println(++count);
        stackOverflow(2 * arg);
    }
    
    public static void f1(int arg) {
        System.out.print(" " + arg);
        if (arg < 7) {
            f1(2 * arg);
        }
    }
    
    public static void f2(int arg) {
        if (arg < 7) {
            f2(2 * arg);
        }
        System.out.print(" " + arg);
    }
    
    public static void f3(int arg) {
        System.out.print(" " + arg);
        if (arg < 7) {
            f3(2 * arg);
        }
        System.out.print(" " + arg);
    }

    public static void invert0(int[] data, int k) {
        if (k < data.length / 2) {
            int temp = data[k];
            data[k] = data[data.length - k - 1];
            data[data.length - k - 1] = temp;
            invert0(data, k + 1);
        }
    }
    
    public static void invert(int[] data) {
        invert0(data, 0);
    }
    
    
    public static void invert20(int[] data, int k) {
        if (k < data.length / 2) {
            invert20(data, k + 1);
            int temp = data[k];
            data[k] = data[data.length - k - 1];
            data[data.length - k - 1] = temp;
        }
    }
    
    public static void invert2(int[] data) {
        invert20(data, 0);
    }
    
    public static int factorial(int arg) {
        if (arg == 1) {
            return 1;
        } else {
            return arg * factorial(arg - 1);
        }
    }
    
    public static int fib(int arg) {
        if (arg == 0) {
            return 1;
        }else if (arg == 1) {
            return 1;
        }
        int[] result = new int[arg +1];
        result[0] = 1;
        result[1] = 1;
        for (int k = 2; k < result.length; k++) {
            result[k] = result[k-2] + result[k - 1];
        }
        return result[arg];
    }
    
    public static int fibonacciRec(int arg) {
        if (arg == 0) {
            return 1;
        }else if (arg == 1) {
            return 1;
        } else {
            return fibonacciRec(arg - 2) + fibonacciRec(arg - 1);
        }
    }
    
    public static int fibonacciRecSwitch(int arg) {
        switch (arg) {
            case 0:
                return 1;
            case 1:
                return 1;
            default:
                return fibonacciRec(arg - 2) + fibonacciRec(arg - 1);
        }
    }
    
    public static int fibRecTern(int arg) {
        return (arg < 2) ? 1 : fibRecTern(arg - 2) + fibRecTern(arg - 1);
    }
    
    public static int fibRecTern2(int arg) {
        System.out.print(" " + arg);
        return (arg < 2) ? 1 : fibRecTern2(arg - 2) + fibRecTern2(arg - 1);
    }
    
    public static int fibRecTern3(int arg) {
        int result = (arg < 2) ? 1 : fibRecTern3(arg - 2) + fibRecTern3(arg - 1);
        System.out.print(" " + arg);
        return result;
    }
    
    public static int fibTest(int arg) {
        return (arg < 2) ? 1 : fibTest(arg - 2) + _(arg) + fibTest(arg - 1);
    }
    
    public static int _(int arg) {
        System.out.print(" " + arg);
        return 0;
    }
}
