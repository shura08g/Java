package thinkinginjavach16;

import java.util.Arrays;

public class GeneratedTest {
    public static void main(String[] args) {
        Integer[] a = {9, 8, 7, 6};
        System.out.println(Arrays.toString(a)); //[9, 8, 7, 6]
        
        a = Generated.array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));  // [0, 1, 2, 3]
        
        Integer[] b = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        System.out.println(Arrays.toString(b)); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
    }
}
/*
[9, 8, 7, 6]
[0, 1, 2, 3]
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
*/