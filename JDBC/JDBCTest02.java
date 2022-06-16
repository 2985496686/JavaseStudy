import java.io.*;
import java.util.*;
import java.sql.*;
public class JDBCTest02{
	public static void main(String args[]){
		Connection conn = null;
		Statement state = null;
		try{
			//ע������
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//�������ݿ�
			String url = "jdbc:mysql://localhost:3306/study2";
			String user = "root";
			String password = "111111";
			conn = DriverManager.getConnection(url,user,password);
			//�������ݿ��������
			state = conn.createStatement();
			//ִ��sql���
			int count = state.executeUpdate("delete from user where id = 1");
			System.out.println(count == 1 ? "ɾ���ɹ���" : "ɾ��ʧ�ܣ�");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//�ر���Դ
			if(state == null){
				try{
					state.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn == null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
}