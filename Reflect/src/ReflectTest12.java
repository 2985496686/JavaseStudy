/*
通过反射机制获取一个类的父类和父接口
 */
public class ReflectTest12 {
    public static void main(String[] args)throws Exception {
        Class c = Class.forName("java.lang.String");
        //一个类最多只有一个父类
        Class superClass = c.getSuperclass();
        System.out.println(superClass.getName());
        //一个类可以实现多个接口
        Class[] superInterfaces = c.getInterfaces();
        for(Class i: superInterfaces){
            System.out.println(i.getName());
        }
    }
}
