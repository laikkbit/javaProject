package service;

import java.util.List;

import dao.BookDao;
import modle.BookModle;

public class BookService {
  
	BookDao bookdao =new BookDao();
  public String add(String bookname,String writer,double price){
	  BookModle book=new BookModle(bookname,writer,price);
	  return bookdao.add(book);	   
  }
  
  public String update(String bookname,String writer,double price,int id){
	  BookModle book=new BookModle(bookname,writer,price);
	  return  bookdao.update(book, id);
  }
  
  public String delete(int id){
	return  bookdao.delete(id);
  }
  
  public BookModle getBook(int id){
	return  bookdao.get(id); 
  }
  
  public BookModle getBook(String bookname){
	return  bookdao.get(bookname);
  }
  
  public List<BookModle> allMessage(){
	return  bookdao.allMessage();
  }
}
