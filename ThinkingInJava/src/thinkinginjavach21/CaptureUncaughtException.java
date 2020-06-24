// 19 Многопоточность
package thinkinginjavach21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
/*
thinkinginjavach21.HandlerThreadFactory@4e25154f creating new Thread
created Thread[Thread-0,5,main]
eh = thinkinginjavach21.MyUncaughtExceptionHandler@70dea4e
run() by Thread[Thread-0,5,main]
eh = thinkinginjavach21.MyUncaughtExceptionHandler@70dea4e
thinkinginjavach21.HandlerThreadFactory@4e25154f creating new Thread
created Thread[Thread-1,5,main]
eh = thinkinginjavach21.MyUncaughtExceptionHandler@7dfc44a
caught java.lang.RuntimeException
*/