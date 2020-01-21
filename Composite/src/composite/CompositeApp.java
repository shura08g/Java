/*
 * Компоновщик (англ. Composite pattern) — структурный шаблон проектирования,
 * объединяющий объекты в древовидную структуру для представления иерархии от
 * частного к целому. Компоновщик позволяет клиентам обращаться к отдельным
 * объектам и к группам объектов одинаково.
 */
package composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AKravchuk
 */
public class CompositeApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape square3 = new Square();
        Shape triangle1 = new Triangle();
        Shape triangle2 = new Triangle();
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape circle3 = new Circle();
        
        Composite composite1 = new Composite();
        composite1.addComponent(square1);
        composite1.addComponent(circle1);
        composite1.addComponent(square2);
        composite1.addComponent(circle2);
        composite1.addComponent(triangle1);
        composite1.addComponent(triangle2);
        
        Composite composite2 = new Composite();
        composite2.addComponent(square3);
        composite2.addComponent(circle3);
        composite2.addComponent(new Triangle());
        
        Composite composite = new Composite();
        composite.addComponent(composite1);
        composite.addComponent(composite2);
        
        composite.draw();
    }
    
}

interface Shape {
    void draw();
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square");
    }   
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Triangle");
    }   
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }   
}

class Composite implements Shape {
    private List<Shape> components = new ArrayList();
    
    public void addComponent(Shape component) {
        components.add(component);
    }
    
    public void removeComponent(Shape component) {
        components.remove(component);
    }
    
    @Override
    public void draw() {
        /* for (Shape component : components){
            component.draw();
        } */    
        components.forEach((component) -> {
            component.draw();
        });
    }
    
}