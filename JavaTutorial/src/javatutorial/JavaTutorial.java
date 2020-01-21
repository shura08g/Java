/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

/**
 *
 * @author AKravchuk
 */

import java.util.Scanner;
import java.util.Random;

public class JavaTutorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    /*    Scanner input = new Scanner(System.in);
        double fnum, snum, answer;
        System.out.println("Enter first number:");
        fnum = input.nextDouble();
        System.out.println("Enter second number:");
        snum = input.nextDouble();
        answer = fnum + snum;
        // System.out.println("Summa of " + fnum + " and " + snum + " equal " + answer);
        System.out.printf("Summa of %s and %s equal %s", fnum, snum, answer);
    */    
        int arr[] = new int[5];
        
        arr[0] = 10;
        arr[1] = 20;
        System.out.println("Index\tValue");
        for (int i = 0; i < arr.length; i++){
            System.out.println(i + "\t" + arr[i]);
        }
        
        int arr2[] = {1, 2, 3, 4, 5, 6, 7};
        change(arr2);
        for (int x: arr2){
            System.out.println(x);
        }
        
        System.out.println("Multy dimension array:");
        int mutlyDimArr[][] = {{30, 31, 32, 33}, {40}, {51, 52, 53}};
        displayMulty(mutlyDimArr);
        
        System.out.println("Avarage of numbers: " + avarage(1, 6, 4, 7, 98, 65 ,78));
    }
    
    public static void change(int intArray[]){
        Random rand = new Random();
        int lengthArr = intArray.length;
        for (int i = 0; i < lengthArr; i++){
            ++intArray[rand.nextInt(lengthArr)];
        }
    }
    
    public static void displayMulty(int multyArr[][]){
        for (int row = 0; row < multyArr.length; row++){
            for (int col = 0; col < multyArr[row].length; col++){
                System.out.print(multyArr[row][col] + "\t");
            }
            System.out.println();
        }
    }
    
    public static int avarage(int ... numbers){
        int total = 0;
        for (int numb: numbers){
            total += numb;
        }
        return total / numbers.length;
    }
    
}
