package exception;

/*
java中异常是以类的形式存在，每一个异常都可以创建异常对象
 现实中的例子：
         火灾(异常类)
              2008年1月1日，小明家着火了。(异常类对象)
              2008年1月2日，小亮家着火了。(异常类对象)
              2008年1月3日，小红家着火了。(异常类对象)
              ......
 */
public class ExceptionTest01 {
    public static void main(String[] args) {
        //int a = 5 / 0;
        /*
         运行时会抛出以下异常：
         Exception in thread "main" java.lang.ArithmeticException: / by zero
	     at exception.ExceptionTest01.main(ExceptionTest01.java:5)
	     实则程序在运行到这里时会创建异常对象: new ArithmeticException("/ by zero");然后将异常抛出
         */
        //任何异常类也是可以自己new对象的
        ArithmeticException x = new ArithmeticException("/ by zero");
        System.out.println(x);
    }
}
