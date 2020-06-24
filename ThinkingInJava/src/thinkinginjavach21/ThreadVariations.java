// 14 Многопоточность
package thinkinginjavach21;

// Использование именованого внутреннего класа
import static java.lang.Thread.sleep;
import java.util.concurrent.TimeUnit;

class InnerThread1 {

    private int countDown = 5;
    private final Inner inner;

    private class Inner extends Thread {

        Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }

        @Override
        public String toString() {
            return getName() + ": " + countDown;
        }
    }

    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}

// Использование анонимного внутреннего класа
class InnerThread2 {

    private int countDown = 5;
    private final Thread t;

    public InnerThread2(String name) {
        t = new Thread(name) {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }

            @Override
            public String toString() {
                return getName() + ": " + countDown;
            }
        };

        t.start();
    }
}

// Использование именованой реализации Runnable
class InnerRunnable1 {

    private int countDown = 5;
    private Inner inner;

    private class Inner implements Runnable {

        Thread t;

        Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("sleep() interrupted");
            }
        }

        @Override
        public String toString() {
            return t.getName() + ": " + countDown;
        }
    }

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }
}

// Использование анонимной реализации Runnable
class InnerRunnable2 {

    private int countDown = 5;
    private final Thread t;

    public InnerRunnable2(String name) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }

            @Override
            public String toString() {
                return Thread.currentThread().getName() + ": " + countDown;
            }
        }, name);

        t.start();
    }
}

// Отдельный метод для выполнения кода в виде задачи
class ThreadMethod {

    private int countDown = 5;
    private Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if (t == null) {
            t = new Thread(name) {
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println(this);
                            if (--countDown == 0) {
                                return;
                            }
                            TimeUnit.MILLISECONDS.sleep(10);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("sleep() interrupted");
                    }
                }

                @Override
                public String toString() {
                    return getName() + ": " + countDown;
                }
            };
            t.start();
        }
    }
}

public class ThreadVariations {

    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}
/*
InnerThread1: 5
InnerThread2: 5
InnerRunnable1: 5
InnerRunnable2: 5
ThreadMethod: 5
InnerThread2: 4
InnerThread1: 4
ThreadMethod: 4
InnerRunnable2: 4
InnerRunnable1: 4
InnerRunnable1: 3
InnerThread1: 3
InnerThread2: 3
InnerRunnable2: 3
ThreadMethod: 3
ThreadMethod: 2
InnerRunnable1: 2
InnerThread1: 2
InnerRunnable2: 2
InnerThread2: 2
InnerThread1: 1
InnerRunnable2: 1
ThreadMethod: 1
InnerThread2: 1
InnerRunnable1: 1
*/