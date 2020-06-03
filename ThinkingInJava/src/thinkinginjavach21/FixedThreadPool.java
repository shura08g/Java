// 6 Многопоточность
package thinkinginjavach21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        // Constructor argument is number of threads
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
/*
#0(9), #3(9), #2(9), #1(9), #4(9), #0(8), #3(8), #2(8), #4(8), #1(8), #3(7), 
#2(7), #0(7), #1(7), #4(7), #3(6), #0(6), #2(6), #1(6), #4(6), #3(5), #0(5), 
#2(5), #1(5), #0(4), #4(5), #2(4), #3(4), #4(4), #3(3), #2(3), #0(3), #2(2), 
#1(4), #2(1), #1(3), #0(2), #3(2), #0(1), #3(1), #4(3), #3(LiftOff), 
#0(LiftOff), #2(LiftOff), #1(2), #4(2), #1(1), #4(1), #1(LiftOff), #4(LiftOff),
*/