/*
 * Посетитель (англ. visitor) — поведенческий шаблон проектирования,
 * описывающий операцию, которая выполняется над объектами других классов.
 * При изменении visitor нет необходимости изменять обслуживаемые классы.
 * 
 * Шаблон демонстрирует классический приём восстановления информации о
 * потерянных типах, не прибегая к понижающему приведению типов при помощи
 * двойной диспетчеризации.
 */
package visitor;

/**
 *
 * @author AKravchuk
 */
public class VisitorApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*BodyElement body = new BodyElement();
        EngineElement engine = new EngineElement();*/
        Element body = new BodyElement();
        Element engine = new EngineElement();
        Visitor visitor = new HooliganVisitor();
        CarElement car = new CarElement();
        
        /*visitor.visit(body);
        visitor.visit(engine);*/
        body.accept(visitor);
        engine.accept(visitor);
        car.accept(visitor);
        
        visitor = new MechanicVisitor();
        /*visitor.visit(body);
        visitor.visit(engine);*/
        
        body.accept(visitor);
        engine.accept(visitor);
        car.accept(visitor);
        
    }
    
}

//Visitor
interface Visitor {
    void visit(EngineElement engine);
    void visit(BodyElement body);
    void visit(WheelElement wheel);
    void visit(CarElement car);
}

//Element
interface Element {
    void accept(Visitor visitor);
}

//Body
class BodyElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//Engine
class EngineElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//Wheel
class WheelElement implements Element {
    String name;
    
    public WheelElement(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
        
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//Car
class CarElement implements Element {
    Element[] elements;
    
    public CarElement() {
        this.elements = new Element[] {new WheelElement("левое переднее"),
                                       new WheelElement("правое переднее"),
                                       new WheelElement("левое заднее"),
                                       new WheelElement("правое заднее"),
                                       new BodyElement(),
                                       new EngineElement(),};
    }
    
    @Override
    public void accept(Visitor visitor) {
        for (Element elem : elements) {
            elem.accept(visitor);
        }
        visitor.visit(this);
    }
}


class HooliganVisitor implements Visitor {
    @Override
    public void visit(EngineElement engine) {
        System.out.println("Завел двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Постучал по кузову");
    }  

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Постучал по " + wheel.getName() + " колесу");
    }
    
    @Override
    public void visit(CarElement car) {
        System.out.println("Покурил по машине");
    }
}

class MechanicVisitor implements Visitor {
    @Override
    public void visit(EngineElement engine) {
        System.out.println("Проверил двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Отполировал кузов");
    }  
    
    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Проверил давление в " + wheel.getName() + " колесе");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Проверил автомобиль");
    }
}