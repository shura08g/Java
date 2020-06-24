// 18 Многопоточность
package thinkinginjavach21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NaiveExceptionHandling {
    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (RuntimeException e) {
            // Эта команда не будет выполнятся!
            System.out.println("Exception has been handled!");
        }
    }
}
/*
Exception in thread "pool-1-thread-1" java.lang.RuntimeException
	at thinkinginjavach21.ExceptionThread.run(ExceptionThread.java:10)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
*/