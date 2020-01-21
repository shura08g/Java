/*
 * Строитель (англ. Builder) — порождающий шаблон проектирования предоставляет
 * способ создания составного объекта.
 */
package builder;

/**
 *
 * @author AKravchuk
 */
public class BuilderApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car car_default = new CarBuilder().build();
        System.out.println(car_default);
        
        Car car = new CarBuilder()
                      .buildMarka("Mercedes")
                      .buildTransmission(Transmission.AUTO)
                      .buildMaxSpeed(250)
                      .build();
        
        System.out.println(car);
        
        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        Car subaru = director.buildCar();
        
        System.out.println(subaru);
        
        director.setBuilder(new FordMondeoBuilder());
        Car ford = director.buildCar();
        System.out.println(ford);
    }
    
}

enum Transmission {
    MANUAL,
    AUTO
}

class Car {
    String make;
    private Transmission transmission;
    private int maxSpeed;
    
    public void setMake(String name) {
        this.make = name;
    } 
    
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    @Override
    public String toString() {
        return "Car [make=" + make + ", transmission=" + transmission
                + ", maxSpeed=" + maxSpeed + "]";
    }
}

class CarBuilder {
    String marka = "Default";
    Transmission trans = Transmission.MANUAL;
    int speed = 220;
    
    CarBuilder buildMarka(String name) {
        this.marka = name;
        return this;
    }
    
    CarBuilder buildTransmission(Transmission t) {
        this.trans = t;
        return this;
    }
    
    CarBuilder buildMaxSpeed(int s) {
        this.speed = s;
        return this;
    }
    
    Car build() {
        Car car = new Car();
        car.setMake(marka);
        car.setTransmission(trans);
        car.setMaxSpeed(speed);
        return car;
    }
}

/*abstract class CarBuilderAbstract {
    Car car;
    
    void createCar() {
        car = new Car();
    }
    
    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();
    
    Car getCar() {
        return car;
    }
}*/

/*class Director {
    CarBuilderAbstract builder;
    
    void setBuilder(CarBuilderAbstract b) {
        this.builder = b;
    }
    
    Car buildCar() {
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Car car = builder.getCar();
        return car;
    }
}*/