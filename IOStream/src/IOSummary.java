/*
四大io流： java.io.InputStream ----- 字节输入流
           java.io.OutputStream ----- 字节输出流
           java.io.read ----- 字符输入流
           java.io.write ----- 字符输出流

注：1.以Stream结尾的都是字节流，以read/write结尾的都是字符流。
    2.所有的流都实现了接口Closeable，都有一个close() 方法。
    3.输出流都实现了接口Flushable，都有一个flush() 方法，刷新输出流，将
      管道中剩余未输出的数据强行输出完(清空管道)，如果没有flush() ，可能会导致数据流失。

文件专属：
java.io.FileInputstream
java.io.Fileoutputstream
java.io.FileReader
java.io.Filewriter

转换流：
java.io.InputstreanReader
java.io.outputstreanWriter

缓冲流：
java.io.BufferedReader
java.io. Bufferedwriter
java.io.BufferedReader
java.io. Bufferedwriter

数据流
java.io.DataInputstream
java.io.Dataoutputstrean

对象专属流
java.io.objectInputstream
java.io.objectoutputstream

标准输出流
java.io.Printwriter
java.io.Printstream
 */
public class IOSummary {
    public static void main(String[] args) {
        System.out.println("这里是笔记！！！");
    }
}
