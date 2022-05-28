import java.lang.reflect.Constructor;

/*
通过反射机制创建对象(调用构造方法)
 */
public class ReflectTest11 {
    public static void main(String[] args)throws Exception {
        Class c = Class.forName("User");
        //默认调用无参数构造方法
        Object obj1 = c.newInstance();
        //因为每一个构造方法的方法名都一样，所以getDeclaredConstructor方法的参数只有要调用的构造方法的构造参数类型列表
        Constructor constructor = c.getDeclaredConstructor(int.class,String.class,int.class,boolean.class);
        Object obj2 = constructor.newInstance(1111,"zhangsan",18,true);
        System.out.println(obj2);
    }
}
