// GUI #2
package thinkinginjavach22;

import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloLabel {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Hello Swing");
        final JLabel label = new JLabel("A Label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(2);
        label.setText("Hey! This is Different!");
        /*SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                label.setText("Hey! This is Different!");
            } 
        });*/
        /*SwingUtilities.invokeLater(() -> {
            label.setText("Hey! This is Different!"); 
        });*/
    }
}
