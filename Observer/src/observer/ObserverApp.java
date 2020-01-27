/*
 * Наблюдатель (англ. Observer) — поведенческий шаблон проектирования. Также
 * известен как «подчинённые» (Dependents). Реализует у класса механизм, который
 * позволяет объекту этого класса получать оповещения об изменении состояния
 * других объектов и тем самым наблюдать за ними[2].
 * 
 * Классы, на события которых другие классы подписываются, называются субъектами
 * (Subjects), а подписывающиеся классы называются наблюдателями (Observers) [3].
 *
 * Похожие шаблоны: «издатель-подписчик», «посредник», «одиночка».
 * 
 * или Издатель/Подписчик (Publisher/Subscriber)
 */
package observer;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AKravchuk
 */
public class ObserverApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();
        
        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());
        station.setMeasurements(25, 760);
        station.setMeasurements(28, 780);
    }
    
}

interface Observed {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class MeteoStation implements Observed {
    int temperature;
    int pressure;
    List<Observer> observers = new ArrayList();
    
    public void setMeasurements(int t, int p){
        this.temperature = t;
        this.pressure = p;
        notifyObservers();
    }
    
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach((o) -> {
            o.handleEveny(temperature, pressure);
        });
    }
    
}

interface Observer {
    void handleEveny(int temp, int presser);
}

class ConsoleObserver implements Observer {
    @Override
    public void handleEveny(int temp, int presser) {
        System.out.println("Погода изменилась. Температура = " + temp + ". Давление = " + presser + ".");
    }  
}

class FileObserver implements Observer {
    @Override
    public void handleEveny(int temp, int presser) {
        File f;
        try {
            f = File.createTempFile("TempPressure", "_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("Погода изменилась. Температура = " + temp + ". Давление = " + presser + ".");
            pw.println();
            pw.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
}