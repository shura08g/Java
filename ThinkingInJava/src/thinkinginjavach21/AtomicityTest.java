// 28 Многопоточность
// D:\JavaProjects\ThinkingInJava\build\classes>
//"C:\Program Files\Java\jdk1.8.0_191\bin\javap.exe" -c thinkinginjavach21.AtomicityTest
package thinkinginjavach21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private int i = 0;
    public int getValue() {return i;}
    private synchronized void evenIncrement() {i++; i++;}
    public void run() {
        while (true) {
            evenIncrement();
        }
    }
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
/*
1
21

*/

/*
Compiled from "AtomicityTest.java"
public class thinkinginjavach21.AtomicityTest implements java.lang.Runnable {
  public thinkinginjavach21.AtomicityTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: iconst_0
       6: putfield      #2                  // Field i:I
       9: return

  public int getValue();
    Code:
       0: aload_0
       1: getfield      #2                  // Field i:I
       4: ireturn

  public void run();
    Code:
       0: aload_0
       1: invokespecial #3                  // Method evenIncrement:()V
       4: goto          0

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #4                  // Method java/util/concurrent/Executors.newCachedThreadPool:()Ljava/util/concurrent/ExecutorService;
       3: astore_1
       4: new           #5                  // class thinkinginjavach21/AtomicityTest
       7: dup
       8: invokespecial #6                  // Method "<init>":()V
      11: astore_2
      12: aload_1
      13: aload_2
      14: invokeinterface #7,  2            // InterfaceMethod java/util/concurrent/ExecutorService.execute:(Ljava/lang/Runnable;)V
      19: aload_2
      20: invokevirtual #8                  // Method getValue:()I
      23: istore_3
      24: iload_3
      25: iconst_2
      26: irem
      27: ifeq          41
      30: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
      33: iload_3
      34: invokevirtual #10                 // Method java/io/PrintStream.println:(I)V
      37: iconst_0
      38: invokestatic  #11                 // Method java/lang/System.exit:(I)V
      41: goto          19
}
*/