public class ReflectTest03 {
    public static void main(String[] args) throws ClassNotFoundException {
        //forName()这个方法的执行会导致 MyClass 类加载，如果只想让一个类的静态代码块执行，就可以调用这个方法
        Class c = Class.forName("MyClass");
    }
}
