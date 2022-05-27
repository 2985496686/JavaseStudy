import java.lang.reflect.Field;
import java.util.ResourceBundle;

public class ReflectTest07 {
    public static void main(String[] args) throws Exception{
        //配合属性文件使用
        ResourceBundle bundle = ResourceBundle.getBundle("classinfo");
        Class c2 = Class.forName(bundle.getString("className"));
        //通过反射实例化User类
        Object obj = c2.newInstance();
        Field field1 = c2.getDeclaredField(bundle.getString("fieldName"));
        //打破封装
        field1.setAccessible(true);
        field1.set(obj,bundle.getString("fieldValue"));
        System.out.println(field1.get(obj));
    }
}
