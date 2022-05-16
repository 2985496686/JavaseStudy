/*
public void interrupt() -----  中断当前线程的阻塞状态

public final void stop() ------- 强行终止当前线程
该方法已经过时，因为它是不安全的，如：当前线程的数据没有保存，强行终止，会导致数据丢失。
 */
package thread;
public class ThreadTest06 {
    public static void main(String[] args) {
        Thread t = new Thread(new myRunnable2());
        t.start();
        try {
            Thread.sleep(1000*3);
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class myRunnable2 implements Runnable{
    public void run(){
            System.out.println(Thread.currentThread().getName() + "------>start");
            try {
                Thread.sleep(1000*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "------>end");
    }
}
