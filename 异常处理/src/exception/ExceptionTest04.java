package exception;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/*
总结：
    1.异常上抛可以同时上抛多个异常，用逗号隔开。
    2.父类异常是包含子类异常的。
    3.异常捕捉语法：
    try{
        //试着执行，如果遇到异常则不执行
    }catch(异常名 引用名){
        //该引用保存的是异常对象的地址
        //如果成功捕捉到该异常，则会执行这里面的语句
    }
    4.在main方法中可以选择将异常上抛，但是并不建议这样做，
      因为当程序中出现了该错误，在main方法中将异常抛给
      JVM，然后JVM就会终止该程序，这样做并不利于程序的
      健壮性。
    5.采用上抛的方式处理异常，遇到异常时会将异常上抛，并且该方法后继的代码不在执行
    6.采用捕捉的方式处理异常，遇到异常会将异常对象捕捉，并不会影响后继代码的执行。
    7.在处理编译时异常时，如何选择上抛还是捕捉？
      如果希望方法的调用者处理该异常时，那么就采用上抛的方式，否则就在采用捕捉的方式处理该方法。
 */
public class ExceptionTest04 {
    public static void main(String[] args) throws FileNotFoundException{
        //调用了m1方法，所以m1的异常被抛给了main方法
        //main方法将异常继续上抛，抛给JVM
        System.out.println("main begin!");
        /*try{
            m1();
        }catch(FileNotFoundException a){
            //遇到异常时一定会创建一个异常对象，这个对象的地址会保存在a中。
            System.out.println("文件不存在，可能路径错误，也可能文件被删除");
        }*/
        m1();
        System.out.println("main end!");
    }
    public static void m1()throws FileNotFoundException {
        //调用了m2方法，所以m3的异常被抛给了m2
        //m2将异常继续上抛
        System.out.println("m1 bengin!");
        m2();
        System.out.println("m1 end!");
    }
    public static void m2()throws FileNotFoundException {
        //调用了m3方法，所以m3的异常被抛给了m2
        //m2将异常继续上抛
        System.out.println("m2 bengin!");
        m3();
        System.out.println("m2 end!");
    }
    public static void m3()throws FileNotFoundException {
        //FileInputStream 抛出了异常FileNotFoundException
        //FileNotFoundException 继承了 IOException
        //IOException继承了Exception
        //所以FileNotFoundException是编译时异常
        //在m3方法中需要对该异常进行提前处理
        //在这里可以选择将异常FileNotFoundException上抛，也可以将它的父类IOException上抛
        //可以理解为：子类异常都是包含在父类异常中的
        System.out.println("m3 bengin!");
        new FileInputStream("D:\\java学s习进阶\\异常处理\\测试.txt");
        System.out.println("m3 end!");
    }
}
