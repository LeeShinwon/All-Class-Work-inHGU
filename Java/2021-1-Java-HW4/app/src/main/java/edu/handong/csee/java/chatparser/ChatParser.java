package edu.handong.csee.java.chatparser;

import java.awt.Desktop;
import edu.handong.csee.java.chatparser.datamodel.Message;
import edu.handong.csee.java.chatparser.parser.ParserForMac;
import edu.handong.csee.java.chatparser.parser.ParserForWindows;
import edu.handong.csee.java.chatparser.parser.Parserable;
import edu.handong.csee.java.chatparser.parser.exception.*;
import java.io.*;

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
	 * @throws IOException
	 * @throws DataFileNotFoundException
	 * @throws AlreadyExistingOutputFileException
	 */
	public static void main(String[] args) throws IOException, DataFileNotFoundException, AlreadyExistingOutputFileException{
		
		if(args.length==0) {
			System.out.println("No data and/or output paths are provided!!!");
			System.exit(1);
		}
		String[] arg=args[0].split(" ");
		
		if(arg.length==1) {
			System.out.println("No data and/or output paths are provided!!!");
			System.exit(1);
		}
		
		
		ChatParser myChatParser = new ChatParser();
		
		myChatParser.run(ReadFile(arg[0]), arg[1]);
		

	}
	/**
	 * This is a method 'run' in the public class ChatParser.
	 * @param ChatMessages
	 * @param outputPath
	 * @throws IOException
	 * @throws AlreadyExistingOutputFileException
	 */
	public void run(String[] ChatMessages, String outputPath) throws IOException, AlreadyExistingOutputFileException {
		
		setNumOfMessages(ChatMessages.length);
		System.out.println(getNumOfMessages());
		String cpy=null;
		int count=0;
				
		for(int messageIndex = 0; messageIndex < this.getNumOfMessages(); messageIndex++) {

			String currentChatMessage = ChatMessages[messageIndex];

			Parserable parser = null;
			if(count==0) {
				cpy="Parsing Message " + (messageIndex+1)+"\n";
				count=1;
			}
			else {
				cpy+="Parsing Message " + (messageIndex+1)+"\n";
			}

			if(!Utils.isWindowsExportedMessage(currentChatMessage)&&Utils.isMacExportedMessage(currentChatMessage)) {
				//System.out.println("1");
				parser = new ParserForMac();
			}	
			else if (Utils.isWindowsExportedMessage(currentChatMessage))
				parser = new ParserForWindows();
			else {
				System.out.println("Message cannot be processed as its format is not supported!!: " + currentChatMessage);
				return;
			}

			parser.parse(currentChatMessage);
			cpy+="When: "+parser.getValue(ValueTypes.DATETIME)+"\n";
			cpy+="Who: "+parser.getValue(ValueTypes.WRITER)+"\n";
			cpy+="What: "+parser.getValue(ValueTypes.MESSAGE)+"\n";
			
			if(messageIndex !=this.getNumOfMessages()-1) {
				cpy+="\n";
			}
			
		}

		System.out.println("The number of all messages processing: " + getNumOfMessages() + "\n");
		
		
		File file = new File(outputPath);
		try {
			
			if(!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			if(!file.exists()) {
				file.createNewFile();
				BufferedWriter w = new BufferedWriter(new FileWriter(file));
				w.write(cpy);
				//Desktop.getDesktop().edit(file);
				w.close();
				System.out.println("All the parsed messages are saved in "+outputPath);
			}
			else {
				//Desktop.getDesktop().edit(file);
				throw new AlreadyExistingOutputFileException(outputPath);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
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
	/**
	 * This is a method 'ReadFile' in the public class ChatParser.
	 * @param args
	 * @return
	 * @throws IOException
	 * @throws DataFileNotFoundException
	 */
	public static String[] ReadFile(String args)throws IOException, DataFileNotFoundException{
		int deleteLine=0;
		int firstLine=0;
		File file = new File(args);
		if(!file.exists()) {
			throw new DataFileNotFoundException(args);
		}
			
		StringBuffer all = new StringBuffer("");//append를 사용하기 위해
		
		BufferedReader br = new BufferedReader(new FileReader(args));
		try {
			while(true) {
				String line = br.readLine();
				if(line==null)break;
				else if(line.contains("Date,User,Message")){
					deleteLine=4;
					continue;
				}
				else if(deleteLine>=0&&deleteLine<=3) {
					deleteLine+=1;
					continue;
				}
				else if(!Utils.isWindowsExportedMessage(line)&&(line.contains("joined this chatroom.")||line.contains("---")||line.contains("left")
					||line.contains("들어왔습니")||line.contains("나갔습니"))) {
					continue;
				}
			
				if(Utils.isWindowsExportedMessage(line)||Utils.isMacExportedMessage(line)) {
					if(firstLine==0) {
						all.append(line);
						firstLine=1;
					}
					else {
						all.append("\n           ").append(line);
					}
				}
				else {
					all.append("\n").append(line);
				}
			}
			br.close();
		
			
		}catch(FileNotFoundException e) {
			throw new DataFileNotFoundException(args);
		}
		return all.toString().split("\n           ");
		
	}

}
