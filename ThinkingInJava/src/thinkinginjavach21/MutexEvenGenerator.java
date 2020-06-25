// 25 Многопоточность
// PS D:\JavaProjects\ThinkingInJava\build\classes> java thinkinginjavach21.MutexEvenGenerator
package thinkinginjavach21;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();
    
    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }
    
    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
    
}
/*
Press Control+C to exit
*/