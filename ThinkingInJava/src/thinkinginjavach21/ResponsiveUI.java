// 16 Многопоточность
// {RunByHand}
// PS D:\Programming\JavaProjects\ThinkingInJava\build\classes> java thinkinginjavach21.ResponsiveUI
package thinkinginjavach21;

import java.io.IOException;

class UnresponsiveUI {
    private volatile double d = 1.0;
    
    public UnresponsiveUI() throws IOException{
        while (d > 0) {
            d = d = (Math.PI + Math.E) / d;
        }
        System.in.read();  // Never gets here
    }
}

public class ResponsiveUI extends Thread {
    private static volatile double d = 1;
    
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }
    
    @Override
    public void run() {
        while (d > 0) {
            d = d = (Math.PI + Math.E) / d;
        }
    }
    
    public static void main(String[] args) throws IOException {
        //! new UnresponsiveUI();  // Процес придется уничтожать
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);  // Вывод информации о ходе выполнения
    }
}
