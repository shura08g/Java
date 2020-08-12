// GUI #4
package thinkinginjavach22;

import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SubmitSwingProgram extends JFrame {
    JLabel label;
    public SubmitSwingProgram() {
        super("Hello Swing");
        label = new JLabel("A Label");
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }
    
    static SubmitSwingProgram ssp;
    
    public static void main(String[] args) throws InterruptedException {
        SwingUtilities.invokeLater(() -> {
            ssp = new SubmitSwingProgram();
        });
        TimeUnit.SECONDS.sleep(2);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp.label.setText("Hey! This is Different!");
            }
        });
    }
}
