/*
 * Прототип, (англ. Prototype) — порождающий шаблон проектирования.
 * Задаёт виды создаваемых объектов с помощью экземпляра-прототипа и создаёт
 * новые объекты путём копирования этого прототипа. Он позволяет уйти от
 * реализации и позволяет следовать принципу «программирование через интерфейсы».
 * В качестве возвращающего типа указывается интерфейс/абстрактный класс на
 * вершине иерархии, а классы-наследники могут подставить туда наследника,
 * реализующего этот тип.
 *
 * Проще говоря, это паттерн создания объекта через клонирование другого объекта
 * вместо создания через конструктор.
 */
package prototype;

/**
 *
 * @author AKravchuk
 */
public class PrototypeApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Human original = new Human(25, "Alex");
        System.out.println(original);
        
        Human copy = (Human) original.copy();
        System.out.println(copy);
        
        copy.age = 30;
        original.name = "Martin";
        
        System.out.println(original);
        System.out.println(copy);
        
        HumanFactory factory = new HumanFactory(copy);
        Human h1 = factory.makeCopy();
        System.out.println(h1);
        
        factory.setPrototype(new Human(35, "Penny"));
        Human h2 = factory.makeCopy();
        System.out.println(h2);
        
    }
    
}

interface Copyble {
    Object copy();
}

class Human implements Copyble {
    int age;
    String name;
    
    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Human [name=" + name + ", age=" + age + "]";
    }

    @Override
    public Object copy() {
        Human copy = new Human(age, name);
        return copy;
    }
}

class HumanFactory {
    Human human;
    
    public HumanFactory(Human human) {
        setPrototype(human);
    }
    
    public final void setPrototype(Human human) {
        this.human = human;
    }
    
    Human makeCopy() {
        return (Human)human.copy();
    }
    
}