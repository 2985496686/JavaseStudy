import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class JDBCTest07 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement state = null;
        ResultSet st = null;
        //注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/study2";
            String user = "root";
            String password = "111111" ;
            conn = DriverManager.getConnection(url,user,password);
            //获取数据库操作对象
             state = conn.createStatement();
             //执行sql语句
            String sql = "select * from user";
            st = state.executeQuery(sql);
            //处理查询结果集
            while(st.next()){
                System.out.println(st.getString("id") + "   " + st.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(state != null){
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
