// 17 Многопоточность
package thinkinginjavach21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
/*
Exception in thread "pool-1-thread-1" java.lang.RuntimeException
	at thinkinginjavach21.ExceptionThread.run(ExceptionThread.java:10)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
*/