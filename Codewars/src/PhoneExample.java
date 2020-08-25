/*
Write a function that accepts an array of 10 integers (between 0 and 9), 
that returns a string of those numbers in the form of a phone number.

Example:
Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
The returned format must be correct in order to complete this challenge.
Don't forget the space after the closing parentheses!
 */

public class PhoneExample {

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < numbers.length; i++) {
            if (i == 3)
                sb.append(") ");
            if (i == 6)
                sb.append("-");
            sb.append(numbers[i]);
        }
        return sb.toString();
        
    }
    
    public static String createPhoneNumber2(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d",numbers[0],numbers[1],numbers[2],numbers[3],numbers[4],numbers[5],numbers[6],numbers[7],numbers[8],numbers[9]);
    }
    
    public static void main(String[] args) {
        System.out.println(PhoneExample.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        System.out.println(PhoneExample.createPhoneNumber2(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
