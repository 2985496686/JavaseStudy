package ReplicaCatalog;

import java.io.*;

public class replicaCatalog {
    public static void copy(String sourse, String dest){
        File file1 = new File(sourse);
        File file2 = new File(dest );
        if(!file2.exists()){
            file2.mkdir();
        }
        File[] files = file1.listFiles();
        for(File f:files){
            if(f.isDirectory()){
                copy(f.getAbsolutePath(),dest + "//" + f.getName());
            }
            else{
                FileInputStream in = null;
                FileOutputStream out = null;
                try {
                    in = new FileInputStream(f.getAbsolutePath());
                    out = new FileOutputStream( dest + "//"+ f.getName(),true);
                    int readCount = 0;
                    byte []bytes = new byte[1024];
                    while((readCount = in.read(bytes)) != -1){
                        out.write(bytes,0,readCount);
                        out.flush();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{
                    if(in != null){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(out != null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        replicaCatalog.copy("D://图片","D://p//图片");
    }
}
