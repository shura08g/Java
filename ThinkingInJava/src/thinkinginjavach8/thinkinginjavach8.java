/*
 * Полиморфизм
 */
package thinkinginjavach8;

/**
 *
 * @author AKravchuk
 */
public class thinkinginjavach8 {
    public static void main(String[] args) {
        // 1. Поведение полиморфных методов при вызове из конструкторов
        new Glyph();
        /*
        Glyph() before call draw()
        Glyph.draw()
        Glyph() after call draw()
        */
        new RoundGlyph(5);
        /*
        Glyph() before call draw()
        RoundGlyph.draw(), radius = 0
        Glyph() after call draw()
        RoundGlyph.RoundGlyph(), radius = 5
        */
        
        // 2. Нисходящее преобразование и динамическое определение типов
        // (RTTI - run-time type identification)
        Useful[] x = {new Useful(), new MoreUseful()};
        
        x[0].f();
        x[1].g();
        //! x[1].u(); // error
        ((MoreUseful)x[1]).u();  // RTTI
        //((MoreUseful)x[0]).u();  //exception java.lang.ClassCastException
    }
}

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }
    
    Glyph() {
        System.out.println("Glyph() before call draw()");
        draw();
        System.out.println("Glyph() after call draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    public RoundGlyph(int r) {
        this.radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    
    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }   
}

class Useful {
    public void f() {}
    public void g() {}
}

class MoreUseful extends Useful {
    public void f() {}
    public void g() {}
    public void u() {}
    public void v() {}
}