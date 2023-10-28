package edu.handong.csee.java.chatparser;

import java.util.ArrayList;
import java.util.HashMap;

import edu.handong.csee.java.chatparser.datamodel.Message;

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
		int count2=0;
		
		message = message.split(",")[0];
		
		for(String arr: message.split(":")) {
			if(!arr.equals(null)) {
				count2+=1;
			}
		}
		if(count2==3) {
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
	public static ArrayList<Message> getMessagesByASpecificDate(ArrayList<Message> messages,String date) {
		
		ArrayList<Message> send= new ArrayList<Message>();
		
		HashMap<String, ArrayList<Message>> dateFilter = new HashMap<String,ArrayList<Message>>();
		
		for(int i=0; i<messages.size(); i++) {
			if(dateFilter.containsKey(messages.get(i).getDatetime())) {
				ArrayList<Message> currentList = dateFilter.get(messages.get(i).getDatetime());
				currentList.add(messages.get(i));
			}
			else {
				dateFilter.put(messages.get(i).getDatetime(), new ArrayList<Message>());
				dateFilter.get(messages.get(i).getDatetime()).add(messages.get(i));
			}

		}
		for(String key: dateFilter.keySet()) {
			if(key.split(" ")[0].equals(date)) {
				send.addAll(dateFilter.get(key));
			}
		}
		
		return send;
	}
	/**
	 * THis is a getMessagesByAWriter method.
	 * @param messages
	 * @param writer
	 * @return
	 */
	public static ArrayList<Message> getMessagesByAWriter(ArrayList<Message> messages,String writer){
		ArrayList<Message> send= new ArrayList<Message>();
		
		HashMap<String, ArrayList<Message>> writerFilter = new HashMap<String,ArrayList<Message>>();
		
		for(int i=0; i<messages.size(); i++) {
			if(writerFilter.containsKey(messages.get(i).getWriter())) {
				ArrayList<Message> currentList = writerFilter.get(messages.get(i).getWriter());
				currentList.add(messages.get(i));
			}
			else {
				writerFilter.put(messages.get(i).getWriter(), new ArrayList<Message>());
				writerFilter.get(messages.get(i).getWriter()).add(messages.get(i));
			}

		}
		for(String key: writerFilter.keySet()) {
			if(key.equals(writer)) {
				send.addAll(writerFilter.get(key));
			}
		}
		
		return send;
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
