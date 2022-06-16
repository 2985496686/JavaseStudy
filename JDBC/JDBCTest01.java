import java.sql.*;
import java.io.*;
public class JDBCTest01{
	public static void main(String [] args){
		Connection conn = null;
		Statement stmt = null;
		try{
			//1、注册驱动
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//2、获取连接
			/*
			URL包括哪几部分：
			协议，IP，端口(PORT),资源名
			协议：jdbc:mysql://
			IP地址：192.168.1.179
			PORT:3306
			资源名(具体的数据库实例名)
			说明:localhost也能代替本机IP
			*/
			String url = "jdbc:mysql://localhost:3306/study2";
			String user = "root";
			String password = "111111";
			conn = DriverManager.getConnection(url,user,password);
			System.out.println(conn);


			//3.获取数据库操作对象
			stmt = conn.createStatement();

			//4.执行sql语句
			/*
			int executeUpdate(String sql) throws SQLException
			专门用来执行sql语句的函数，返回值为"影响数据库中记录条数"
			*/
			int count = stmt.executeUpdate("insert into user (name) value ('杜甫')");
			if(count == 1){
				System.out.println("保存成功！");
			}
			else{
				System.out.println("保存失败！");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//6.释放资源，从小到大释放
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