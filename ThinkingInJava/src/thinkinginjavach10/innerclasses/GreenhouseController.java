/*
 * Используем паттерн "Комманда" - каждый обьект в eventList представляет запрос, 
 * инкапсулирующий обьект.
 *  D:\Programming\JavaProjects\ThinkingInJava\build\classes> java thinkinginjavach10.innerclasses.GreenhouseController 5000
 */
package thinkinginjavach10.innerclasses;
import thinkinginjavach10.innerclasses.controller.*;
/**
 *
 * @author AKravchuk
 */
// {Args: 5000}
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        // Вместо жесткой фиксации параметров в коде
        // модно было бы считать информацию
        // из текстового файла
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
            gc.new ThermostatNight(0),
            gc.new LightOn(200),
            gc.new LightOff(400),
            gc.new WaterOn(600),
            gc.new WaterOff(800),
            gc.new ThermostatDay(1400)
        };
        
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1) {
            gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
            gc.run();
        }
    }
    /*
    БАМ!
    Термостат использует ночной режим
    Свет включен
    Свет выключен
    Полив включен
    Полив выключен
    Термостат использует дневной режим
    Перезапуск системы
    Отключение
    */
}
