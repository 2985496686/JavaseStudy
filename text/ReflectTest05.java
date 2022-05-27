package text;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
通过反射机制，获取User的源代码(不含构造方法和实例方法)
 */
public class ReflectTest05 {
    public static void main(String[] args) throws Exception{
        StringBuffer s = new StringBuffer();
        //获取User类的Class对象
        Class c = Class.forName("User");
        //获取类名及其修饰符，拼接到字符串s上。
        s.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() + "{\n");
        //获取类中属性
        Field[] f1 = c.getDeclaredFields();
        for(Field field:f1){
            //获取属性的修饰符以及名字，并将其拼接
            s.append("\t" + Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName() + "\n");
        }
        s.append("}");
        System.out.println(s);
    }
}