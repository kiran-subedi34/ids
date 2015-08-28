package com.netids;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ProjectInfo extends JPanel {
	
	JButton aboutButton;
	JButton helpButton;
	JButton infoButton;
	public ProjectInfo(){
		/*
		 * About Button
		 */
		aboutButton = new JButton("About");
		aboutButton.setBackground(new Color(59, 89, 182));
		aboutButton.setForeground(Color.WHITE);
        aboutButton.setFocusPainted(false);
        aboutButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        Border border = BorderFactory.createLineBorder(Color.GRAY);
		Border paddingBorder = BorderFactory.createEmptyBorder(10,35,10,35);
		aboutButton.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
		
		/* 
		 * Help Button
		 */
		helpButton = new JButton("Help");
		helpButton.setBackground(new Color(59, 89, 182));
		helpButton.setForeground(Color.WHITE);
        helpButton.setFocusPainted(false);
        helpButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        helpButton.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
		
        /*
         * Info Button
         */
		infoButton = new JButton("Info");
		infoButton.setBackground(new Color(59, 89, 182));
		infoButton.setForeground(Color.WHITE);
        infoButton.setFocusPainted(false);
        infoButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        infoButton.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
		
        setLayout(new FlowLayout());
        add(aboutButton);
        add(helpButton);
        add(infoButton);
		
	}
}
