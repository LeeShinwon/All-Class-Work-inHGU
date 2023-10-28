package edu.handong.csee.java.hw3.datamodel;
/**
 * This is a public class Message.
 * @author leeshinwon
 *
 */
public class Message {
	private String datetime;
	private String writer;
	private String message;
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
