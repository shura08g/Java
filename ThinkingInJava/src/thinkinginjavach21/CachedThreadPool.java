// 5 Многопоточность
package thinkinginjavach21;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
/*
#0(9), #4(9), #3(9), #2(9), #1(9), #2(8), #4(8), #3(8), #3(7), #0(8), #3(6), 
#4(7), #2(7), #1(8), #2(6), #4(6), #3(5), #0(7), #3(4), #4(5), #2(5), #1(7), 
#2(4), #4(4), #3(3), #0(6), #3(2), #4(3), #2(3), #1(6), #2(2), #4(2), #3(1), 
#4(1), #0(5), #4(LiftOff), #0(4), #3(LiftOff), #2(1), #1(5), #2(LiftOff), 
#1(4), #0(3), #1(3), #0(2), #1(2), #0(1), #1(1), #0(LiftOff), #1(LiftOff),
*/