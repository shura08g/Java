package webbrowser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author AKravchuk
 */
public class ReadFile extends JFrame {
    private JTextField addressBar;
    private JEditorPane display;
    
    //constructor
    public ReadFile() {
        super("My Browser");
        
        addressBar = new JTextField("enter a URL hoss!");
        addressBar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loadCrap(e.getActionCommand());
                }
            }
        );
        add(addressBar, BorderLayout.NORTH);
        
        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
            new HyperlinkListener() {
                @Override
                public void hyperlinkUpdate(HyperlinkEvent e) {
                    if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
                        loadCrap(e.getURL().toString());
                    }
                }
            }
        );
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500, 300);
        setVisible(true);
    }
    
    //load crap to display on the screen
    private void loadCrap(String userText) {
        try {
            display.setPage(userText);
            addressBar.setText(userText);
        } catch(Exception e) {
            System.out.println("crap!");
        }
    }
}
