package Serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest01 {
    public static void main(String[] args) {
        Student s = new Student("张三","123");
        ObjectOutputStream o = null;
        try {
            o = new ObjectOutputStream(new FileOutputStream("students"));
            o.writeObject(s);
            o.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
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
