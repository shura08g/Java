package thinkinginjavach16;

import java.util.Arrays;
import java.util.Random;

public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3},
                     {4, 5, 6}};
        System.out.println(Arrays.deepToString(a));  // [[1, 2, 3], [4, 5, 6]]
        
        int[][][] b = new int[2][2][4];
        System.out.println(Arrays.deepToString(b));  // [[[0, 0, 0, 0], [0, 0, 0, 0]], [[0, 0, 0, 0], [0, 0, 0, 0]]]
        
        Random rand = new Random(47);
        int[][][] c = new int[rand.nextInt(7)][][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new int[rand.nextInt(5)][];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = new int[rand.nextInt(5)];
            }
        }
        System.out.println(Arrays.deepToString(c)); // [[], [[0], [0], [0, 0, 0, 0]], [[], [0, 0], [0, 0]], [[0, 0, 0], [0], [0, 0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0], []], [[0], [], [0]]]
        
    }
}
