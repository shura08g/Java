// 24 Многопоточность
// PS D:\JavaProjects\ThinkingInJava\build\classes> java thinkinginjavach21.SynchronizedEvenGenerator
package thinkinginjavach21;

public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    
    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();  // Couse failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }
    
    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
    
}
/*
Press Control+C to exit
*/