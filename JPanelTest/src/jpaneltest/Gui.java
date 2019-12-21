/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaneltest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author AKravchuk
 */
public class Gui extends JFrame{
    
    private JPanel mousepane;
    private JLabel statusbar;
    
    public Gui() {
        super("JPanel Test");
        
        mousepane = new JPanel();
        mousepane.setBackground(Color.WHITE);
        add(mousepane, BorderLayout.CENTER);
        
        statusbar = new JLabel("default");
        add(statusbar, BorderLayout.SOUTH);
        
        HandlerClass handler = new HandlerClass();
        mousepane.addMouseListener(handler);
        mousepane.addMouseMotionListener(handler);
        
    }
    
    private class HandlerClass implements MouseListener, MouseMotionListener {

        //MouseListener
        @Override
        public void mouseClicked(MouseEvent e) {
            statusbar.setText(String.format("Clicked at %d, %d", e.getX(), e.getY()));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            statusbar.setText("You pressed down the mouse");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            statusbar.setText("You released the mouse button");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            statusbar.setText("You entered thr area");
            mousepane.setBackground(Color.RED);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            statusbar.setText("The mouse has left the window");
            mousepane.setBackground(Color.WHITE);
        }

        //MouseMotionListener
        @Override
        public void mouseDragged(MouseEvent e) {
            statusbar.setText("You are dragging the mouse");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            statusbar.setText("You are moving the mouse");
        }
        
    }
    
    
}
