/*
Welcome. In this kata, you are asked to square every digit of a number.

For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1.

Note: The function accepts an integer and returns an integer
 */

public class SquareDigit {

    public int squareDigits(int n) {
        String strNum = String.valueOf(n);
        char[] charNum = strNum.toCharArray();
        StringBuilder strRes = new StringBuilder();
        int result = 0;
        for (char ch : charNum) {
            int res = Integer.valueOf(String.valueOf(ch));
            res *= res;
            strRes.append(res);
        }
        result = Integer.valueOf(strRes.toString());
        return result;
    }
    
    public int squareDigits2(int n) {
        String result = "";
        while (n != 0 ) {
            int num = n % 10;
            result = num * num + result;
            n /= 10;
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        SquareDigit sd = new SquareDigit();
        System.out.println(sd.squareDigits(919));
        System.out.println(sd.squareDigits2(919));
    }

}
