package exception;

public class ExceptionTest03 {
    public static void main(String[] args)  {
        //在这里在调用doSome方法时必须对ClassNotFoundException进行预先处理
        //如果不处理此异常，编译器就会报错
        //编译器报错信息如下：
        //Error:(8, 15) java: 未报告的异常错误java.lang.ClassNotFoundException; 必须对其进行捕获或声明以便抛出
        //第一种处理方式:
        /*
        在方法声明上使用throws，将异常继续上抛
        public static void main(String[] args) throws ClassNotFoundException
        */
        //第二种处理方式：
        //异常捕捉
        try {
            doSome();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //ClassNotFountException是Exception的直接子类，所以它是编译时异常。
    //doSome方法将异常抛给了它的上级
    public static void doSome() throws ClassNotFoundException{
        System.out.println("doSome!!!");
    }
}
