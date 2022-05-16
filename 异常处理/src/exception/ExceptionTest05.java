package exception;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
深入try..catch
1.catch的后面的小括号可以是具体的异常类型，也可以是父类型异常。
2.try中代码抛出多个异常时，可以写多个catch，但是catch内的异常必须从小到大(继承关系)
3.catch后面小括号虽然可以是父类型，但是建议使用具体异常类型，有利于程序的调试。
 */
public class ExceptionTest05 {
    public static void main(String[] args) {
        try{
            new FileInputStream("D:\\java学习d进阶\\异常处理\\测试.txt");
        }catch(Exception x){
            //catch后面写父类型异常——多态
            //Exception x = new FileNotFoundException()
        }


        try{
            //创建输入流 —— 会抛出 FileNotFoundException 异常(编译时异常)
            FileInputStream fis =  new FileInputStream("D:\\java学习d进阶\\异常处理\\测试.txt");
            //读文件 —— 会抛出 IOException 异常(编译时异常)
            fis.read();
        }catch(FileNotFoundException f){

        }catch(IOException i){
        //IOException不能放在FileNotFoundException之前，因为IOException是FileNotFountException的父类
        }

        //jdk8之后支持：用try..catch处理多个异常时，catch后面的括号可以拿 | 连接，引用写在最后面
        //注意：拿 | 来连接的异常不能具有继承关系
        try{
            FileInputStream fis =  new FileInputStream("D:\\java学习d进阶\\异常处理\\测试.txt");
            System.out.println(100 / 0);
        }catch(FileNotFoundException | ArithmeticException x){
        }
    }
}
