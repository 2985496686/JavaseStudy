/*
与FileInputStream区别
1. FileInputStream使用read()一次读取一个字节，并且返回的时byte类型的数
   FileReader使用read()方法一次读取一个字符，返回的是读取到的char类型字符
2. FileInputStream使用read(byte[] b),而FileReader使用read(char[] c)

3.FileReader和FileWriter只能读写普通文件，不能读写像图片、视频、录音等特特殊文件。
 */
package fileReaderdAndWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("D:\\JavaStudy\\IOStream\\src\\fileInput\\test.txt");
            char[] chars = new char[2];
            int retCount = 0;
            while((retCount = reader.read(chars)) != -1){
                System.out.println(new String(chars,0,retCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
