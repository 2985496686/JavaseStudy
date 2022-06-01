package printStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintstreamTest01 {
    public static void main(String[] args) {
        //这个流不需要关闭，默认输出到控制台
        PrintStream p = System.out;
        p.println("ddddddddd");
        //改变输出方向
        try {
            System.setOut(new PrintStream(new FileOutputStream("log.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("ssssssssssss");
    }
}
