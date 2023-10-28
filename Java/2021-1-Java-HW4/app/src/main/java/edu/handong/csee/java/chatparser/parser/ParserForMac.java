package edu.handong.csee.java.chatparser.parser;

import edu.handong.csee.java.chatparser.ChatParser;
import edu.handong.csee.java.chatparser.ChatParser.ValueTypes;
import edu.handong.csee.java.chatparser.datamodel.Message;
/**
 * This is a public class ParserForMac implementing interface, Parserable.
 * @author leeshinwon
 *
 */
public class ParserForMac implements Parserable{
	Message toNewMessage = null;
	/**
	 * This is a public method parse in the ParserForMac.
	 */
	public Message parse(String message) {
		String [] splitedMessage = message.split(",|\"");
		
		String splitedMessage1 = message.substring(0,message.indexOf(","));
		String splitedMessage2 = message.substring(message.indexOf("\""));
		String splitedMessage3 = splitedMessage2.substring(splitedMessage2.indexOf(","));
		//String splitedMessage4 = splitedMessage2.substring(1,splitedMessage2.indexOf(","));
		String splitedMessage5 = splitedMessage2.substring(1,splitedMessage2.lastIndexOf(",")-1);
		String splitedMessage6 = splitedMessage3.substring(splitedMessage3.indexOf("\"")+1,splitedMessage3.lastIndexOf("\""));
		
		toNewMessage = new Message();
		toNewMessage.setDatetime(splitedMessage1.trim());
		toNewMessage.setWriter(splitedMessage5.trim());
		toNewMessage.setMessage(splitedMessage6.trim());
		
		return toNewMessage;
	}
	/**
	 * This is a public method getValue in the ParserForMac.
	 */
	public String getValue(ChatParser.ValueTypes type) {
		
		if(ValueTypes.DATETIME.equals(type)) {
			return toNewMessage.getDatetime();
		}
		else if(ValueTypes.WRITER.equals(type)) {
			return toNewMessage.getWriter();
		}
		else {
			return toNewMessage.getMessage();
		}
	}
}
