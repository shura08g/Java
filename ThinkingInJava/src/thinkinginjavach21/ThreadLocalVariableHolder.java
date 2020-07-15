// 36 Многопоточность
package thinkinginjavach21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Accessor implements Runnable {
    private final int id;
    
    public Accessor(int idn) { id = idn; }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
    
    @Override
    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
    
}

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random rand = new Random(47);
        @Override
        protected synchronized Integer initialValue() {
            return rand.nextInt(1000);
        }
    };
    
    public static void increment() {
        value.set(value.get() + 1);
    }
    
    public static int get() { return value.get(); }
    
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        
        for (int i = 0; i < 5; i++) {
            exec.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}
/*
....
#3: 9967
#3: 9968
#3: 9969
#2: 9611
#3: 9970
#2: 9612
#1: 10898
#1: 10899
#1: 10900
#1: 10901
#1: 10902
#1: 10903
#1: 10904
#1: 10905
#0: 10902
#1: 10906
#0: 10903
#0: 10904
#0: 10905
#0: 10906
#4: 9606
#0: 10907
#0: 10908
#0: 10909
#0: 10910
#0: 10911
#1: 10907
#3: 9971
#2: 9613
#4: 9607
*/