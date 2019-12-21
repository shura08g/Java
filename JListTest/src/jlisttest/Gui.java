/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlisttest;

/**
 *
 * @author AKravchuk
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

public class Gui extends JFrame{
    
    private JList list;
    private JList leftlist;
    private JList rightlist;
    private JButton movebutton;
    private static final String[] COLORNAME = {"black", "blue", "red", "white", "yellow"};
    private static final Color[] COLORS = {Color.BLACK, Color.BLUE, Color.RED, Color.WHITE, Color.YELLOW};
    private static final String[] FOODS = {"bacon", "wings", "ham", "beef", "morebacon"};
    
    public Gui(){
        super("JList");
        setLayout(new FlowLayout());
        
        list = new JList(COLORNAME);
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list));
        
//        list.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                getContentPane().setBackground(colors[list.getSelectedIndex()]);
//            }
//        });
        
        list.addListSelectionListener((ListSelectionEvent e) -> {
            getContentPane().setBackground(COLORS[list.getSelectedIndex()]);
        });
        
        leftlist = new JList(FOODS);
        leftlist.setVisibleRowCount(3);
        leftlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(leftlist));
        
        movebutton = new JButton("Move -->");
        movebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //rightlist.setListData(leftlist.getSelectedValues());
                Vector content;
                content = new Vector(leftlist.getSelectedValuesList());
                rightlist.setListData(content);
            }
        });
        add(movebutton);   
              
        rightlist = new JList();
        rightlist.setVisibleRowCount(3);
        rightlist.setFixedCellWidth(100);
        rightlist.setFixedCellHeight(15);
        rightlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(rightlist));
        
    }
    
}
