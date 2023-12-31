package com.todo.service;

import java.io.Writer;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String title, desc, cate;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "[항목 추가]\n"
				+ "제목 > ");
		
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.printf("\n이미 존재하는 제목은 사용할 수 없습니다.");
			return;
		}
		System.out.println("카테고리 > ");
		cate = sc.next();
		
		sc.nextLine();
		System.out.println("내용 > ");
		desc = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, cate, desc);
		list.addItem(t);
		System.out.println("추가되었습니다. ");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "[항목 삭제]\n"
				+ "삭제할 항목의 번호를 입력하시오 > ");
		int num = sc.nextInt();
		if(l.getList().size()<num) {
			System.out.println("해당 번호의 항목이 존재하지 않습니다.");
		
		}
		else {
			System.out.println(num+". "+l.getList().get(num-1).toString());
			System.out.println("위 항목을 삭제하시겠습니까? (y/n) > ");
			String delete = sc.next();
			if(delete.equals("y")) {
				l.deleteItem(l.getList().get(num-1));
				System.out.println("삭제되었습니다.");
			}
			
		}
		
		
		/*for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.println("삭제되었습니다.");
				break;
			}
		}*/
	}


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "[항목 수정]\n"
				+ "수정할 항목의 번호를 입력하시오 > \n");
		int num = sc.nextInt();
		
		if(l.getList().size()<num) {
			System.out.println("해당 번호의 항목이 존재하지 않습니다.");
		
		}
		else {
			System.out.println("새 제목 > ");
			String new_title = sc.next().trim();
			if (l.isDuplicate(new_title)) {
				System.out.println("이미 존재하는 제목은 사용할 수 없습니다.");
				return;
			}
			System.out.println("새 카테고리 > ");
			String cate = sc.next();
			
			sc.nextLine();
			
			System.out.println("새 내용 > ");
			String new_description = sc.nextLine().trim();
			
			System.out.println("새 마감일자 > ");
			String due_date = sc.nextLine().trim();
			
			String current_date = l.getList().get(num-1).getCurrent_date();
			
			l.deleteItem(l.getList().get(num-1));
			
			TodoItem t = new TodoItem(new_title, cate,new_description,current_date,due_date);
			l.addItem(t);
			
			System.out.println("수정되었습니다. ");
			
		}
		

	}

	public static void listAll(TodoList l) {
		System.out.println("[전체 목록, 총 "+l.getList().size()+"개]");
		for(int i=0; i<l.getList().size();i++) {
			System.out.println((i+1)+". "+l.getList().get(i).toString());
		}
	}
	public static void saveList(TodoList l, String filename) {
		//FileWriter
		//todolist.txt에 
		try {
			Writer w = new FileWriter(filename);
			for(int i=0; i<l.getList().size(); i++) {
				w.write(l.getList().get(i).toSaveString());
			}
			w.close();
			System.out.println("모든 데이터가 저장되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadList(TodoList l, String filename) {
		//BufferedReader, FileReader, StringTokenizer 사용 
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			String oneline;
			while((oneline = br.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(oneline, "##");
				String cate = st.nextToken();
				String title = st.nextToken();
				String desc = st.nextToken();
				String due = st.nextToken();
				String date = st.nextToken();
				
				
				TodoItem item = new TodoItem(title, cate, desc, date,due);
				l.addItem(item);
				//System.out.println(item.toString());
			}
			System.out.println(l.getList().size()+"개의 항목을 읽었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("todolist.txt 파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void FindKeyword(TodoList l, String keyword) {
		int num=0;
		for(int i=0; i<l.getList().size(); i++) {
			if(l.getList().get(i).getTitle().contains(keyword) || l.getList().get(i).getDesc().contains(keyword)) {
				System.out.println(i+1+". "+l.getList().get(i).toString());
				num++;
			}
		}
		System.out.println("총 "+num+"개의 항목을 찾았습니다.");
	}
	public static void FindCateKeyword(TodoList l, String keyword) {
		int num=0;
		for(int i=0; i<l.getList().size(); i++) {
			if(l.getList().get(i).getCategory().contains(keyword)) {
				System.out.println(i+1+". "+l.getList().get(i).toString());
				num++;
			}
		}
		System.out.println("총 "+num+"개의 항목을 찾았습니다.");
	}
	public static void listCate(TodoList l) {
		Set<String> clist = new HashSet<String>();
		
		for(int i=0; i<l.getList().size(); i++) {
			clist.add(l.getList().get(i).getCategory());
		}
		
		Iterator it =clist.iterator();
		
		while(it.hasNext()) {
			String s = (String) it.next();
			System.out.print(s);
			if(it.hasNext()) {
				System.out.print(" / ");
			}
			else {
				System.out.println();
			}
		}
		System.out.println("총 "+clist.size()+"개의 카테고리가 등록되어 있습니다.");
		
	}
}
