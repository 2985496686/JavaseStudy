/*
BufferedReader是一个缓冲输入流，创建对象时需要传一个Reader对象
BufferedReader有一个readline()方法，可以一次读取一行
 */
import java.io.*;

public class bufferedReaderAndWriter {
    public static void main(String[] args) {
        BufferedReader in = null;
        FileReader fis = null;
        try {
            //fis为节点流
            fis = new FileReader("D:\\JavaStudy\\IOStream\\src\\fileInput\\test.txt");
            //in为包装流
            in = new BufferedReader(fis);
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(in != null){
                try {
                    //关闭流时只需要关闭包装流
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
