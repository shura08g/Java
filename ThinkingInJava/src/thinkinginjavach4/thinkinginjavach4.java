/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinkinginjavach4;

import java.util.Random;

/**
 *
 * @author AKravchuk
 */
public class thinkinginjavach4 {
    public static void main(String[] args) {
        for (char c = 32; c < 128; c++) {
            /*if (Character.isLowerCase(c)) {
                System.out.println("Значение: " + (int)c + " символ: " + c);
            }*/
            System.out.print(c + " ");
        }
        System.out.println();
        /*for (char c = 1040; c < 1104; c++) {
            System.out.println("Значение: " + (int)c + " символ: " + c);
        }*/
        
        char start = 'А';
        char finish = 'я';
        for (int i = (int)start; i <= (int)finish; i++){
            System.out.print((char)i + ", ");
        }
        
        System.out.println();
        
        Random rand = new Random(47);
        for (int i = 0; i < 20; i++) {
            int c = rand.nextInt(26) + (int)'a';
            System.out.print((char)c +", " + c + ": ");
            switch(c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': System.out.println("гласная");
                    break;
                case 'y':
                case 'w': System.out.println("условно гласная");
                    break;
                default: System.out.println("согласная");
            }
        }
        
    }
    
}
