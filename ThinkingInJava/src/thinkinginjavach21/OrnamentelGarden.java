// 37 Многопоточность
package thinkinginjavach21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Count {
    private int count = 0;
    private Random rand = new Random(47);
    
    // Удаляем ключевое слово  synchronized чтобы увидеть сбой в системе подсчета
    /*
    Total: 75
    Sum of Entances: 150
    */
    public synchronized int increment() {
        int temp = count;
        if(rand.nextBoolean()) // Уступает управление
            Thread.yield();    // в половине случаев
        return (count = ++temp);
    }
    
    public synchronized int value() { return count; }
}


class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<Entrance>();
    private int number = 0;
    // Для чтения синхронизация не нужна
    private final int id;
    private static volatile boolean canceled = false;
    
    // Атомарная опереция с volatile-полем
    public static void cancel() { canceled = true; }
    
    public Entrance(int id) {
        this.id = id;
        // Задача остается в списке. Также предотвращает
        // уничтожение "метрвых" задач при уборке мусора
        entrances.add(this);
    }

    @Override
    public void run() {
        while(!canceled) {
            synchronized(this) {
                ++number;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch(InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Stopping " + this);
    }
    
    public synchronized int getValue() { 
        return number; 
    }
    
    @Override
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }
    
    public static int getTotalCount() {
        return count.value();
    }
    
    public static int sumEntrances() {
        int sum = 0;
        for(Entrance entrance : entrances)
            sum += entrance.getValue();
        return sum;
    }
    
}

public class OrnamentelGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        
        for (int i = 0; i < 5; i++)
            exec.execute(new Entrance(i));
        
        // Поработв=ать некоторое время, затем остановиться и собрать данные
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();
        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.println("Some tasks were not terminated!");
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entances: " + Entrance.sumEntrances());
    }
}
/*
...
Entrance 4: 29 Total: 141
Entrance 2: 29 Total: 145
Entrance 3: 29 Total: 144
Entrance 1: 29 Total: 143
Entrance 0: 29 Total: 142
Entrance 3: 30 Total: 146
Entrance 0: 30 Total: 150
Entrance 2: 30 Total: 148
Entrance 4: 30 Total: 149
Entrance 1: 30 Total: 147
Stopping Entrance 3: 30
Stopping Entrance 4: 30
Stopping Entrance 1: 30
Stopping Entrance 2: 30
Stopping Entrance 0: 30
Total: 150
Sum of Entances: 150
*/