/*
 * Приспособленец (англ. flyweight, «легковесный (элемент)») — структурный 
 * шаблон проектирования, при котором объект, представляющий себя как уникальный
 * экземпляр в разных местах программы, по факту не является таковым.
 */
package flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author AKravchuk
 */
public class FlyweightApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        
        List<Shape> shapes = new ArrayList<>();
        
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));
        
        Random rand = new Random();
        shapes.forEach((shape) -> {
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            shape.draw(x, y);
        });
        
        Map<String, Shape> sh = shapeFactory.shapes();
        //for (Map.Entry<String, Shape> entry : sh.entrySet()) {
        sh.entrySet().forEach((entry) -> {
            String key = entry.getKey();
            Shape value = entry.getValue();
            System.out.println(key + " = " + value);
        });
        
        Iterator it = sh.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
    
}

//Flywight
interface Shape {
    void draw(int x, int y);
}

//Point Flyweight
class Point implements Shape {
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + ", " + y + "): draw point");
    }   
}

//Circle Flyweight
class Circle implements Shape {
    int r = 5;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + ", " + y + "): draw circle with radius " + r);
    }   
}

//Rectangle Flyweight
class Square implements Shape {
    int a = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + ", " + y + "): draw square with side " + a);
    }   
}

class ShapeFactory {
    private static final Map<String, Shape> shapes = new HashMap<>();
    
    public Shape getShape(String shapeName) {
        Shape shape = shapes.get(shapeName);
        if (shape == null) {
            switch (shapeName) {
                case "circle":
                    shape = new Circle();
                    break;
                case "square":
                    shape = new Square();
                    break;
                case "point":
                    shape = new Point();
                    break;
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }
    
    public Map<String, Shape> shapes() {
        return shapes;
    }
}