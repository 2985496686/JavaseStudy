/*
线程的调度
public final int getPriority() —— 该线程的优先级

public final void setPriority(int newPriority) —— 修改线程的优先级

public static void yield() —— 暂停当前线程，并且执行其他线程。暂停该线程并不是该线程进入阻塞状态，
                                而是回到就绪状态，此时线程仍然有概率抢到时间片。

 public final void join()
                throws InterruptedException
 合并线程，如：t.join()，将当前线程加入t线程，并且放在t线程的后面
 */

package thread;

public class ThreadTest08 {
    public static void main(String[] args) {
        System.out.println("最大优先级" + Thread.MAX_PRIORITY);
        System.out.println("最小优先级" + Thread.MIN_PRIORITY);
        System.out.println("默认优先级" + Thread.NORM_PRIORITY);
        //获取线程对象的优先级
        System.out.println( Thread.currentThread().getPriority());
        //修改线程对象优先级
        Thread.currentThread().setPriority(10);
        Thread t = new Thread(new myRunnable4());
        t.start();
        /*try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        for(int i = 0; i < 10000; i++){
            System.out.println("主线程----->" + i);
        }
    }
}
class myRunnable4 implements Runnable{
    public void run(){
        Thread.currentThread().setPriority(1);
        for(int i = 0; i < 10000; i++){
            System.out.println("副线程----->" + i);
        }
    }
}