package thread;
/*
public final void stop() ------- 强行终止当前线程
该方法已经过时，因为它是不安全的，如：当前线程的数据没有保存，强行终止，会导致数据丢失。
下面演示正确终止线程的方式：
 */
public class ThreadTest07 {
    public static void main(String[] args) {
        myRunnable3 r = new myRunnable3();
        Thread t = new Thread(r);
        //五秒之后终止线程t
        try{
            t.start();
            Thread.sleep(1000*3);
            r.flag = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class myRunnable3 implements Runnable{
    boolean flag = true;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "------>start");
        for (int i = 0; i < 1000; i++) {
            if(flag){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else{
                //进行数据的保存以及相关操作
            }
        }
    }
}
