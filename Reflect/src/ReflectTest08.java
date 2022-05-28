import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
将一个类中的方法通过反射机制反编译出来(方法体具体内容无法得到)
 */
public class ReflectTest08 {
    public static void main(String[] args)throws Exception {
        Class c = Class.forName("java.lang.String");
        Method[] methods = c.getDeclaredMethods();
        StringBuffer s = new StringBuffer();
        for(Method m:methods){
            Class[] parameterTypes = m.getParameterTypes();
            s.append(Modifier.toString(m.getModifiers()) + " " + m.getReturnType().getSimpleName() + " " + m.getName() + "(");
            for(Class cs:parameterTypes){
                s.append(cs.getSimpleName() + " ");
            }
            s.append("){}\n");
        }
        System.out.println(s);
    }
}
