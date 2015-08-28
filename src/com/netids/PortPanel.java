package com.netids;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PortPanel extends JPanel {
	JCheckBox tcpBox;
	JCheckBox udpBox;
	JCheckBox httpBox;
	JCheckBox ftpBox;
	JCheckBox imapBox;
	JCheckBox dnsBox;
	JCheckBox smtpBox;
	JCheckBox popBox;
	public PortPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 250;
		dim.height = 250;
		setPreferredSize(dim);
		
		Border innerBorder = BorderFactory.createTitledBorder("Filter Port");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	
		tcpBox = new JCheckBox("TCP()");
		udpBox = new JCheckBox("UDP()");
		httpBox = new JCheckBox("HTTP(80)");
		ftpBox = new JCheckBox("FTP(21)");
		imapBox = new JCheckBox("IMAP(143)");
		popBox = new JCheckBox("POP(110)");
		dnsBox = new JCheckBox("DNS(110)");
		smtpBox = new JCheckBox("SMTP(25)");
		
		setLayout(new FlowLayout());
		add(httpBox);
		add(Box.createRigidArea(new Dimension(45,0)));
		add(ftpBox);
		add(tcpBox);
		add(Box.createRigidArea(new Dimension(45,0)));
		add(udpBox);
		
		add(imapBox);
		add(Box.createRigidArea(new Dimension(45,0)));
		add(popBox);
		
		add(dnsBox);
		add(Box.createRigidArea(new Dimension(45,0)));
		add(smtpBox);
	}
}
