package edu.handong.csee.java.chatparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.handong.csee.java.chatparser.datamodel.Message;
import edu.handong.csee.java.chatparser.ds.CustomLinkedList;
import edu.handong.csee.java.chatparser.parser.exception.DataFileNotFoundException;
/**
 * This is a class DirFileReader for read files.
 * @author leeshinwon
 *
 */
public class DirFileReader implements Runnable{
	
	//private String input;
	
	/**
	 * constructor
	 * @param input
	 */
	/*public DirFileReader(String input) {
		
		this.input=input;
	}*/
	
	/**
	 * method overriding run() of runnable(thread)
	 */
	@Override
	public void run() {
		
	}
	/**
	 * method readfile
	 * @return
	 */
	/*public CustomLinkedList readFile(String input) {
		
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
					
					messages.addANodeToTail(m);
					//messages.add(m);
				}
			}catch(FileNotFoundException e) {
				  System.out.println(e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
						//System.out.println(line);
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
									//messages.add(new Message(AddLine,rememberDate));
								}
								else if(Utils.isMacExportedMessage(line)){
									messages.addANodeToStart(new Message(AddLine));
									//messages.add(new Message(AddLine));
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
									//messages.add(new Message(AddLine));
								}
								else{
									messages.addANodeToStart(new Message(AddLine,rememberDate));
									//messages.add(new Message(AddLine,rememberDate));
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
	}*/
	
	

}
