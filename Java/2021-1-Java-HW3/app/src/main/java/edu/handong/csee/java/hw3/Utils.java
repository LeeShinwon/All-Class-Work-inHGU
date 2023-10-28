package edu.handong.csee.java.hw3;
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
		
		int count=0; 
		
		for(String arr: message.split(",")) {
			if(!arr.equals(null)) {
				count+=1;
			}
		}
		if(count==3) {
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
		
		for(String arr: message.split("\\]")) {
			if(!arr.equals(null)) {
				count+=1;
			}
		}
		if(count==3) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
