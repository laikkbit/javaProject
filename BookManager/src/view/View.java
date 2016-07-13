package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modle.BookModle;


import service.BookService;

public class View {

	public static final String CONTEXT="欢迎使用图书管理系统!\n"+
			"下面是该系统功能列表：\n"+
			"[MAIN]: 主菜单\n"+
			"[ADD]:添加图书信息\n" +
			"[UPDATE]:更新图书信息\n" +
			"[DELETE]:删除图书信息\n" +
			"[SEARCH]:查询图书信息(根据图书名、id查询)\n" +
			"[EXIT]:退出图书管理系统\n" +
			"[EXCEL]：所有图书信息\n"+
			"[BREAK/B]:退出当前功能，返回主菜单";
	/*
	 * 这部分暂时还未实现
	 * static{
		CreateData data =new CreateData();
		data.judgeDataBase();
	}*/
	public static void main(String[] args) {
		
	
		Scanner s=new Scanner(System.in);
		BookService service =new BookService(); 
		int n=1;
		while(n==1){ 

			System.out.println(CONTEXT);
			String input= s.next();
			if(input.equals("ADD")){	    		  
				System.out.println("请输入图书名："); 
				String bookname=s.next();
				System.out.println("请输入图书作者："); 
				String writer=s.next();
				System.out.println("请输入图书价格：");
				double price=s.nextDouble();
				System.out.println(service.add(bookname, writer, price));
			}

			else if(input.equals("UPDATE")){
				System.out.println("请输入要修改图书的id");
				int id=s.nextInt();
				System.out.println("请输入修改后的图书名："); 
				String bookname=s.next();
				System.out.println("请输入修改后的图书作者："); 
				String writer=s.next();
				System.out.println("请输入修改后的图书价格：");
				double price=s.nextDouble();
				System.out.println(service.update(bookname, writer, price, id));			
			}

			else if(input.equals("DELETE")){
				System.out.println("请输入图书id");
				int id =s.nextInt();			
				System.out.println(service.delete(id));
			}

			else if(input.equals("SEARCH")){
				System.out.println("通过id查询请按1，通过图书名查询请按2");
				int oh=0;
				while(oh==0){
					oh=s.nextInt();
					if(oh==1) {
						System.out.println("请输入查询id");
						int id =s.nextInt();
						BookModle book =service.getBook(id);
						System.out.println(book.toString());
					}
					else if(oh==2) {
						System.out.println("请输入图书名");
						String bookname =s.next();
						BookModle book =service.getBook(bookname);
						System.out.println(book.toString());
					}
					else  System.out.println("输入错误，请重新输入！");
				}
			}

			else if(input.equals("BREAK")) {
				System.out.println("成功退出！");
				n=0;
			} 

			else if(input.equals("MAIN"))
				continue;

			else if(input.equals("EXIT")){
				System.out.println("成功退出！");
				n=0;
			} 

			else if(input.equals("EXCEL")) {
				List <BookModle> result =new ArrayList<BookModle>(service.allMessage());
				for(BookModle e:result){
					BookModle book=new BookModle();
					book=e;
					System.out.println(book.toString());
				}
			}

			else System.out.println("请正确输入！");
		}
		s.close();	
	}



}
