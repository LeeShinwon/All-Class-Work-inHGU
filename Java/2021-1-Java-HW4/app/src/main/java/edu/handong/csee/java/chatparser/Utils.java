package edu.handong.csee.java.chatparser;
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
	
		for(String arr: message.split("-")) {
			if(!arr.equals(null)) {
				count1+=1;
			}
		}
		for(String arr: message.split(":")) {
			if(!arr.equals(null)) {
				count2+=1;
			}
		}
		if(count1==3&&count2==3) {
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
		
		int count=0;
		int count2=0;
		int count3=0;
		
		for(String arr: message.split("\\]")) {
			
			if(!arr.equals(null)) {
				count+=1;
			}
			if(count==2) {
				if(arr.contains("오전")||arr.contains("오후")||arr.contains("AM")||arr.contains("PM")) {
					count3+=1;
				}
			}
		}
		for(String arr: message.split(":")) {
			
			if(!arr.equals(null)) {
				count2+=1;
			}
		}
		
		if(count>=3&&count2>=1&&count3>=1) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
