package edu.handong.csee.java.chatparser.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.handong.csee.java.chatparser.datamodel.Message;

/**
 * This is a class CustomLinkedList
 * @author leeshinwon
 *
 */
public class CustomLinkedList {
	private ListNode head;
	private ListNode tail;
	/**
	 * constructor
	 */
	public CustomLinkedList() {
		head = null;
	}
	/**
	 * method listToList- 링크드리스트들끼리 연결 
	 * @param m
	 */
	public void listToList(CustomLinkedList m) {
		
		ListNode current = m.head;
		
		if(head==null) {
			head=m.head;
		}
		else {
			for(int i=0; i<m.length(); i++) {
				
				this.addANodeToStart(current.data);
				current = current.link; // move to next
			}
			//tail.link=m.head;
		}
	}
	/**
	 * method showList
	 */
	public void showList() {
		ListNode position = head;
		while(position != null) {
			System.out.println( position.data.getDatetime());
			System.out.println( position.data.getWriter());
			System.out.println( position.data.getMessage());
			position = position.link;
		}
	}
	/**
	 * method length
	 * @return
	 */
	public int length() {
		int count = 0;
		ListNode position = head;
		while(position != null) {
			count++;
			position = position.link;
		}
		return count;
	}
	/**
	 * method addANodeToStart
	 * @param addData
	 */
	public void addANodeToStart(Message addData) {
		//System.out.println(addData);
		if(length()<2)
			tail = head;
		head = new ListNode(addData,head);
	}
	
	/**
	 * method deleteNode
	 * @param addData
	 */
	public void deleteNode(Message addData) {
		
		ListNode current = head;
		ListNode previous = head;
		while(current!=null) {
			System.out.println("2");
			if(current.data.equals(addData)) {
				current.data=null;
				previous.link=current.link;
				current=current.link;
				previous = current;
			}
			else {
				previous = current;
				current = current.link; // move to next
			}
		}
		this.showList();
	}
	


	/**
	 * method finSD
	 * @param sd
	 * @return
	 */
	public CustomLinkedList finSD(String sd) {
		CustomLinkedList m = new CustomLinkedList();
		ListNode position = head;

		
		while(position != null) {
	
			if(sd.compareTo(position.data.getDatetime())<0) { 
				m.addANodeToStart(position.data);	
			}
			
			position = position.link;
		}
		return m;
	}
	/**
	 * method finED
	 * @param ed
	 * @return
	 */
	public CustomLinkedList finED(String ed) {
		CustomLinkedList m = new CustomLinkedList();
		ListNode position = head;
		
		
		while(position != null) {
			if(ed.compareTo(position.data.getDatetime().split("\\s")[0])>=0) { 
				m.addANodeToStart(position.data);	
			}
			
			position = position.link;
		}
		return m;
	}
	/**
	 * method finSE
	 * @param sd
	 * @param ed
	 * @return
	 */
	public CustomLinkedList finSE(String sd, String ed) {
		CustomLinkedList m = new CustomLinkedList();
		ListNode position = head;
		
		//System.out.println( position.data.getDatetime());
		
		while(position != null) {
			//System.out.println("1");
			if(sd.compareTo(position.data.getDatetime())<0&&ed.compareTo(position.data.getDatetime().split("\\s")[0])>=0) {
				m.addANodeToStart(position.data);	
			}
			
			position = position.link;
		}
		return m;
	}
	/**
	 * method finWriter
	 * @param wr
	 * @return
	 */
	public CustomLinkedList finWriter(String wr) {
		CustomLinkedList m = new CustomLinkedList();
		ListNode position = head;
		
		//System.out.println( position.data.getDatetime());
		
		while(position != null) {
			//System.out.println("1");
			if(wr.equals(position.data.getWriter())) {
				m.addANodeToStart(position.data);	
			}
			
			position = position.link;
		}
		return m;
	}
	/**
	 * method toArrayList
	 * @return
	 */
	public ArrayList<Message> toArrayList() {
		ArrayList<Message> list = new ArrayList<Message>(length());
		ListNode position = head;
		while(position != null) {
			list.add(position.data);
			position = position.link;
		}
		return list;
	}
	/**
	 * class ListNode
	 * @author leeshinwon
	 *
	 */
	private class ListNode{
		private Message data;
		/**
		 * method getData()
		 * @return
		 */
		public Message getData() {
			return this.data;
		}
		/**
		 * method getLink()
		 * @return
		 */
		public ListNode getLink() {
			return this.link;
		}
		
		private ListNode link;
		/**
		 * method ListNode
		 * @param newData
		 * @param linkedNode
		 */
		public ListNode(Message newData, ListNode linkedNode) {
			this.data = newData;
			this.link = linkedNode;
		}
	}
	/**
	 * method sort
	 * @param comparator
	 * @return
	 */
	public ArrayList<Message> sort() {
		
		ArrayList<Message> list = this.toArrayList();
		Collections.sort(list);
		
		return list;
	}
	
}