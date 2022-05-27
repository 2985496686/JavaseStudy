import java.lang.reflect.Field;
import java.util.ResourceBundle;

/*
通过反射机制访问一个java对象的属性(get和set)。
 */
public class ReflectTest06 {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("User");
        //通过反射实例化User类
        Object user = c.newInstance();
        //设置User对象的no
        Field field = c.getDeclaredField("no");
        field.set(user,12);
        //获得User对象的no
        System.out.println(field.get(user));

        //设置User对象的name，需要打破封装，因为name属性是私有属性，不能直接设置
        Field field1 = c.getDeclaredField("name");
        field1.setAccessible(true);
        field1.set(user,"Joke");
        System.out.println(field1.get(user));
    }
}
