package exception;
/*
Java中允许使用者自定义异常类
步骤：
    1、编译时异常要继承Exception，运行时异常继承RunTimeException。
    2、要创建一个无参构造和一个有参构造(带一个String参数)
 */
//编译时异常
public class MyException extends Exception{
     public MyException(){

     }
     public MyException(String s){
         super(s);
     }
}
