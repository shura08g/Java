package thinkinginjavach16;

import java.util.Arrays;

public class CopingArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        int[] a = new int[10];
        
        Arrays.fill(i, 10);
        Arrays.fill(j, 99);
        System.out.println("i = " + Arrays.toString(i));
        System.out.println("j = " + Arrays.toString(j));
        
        System.arraycopy(j, 0, a, 0, a.length);;
        System.out.println("a = " + Arrays.toString(a));
        j[0] = 77;
        j[2] = 77;
        j[4] = 77;
        j[6] = 77;
        System.out.println("j = " + Arrays.toString(j));
        System.out.println("a = " + Arrays.toString(a));
        
        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("j = " + Arrays.toString(j));
        
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Integer[] k = new Integer[10];
        Arrays.fill(u, new Integer(20));
        Arrays.fill(v, new Integer(55));
        System.out.println("u = " + Arrays.toString(u));
        System.out.println("v = " + Arrays.toString(v));
        
        k = u;
        System.out.println("k = " + Arrays.toString(k));
        System.arraycopy(v, 0, u, 0, v.length);
        System.out.println("u = " + Arrays.toString(u));
        System.out.println("k = " + Arrays.toString(k));
    }
}
/*
i = [10, 10, 10, 10, 10, 10, 10]
j = [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
a = [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
j = [77, 99, 77, 99, 77, 99, 77, 99, 99, 99]
a = [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
j = [10, 10, 10, 10, 10, 10, 10, 99, 99, 99]
u = [20, 20, 20, 20, 20, 20, 20, 20, 20, 20]
v = [55, 55, 55, 55, 55]
k = [20, 20, 20, 20, 20, 20, 20, 20, 20, 20]
u = [55, 55, 55, 55, 55, 20, 20, 20, 20, 20]
k = [55, 55, 55, 55, 55, 20, 20, 20, 20, 20]
*/