package edu.handong.csee.java.hw3;

import edu.handong.csee.java.hw3.datamodel.Message;
import edu.handong.csee.java.hw3.parser.ParserForMac;
import edu.handong.csee.java.hw3.parser.ParserForWindows;
import edu.handong.csee.java.hw3.parser.Parserable;
/**
 * This is a public class ChatParser contain main method.
 * @author leeshinwon
 *
 */
public class ChatParser {
	
	private int numOfMessages=0;
	
	public static enum ValueTypes {DATETIME, WRITER, MESSAGE};
	/**
	 * This is a main method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		ChatParser myChatParser = new ChatParser();
		
		myChatParser.run(args);

	}
	/**
	 * This is a method 'run' in the public class ChatParser.
	 * @param ChatMessages
	 */
	public void run(String[] ChatMessages) {
		
		setNumOfMessages(ChatMessages.length);

		System.out.println("The number of all messages processing: " + getNumOfMessages() + "\n");
		
		for(int messageIndex = 0; messageIndex < this.getNumOfMessages(); messageIndex++) {

			String currentChatMessage = ChatMessages[messageIndex];

			Parserable parser = null;

			System.out.println("Parsing Message " + (messageIndex+1));
			
			if(Utils.isMacExportedMessage(currentChatMessage))	
				parser = new ParserForMac();
			else if (Utils.isWindowsExportedMessage(currentChatMessage))
				parser = new ParserForWindows();
			else {
				System.out.println("Message cannot be processed as its format is not supported!!: " + currentChatMessage);
				return;
			}

			Message newMessage = parser.parse(currentChatMessage);
			System.out.println(parser.getValue(ValueTypes.DATETIME) + 
								"|" + parser.getValue(ValueTypes.WRITER) + 
								"|" + parser.getValue(ValueTypes.MESSAGE));
			newMessage.print();

			System.out.println();
			
		}

		if(ChatMessages.length==0)
			System.out.println("No messages!!");
		
	}
	/**
	 * This is a method 'getNumOfMessages' in the public class ChatParser.
	 * @return
	 */
	public int getNumOfMessages() {
		return numOfMessages;
	}
	/**
	 * This is a method 'setNumOfMessages' in the public class ChatParser.
	 * @param numOfMessages
	 */
	public void setNumOfMessages(int numOfMessages) {
		this.numOfMessages = numOfMessages;
	}

}
