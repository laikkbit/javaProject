package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	/*
	 * ���ݿ��û����Լ����� 
	 */
	private String URL="jdbc:mysql://127.0.0.1:3306/aa";
	private String USER="root";
	private String PASSWORD="228327";

	public  Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException e1) {
			System.out.println("��������ʧ��");
		}catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
		}
		return conn;
	}

	public void closeConnection(Connection conn){
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("���ݿ�ر�����ʧ��");
			} 
	}
}
