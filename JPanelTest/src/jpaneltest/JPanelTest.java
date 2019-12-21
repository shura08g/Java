/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaneltest;

import javax.swing.JFrame;

/**
 *
 * @author AKravchuk
 */
public class JPanelTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gui go = new Gui();
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setSize(300, 200);
        go.setVisible(true);
    }
    
}
