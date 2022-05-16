package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
异常类中的两个常用方法：getMessage() , printStackTrace()
 */
public class ExceptionTest06 {
    public static void main(String[] args) {
        //getMessage():获取异常的简单描述信息，该描述信息是创建异常对象时传给构造方法的String参数
        FileNotFoundException x = new FileNotFoundException("错误！！！");
        System.out.println(x.getMessage());



        //printStackTrace(): 打印异常的堆栈信息，可以在堆栈信息找到异常对象在Java源代码中的位置
        x.printStackTrace();
        //该方法时常与try..catch连用
        try{
            new FileInputStream("D:\\java学习d进阶\\异常处理\\测试.txt");
        }catch(FileNotFoundException a){
            //当捕捉到异常后，为了程序员知道出错了，并且找到出错的位置，就可以使用该方法。
            a.printStackTrace();
        }
    }
}