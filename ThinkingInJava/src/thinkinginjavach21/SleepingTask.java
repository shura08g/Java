// 9 Многопоточность
package thinkinginjavach21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.print(status());
                // old style
                //Thread.sleep(100);
                // Lava SE5/6 style
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
    }
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
/*
#0(9), #1(9), #2(9), #4(9), #3(9), #3(8), #4(8), #2(8), #1(8), #0(8), #1(7), 
#0(7), #2(7), #4(7), #3(7), #4(6), #1(6), #2(6), #0(6), #3(6), #0(5), #2(5), 
#1(5), #3(5), #4(5), #3(4), #4(4), #1(4), #0(4), #2(4), #4(3), #0(3), #2(3), 
#1(3), #3(3), #4(2), #3(2), #0(2), #2(2), #1(2), #1(1), #2(1), #3(1), #0(1), 
#4(1), #2(LiftOff), #1(LiftOff), #0(LiftOff), #4(LiftOff), #3(LiftOff),
*/