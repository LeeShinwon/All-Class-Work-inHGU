package edu.handong.csee.java.chatparser;
import org.apache.commons.cli.Options;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.handong.csee.java.chatparser.parser.exception.DataFileNotFoundException;
import edu.handong.csee.java.chatparser.ChatParser.ValueTypes;
import edu.handong.csee.java.chatparser.datamodel.Message;
import edu.handong.csee.java.chatparser.ds.CustomLinkedList;
import edu.handong.csee.java.chatparser.parser.exception.AlreadyExistingOutputFileException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner; 



/**
 * This is a public class ChatParser contain main method.
 * @author leeshinwon
 *
 */
public class ChatParser {
	
	private String input;
	
	private String startdate;
	private String enddate;
	private String output;
	private String writer;
	private boolean help;
	
	private int numOfMessages=0;
	public static enum ValueTypes {DATETIME, WRITER, MESSAGE};
	/**
	 * This is a main method.
	 * @param args
	 * @throws AlreadyExistingOutputFileException
	 * @throws IOException 
	 */
	public static void main(String[] args) throws AlreadyExistingOutputFileException, IOException {
	ChatParser myRunner = new ChatParser();
		myRunner.run(args);
	}
	/**
	 * This is a run method
	 * @param args
	 * @throws AlreadyExistingOutputFileException
	 * @throws IOException 
	 */
	private void run(String[] args) throws AlreadyExistingOutputFileException, IOException {
		int fileNum=0;
		Options options = createOptions();
		
		if(parseOptions(options, args)) {
			if (help){
				printHelp(options);
				return;
			}
			else {
				try {
					String in=input;
					input="."+input;
					  if(!new File(input).exists()) {
						  throw new DataFileNotFoundException(in);
					  }
					  
					  File f = new File (input);
					  
					  CustomLinkedList messages = new CustomLinkedList();
					  
					  if(f.isDirectory()) {
						  File[] flist = f.listFiles();
						  System.out.println("The number of files in the directory, "+ input +": "+flist.length);
						  fileNum=flist.length;
						  
						  
						  
						  for(int i=0; i<fileNum; i++) {
							  CustomLinkedList m = loadData(input+flist[i].getName());
							  messages.listToList(m);
							 
						  }
						  
					  }
					  else {
						  messages = loadData(input);
						  
					  }
					  
					  
					  if(startdate == null && enddate==null&& writer == null)
					     System.out.println("The number of all messages processing: " + messages.length() + "\n");
					  if(startdate != null||enddate!=null) {
					     messages = Utils.getMessagesByASpecificDate(messages,startdate, enddate);
					  }
					 
					  if(writer != null) {
					     messages = Utils.getMessagesByAWriter(messages,writer);
					  }
					  
					  if(startdate != null && enddate != null && writer == null)//oox
					     System.out.println("The number of messages filtered by the start date, " + startdate + ", and the end date, " + enddate+": "+ messages.length() + "\n");
					  
					  if(startdate != null && enddate != null && writer != null)//ooo
						     System.out.println("The number of messages filtered by the start date, " + startdate + ", and the end date, " + enddate+", and the writer, "+writer+": "+ messages.length() + "\n");
						  
					  if(startdate != null && enddate == null && writer == null)//oxx
						  System.out.println("The number of messages filtered by the start date, " + startdate +": "+ messages.length() + "\n");
					 
					  if(startdate == null && enddate == null && writer != null)//xxo
						  System.out.println("The number of messages filtered by the writer, " + writer +": "+ messages.length() + "\n");
					  //
					  if(startdate == null && enddate != null && writer == null)//xox
						  System.out.println("The number of messages filtered by the end date, " + enddate +": "+ messages.length() + "\n");
					  
					  if(startdate != null && enddate == null && writer != null)//oxo
						  System.out.println("The number of messages filtered by the start date, " + startdate + ", and the writer, "+writer+": "+ messages.length() + "\n");
					  
					  if(startdate == null && enddate != null && writer != null)//xoo
						  System.out.println("The number of messages filtered by the end date, " + enddate + ", and the writer, "+writer+": "+ messages.length() + "\n");
					  
					  
					  if(new File(output).exists()) throw new AlreadyExistingOutputFileException(output);
					  
			
					  
					  saveMessages(messages.sort(),output);
					  System.out.println("All the parsed messages are saved in " + output);
					  	
					  	
				} catch(DataFileNotFoundException e) {
					  System.out.println(e.getMessage());
				} catch(AlreadyExistingOutputFileException e) {
					  System.out.println(e.getMessage());
				}

			}
			
		}
		return;
		
	}
	/**
	 * THis is a parseOptions method.
	 * @param options
	 * @param args
	 * @return
	 */
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			
			input = cmd.getOptionValue("i");
			writer = cmd.getOptionValue("w");
			startdate = cmd.getOptionValue("sd");
			enddate = cmd.getOptionValue("ed");
			output = cmd.getOptionValue("o");
			help = cmd.hasOption("h");
			
		} catch (Exception e) {
				printHelp(options);
				return false;
		}
		return true;
	}
	// Definition Stage
		/**
		 * THis is a createOptions method.
		 * @return
		 */
		private Options createOptions() {
			Options options = new Options();

			// add options by using OptionBuilder
			options.addOption(Option.builder("i").longOpt("input")
					.desc("Set a directory path or input data file path for chat messages")
					.hasArg()
					.argName("Input dir/file path")
					.required()
					.build());
			
			// add options by using OptionBuilder
			options.addOption(Option.builder("sd").longOpt("startdate")
								.desc("Apply a filter by a specific start date")
								.hasArg()
								.argName("Start date filter")
								//.required()
								.build());
			
			// add options by using OptionBuilder
						options.addOption(Option.builder("ed").longOpt("enddate")
											.desc("Apply a filter by a specific end date")
											.hasArg()
											.argName("End date filter")
											//.required()
											.build());
						
			// add options by using OptionBuilder
						options.addOption(Option.builder("o").longOpt("output")
								.desc("Set an output data file path for chat messages")
								.hasArg()
								.argName("Output file path")
								.required()
								.build());		
						
			// add options by using OptionBuilder
			options.addOption(Option.builder("w").longOpt("writer")
								.desc("Apply a filter by a specific writer")
								.hasArg()
								.argName("Writer filter")
								//.required()
								.build());
			
			
			// add options by using OptionBuilder
			options.addOption(Option.builder("h").longOpt("help")
			        .desc("Show a Help page")
			        .build());

			return options;
	}
	/**
	 * This is a printHelp method.
	 * @param options
	 */
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "Chatparser program";
		String footer ="\nThis chatparser is implemented in 2021-1 Java class.";
		formatter.printHelp("chatparser", header, options, footer, true);
	}
	/**
	 * This is a loadData method.
	 * @param input
	 * @return
	 * @throws DataFileNotFoundException
	 * @throws IOException 
	 */
	private CustomLinkedList loadData(String input) throws DataFileNotFoundException, IOException{
		CustomLinkedList messages = new CustomLinkedList ();
		
		File file = new File(input);
		
		if(input.contains(".xlsx")) {
			
			try {
				
				FileInputStream fis = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
				int rowindex =0; 
				int colindex = 0;
				
				XSSFSheet sheet = workbook.getSheetAt(0);
				
				int rows=sheet.getPhysicalNumberOfRows();
				for(rowindex=1; rowindex<rows; rowindex++) {
					Message m = new Message();
					
					XSSFRow row = sheet.getRow(rowindex);
					
					SimpleDateFormat formatter_one = new SimpleDateFormat ( "EEE MMM dd hh:mm:ss z yyyy",Locale.ENGLISH );
					SimpleDateFormat formatter_two = new SimpleDateFormat ( "yyyy-MM-dd HH:mm" );
					String inString = String.valueOf(row.getCell(0).getDateCellValue());
					ParsePosition pos = new ParsePosition ( 0 );
					Date frmTime = formatter_one.parse ( inString, pos );
					String outString = formatter_two.format ( frmTime );
					
					m.setDatetime(outString);
					m.setWriter(String.valueOf(row.getCell(1)));
					m.setMessage(String.valueOf(row.getCell(2)));
					
					messages.addANodeToStart(m);
				}
			}catch(FileNotFoundException e) {
				  System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		else {
			try {
				Scanner scan = new Scanner(file);
				
				String AddLine=null;
				
				String rememberDate=null;
				int check=0;
				
				while(scan.hasNextLine()) {
					String line= scan.nextLine();
					if(line == null) {
						break;
					}
					else if(line.contains("Date,User,Message")||line.contains("Date Saved : 2021-")||(line.contains("2021-1 JC")&&line.contains("with KakaoTalk Chats"))) {
						continue;
					}
					else {
						
							if(line.contains("-----")) {
								rememberDate=line.replace("-", "").trim();
								continue;
							}
							if(line.contains("\"\"")) {
								line=line.replace("\"\"", "\"");
							}
							if(check!=0) {
								if(Utils.isWindowsExportedMessage(line)) {
									messages.addANodeToStart(new Message(AddLine,rememberDate));
								}
								else if(Utils.isMacExportedMessage(line)){
									messages.addANodeToStart(new Message(AddLine));
								}
							}
							if(Utils.isMacExportedMessage(line)||Utils.isWindowsExportedMessage(line)) {
								AddLine=line;
								if(Utils.isMacExportedMessage(line)) {
									check=1;
								}
								else {
									check=2;
								}
							}
							else {
								AddLine+="\n"+line;
							}
							if(!scan.hasNextLine()) {
								
								if(check==1) {
									
									messages.addANodeToStart(new Message(AddLine));
								}
								else{
									messages.addANodeToStart(new Message(AddLine,rememberDate));
								}
							}
							
							
								
					}
					
				}
				scan.close();
				
				
			}catch(FileNotFoundException e) {
				  System.out.println(e.getMessage());
			}
		}
		return messages;
	
	}
	/**
	 * This is a saveMessages method.
	 * @param messages
	 * @param output
	 * @throws AlreadyExistingOutputFileException
	 */
	private void saveMessages(ArrayList<Message> messages, String output) throws AlreadyExistingOutputFileException {
		
		
		
			File file = new File(output);
			try {
				
				if (!file.exists()) {
				    file.createNewFile();
				
					BufferedWriter w = new BufferedWriter(new FileWriter(file));
					for(int i=0; i<messages.size(); i++) {
						w.write("Parsing Message "+(i+1)+"\n");
						w.write("When: "+messages.get(i).getDatetime()+"\n");
						w.write("Who: "+messages.get(i).getWriter()+"\n");
						w.write("What: "+messages.get(i).getMessage());
						
						if(i!=messages.size()-1) {
							w.write("\n\n");
						}
						
					}
					
					Desktop.getDesktop().edit(file);
					w.close();
				}
				else {
					Desktop.getDesktop().edit(file);
					throw new AlreadyExistingOutputFileException(output);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	

}

