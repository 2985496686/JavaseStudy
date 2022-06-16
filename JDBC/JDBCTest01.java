import java.sql.*;
import java.io.*;
public class JDBCTest01{
	public static void main(String [] args){
		Connection conn = null;
		Statement stmt = null;
		try{
			//1��ע������
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//2����ȡ����
			/*
			URL�����ļ����֣�
			Э�飬IP���˿�(PORT),��Դ��
			Э�飺jdbc:mysql://
			IP��ַ��192.168.1.179
			PORT:3306
			��Դ��(��������ݿ�ʵ����)
			˵��:localhostҲ�ܴ��汾��IP
			*/
			String url = "jdbc:mysql://localhost:3306/study2";
			String user = "root";
			String password = "111111";
			conn = DriverManager.getConnection(url,user,password);
			System.out.println(conn);


			//3.��ȡ���ݿ��������
			stmt = conn.createStatement();

			//4.ִ��sql���
			/*
			int executeUpdate(String sql) throws SQLException
			ר������ִ��sql���ĺ���������ֵΪ"Ӱ�����ݿ��м�¼����"
			*/
			int count = stmt.executeUpdate("insert into user (name) value ('�Ÿ�')");
			if(count == 1){
				System.out.println("����ɹ���");
			}
			else{
				System.out.println("����ʧ�ܣ�");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//6.�ͷ���Դ����С�����ͷ�
			if (stmt != null){
				try{
				stmt.close();
			    }catch (SQLException e){
				e.printStackTrace();
			    }
			}
			if(conn != null){
				try{
					conn.close();
			    }
				catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
}