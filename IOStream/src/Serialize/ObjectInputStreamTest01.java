package Serialize;

import java.io.*;

public class ObjectInputStreamTest01 {
    public static void main(String[] args) {
        ObjectInputStream o = null;
        try {
            o = new ObjectInputStream(new FileInputStream("students"));
            Student obj =  (Student)o.readObject();
            System.out.println(obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
