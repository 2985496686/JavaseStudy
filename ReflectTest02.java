import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

/*
java的反射机制十分灵活，通过反射机制可以在不改变Java源码的情况下，
可以做到不同对象的实例化(符合OCP开闭原则：对扩展开放，对修改关闭)
 */
public class ReflectTest02 {
    public static void main(String[] args) throws Exception {

        //以下代码是灵活的，代码不需要改动，可以修改配置文件，配置文件修改之后，可以创建不同的实例化对象

        //通过IO流读取classinfo.properties文件
        FileReader reader = new FileReader("D:\\java学习进阶\\Reflect\\src\\classinfo.properties");
        //创建属性类对象Map
        Properties pro = new Properties();
        //加载
        pro.load(reader);
        //关闭流
        reader.close();
        //通过key获取value
        String className = pro.getProperty("className");
        //通过反射机制实例化对象
        Class c = Class.forName(className);

        //newInstance()方法底层调用的是该类的无参构造
        Object o = c.newInstance();
        System.out.println(o);
    }
}
