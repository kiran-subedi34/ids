package com.netids;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class InterfacePanel extends JPanel {
	JButton listInterface;
	JButton selectInterface;
	JTextField inputInterface;
	
	public InterfacePanel(){
		Dimension dim = getPreferredSize();
		dim.width = 150;
		dim.height = 250;
		setPreferredSize(dim);
		
		Border innerBorder = BorderFactory.createTitledBorder("Interace Info");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		listInterface = new JButton("List Interface");
		listInterface.setBackground(new Color(59, 89, 182));
        listInterface.setForeground(Color.WHITE);
        listInterface.setFocusPainted(false);
        listInterface.setFont(new Font("Tahoma", Font.BOLD, 12));
        
		selectInterface = new JButton("Select Interface");
		selectInterface.setBackground(new Color(59, 89, 182));
        selectInterface.setForeground(Color.WHITE);
        selectInterface.setFocusPainted(false);
        selectInterface.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		inputInterface = new JTextField(10);
		
		setLayout(new FlowLayout()); 
	    add(listInterface);
	    add(inputInterface);
	    add(selectInterface);
	     
	    
	}
}
