// 4 Многопоточность
package thinkinginjavach21;

public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
/*
Waiting for LiftOff
#0(9), #1(9), #2(9), #0(8), #2(8), #0(7), #0(6), #3(9), #4(9), #3(8), #0(5), 
#2(7), #2(6), #2(5), #2(4), #1(8), #2(3), #1(7), #0(4), #3(7), #4(8), #0(3), 
#3(6), #1(6), #2(2), #1(5), #3(5), #0(2), #4(7), #0(1), #3(4), #1(4), #2(1), 
#1(3), #3(3), #0(LiftOff), #4(6), #3(2), #1(2), #2(LiftOff), #4(5), #3(1), 
#1(1), #4(4), #3(LiftOff), #1(LiftOff), #4(3), #4(2), #4(1), #4(LiftOff),
*/