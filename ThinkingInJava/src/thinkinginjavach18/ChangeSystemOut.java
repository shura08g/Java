package thinkinginjavach18;

import java.io.PrintWriter;

public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world");
        
        out.print("Print test");
        out.println();
    }
}
