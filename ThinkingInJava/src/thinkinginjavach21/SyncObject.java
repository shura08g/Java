// 35 Многопоточность
package thinkinginjavach21;

class DualSynch {
    private Object synchObject = new Object();
    
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }
    
    public void g() {
        synchronized(synchObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread() {
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }
}
/*
g()
f()
g()
f()
g()
f()
g()
f()
g()
f()
*/

/*
g()
g()
g()
f()
g()
f()
g()
f()
f()
f()
*/