package thinkinginjavach16;

import java.util.Arrays;
import java.util.Random;

public class IceCream {
    private static Random rand = new Random(47);
    static final String[] FLAVOR = {"Chokolate", "Strawberry", "Valilla Fudge Swirl",
                                    "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
                                    "Praline Cream", "Mud Pie"};
    
    public static String[] flavorSet(int n) {
        if (n > FLAVOR.length) {
            throw new IllegalArgumentException("Set too big");
        }
        String[] result = new String[n];
        boolean[] picked = new boolean[FLAVOR.length];
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVOR.length);
            } while (picked[t]);
            result[i] = FLAVOR[t];
            picked[t] = true;
        }
        return result;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(Arrays.toString(flavorSet(3)));
        }
    }
}
/*
[Rum Raisin, Mint Chip, Mocha Almond Fudge]
[Chokolate, Strawberry, Mocha Almond Fudge]
[Strawberry, Mint Chip, Mocha Almond Fudge]
[Rum Raisin, Valilla Fudge Swirl, Mud Pie]
[Valilla Fudge Swirl, Chokolate, Mocha Almond Fudge]
[Praline Cream, Strawberry, Mocha Almond Fudge]
[Mocha Almond Fudge, Strawberry, Mint Chip]
*/