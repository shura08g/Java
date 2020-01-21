/*
 * Шаблон фасад (англ. Facade) — структурный шаблон проектирования, позволяющий
 * скрыть сложность системы путём сведения всех возможных внешних вызовов к
 * одному объекту, делегирующему их соответствующим объектам системы.
 */
package facade;

/**
 *
 * @author AKravchuk
 */
public class FacadeApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Power power = new Power();
        power.on();
        
        DVDRom dvd = new DVDRom();
        dvd.load();
        dvd.unload();
        
        HDD hdd = new HDD();
        hdd.copyFromDVD(dvd);
        
        // with Facade
        Computer comp = new Computer();
        comp.copy();
    }
    
}

class Computer {
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();
    
    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}


class Power {
    void on() {
        System.out.println("Power ON");
    }
    
    void off() {
        System.out.println("Power OFF");
    }
}

class DVDRom {
    private boolean data = false;
    
    public boolean hasData() {
        return data;
    }
    
    void load() {
        data = true;
    }
    
    void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if (dvd.hasData()) {
            System.out.println("Copy data from disk");
        }
        else {
            System.out.println("Insert disk");
        }
    }
}