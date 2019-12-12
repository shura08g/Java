/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacollections;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author AKravchuk
 */
public class JavaCollections {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String filename = "moscow-buildings.csv";
        FileInputStream stream = null;
        
        byte[] data = null;
        try {
            stream = new FileInputStream(filename);
            int length = stream.available();
            data = new byte[length];
            stream.read(data);
        } catch (FileNotFoundException fnfe){
            System.out.println("File " + filename + " not found");
            throw new FileNotFoundException(fnfe.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(JavaCollections.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        
        String text = new String(data);
        ArrayList<String[]> lineWords = new ArrayList<>();
        String[] lines = text.split("\n");
        // System.out.println(text);
        for (String line : lines) {
            String[] words = line.split(",");
            lineWords.add(words);
        }
        
        for (String[] words : lineWords) {
            if (words[9].equals("1850")) {
                for (String word : words) {
                    System.out.print(word);
                    System.out.print("|");
                }
                System.out.println("\n-------------------------------------------");
            }
        }
        
        //HashMap<String, Integer> map = new HashMap<>();  // unsorted
        TreeMap<String, Integer> map = new TreeMap<>();   // sorted
        for (String[] words : lineWords) {
            if (map.containsKey(words[9])) {
                Integer k = map.get(words[9]);
                k += 1;
                map.put(words[9], k);
            } else {
                map.put(words[9], 1);
            }
        }
        
        String year;
        year = "1990";
        System.out.println((map.get(year) != null ? map.get(year) : "0") + " buildings constructed in " + year);
        
        year = "1890";
        System.out.println((map.get(year) != null ? map.get(year) : "0") + " buildings constructed in " + year);
        
        year = "1800";
        System.out.println((map.get(year) != null ? map.get(year) : "0") + " buildings constructed in " + year);
        
        year = "1700";
        System.out.println((map.get(year) != null ? map.get(year) : "0") + " buildings constructed in " + year);
        
        String nameOut = "filter.txt";
        String nameStream = "filter.csv";
        BufferedWriter output;
        output = new BufferedWriter(new FileWriter(nameOut, false));
        FileOutputStream outStream;
        outStream = new FileOutputStream(nameStream);
        byte[] outByte;
        String header = "Год, Построено\n";
        outByte = header.getBytes("Cp1251");
        outStream.write(outByte);
        for (String key : map.keySet()){
            try {
                int i = Integer.parseInt(key.trim());
                if (i < 2020 && i > 1500) {
                    String getKey = map.get(key).toString();
                    String line = "Год: " + key + ", Построено: " + getKey;
                    String csvOut = key + ", " + getKey + "\n";
                    System.out.println(line);
                    outByte = csvOut.getBytes("Cp1251");
                    output.append(line + "\n");
                    outStream.write(outByte);
                }
            } catch (NumberFormatException nfe) {
                // System.out.println("Год не определен");
            }   
        }
        output.close();
        outStream.close();
    }
    
}
