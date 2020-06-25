// 26 Многопоточность
//PS D:\JavaProjects\ThinkingInJava\build\classes> java thinkinginjavach21.AttemptLocking
package thinkinginjavach21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    
    public void untime() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) lock.unlock();
        }
    }
    
    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) lock.unlock();
        }
    }
    
    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untime(); // True - блокировка доступна
        al.timed(); // True - блокировка доступна
        // Создаем отдельную задачу для получения блокировки
        new Thread() {
            { setDaemon(true); }
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        
        Thread.yield(); // предоставляем возможность 2-й задаче
        al.untime(); // False - блокировка захвачена задачей
        //Thread.yield();
        al.timed(); // False - блокировка захвачена задачей
    }
}
/*
tryLock(): true
tryLock(2, TimeUnit.SECONDS): true
tryLock(): true  !!!
acquired
tryLock(2, TimeUnit.SECONDS): false
*/