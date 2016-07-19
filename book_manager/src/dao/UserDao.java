package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.resource.cci.ResultSet;

import db.DbUtil;

public class UserDao {
	
	DbUtil db=new DbUtil();
	
	public Boolean loginRequest(String username,String password){
            Connection conn=db.getConnection();
            String sql="select password from user_message where username=? ";
            PreparedStatement ptmt=null;
		try {
			ptmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ps=null;
            try {
				ptmt.setString(1, username);
				ResultSet rs=(ResultSet) ptmt.executeQuery();
				while(rs.next()){
					ps=rs.getString("password");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
            if (password.equals(ps))
            	return true;
            else return false;
	}
}
