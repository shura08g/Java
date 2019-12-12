/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arr;
import java.util.Arrays;
/**
 *
 * @author AKravchuk
 */
public class Arr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int MAX1 = 10, MAX2 = 7;
        int[] even = new int[MAX1];
        for (int i = 0; i < even.length; i++){
            even[i] = i * 2 + 2;
        }
        for(int number: even){
            System.out.println(number);
        }
        
        int[][] coord = new int[MAX1][MAX2];
        for(int i = 0; i < coord.length; i++){
            for(int j = 0; j < coord[0].length; j++){
                coord[i][j] = (i + j) * j;
            }
        }
        coord[0][2] = coord[0][coord[0].length-1];
        coord[1][1] = coord[1][coord[0].length-1];
        coord[2][4] = coord[2][coord[0].length-1];
        coord[3][3] = coord[3][coord[0].length-1];
        for(int[] ar1: coord){
            System.out.print("[ ");
            int count = 0;
            for(int point: ar1){
                count++;
                //if(point == ar1[ar1.length-1]){
                if(count == ar1.length){
                    System.out.print(point);
                }
                else{
                    System.out.print(point + "," + "\t");
                }
            }
            System.out.print(" ]\n");
        }
        
        System.out.println(Arrays.toString(even));
        System.out.println(Arrays.toString(coord));
        
        for(int[] arr: coord){
            System.out.println(Arrays.toString(arr));
        }
    }
    
}
