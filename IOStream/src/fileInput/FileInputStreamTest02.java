package fileInput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest02 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\JavaStudy\\IOStream\\src\\fileInput\\test.txt");
            int rntSize = 0;
            byte[] bytes = new byte[4];
            while((rntSize = fis.read(bytes)) != -1){
                System.out.print(new String(bytes,0,rntSize));//abcdefg
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
