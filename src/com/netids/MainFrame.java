package com.netids;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class MainFrame extends JFrame {

	/* 
	 * Width of the JFrame window
	 */
	public static final int frameWidth = 800;
	
	/*
	 * Height of the JFrame window
	 */
	public static final int frameHeight = 600;
	
	/*
	 * JLabel to display the version and name of the ids
	 */
	JLabel textLabel;
	
	/*
	 * Texarea to display the result
	 */
	TextPanel textPanel;
	
	/*
	 * Texarea to display the result
	 */
	FormPanel formPanel;
	
	ManageLayout manage;
	PacketPrinter printer;
	
	
	
	public MainFrame(){
		setTitle("Network IDS");
		
		// display the version and name of the ids
		textLabel = new JLabel("B2NK IDKv1.0",SwingConstants.CENTER);

		// set border to textLabel
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		Border paddingBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		textLabel.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
		
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		manage = new ManageLayout();
		
		printer = new PacketPrinter();
		printer.setPacketListener(textPanel);
		
		formPanel.setStringListener(new StringListener() {
			
			@Override
			public void setTextEmitted(String text) {
				textPanel.setText(text);
			}
		});
		// add component to the frame
		add(textLabel,BorderLayout.NORTH);
		add(textPanel , BorderLayout.CENTER);
		add(formPanel,BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(frameWidth,frameHeight);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
