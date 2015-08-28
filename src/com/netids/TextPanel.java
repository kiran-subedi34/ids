package com.netids;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel{
	
	JTextArea textArea ;
	
	public TextPanel(){
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textArea.setForeground(Color.BLUE);
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea),BorderLayout.CENTER);
	}
	
	public void setText(String text){
		textArea.append(text);
	}
}
