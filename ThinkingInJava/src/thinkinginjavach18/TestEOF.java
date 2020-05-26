package thinkinginjavach18;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {

    public static void main(String[] args) throws IOException {
        DataInputStream in;
        in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("src//thinkinginjavach18//TestEOF.java")));
        while (in.available() != 0) {
            System.out.print((char) in.readByte());
        }
    }
}
