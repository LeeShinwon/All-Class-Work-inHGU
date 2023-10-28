package edu.handong.csee.java.chatparser.parser.exception;

/**
 * This is a class 'AlreadyExistingOutputFileException'.
 * @author leeshinwon
 *
 */
public class AlreadyExistingOutputFileException extends Exception{
	/**
	 * This is a constructor.
	 * @param args
	 */
	public AlreadyExistingOutputFileException(String args) {
		System.out.println("AlreadyExistingOutputFileException: "+args);
		System.exit(1);
	}
}
