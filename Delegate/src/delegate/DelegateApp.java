/*
 * Делегирование (англ. Delegation) — основной шаблон проектирования,
 * в котором объект внешне выражает некоторое поведение, но в реальности
 * передаёт ответственность за выполнение этого поведения связанному объекту.
 * Шаблон делегирования является фундаментальной абстракцией, на основе которой
 * реализованы другие шаблоны - композиция (также называемая агрегацией),
 * примеси (mixins) и аспекты (aspects).
 */
package delegate;

/**
 *
 * @author AKravchuk
 */
public class DelegateApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A a = new A();
        a.f();
        
        B b = new B();
        b.f();
        
        Painter painter = new Painter();
        painter.setGraphics(new Square());
        painter.draw();
        
        painter.setGraphics(new Triangle());
        painter.draw();
        
        painter.setGraphics(new Circle());
        painter.draw();
    }
    
}

class A {
    void f() {
        System.out.println("f()");
    }
}

class B {
    A a = new A();
    void f() {
        a.f();
    }
}

interface Graphics {
    void draw();
}

class Triangle implements Graphics {
    @Override
    public  void draw() {
        System.out.println("Draw triangle");
    }
}

class Square implements Graphics {
    @Override
    public  void draw() {
        System.out.println("Draw square");
    }
}

class Circle implements Graphics {
    @Override
    public  void draw() {
        System.out.println("Draw circle");
    }
}

class Painter {
    /*void drawTriangle() { System.out.println("Draw triangle"); }
    void drawSquare() { System.out.println("Draw square"); }
    void drawCircle() { System.out.println("Draw circle"); }*/
    
    Graphics graphics;
    
    void setGraphics(Graphics g) {
        graphics = g;
    }
    
    void draw() {
        graphics.draw();
    }
}