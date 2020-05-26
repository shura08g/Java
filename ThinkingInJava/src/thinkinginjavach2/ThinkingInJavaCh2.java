/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinkinginjavach2;

import java.util.Date;

/**
 *
 * @author AKravchuk
 */
public class ThinkingInJavaCh2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(new Date());
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
    }
    
}
