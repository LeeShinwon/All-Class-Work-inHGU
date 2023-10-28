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
	String rememberDate;
	/**
	 * This is a public method parse in the ParserForWindows.
	 */
	public Message parse(String message) {
		
		String[] messageArray=message.split("] ",3);
		for(int i=0;i<3;i++) {
			messageArray[i]=messageArray[i].replace("[","");
		}
		
		toNewMessage = new Message();
		
		toNewMessage.setDatetime(messageArray[1].trim());
		toNewMessage.setWriter(messageArray[0].trim());
		toNewMessage.setMessage(messageArray[2].trim());
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
