package edu.handong.csee.java.hw3.parser;

import edu.handong.csee.java.hw3.*;
import edu.handong.csee.java.hw3.datamodel.*;
/**
 * This is a interface Parserable.
 * @author leeshinwon
 *
 */
public interface Parserable {
	/**
	 * This is a public method parse in the public interface Parserable.
	 * @param message
	 * @return
	 */
	public Message parse(String message);
	/**
	 * This is a public method getValue in the public interface Parserable.
	 * @param type
	 * @return
	 */
	public String getValue(ChatParser.ValueTypes type); 

}
