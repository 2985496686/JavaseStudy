package printStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mylog {
    public static void log( String s){
        try {
            System.setOut(new PrintStream(new FileOutputStream("log.txt",true)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
        System.out.println(sf.format(date) + s);
    }

    public static void main(String[] args) {
        mylog.log("我运行了这个程序！");
        mylog.log("我把这个代码写完了");
    }
}
