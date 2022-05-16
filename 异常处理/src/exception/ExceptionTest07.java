package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
try不能单独使用，try可以和catch联合使用，try也可以和fianlly联合使用，try，catch，fianlly三个也可以一块联合使用
finally子句的使用
finally使用在try..catch的后边，无论是否捕捉到异常，都会最后执行finally子句中的代码
 */

public class ExceptionTest07 {
    public static void main(String[] args) {
        FileInputStream x = null;
      /*
        //try和finally的联合使用
        try{
            System.out.println("111");
            //这里的return并不会影响222的打印
            return;
        }finally{
            System.out.println("222");
        }*/
        try {
            //创建输入流
            x = new FileInputStream("D:\\java学习d进阶\\异常处理\\测试.txt");
            String s = null;
            //这里会出现NuLLPointException，下面的代码将不会在执行
            s.toString();
            //流使用完要关闭，即使程序出现异常也要关闭，所以将x.close放在这里十分危险
            x.close();
        } catch (FileNotFoundException a) {
            a.printStackTrace();
        } catch (NullPointerException b) {
            b.printStackTrace();
        } catch (IOException c) {
            c.printStackTrace();
        } finally {
            //在这里关闭流比较保险
            if (x != null) {
                try {
                    x.close();
                } catch (IOException d) {
                    d.printStackTrace();
                }
            }
        }
    }
}
