package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modle.BookModle;


import db.DbUtil;

public class BookDao {

	DbUtil db =new DbUtil();

	public String add(BookModle book) {
		Connection conn =db.getConnection();
		String sql="" +
				"insert into book_message" +
				"(book_name,writer,price)" +
				"values(?,?,?)";
		 PreparedStatement ptmt=null;
		try {
			ptmt = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			return "连接失败";
		}
		try{
			ptmt.setString(1,book.getBook_name());
			ptmt.setString(2, book.getWriter());
			ptmt.setDouble(3,book.getPrice());
			ptmt.execute();
			ptmt.close();
			db.closeConnection(conn);
			return "操作成功";
	  } catch(SQLException e){
			return "操作失败";
		}		

	}

	public String update(BookModle book,int id) {
		Connection conn = db.getConnection();
		String sql="" +
				" update book_message " +
				" set book_name=?,writer=?,price=?" +
				" where id=? ";
		PreparedStatement ptmt=null;
		try {
			ptmt = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			return "连接失败";
		}
		try {			
			ptmt.setString(1,book.getBook_name());
			ptmt.setString(2,book.getWriter());
			ptmt.setDouble(3,book.getPrice());
			ptmt.setInt(4, id);
			ptmt.execute();
			ptmt.close();
			db.closeConnection(conn);
			return "成功修改";
		} catch (SQLException e) {
			return "操作失败";
		}		
	}

	public String delete(int id) {
		Connection conn =null;
		PreparedStatement ptmt=null;
		conn =db.getConnection();
		String sql="" +
				" delete from book_message " +
				" where id=? ";
		try {
			ptmt = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			return "连接失败";
		}
		try {
			
			ptmt.setInt(1, id);
			ptmt.execute();
			ptmt.close();
			conn.close();
			return "删除成功";
		} catch (SQLException e) {
			return "删除失败";
		}
	}

	public BookModle get(int id){
		Connection conn =null;
		PreparedStatement ptmt=null;
		BookModle book =new BookModle();
		conn =db.getConnection();
		String sql="" +
				" select * from book_message "  +
				" where id=? ";
		try {
			ptmt = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			System.out.println("连接失败");
		}
		try {
			ptmt.setInt(1, id);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){			
				book.setId(rs.getInt("id"));
				book.setBook_name(rs.getString("book_name"));
				book.setWriter(rs.getString("writer"));
				book.setPrice(rs.getDouble("price"));
			}	
			rs.close();	
			ptmt.close();
			conn.close();
			return book;
		} catch (SQLException e) {
			System.out.println("操作失败");
			return null;
		}		
	}	

	public BookModle get(String bookname) {
		Connection conn =null;
		PreparedStatement ptmt=null;
		conn =db.getConnection();
		BookModle book =null;
		String sql="" +
				" select * from book_message "  +
				" where book_name=? ";		
		try{		
			ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, bookname);
			ResultSet rs=ptmt.executeQuery();		
			while(rs.next()){
				book=new BookModle();
				book.setId(rs.getInt("id"));
				book.setBook_name(rs.getString("book_name"));
				book.setWriter(rs.getString("writer"));
				book.setPrice(rs.getDouble("price"));
			}
			rs.close();
			ptmt.close();		
			conn.close();
		}catch(SQLException e){
			System.out.println("操作失败");
		}
		return book; 
	}

	public List<BookModle> allMessage() {
		Connection conn =null;
		PreparedStatement ptmt=null;
		List<BookModle> result =new ArrayList<BookModle>();
		conn =db.getConnection();
		String sql="select * from book_message";
		try {
			ptmt=conn.prepareStatement(sql);
			ResultSet rs =ptmt.executeQuery();
			BookModle g=null;
			while(rs.next()){
				g =new BookModle();
				g.setId(rs.getInt("id"));
				g.setWriter(rs.getString("writer"));
				g.setBook_name(rs.getString("book_name"));
				g.setPrice(rs.getDouble("price"));
				result.add(g);
			}
			rs.close();
			ptmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("操作失败");
		}		
		return result;
	}
}
