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
		
		String[] messageArray=message.split(",",3);
		toNewMessage = new Message();
		
		toNewMessage.setDatetime(messageArray[0].trim());
		
		if(messageArray[1].trim().charAt(0)=='\"') {
			toNewMessage.setWriter(messageArray[1].trim().substring(1,messageArray[1].lastIndexOf("\"")));
		}
		else {
			toNewMessage.setWriter(messageArray[1].trim());
		}
		if(messageArray[2].trim().charAt(0)=='\"') {
			toNewMessage.setMessage(messageArray[2].trim().substring(1,messageArray[2].lastIndexOf("\"")));
		}
		else {
			toNewMessage.setMessage(messageArray[2].trim());
		}
		
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
