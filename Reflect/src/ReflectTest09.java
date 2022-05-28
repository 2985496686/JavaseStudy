import java.lang.reflect.Method;

/*
使用反射机制调用一个对象的方法,步骤如下：
1.获取对应类的Class对象。
2.通过反射机制实例化出一个对象。
3.通过方法 ：public Method getDeclaredMethod(String name, Class... parameterTypes)，获取对应的Method对象
注意：getDeclaredMethod方法是在java.lang.Class下的方法，第一个参数是方法名，第二个参数是可变长参数，是该方法的形式参数类型列表
4.通过方法：public Object invoke(Object obj,Object... args)，可以调用Method对象对应的方法。
注意：该方法是java.lang.reflect.Method下的方法，第一个参数是对象，第二个参数是方法的实际参数列表

 */
public class ReflectTest09 {
    public static void main(String[] args)throws Exception {
        Class c = Class.forName("User");
        Object obj = c.newInstance();
        Method method = c.getDeclaredMethod("doSome",int.class);
        System.out.println(method.invoke(obj,1));
    }
}
