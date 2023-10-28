package edu.handong.csee.java.chatparser.parser.exception;
/**
 * This is a class 'DataFileNotFoundException'.
 * @author leeshinwon
 *
 */
public class DataFileNotFoundException extends Exception{
	/**
	 * This is a constructor.
	 * @param args
	 */
	public DataFileNotFoundException(String args) {
		System.out.println("DataFileNotFoundException: "+args);
		System.exit(1);
	}
}
