package fileOutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputTest01 {
    public static void main(String[] args) {
        FileOutputStream fos  = null;
        try {
            //若文件不存在，会在相对路径下创建该文件
            /*
            //该方法是有风险的，因为每次写都会将文件中原本存的东西全部删除，然后重新写入
            fos = new FileOutputStream("test2.txt");
            byte[] bytes = {98,99,100};
            fos.write(bytes);
            */
            //可在文件末尾追加的输出流
            fos = new FileOutputStream("test2.txt",true);
            byte[] bytes = {98,99,100};
            fos.write(bytes);
            String s = "我是中国人！！！";
            bytes = s.getBytes();
            fos.write(bytes);
            fos.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
