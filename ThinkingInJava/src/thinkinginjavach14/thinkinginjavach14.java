package thinkinginjavach14;

class Candy {
    static { System.out.println("Load class Candy"); }
}

class Gum {
    static { System.out.println("Load class Gum"); }
}

class Cookie {
    static { System.out.println("Load class Cookie"); }
}

public class thinkinginjavach14 {
    public static void main(String[] args) {
        System.out.println("In main method");
        new Candy();
        System.out.println("After creating Candy object");
        try {
            Class.forName("thinkinginjavach14.Gum");
            //Class.forName("Gum") // не найдет. Нужно указывать имя пакетаS
        } catch(ClassNotFoundException e) {
            System.out.println("Gum not found: " + e.getMessage());
        }
        System.out.println("After method Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie object");
    }
}
/*
Output:

In main method
Load class Candy
After creating Candy object
Load class Gum
After method Class.forName("Gum")
Load class Cookie
After creating Cookie object
*/