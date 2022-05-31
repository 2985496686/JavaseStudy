/*
idea默认的当前路径是工程project的根(JavaStudy包下)
read() ----- 一次读取一个字节，并将读到的数据返回,没有读到数据返回-1
read(byte[] arr) ---- 一次最多读取arr.length个字节，将读到的数据存到byte数组当中，并将读到的字节数返回，没有读到数据仍然返回1
 注意：若被读取的文件里面存的是:abcdef，byte数组长度为4
       那么，第一次会读到abcd，并将其存到数组里面，再读
       一次，会读到ef，并且ef将会把ab覆盖掉。

 */
package fileInput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            //文件中存的是abcdefg
            fis = new FileInputStream("D:\\JavaStudy\\IOStream\\src\\fileInput\\test.txt");
            //read()一次读取一个字节，返回1
            /*
            int readData;
            while((readData = fis.read()) != -1){
                System.out.printf("%c ",readData);
            }*/
            byte[] b = new byte[4];

            fis.read(b);
            fis.read(b);
            String s = new String(b);
            System.out.println(s);//输出

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
