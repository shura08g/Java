/*
 * Constructor
 */
package thinkinginjavach5;

import java.util.Arrays;

/**
 *
 * @author AKravchuk
 */

enum Spiciness {
    NOT, MILD, MEDIUM, HOT, FLAMING
}

public class thinkinginjavach5 {
    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        
        // вызываем явно сборщик мусора
        System.gc();
        System.out.println("Garbadge collector worked");
        
        new Book(true);
        System.gc();
        
        //разные типы в массив
        Spiciness spice = Spiciness.MEDIUM;
        Object[] arr = {new Integer(7), new Float(3.14), spice,
                        new Double(11.11), new String("one")};
        
        System.out.println(Arrays.toString(arr));
        Object[] arr2 = {7, 3.14, "one", "two", spice, novel, new Book(true)};
        
        System.out.println(Arrays.toString(arr2));
        
        for (Spiciness s : Spiciness.values()) {
            System.out.println(s + " ordinal " + s.ordinal());
        }
    }
}

class Book {
    boolean chekedOut = false;
    
    Book(boolean checkOut) {
        chekedOut = checkOut;
    }
    
    void checkIn() {
        chekedOut = false;
    }
    
    public void finalize() {
        if (chekedOut) {
            System.out.println("Ошибка: checkedOut");
            //super.finalize();
        }
    }
}

