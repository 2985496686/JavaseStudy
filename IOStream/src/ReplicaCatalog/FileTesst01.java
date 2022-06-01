package ReplicaCatalog;

import java.io.File;

public class FileTesst01 {
    public static void main(String[] args) {
        File file = new File("D:\\JavaStudy\\图片");
        File[] files = file.listFiles();
        for(File f:files){
            System.out.println(f.getName());
        }
    }
}
