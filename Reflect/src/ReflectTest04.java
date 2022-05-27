import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/*
public Field[] getFields()  -------  java.lang.Class中的方法，将类中public修饰的属性以数组的形式返回

public Field[] getDeclaredFields() ------ java.lang.Class中的方法，将类中所有的属性以数组的形式返回

public Class getType() ------ java.lang.reflect.Field中的方法，获取属性的类型并返回

public int getModifiers() ----- java.lang.reflect.Field中的方法，获取属性的修饰符，并以整数编码的形式返回(一个整数编码可能代表多个修饰符)

static String toString(int mod)  ------ java.lang.reflect.Modifier中的静态方法，传入修饰符的整数编码，以字符串的形式将修饰符返回


 */
public class ReflectTest04 {
    public static void main(String[] args) throws  Exception {
        //获取整个类
        Class c = Class.forName("User");
        //获取类中的所以Field
        Field[]fields = c.getFields();
        System.out.println(fields.length);//长度为1
        System.out.println(fields[0].getName());//no，说明通过getFields()方法只能获取public修饰的属性

        Field[] fields1 = c.getDeclaredFields();
        System.out.println(fields1.length);
        for(Field f:fields1){
            //getType()可以获取属性的类型，返回的是一个Class对象
            //getModifiers()获取属性的修饰符,返回修饰符的整数编码
            System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getName() + "  " + f.getName());
        }
    }
}
