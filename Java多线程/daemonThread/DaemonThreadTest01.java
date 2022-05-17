package daemonThread;
/*
Java中线程分为两大类：守护线程和用户线程

垃圾回收机制就是一个守护线程，main方法是一个用户线程

守护线程的特点：一般守护线程是一个死循环，所有用户线程一旦结束，守护线程自动结束

 d.setDaemon(true) 将线程d设置为守护线程，该方法需要出现在线程开始的前面
 */
public class DaemonThreadTest01 {
    public static void main(String[] args) {
        DaemonThread d = new DaemonThread();
        d.setName("DaemonThread");
        /*
        d.setDaemon(true) 将线程d设置为守护线程，该方法需要出现在线程开始的前面
         */
        d.setDaemon(true);
        d.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main----->正在执行" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DaemonThread extends Thread{
    public void run(){
        int i = 0;
        while(true){
            System.out.println(Thread.currentThread().getName() + "----->正在执行" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
