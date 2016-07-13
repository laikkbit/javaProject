package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modle.BookModle;


import service.BookService;

public class View {

	public static final String CONTEXT="��ӭʹ��ͼ�����ϵͳ!\n"+
			"�����Ǹ�ϵͳ�����б�\n"+
			"[MAIN]: ���˵�\n"+
			"[ADD]:���ͼ����Ϣ\n" +
			"[UPDATE]:����ͼ����Ϣ\n" +
			"[DELETE]:ɾ��ͼ����Ϣ\n" +
			"[SEARCH]:��ѯͼ����Ϣ(����ͼ������id��ѯ)\n" +
			"[EXIT]:�˳�ͼ�����ϵͳ\n" +
			"[EXCEL]������ͼ����Ϣ\n"+
			"[BREAK/B]:�˳���ǰ���ܣ��������˵�";
	/*
	 * �ⲿ����ʱ��δʵ��
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
				System.out.println("������ͼ������"); 
				String bookname=s.next();
				System.out.println("������ͼ�����ߣ�"); 
				String writer=s.next();
				System.out.println("������ͼ��۸�");
				double price=s.nextDouble();
				System.out.println(service.add(bookname, writer, price));
			}

			else if(input.equals("UPDATE")){
				System.out.println("������Ҫ�޸�ͼ���id");
				int id=s.nextInt();
				System.out.println("�������޸ĺ��ͼ������"); 
				String bookname=s.next();
				System.out.println("�������޸ĺ��ͼ�����ߣ�"); 
				String writer=s.next();
				System.out.println("�������޸ĺ��ͼ��۸�");
				double price=s.nextDouble();
				System.out.println(service.update(bookname, writer, price, id));			
			}

			else if(input.equals("DELETE")){
				System.out.println("������ͼ��id");
				int id =s.nextInt();			
				System.out.println(service.delete(id));
			}

			else if(input.equals("SEARCH")){
				System.out.println("ͨ��id��ѯ�밴1��ͨ��ͼ������ѯ�밴2");
				int oh=0;
				while(oh==0){
					oh=s.nextInt();
					if(oh==1) {
						System.out.println("�������ѯid");
						int id =s.nextInt();
						BookModle book =service.getBook(id);
						System.out.println(book.toString());
					}
					else if(oh==2) {
						System.out.println("������ͼ����");
						String bookname =s.next();
						BookModle book =service.getBook(bookname);
						System.out.println(book.toString());
					}
					else  System.out.println("����������������룡");
				}
			}

			else if(input.equals("BREAK")) {
				System.out.println("�ɹ��˳���");
				n=0;
			} 

			else if(input.equals("MAIN"))
				continue;

			else if(input.equals("EXIT")){
				System.out.println("�ɹ��˳���");
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

			else System.out.println("����ȷ���룡");
		}
		s.close();	
	}



}
