// 29 Многопоточность
package thinkinginjavach21;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    
    public static int nextSerialNumber() {
        return serialNumber++; // небезопасно для потоков 
    }
    
    public synchronized static int nextSerialNumber2() {
        return serialNumber++; // небезопасно для потоков 
    }
}
