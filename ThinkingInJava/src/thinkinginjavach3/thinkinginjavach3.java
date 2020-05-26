/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinkinginjavach3;

import java.util.Random;


/**
 *
 * @author AKravchuk
 */
public class thinkinginjavach3 {
    public static void main(String[] args) {
        //Random rand = new Random(47); // одинаковый последовательности
        Random rand = new Random();
        int x;
        for (int i = 0; i < 3; i++) {
            x = rand.nextInt(10);
            System.out.println(x);
        }
        
        int i1 = 0x2f;
        System.out.println("i1: " + Integer.toBinaryString(i1));
        int i2 = 011;  // с 0 восмиричная система
        System.out.println("i2: " + Integer.toBinaryString(i2));
        
        int i3 = -1;
        System.out.println(Integer.toBinaryString(i3));
        i3 >>>= 10;
        System.out.println(Integer.toBinaryString(i3));
        long l = -1;
        System.out.println(Long.toBinaryString(l));
        l >>>= 10;
        System.out.println(Long.toBinaryString(l));
        short s = -1;
        System.out.println(Integer.toBinaryString(s));
        s >>>= 10;
        System.out.println(Integer.toBinaryString(s));
        byte b = -1;
        System.out.println(Integer.toBinaryString(b));
        b >>>= 10;
        System.out.println(Integer.toBinaryString(b));
        b = -1;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b>>>10));
        
        int bigNum = 250000000;
        int count = 0;
        
        while (bigNum > 0) {
            bigNum /= 2;
            count++;
        }
        
        System.out.println(count);  // 28
        
        System.out.println("Int max value = " + Integer.MAX_VALUE); // 2147483647
        int low = Integer.MAX_VALUE - 100;
        int hight = Integer.MAX_VALUE;
        
        int midle = (hight + low) / 2; // invalid -51 overflow
        System.out.println(midle);
        
        midle = (hight + low) >>> 1; // 2147483597
        System.out.println(midle);
        
        midle = hight - (hight - low) / 2; // 2147483597
        System.out.println(midle);
        
        midle = low + (hight - low) / 2; // 2147483597
        System.out.println(midle);
        
    }
    
}
