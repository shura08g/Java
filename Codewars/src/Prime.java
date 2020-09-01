/*
Define a function that takes an integer argument and returns logical value true
or false depending on if the integer is a prime.

Per Wikipedia, a prime number (or a prime) is a natural number greater than 
1 that has no positive divisors other than 1 and itself.

Requirements
You can assume you will be given an integer input.
You can not assume that the integer will be only positive. You may be given 
negative numbers as well (or 0).
NOTE on performance: There are no fancy optimizations required, but still the 
most trivial solutions might time out. Numbers go up to 2^31 (or similar, 
depends on language version). Looping all the way up to n, or n/2, will be too slow.
Example
is_prime(1)  // false
is_prime(2)  // true  
is_prime(-1) // false 
 */

public class Prime {

    public static boolean isPrime(int num) { 
        if (num <= 1) {
            return false;
        }
        //for (int i = 2; i <= num / 2; i++) {// очень медленный
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPrime3(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Prime.isPrime(0));  // false
        System.out.println(Prime.isPrime(1));  // false
        System.out.println(Prime.isPrime(2));  // true
        System.out.println(Prime.isPrime(73));  // true
        System.out.println(Prime.isPrime(75));  // false
        System.out.println(Prime.isPrime(-1));  // false

        System.out.println(Prime.isPrime(3));  // true
        System.out.println(Prime.isPrime(5));  // true
        System.out.println(Prime.isPrime(7));  // true
        System.out.println(Prime.isPrime(41));  // true
        System.out.println(Prime.isPrime(5099));  // true

        System.out.println(Prime.isPrime(4));  // false
        System.out.println(Prime.isPrime(6));  // false
        System.out.println(Prime.isPrime(8));  // false
        System.out.println(Prime.isPrime(9));  // false
        System.out.println(Prime.isPrime(45));  // false
        System.out.println(Prime.isPrime(-5));  // false
        System.out.println(Prime.isPrime(-8));  // false
        System.out.println(Prime.isPrime(-41));  // false

    }
}
