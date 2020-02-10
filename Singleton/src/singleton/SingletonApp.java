/*
 * Одиночка (англ. Singleton) — порождающий шаблон проектирования,
 * гарантирующий, что в однопоточном приложении будет единственный экземпляр
 * некоторого класса, и предоставляющий глобальную точку доступа к этому
 * экземпляру.
 */
package singleton;

/**
 *
 * @author AKravchuk
 */
public class SingletonApp {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 1000;
        Thread t[] = new Thread[SIZE];
        Thread t2[] = new Thread[SIZE];
        Thread t3[] = new Thread[SIZE];
        Thread t4[] = new Thread[SIZE];
        
        //Singleton s = new Singleton();
    /*    Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        
        System.out.println(Singleton.counter);
        
        Singleton[] arr = new Singleton[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = Singleton.getInstance();
        }
        
        System.out.println(Singleton.counter);*/
        
        // in threads
        for (int i = 0; i < SIZE; i++) {
            t[i] = new Thread(new R());
            t[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            t[i].join();
        }
        System.out.println(Singleton.counter);
        
        for (int i = 0; i < SIZE; i++) {
            t2[i] = new Thread(new R2());
            t2[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            t2[i].join();
        }
        System.out.println(SingletonMultyThread.counter);
        
        for (int i = 0; i < SIZE; i++) {
            t3[i] = new Thread(new R3());
            t3[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            t3[i].join();
        }
        System.out.println(SingletonWithThread.counter);
        
        for (int i = 0; i < SIZE; i++) {
            t4[i] = new Thread(new R4());
            t4[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            t4[i].join();
        }
        System.out.println(SingletonThread.counter);
    }
    
}

// не работает в многопоточной среде
class Singleton {
    public static int counter = 0;
    private static Singleton instance;
    private Singleton() { counter++; }
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance =  new Singleton();
        }
        return instance;
    }
}

// не использует ленивую инициализацию, а сразу создает экземпляр класса
class SingletonMultyThread {
    public static int counter = 0;
    private static SingletonMultyThread instance = new SingletonMultyThread();
    private SingletonMultyThread() { counter++; }
    
    public static SingletonMultyThread getInstance() {
        return instance;
    }
}

// synchronized блокирует потоки, хотя синхронизация нужна только при первом вызове
class SingletonWithThread {
    public static int counter = 0;
    private static SingletonWithThread instance = null;
    private SingletonWithThread() { counter++; }
    
    public static synchronized SingletonWithThread getInstance() {
        if (instance == null) {
            instance =  new SingletonWithThread();
        }
        return instance;
    }
}

// самый правильный вариант
class SingletonThread {
    //private static final Object synch = new Object();
    public static int counter = 0;
    private static volatile SingletonThread instance = null;  //volatile используется при многопоточности если переменная используется не внутри блока synchronized (проблема с кешами)
    private SingletonThread() { counter++; }
    
    public static SingletonThread getInstance() {
        if (instance == null) {
            //synchronized(synch) {
            synchronized(SingletonThread.class) {
                if (instance == null) { // без этой проверки не работает (на первом if могут несколько потоков попасть в эту ветку)
                    instance =  new SingletonThread();
                }
            }
        }
        return instance;
    }
}

class R implements Runnable {

    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class R2 implements Runnable {

    @Override
    public void run() {
        SingletonMultyThread.getInstance();
    }
}

class R3 implements Runnable {

    @Override
    public void run() {
        SingletonWithThread.getInstance();
    }  
}

class R4 implements Runnable {

    @Override
    public void run() {
        SingletonThread.getInstance();
    }  
}