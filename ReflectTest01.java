import java.util.Date;

/*
有三种获得类的字节码的方式

第一种：
java.lang.Class类下的静态方法：static Class forName(String className)
注意：1.参数是一个带有包名的完整类名
      2.抛出编译时异常：ClassNotFountException


第二种：Object类下有个方法: Class getClass() ----- 返回此对象对应被实例化的类


第三种：Java种任何一种类型，包括基本数据类型，都有class静态属性，直接通过 类名.class,就可以返回相应的Class类
 */
public class ReflectTest01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("java.util.Date");
        Date d = new Date();
        Class c2 = d.getClass();
        System.out.println(c1.equals(c2));//true
        Class c3 = Date.class;
        System.out.println(c3.equals(c2));//true
    }
}
