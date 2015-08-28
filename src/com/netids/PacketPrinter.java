package com.netids;

import jpcap.PacketReceiver;
import jpcap.packet.ARPPacket;
import jpcap.packet.DatalinkPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;


public class PacketPrinter implements PacketReceiver {

	String s ;
	TextPanel panel;
	@Override
	public void receivePacket(Packet packet) {
		
			  
			  if(packet instanceof jpcap.packet.TCPPacket){
					TCPPacket p=(TCPPacket)packet;
	                          s="TCPPacket:| dst_ip "+p.dst_ip+":"+p.dst_port
	                          +"|src_ip "+p.src_ip+":"+p.src_port
	                          +" |len: "+p.len+" |flag: "+p.d_flag+" |ack_num: "+p.ack;
				panel.setText(s);


				}
				//UDP, tcp+udp
				else if(packet instanceof jpcap.packet.UDPPacket){
					UDPPacket p=(UDPPacket)packet;
					s="UDPPacket:| dst_ip "+p.dst_ip+":"+p.dst_port
			         +"|src_ip "+p.src_ip+":"+p.src_port
		            +" |len: "+p.len+" |THIS: "+p.d_flag;
					panel.setText(s);

				}
				//ping, ICMPPacket
		       else if(packet instanceof jpcap.packet.ICMPPacket){
		    	   ICMPPacket p=(ICMPPacket)packet;
		    	   //ICMP
		    	   String router_ip="";
		    	   for(int i=0;i<p.router_ip.length;i++){
		    		   router_ip+=" "+p.router_ip[i].getHostAddress();
		    	   }
					s="@ @ @ ICMPPacket:| router_ip "+router_ip
					 +" |redir_ip: "+p.redir_ip
					 +" |mtu: "+p.mtu
		             +" |length: "+p.len+ " |This ICMP: "+p.addr_num;
					panel.setText(s);

				}

		       else if(packet instanceof jpcap.packet.ARPPacket){
		    	   ARPPacket p=(ARPPacket)packet;
		    	   //Returns the hardware address (MAC address) of the sender
		    	   Object  saa=   p.getSenderHardwareAddress();
		    	   Object  taa=p.getTargetHardwareAddress();
		    	   s="* * * ARPPacket:| SenderHardwareAddress "+saa
			         +"|TargetHardwareAddress "+taa
		             +" |len: "+p.len;
		    	   panel.setText(s);

				}

		     DatalinkPacket datalink  =packet.datalink;

		     if(datalink instanceof jpcap.packet.EthernetPacket){
		    	 EthernetPacket ep=(EthernetPacket)datalink;
		    	  s="  datalink layer packet: "
		    		  +"|Destination Address: "+ep.getDestinationAddress()
		    		  +"|Source Address: "+ep.getSourceAddress();
		    	  panel.setText(s);

			}	 
		  }
	
	public void setPacketListener(TextPanel panel){
		this.panel = panel;
	}

		
	}

