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
	public AlreadyExistingOutputFileException(String input) {
		System.out.println("AlreadyExistingOutputFileException: "+input);
		System.exit(0);
	}
}
