import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/*
通过反射机制获取一个类中的构造方法
 */
public class ReflectTest10 {
    public static void main(String[] args)throws Exception {
        Class c = Class.forName("java.lang.String");
        Constructor[] constructors = c.getDeclaredConstructors();
        StringBuffer s = new StringBuffer();
        for(Constructor co: constructors){
            s.append(Modifier.toString(co.getModifiers()) + " " +c.getSimpleName() + "(");
            Class[] parameterType = co.getParameterTypes();
            for(Class cs:parameterType){
                s.append(cs.getSimpleName()+" ");
            }
            s.append("){}\n");
        }
        System.out.println(s);
    }
}
