package fileReaderdAndWriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest01 {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("D:\\JavaStudy\\IOStream\\src\\fileInput\\test.txt",true);
            writer.write("dshdhdiiwuweiuiwuedsfdserdscf");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(writer!= null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
