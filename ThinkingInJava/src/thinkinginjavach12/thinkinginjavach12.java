/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinkinginjavach12;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AKravchuk
 */
public class thinkinginjavach12 {
    public static void main(String[] args) {
        TestException test1 = new TestException();
        try {
            test1.test();
        } catch (MyException ex) {
            System.err.println("Intercept exception " + ex);
            //ex.printStackTrace();
        }
        
        TestException test2 = new TestException();
        try {
            test2.test();
        } catch (MyException ex) {
            Logger.getLogger(thinkinginjavach12.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            throw new Exception("Exception test...");
        } catch (Exception e) {
            System.out.println("e.getMessage() " + e.getMessage());
            System.out.println("e.getLocalizedMessage() " + e.getLocalizedMessage());
//            for (StackTraceElement st : e.getStackTrace()) {
//                System.out.println("e.getStackTrace() " + st);
//            }
             System.out.println("e.getStackTrace() " + Arrays.toString(e.getStackTrace()));
        }
    }
    
}

class MyException extends Exception {}

class TestException {
    void test() throws MyException {
        System.out.println("Throw exception");
        throw new MyException();
    }
}
