/*
想要序列化多个对象时，可以利用集合将对象存储，然后序列化这个集合对象()
 */
package Serialize;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamTest02 {
    public static void main(String[] args) {
        List<Student> l = new ArrayList<>();
        l.add(new Student("张三","123"));
        l.add(new Student("李四","124"));
        l.add(new Student("王五","125"));
        ObjectOutputStream o = null;
        try {
           o = new ObjectOutputStream(new FileOutputStream("StudentsList"));
           o.writeObject(l);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(o != null){
                try {
                    o.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
