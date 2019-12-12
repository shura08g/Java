/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package except;

/**
 *
 * @author AKravchuk
 */

import javax.swing.JOptionPane;
import java.util.Random;

public class Except {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rnd = new Random(System.currentTimeMillis());
        int secret = 1 + rnd.nextInt(10);
        int userData = 0;
        String userInput;
        
        while(true){
            userInput = JOptionPane.showInputDialog("Угадайте число от 1 до 10");
            
            try{
                userData = Integer.parseInt(userInput);
                if (userData == secret){
                    JOptionPane.showMessageDialog(null, "Вы угадали число");
                    break;
                }
            }
            catch(NumberFormatException e){
                // if user press "Cancel"
                if(e.toString().contains("null")){
                    System.exit(0);
                }
                // if invalid value
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Недопустимое значение!",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
