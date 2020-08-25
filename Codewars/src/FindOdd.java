/*
Given an array of integers, find the one that appears an odd number of times.

There will always be only one integer that appears an odd number of times.

 */

import static java.util.Arrays.stream;
import java.util.HashMap;
import java.util.Map;

public class FindOdd {

    public static int findIt(int[] a) {
        int odd = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < a.length; i++) {
            try {
                int count = map.get(a[i]);
                map.put(a[i], ++count);
            } catch (NullPointerException e) {
                map.put(a[i], 1);
            }
        }
        //System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) {
                odd = key;
                break;
            }

        }
        return odd;
    }

    public static int findIt2(int[] a) {
        int xor = 0;
        for (int i = 0; i < a.length; i++) {
            xor ^= a[i];
        }
        return xor;
    }

    public static int findIt3(int[] arr) {
        return stream(arr).reduce(0, (x, y) -> x ^ y);
    }

    public static void main(String[] args) {
        System.out.println(FindOdd.findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        System.out.println(FindOdd.findIt(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
        System.out.println(FindOdd.findIt(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
        System.out.println(FindOdd.findIt(new int[]{10}));
        System.out.println(FindOdd.findIt(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
        System.out.println(FindOdd.findIt(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
        System.out.println("-----XOR-----");
        System.out.println(FindOdd.findIt2(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        System.out.println(FindOdd.findIt2(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
        System.out.println(FindOdd.findIt2(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
        System.out.println(FindOdd.findIt2(new int[]{10}));
        System.out.println(FindOdd.findIt2(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
        System.out.println(FindOdd.findIt2(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
        System.out.println("-----STREAM-----");
        System.out.println(FindOdd.findIt3(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        System.out.println(FindOdd.findIt3(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
        System.out.println(FindOdd.findIt3(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
        System.out.println(FindOdd.findIt3(new int[]{10}));
        System.out.println(FindOdd.findIt3(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
        System.out.println(FindOdd.findIt3(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
    }
}

/*
5
-1
5
10
10
1
 */
