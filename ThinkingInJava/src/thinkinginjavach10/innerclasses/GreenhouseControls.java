/*
 * Пример конкретного приложения на основе системы
 * управления, все находится в одном класе. Внутренние
 * классы дают возможность инкапсулировать различную
 * функциональность для каждого отдельного события.
*/

package thinkinginjavach10.innerclasses;

import thinkinginjavach10.innerclasses.controller.*;
/**
 *
 * @author AKravchuk
 */
public class GreenhouseControls extends Contoller{
    private boolean ligth = false;
    
    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            // Поместите сюда код укправления оборудыванием,
            // выполняющий непосредственное включение света.
            ligth = true;
        }
        
        @Override
        public String toString() {
            return "Свет включен";
        }
    }
    
    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            // Поместите сюда код укправления оборудыванием,
            // выполняющий непосредственное включение света.
            ligth = false;
        }
        
        @Override
        public String toString() {
            return "Свет выключен";
        }
    }
    
    public boolean water = false;
    
    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            // Здесь размещается код управления оборудыванием
            water = true;
        }
        
        @Override
        public String toString() {
            return "Полив включен";
        }
    }
    
    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            // Здесь размещается код управления оборудыванием
            water = false;
        }
        
        @Override
        public String toString() {
            return "Полив выключен";
        }
    }
    
    private String thermostat = "День";
    
    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            // Здесь размещается код управления оборудыванием
            thermostat = "Ночь";
        }
        
        @Override
        public String toString() {
            return "Термостат использует ночной режим";
        }
    }
    
    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            // Здесь размещается код управления оборудыванием
            thermostat = "День";
        }
        
        @Override
        public String toString() {
            return "Термостат использует дневной режим";
        }
    }
    
    // Пример метода action(), вставляющий новый экземпляр
    // самого себя в список событий
    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }
        
        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }
        
        @Override
        public String toString() {
            return "БАМ!";
        }
    }
    
    public class Restart extends Event {
        private Event[] eventList;
        
        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList) {
                addEvent(e);
            }
        }
        
        @Override
        public void action() {
            for (Event e : eventList) {
                e.start(); // Перезапуск каждого события
                addEvent(e);
            }
            start(); // Перезапуск текущего события
            addEvent(this);
        }
        
        @Override
        public String toString() {
            return "Перезапуск системы";
        }
    }
    
    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }
        
        @Override
        public void action() {
            System.exit(0);
        }
        
        @Override
        public String toString() {
            return "Отключение";
        }
    }
}
