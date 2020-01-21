/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

/**
 *
 * @author AKravchuk
 */
abstract class CarBuilderAbstract {
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
}
