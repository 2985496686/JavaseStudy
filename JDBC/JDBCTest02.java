import java.io.*;
import java.util.*;
import java.sql.*;
public class JDBCTest02{
	public static void main(String args[]){
		Connection conn = null;
		Statement state = null;
		try{
			//注册驱动
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//连接数据库
			String url = "jdbc:mysql://localhost:3306/study2";
			String user = "root";
			String password = "111111";
			conn = DriverManager.getConnection(url,user,password);
			//创建数据库操作对象
			state = conn.createStatement();
			//执行sql语句
			int count = state.executeUpdate("delete from user where id = 1");
			System.out.println(count == 1 ? "删除成功！" : "删除失败！");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//关闭资源
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