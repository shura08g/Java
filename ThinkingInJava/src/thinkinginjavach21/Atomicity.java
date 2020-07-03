// 27 Многопоточность
// D:\JavaProjects\ThinkingInJava\build\classes>
//"C:\Program Files\Java\jdk1.8.0_191\bin\javap.exe" -c thinkinginjavach21.Atomicity
package thinkinginjavach21;

public class Atomicity {
    int i;
    void f1() { i++; }
    void f2() { i += 3;}
    
    public static void main(String[] args) {
        
    }
}
/*
между get и put производятся опперации поэтому i++ и i += 3 не атомарные операции
*/
/*
Compiled from "Atomicity.java"
public class thinkinginjavach21.Atomicity {
  int i;

  public thinkinginjavach21.Atomicity();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  void f1();
    Code:
       0: aload_0
       1: dup
       2: getfield      #2                  // Field i:I
       5: iconst_1
       6: iadd
       7: putfield      #2                  // Field i:I
      10: return

  void f2();
    Code:
       0: aload_0
       1: dup
       2: getfield      #2                  // Field i:I
       5: iconst_3
       6: iadd
       7: putfield      #2                  // Field i:I
      10: return

  public static void main(java.lang.String[]);
    Code:
       0: return
}
*/