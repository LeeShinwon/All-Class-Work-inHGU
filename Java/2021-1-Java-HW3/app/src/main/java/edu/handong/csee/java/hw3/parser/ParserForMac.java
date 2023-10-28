package edu.handong.csee.java.hw3.parser;

import edu.handong.csee.java.hw3.ChatParser;
import edu.handong.csee.java.hw3.ChatParser.ValueTypes;
import edu.handong.csee.java.hw3.datamodel.Message;
/**
 * This is a public class ParserForMac implementing interface, Parserable.
 * @author leeshinwon
 *
 */
public class ParserForMac implements Parserable{
Message toNewMessage = null;
	/**
	 * @override
	 * This is a public method parse in the ParserForMac.
	 */
	public Message parse(String message) {
		String [] splitedMessage = message.split(",");
		
		toNewMessage = new Message();
		toNewMessage.setDatetime(splitedMessage[0].trim());
		toNewMessage.setWriter(splitedMessage[1].trim());
		toNewMessage.setMessage(splitedMessage[2].trim());
		
		return toNewMessage;
	}
	/**
	 * @override
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
