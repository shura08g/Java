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
class Director {
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
}
