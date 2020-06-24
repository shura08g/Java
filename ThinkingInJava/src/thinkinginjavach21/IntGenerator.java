// 21 Многопоточность
package thinkinginjavach21;

public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    // Для отмены
    public void cancel() {canceled = true;}
    public boolean isCanceled() {return canceled;}
}
