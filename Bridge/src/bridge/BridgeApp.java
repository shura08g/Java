/*
 * Шаблон мост (англ. Bridge) — структурный шаблон проектирования, используемый
 * в проектировании программного обеспечения чтобы «разделять абстракцию и 
 * реализацию так, чтобы они могли изменяться независимо». Шаблон мост использует
 * инкапсуляцию, агрегирование и может использовать наследование для того, чтобы
 * разделить ответственность между классами.
 */
package bridge;

/**
 *
 * @author AKravchuk
 */
public class BridgeApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car kia = new Sedan(new Kia());
        kia.showDetails();
        
        Car  skoda = new Sedan(new Skoda());
        skoda.showDetails();
        
        skoda = new Hatchback(new Skoda());
        skoda.showDetails();
        
        Car mercedes = new Coupe(new Mercedes());
        mercedes.showDetails();
        
    }   
}

abstract class Car {
    Make make;
    public Car(Make m) {
        this.make = m;
    }
    
    abstract void showType();
    
    //используем патерн шаблонный метод
    void showDetails() {
        showType();
        make.setMake();
    }
    
    
}

class Sedan extends Car {
    public Sedan(Make m) {
        super(m);
    }
    
    @Override
    void showType() {
        System.out.println("Sedan");
    }
    
//    @Override
//    void showDetails() {
//        System.out.println("Sedan");
//        make.setMake();
//    }
}

class Hatchback extends Car {
    public Hatchback(Make m) {
        super(m);
    }
    
    @Override
    void showType() {
        System.out.println("Hatchback");
    }

//    @Override
//    void showDetails() {
//        System.out.println("Hatchback");
//        make.setMake();
//    }    
}

class Coupe extends Car {
    public Coupe(Make m) {
        super(m);
    }
    
    @Override
    void showType() {
        System.out.println("Coupe");
    }   
}

interface Make {
    void setMake();
}

class Kia implements Make {
    @Override
    public void setMake() {
        System.out.println("Kia");
    }  
}

class Skoda implements Make {
    @Override
    public void setMake() {
        System.out.println("Skoda");
    } 
}

class Mercedes implements Make {
    @Override
    public void setMake() {
        System.out.println("Mercedes");
    } 
}