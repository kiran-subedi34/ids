package com.netids;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterfaceAddress;


public class FormPanel  implements ActionListener {
	
	StringListener textListener;
	
	JButton listInterfaceButton;
	JButton captureButton;
	
	PacketProcess packetProcess;
	
	public FormPanel(){
		
		JPanel interfacePanel = new JPanel();
		packetProcess = new PacketProcess();
		/*
		 * List Interface Button 
		 */
		listInterfaceButton = new JButton("List Interface");
		listInterfaceButton.setBackground(new Color(59, 89, 182));
        listInterfaceButton.setForeground(Color.WHITE);
        listInterfaceButton.setFocusPainted(false);
        listInterfaceButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        Border border = BorderFactory.createLineBorder(Color.GRAY);
		Border paddingBorder = BorderFactory.createEmptyBorder(10,35,10,35);
		listInterfaceButton.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
        
		/*
		 * Capture Button 
		 * 
		 */
		captureButton = new JButton("Capture");
		captureButton.setBackground(new Color(59, 89, 182));
        captureButton.setForeground(Color.WHITE);
        captureButton.setFocusPainted(false);
        captureButton.setFont(new Font("Tahoma", Font.BOLD, 18));
       
		captureButton.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
		
		interfacePanel.setLayout(new FlowLayout());
		
		interfacePanel.add(listInterfaceButton);
		listInterfaceButton.addActionListener(this);
		
		interfacePanel.add(captureButton);
		captureButton.addActionListener(this);
	}
	
	public void setStringListener(StringListener listener){
		this.textListener = listener;
	}
	
	public void actionPerformed(ActionEvent e){
		JButton clicked = (JButton)e.getSource();
		/*
		 * ListInterface Button event Listener 
		 */
		if(clicked == listInterfaceButton){
			if(textListener != null){
				String s = packetProcess.listInterfaces();
				textListener.setTextEmitted(s);
			}
		}
		
		if(clicked == captureButton){
			if(textListener != null){
				try {
					packetProcess.capturePacket();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	/*
	 * List the interface details
	 */
	public String listInterfaces(){
		String s = null; 
		jpcap.NetworkInterface[] devices = JpcapCaptor.getDeviceList();
		
		for (int i = 0; i < devices.length; i++) {
		      s = i+": Device Name : "+devices[i].name + " \n Device Description : " + devices[i].description+"\n";
			  s += " Datalink : "+devices[i].datalink_name + "\n Datalink Description" + devices[i].datalink_description+" \n ";
			  s += "  MAC address:";
			  for (byte b : devices[i].mac_address)
			    s += Integer.toHexString(b&0xff) + ":" ;
			  for (NetworkInterfaceAddress a : devices[i].addresses)
			    s += " \n Address:"+a.address + " \n Subnet " + a.subnet + "\n BroadCast "+ a.broadcast;
			  }
			  s += "\n --------------------------------------------------------------------------------------------- \n";
		
		return s;
	}
	
	public String capturePacket(){
		return null;
		
	}
}
