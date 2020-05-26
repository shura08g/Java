package thinkinginjavach18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
    // вывод исключений на консоль
    public static String read(String filename) throws IOException {
        // чтение по строкам
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        // System.out.print(read("BufferedInputFile.java"));
        System.out.print(read("src\\thinkinginjavach18\\BufferedInputFile.java"));
    }
}
