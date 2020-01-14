/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorymethod;

import java.util.Date;

/**
 *
 * @author AKravchuk
 */
public class FactoryMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Watch watch = new DigitalWatch();
        //Watch watch = new RomeWatch();
        //watch.showTime();
        
        //WatchMaker maker = new DigitalWatchMaker();
        //WatchMaker maker = new RomeWatchMaker();
        //Watch watch = maker.createWatch();
        //watch.showTime();
        
        WatchMaker maker = getMakerByName("Digital");
        //WatchMaker maker = getMakerByName("Error");
        //WatchMaker maker = getMakerByName("Rome");
        Watch watch = maker.createWatch();
        watch.showTime();
    }
    
    public static WatchMaker getMakerByName(String maker) {
        if (maker.equals("Digital")) {
            return new DigitalWatchMaker();
        }
        else if (maker.equals("Rome")) {
            return new RomeWatchMaker();
        }
        
        throw new RuntimeException("Not supported " + maker);
    }
    
}

/*interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("XX-XX-XX");
    }
}*/

/*interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch(){
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch(){
        return new RomeWatch();
    }
}*/