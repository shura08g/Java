package thinkinginjavach16;

import java.util.Arrays;

public class ArrayOptions {
    public static void main(String[] args) {
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];
    
        // System.out.println("a: " + Arrays.toString(a)); // Bad local variable type
        System.out.println("b: " + Arrays.toString(b)); // b: [null, null, null, null, null]
        
        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            c[i] = new BerylliumSphere();
        }
        
        // Группрвая инициализация
        BerylliumSphere[] d = {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
        
        // Динамическая группрвая инициализация
        a = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(),};
        
        System.out.println("a.length = " + a.length); // a.length = 3
        System.out.println("b.length = " + b.length); // b.length = 5
        System.out.println("c.length = " + c.length); // c.length = 4
        System.out.println("d.length = " + d.length); // d.length = 3
        
        a = c;
        System.out.println("a.length = " + a.length); // a.length = 4
        
        // Массив примитивов
        int[] e;
        int[] f = new int[5];
        System.out.println("f: " + Arrays.toString(f)); // f: [0, 0, 0, 0, 0]
        
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }
        
        int[] h = {11, 47, 93};
        
        //System.out.println("e.length = " + e.length); // Bad local variable type
        System.out.println("f.length = " + f.length); // f.length = 5
        System.out.println("g.length = " + g.length); // g.length = 4
        System.out.println("h.length = " + h.length); // h.length = 3
        
        e = h;
        System.out.println("e.length = " + e.length); // e.length = 3
        
        e = new int[]{1, 2};
        System.out.println("e.length = " + e.length); // e.length = 2
        
        char[] charArr = new char[5];
        System.out.println("carArr: " + Arrays.toString(charArr));  // carArr: [ ,  ,  ,  ,  ]
    }
    
}
