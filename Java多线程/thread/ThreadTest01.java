
//创建线程的第一种方式：编写继承Thread的线程类。
package thread;
class myThread extends Thread{
    public void run(){
        for(int i = 0; i < 1000; i++){
            System.out.println("分支线程->" + i);
        }
    }
}
public class ThreadTest01 {
    public static void main(String[] args) {
        myThread t = new myThread();
        t.start();
        for(int i = 0; i < 1000; i++){
            System.out.println("主线程->" + i);
        }
    }
}
