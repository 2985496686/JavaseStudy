package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class test {
    public static void main(String[] args){
        try{
            System.out.println("111");
            //这里的return并不会影响222的打印
            return;
        }finally{
            System.out.println("222");
        }
    }
}
