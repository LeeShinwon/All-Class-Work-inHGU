package edu.handong.csee.java.chatparser;

import java.util.ArrayList;
import java.util.HashMap;

import edu.handong.csee.java.chatparser.datamodel.Message;
import edu.handong.csee.java.chatparser.ds.CustomLinkedList;

/**
 * This is a public class Utils.
 * @author leeshinwon
 *
 */
public class Utils {
	
	/**
	 * This is a public static method 'isMacExportedMessage' in the public class Utils.
	 * @param message
	 * @return
	 */
	public static boolean isMacExportedMessage(String message) {
		int count1=0;
		int count2=0;
		
		
		
		message = message.split(",")[0];
		
			//System.out.println(message);
			for(String arr: message.split(":")) {
				if(!arr.equals(null)) {
					count2+=1;
				}
			}
			//System.out.println(message);
			for(String arr: message.split("\\.")) {
				if(!arr.equals(null)) {
					count1+=1;
				}
			}
		
		if(count2==3||(count1==3&&count2==2)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	/**
	 * This is a public static method 'isWindowsExportedMessage' in the public class Utils.
	 * @param message
	 * @return
	 */
	public static boolean isWindowsExportedMessage(String message) {
		int count1=0;
		int count2=0;
		
		message = message.split(":")[0];
		 
		for(String arr: message.split("\\]")) {
			if(!arr.equals(null)) {
				count1+=1;
			}
		}
		for(String arr: message.split("\\[")) {
			if(!arr.equals(null)) {
				count2+=1;
			}
		}
		if(count1==2&&count2==3) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * THis is a getMessagesByASpecificDate method.
	 * @param messages
	 * @param date
	 * @return
	 */
	public static CustomLinkedList getMessagesByASpecificDate( CustomLinkedList messages,String sd, String ed) {
		
		if(sd!=null&&ed==null) {
			messages = messages.finSD(sd);
		}
		else if(sd==null&&ed!=null) {
			messages = messages.finED(ed);
		}
		else {
			messages = messages.finSE(sd,ed);
		}
		return messages;
	}
	/**
	 * THis is a getMessagesByAWriter method.
	 * @param messages
	 * @param writer
	 * @return
	 */
	public static CustomLinkedList getMessagesByAWriter(CustomLinkedList messages,String writer){
		
		messages = messages.finWriter(writer);
		
		return messages;
	}
	/**
	 * This is a processMultilineMessage method.
	 * @param message
	 * @return
	 */
	public static String processMultilineMessage(String message) {
		String[] splitMessage = message.split("\n");
		String processedMessage = "";
				
		for(int i=0; i < splitMessage.length ; i++) {
					
		      if(i==0)
		         processedMessage= splitMessage[i].trim();
		      else
		         processedMessage = processedMessage + "\n" + splitMessage[i];
					
		   }
				
		   return processedMessage;
	}
	

}
