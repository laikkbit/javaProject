package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import db.DbUtil;

public class UserDao {
	
	DbUtil db=new DbUtil();
	
	public Boolean loginRequest(String username,String password){
            Connection conn=db.getConnection();
            String sql="select password from user_message where username=? ";
            PreparedStatement ptmt=null;
		try {
		    System.out.println(conn == null);
			ptmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("δ֪����");
		}
		String ps=null;
            try {
				ptmt.setString(1, username);
				ResultSet rs=  ptmt.executeQuery();
				while(rs.next()){
					ps=rs.getString("password");
				}
			} catch (Exception e) {
				System.out.println("yigeweizhidecuowu");
			}
            if (password.equals(ps))
            	return true;
            else return false;
	}
}
