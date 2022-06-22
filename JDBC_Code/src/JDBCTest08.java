import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
login1存在sql注入问题
该登录注册功能的sql语句是将用户输入的信息与字符串拼接，形成一个完整的sql语句，如果用户在输入时输入了带有sql关键字的'非法信息'
并且该非法信息串改了sql语句的原先的含义，导致未输入正确的信息也同样登录成功。

login2解决了sql注入问题
PreParedStatement是Statement的子类
在该方法中我们通过调用数据库连接对象的prepareStatement(sql)方法获取的是预编译的数据库操作对象，在获取预编译的数据库操作对象时
需要传入SQL语句的框子，其中它用占位符?来代替sql语句要接收的值。然后我们再用setString(int parameterIndex, String x) 方法给占位符‘ ？’传值
Statement 和 preparemenr 的区别
1.Statement存在sql注入问题，PreparedStatement不存在sql注入问题。
2.Statement每一次执行都需要对sql语句进行编译一次，效率较低，PreparedStatement只需要编译一次就可以执行N次，效率较高。
3.PreparedStatement会在编译阶段做类型检查，但是Statement不会。
 */
public class JDBCTest08 {
    public static void main(String[] args) {
        Map map = InitUI();
        if(login2(map)){
            System.out.println("登录成功！");
        }
        else{
            System.out.println("登录失败！");
        }
    }

    public static Map<String,String> InitUI(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String passWord = scanner.nextLine();
        Map<String,String> map = new HashMap<>();
        map.put("loginName",name);
        map.put("passWord",passWord);
        return map;
    }
    public static boolean Login1(Map<String,String> map){
        Connection conn = null;
        Statement state = null;
        ResultSet st = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost/study2","root","111111");
            //获取数据库操作对象
            state = conn.createStatement();
            //执行查询语句
            st = state.executeQuery("select *from login where loginName ='" + map.get("loginName") + "'and  loginPwd = '" + map.get("passWord") + "'");
            if(st.next()){
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ;
            }
        }
        return false;
    }

    public static boolean login2(Map<String,String> map){
        ResultSet rs = null;
        Connection conn = null;
        //预编译的数据库操作对象
        PreparedStatement ps = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study2","root","111111");
            //获取预编译的数据库操作对象
            ps = conn.prepareStatement("select * from login where loginName = ? and loginPwd = ?");
            //给占位符传值
            ps.setString(1,map.get("loginName"));
            ps.setString(2,map.get("passWord"));
            //执行sql语句
            rs = ps.executeQuery();
            //处理查询结果
            if(rs.next()){
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(ps != null){
                try {
                    ps.close();
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
        return false;
    }
}
