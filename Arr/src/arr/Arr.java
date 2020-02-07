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
        System.out.println(Arrays.toString(coord)); // [[I@15db9742, [I@6d06d69c, [I@7852e922, [I@4e25154f, [I@70dea4e, [I@5c647
        System.out.println(Arrays.deepToString(coord));  // [[0, 1, 36, 9, 16, 25, 36], [0, 42, 6, 12, 20, 30, 42], 
        
        for(int[] arr: coord){
            System.out.println(Arrays.toString(arr));
        }
        
        int[] arr_inv = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        invert(arr_inv);
        System.out.println(Arrays.toString(arr_inv));
        
        invertRecurs(arr_inv, 0);
        System.out.println(Arrays.toString(arr_inv));
        
        firstToLast(arr_inv);
        System.out.println(Arrays.toString(arr_inv));
        
        lastToFirst(arr_inv);
        System.out.println(Arrays.toString(arr_inv));
        
        String str = "abcdefgh";
        String inv_str = invertStr(str);
        System.out.println(inv_str);
        
        
    }
    
    public static void invert(int[] data) {
        for (int i = 0; i < data.length / 2; i++) {
            int temp = data[i];
            data[i] = data[data.length - 1 - i];
            data[data.length - 1 - i] = temp;
        }
    }
    
    public static void invertRecurs(int[] data, int i) {
        if (i < data.length / 2) {
            int temp = data[i];
            data[i] = data[data.length - 1 - i];
            data[data.length - 1 - i] = temp;
            invertRecurs(data, i + 1);
        }
    }
    
    public static void firstToLast(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int temp = data[i];
            data[i] = data[i + 1];
            data[i + 1] = temp;
        }
    }
    
    public static void lastToFirst(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            int temp = data[i];
            data[i] = data[i - 1];
            data[i - 1] = temp;
        }
    }
    
    public static void conditionalSwap(int[] data, int lhv, int rhv) {
        if (data[lhv] > data[rhv]) {
            int temp = data[lhv];
            data[lhv] = data[rhv];
            data[rhv] = temp;
        }
    }
    
    public static String invertStr(String data) {
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length / 2; ++i) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
    
}
