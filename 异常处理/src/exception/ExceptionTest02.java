package exception;

import java.util.Scanner;
/*
Java语言处理异常的两种方式：
    1.异常上抛：在方法声明的位置上，使用 throws 关键字，抛给上一级(抛给方法掉用着)
    2.异常捕捉：使用 try..catch 进行对异常的捕捉
    注意：Java中异常发生后，如果一直上抛，最终抛给调用者JVM，JVM知道异常的发生，会终止Java程序的执行。
 */
public class ExceptionTest02 {
    public static void main(String[] args)throws ArithmeticException {

        /*程序执行到此处发生了ArithmeticException异常
         底层创建了一个ArithmeticException类的异常对象，
         因为是main方法调用了 3 / 0 ，所以这个异常抛给了
         mian方法，main方法中并没有处理此异常，所以将这个
         异常又抛给了JVM,JVM终止了此程序，所以后继程序将
         不在执行。

         ArithmeticException继承了RuntimeException ，是运行时异常，
         在编写程序阶段不需要对这种异常进行预处理。
         */
        int a = 3 / 0;
        System.out.println("Hello World");
    }
}
