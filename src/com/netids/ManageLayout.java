package com.netids;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

public class ManageLayout extends JPanel {
	
	FormPanel formPanel;
	ProjectInfo info;
	PortPanel port;
	InterfacePanel interfacePanel;
	
	public ManageLayout(){
		formPanel = new FormPanel();
		info = new ProjectInfo();
		port = new PortPanel();
		interfacePanel = new InterfacePanel();
		
		setLayout(new BorderLayout());
		add(formPanel,BorderLayout.EAST);
		add(info, BorderLayout.SOUTH);
		add(port,BorderLayout.WEST);
		add(interfacePanel , BorderLayout.CENTER);
	}
	
	
	
}
