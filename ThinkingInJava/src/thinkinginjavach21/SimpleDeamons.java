// 11 Многопоточность
package thinkinginjavach21;

import java.util.concurrent.TimeUnit;

public class SimpleDeamons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread deamon = new Thread(new SimpleDeamons());
            deamon.setDaemon(true);
            deamon.start();
        }
        System.out.println("All deamons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
/*
All deamons started
Thread[Thread-8,5,main] thinkinginjavach21.SimpleDeamons@243fc8f3
Thread[Thread-5,5,main] thinkinginjavach21.SimpleDeamons@2908e856
Thread[Thread-1,5,main] thinkinginjavach21.SimpleDeamons@780b9c4a
Thread[Thread-9,5,main] thinkinginjavach21.SimpleDeamons@73726bbb
Thread[Thread-7,5,main] thinkinginjavach21.SimpleDeamons@2d4021ce
Thread[Thread-0,5,main] thinkinginjavach21.SimpleDeamons@93df8ab
Thread[Thread-6,5,main] thinkinginjavach21.SimpleDeamons@64fe8248
Thread[Thread-3,5,main] thinkinginjavach21.SimpleDeamons@53da5094
Thread[Thread-4,5,main] thinkinginjavach21.SimpleDeamons@2682a97f
Thread[Thread-2,5,main] thinkinginjavach21.SimpleDeamons@109827e7
*/