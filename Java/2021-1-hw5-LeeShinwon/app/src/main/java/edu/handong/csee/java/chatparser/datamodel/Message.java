package edu.handong.csee.java.chatparser.datamodel;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import edu.handong.csee.java.chatparser.ChatParser.ValueTypes;
import edu.handong.csee.java.chatparser.Utils;
import edu.handong.csee.java.chatparser.parser.ParserForMac;
import edu.handong.csee.java.chatparser.parser.ParserForWindows;
import edu.handong.csee.java.chatparser.parser.Parserable;

/**
 * This is a public class Message.
 * @author leeshinwon
 *
 */
public class Message implements Comparable<Message>{
	 private String datetime;
	 private String writer;
	 private String message;
	 /**
	  * This is a constructor.
	  * @param m
	  */
	 public Message(String m) {
		 Parserable parser=null;
		 parser = new ParserForMac();
		 parser.parse(m);
		 
		 SimpleDateFormat formatter_one = new SimpleDateFormat ( "yyyy-MM-dd hh:mm:ss",Locale.ENGLISH );
			SimpleDateFormat formatter_two = new SimpleDateFormat ( "yyyy-MM-dd HH:mm" );
			String inString = parser.getValue(ValueTypes.DATETIME);
			ParsePosition pos = new ParsePosition ( 0 );
			Date frmTime = formatter_one.parse ( inString, pos );
			String outString = formatter_two.format ( frmTime );
			
			
			this.datetime = outString;
			this.writer = parser.getValue(ValueTypes.WRITER);
			this.message = parser.getValue(ValueTypes.MESSAGE);
		 
	 }
	/**
	 * THis is a constructor.
	 * @param m
	 * @param rememberDate
	 */
	public Message(String m, String rememberDate) {
		
		
		Parserable parser=null;
		 parser = new ParserForWindows();
		parser.parse(m);
		
		SimpleDateFormat formatter_one = new SimpleDateFormat ( "EEE, MMM dd, yyyyhh:mm a",Locale.ENGLISH );
		SimpleDateFormat formatter_two = new SimpleDateFormat ( "yyyy-MM-dd HH:mm" );
		String inString = rememberDate+ parser.getValue(ValueTypes.DATETIME);
		ParsePosition pos = new ParsePosition ( 0 );
		Date frmTime = formatter_one.parse ( inString, pos );
		String outString = formatter_two.format ( frmTime );
		
		
		this.datetime = outString;
		this.writer = parser.getValue(ValueTypes.WRITER);
		this.message = parser.getValue(ValueTypes.MESSAGE);
		
		
	}
	/**
	 * THis is a constructor.
	 */
	public Message() {
		datetime=null;
		writer=null;
		message=null;
	}
	/**
	 * @override
	 * @param m
	 * @return
	 */
	public int compareTo(Message m) {
		if(this.datetime.compareTo(m.datetime)>0) { 
			return 1;
		}
		else if(this.datetime.compareTo(m.datetime)<0) {
			return -1;
		}
		else {//동일한 경우 
			if(this.writer.compareTo(m.writer)>0) {
				return 1;
			}
			else if(this.writer.compareTo(m.writer)<0) {
				return -1;
			}
			else {
				if(this.message.compareTo(m.message)>0) {
					return 1;
				}
				else if(this.message.compareTo(m.message)<0) {
					return -1;
				}
				else {
					return 0;
				}
			}
			
		}
	}
	/**
	 * This is a public method setDatetime in the public class Message.
	 * @param datetime
	 */
	public void setDatetime(String datetime) {//setter
		this.datetime=datetime;
	}
	/**
	 * This is a public method setWriter in the public class Message.
	 * @param writer
	 */
	public void setWriter(String writer) {
		this.writer=writer;
	}
	/**
	 * This is a public method setMessage in the public class Message.
	 * @param message
	 */
	public void setMessage(String message) {
		this.message=message;
	}
	/**
	 * This is a public method getDatetime in the public class Message.
	 * @return
	 */
	public String getDatetime() {//getter
		return datetime;
	}
	/**
	 * This is a public method getWriter in the public class Message.
	 * @return
	 */
	public String getWriter() {
		return writer;
	}
	/**
	 * This is a public method getMessage in the public class Message.
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * This is a public method print in the public class Message.
	 */
	public void print() {
		System.out.println("When: "+ datetime);
		System.out.println("Who: "+ writer);
		System.out.println("What: "+ message);
	}
	

}

