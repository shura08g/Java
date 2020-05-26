package thinkinginjavach18;

import java.io.File;

public class DirectoryDemo {
    public static void main(String[] args) {
        // Все каталоги
        PPrint.pprint(Directory.walk(".").dirs);
        System.out.println("----------------------------------");
        // Все файлы, имена которых начинаются с 'T'
        for (File file : Directory.walk(".", "T.*")) {
            System.out.println(file);
        }
        System.out.println("----------------------------------");
        // Все файлы java, имена которых начинаются с 'T'
        for (File file : Directory.walk(".", "T.*\\.java")) {
            System.out.println(file);
        }
        System.out.println("----------------------------------");
        // Файлы классов, имена которых содержат 'Z' или 'z'
        for (File file : Directory.walk(".", ".*[Zz].*\\.class")) {
            System.out.println(file);
        }
        System.out.println("----------------------------------");
        
    }
}
