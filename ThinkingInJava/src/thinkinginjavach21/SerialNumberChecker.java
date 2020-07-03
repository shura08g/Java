// 30 Многопоточность
package thinkinginjavach21;

//Многократно использует память во избежание ее исчерпания

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;
    
    public CircularSet(int size) {
        array = new int[size];
        len = size;
        // Инициализация значением, которое не производится
        // кассом SerialNumberGenerator
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }
    
    public synchronized void add(int i) {
        array[index] = i;
        // Перенос индекса с перезаписью старых элементов
        index = ++index % len;
    }
    
    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++) {
            if (array[i] == val) return true;
        }
        return false;
    }
}

public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(100);
    private static ExecutorService exec = Executors.newCachedThreadPool();
    
    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (serials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new SerialChecker());
        }
        // Остановка через n секунд при наличии аргумента
        TimeUnit.SECONDS.sleep(new Integer(args[0]));
        System.out.println("No duplicates detected");
        System.exit(0);
    }
}
/*
Duplicate: 4929
Duplicate: 5880
Duplicate: 5881
Duplicate: 5879
*/