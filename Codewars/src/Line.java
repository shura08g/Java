/*
The new "Avengers" movie has just been released! There are a lot of people at 
the cinema box office standing in a huge line. Each of them has a single 100, 
50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.

Vasya is currently working as a clerk. He wants to sell a ticket to every single
person in this line.

Can Vasya sell a ticket to every person and give change if he initially has no 
money and sells the tickets strictly in the order people queue?

Return YES, if Vasya can sell a ticket to every person and give change with the 
bills he has at hand at that moment. Otherwise return NO.

Examples:
Line.Tickets(new int[] {25, 25, 50}) // => YES 
Line.Tickets(new int[] {25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
Line.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to give 75 dollars of change (you can't make two bills of 25 from one of 50)

 */

public class Line {

    public static String Tickets(int[] peopleInLine) {
        int amount = 0;
        int change = 0;
        int count_25 = 0;
        int count_50 = 0;
        int cash = 0;
        for (int i = 0; i < peopleInLine.length; i++) {
            cash = peopleInLine[i];
            amount += cash;
            switch (cash) {
                case 25: change = 0; count_25++; break;
                case 50: change = 25; count_50++; break;
                case 100: change = 75; break;
            }
            switch (change) {
                case 25: {
                    if (count_25 < 1) return "NO";
                    count_25--;
                    break;
                }
                case 75: {
                    if (count_25 < 1) return "NO";
                    if ((count_25 < 3) && (count_50 == 0)) return "NO";
                    if (count_50 > 0){
                        count_50--;
                        count_25--;
                    } 
                    else {
                        count_25 -= 3;
                    }
                    break;
                }
            }
            amount -= change;            
        }
        return "YES";
    }
    
    public static void main(String[] args) {
        System.out.println(Line.Tickets(new int[]{25, 25, 50})); // => YES 
        System.out.println(Line.Tickets(new int[]{25, 100})); // => NO
        System.out.println(Line.Tickets(new int[]{25, 25, 50, 50, 100})); // => NO
        System.out.println(Line.Tickets(
                new int[]{25,25,50,100,25,50,25,100,25,25,50,100,25,25,50,100})); // => YES
    }
}
