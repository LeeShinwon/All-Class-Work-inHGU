package edu.handong.csee.java.chatparser.parser;

import edu.handong.csee.java.chatparser.ChatParser;
import edu.handong.csee.java.chatparser.ChatParser.ValueTypes;
import edu.handong.csee.java.chatparser.datamodel.Message;
/**
 * This is a public class ParserForWindows implementing interface, Parserable.
 * @author leeshinwon
 *
 */
public class ParserForWindows implements Parserable{
	
	Message toNewMessage = null;
	/**
	 * This is a public method parse in the ParserForWindows.
	 */
	public Message parse(String message) {
		
		String splitedMessage1 = message.substring(1,message.indexOf("]"));
		String splitedMessage2 = message.substring(message.indexOf("]"));
		String splitedMessage3 = splitedMessage2.substring(splitedMessage2.indexOf("["));
		String splitedMessage4 = splitedMessage3.substring(1,splitedMessage3.indexOf("] "));
		String splitedMessage5 = splitedMessage3.substring( splitedMessage3.indexOf("] "));
		String splitedMessage6 = splitedMessage5.substring(splitedMessage5.indexOf(" "));
		toNewMessage = new Message();
		
		toNewMessage.setDatetime(splitedMessage4.trim());
		toNewMessage.setWriter(splitedMessage1.trim());
		toNewMessage.setMessage(splitedMessage6.trim());
		
		
		return toNewMessage;
	}
	/**
	 *  @override
	 * This is a public method getValue in the ParserForWindows.
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
