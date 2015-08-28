package com.netids;

import java.io.IOException;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterfaceAddress;

public class PacketProcess {
	String s = null ;
	jpcap.NetworkInterface[] devices = JpcapCaptor.getDeviceList();
	
	public String listInterfaces(){
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
	
	public String capturePacket() throws IOException{
		JpcapCaptor captor=JpcapCaptor.openDevice(devices[0], 65535, false, 20);
		captor.loopPacket(-1,new PacketPrinter());
		captor.close();
		return null;
	}
}
