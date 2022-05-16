package thread;
/*
获取线程名字：
getName()

修改线程名字：
setName()

默认线程名字：
Thread-0
Thread-1
Thread-2
 */
public class ThreadTest03 {
    public static void main(String[] args) {
        Thread t2 = Thread.currentThread();
        Thread t = new Thread(new Runnable() {
            Thread t2 = Thread.currentThread();
            @Override
            public void run() {
                System.out.println(t2.getName() + "执行");
            }
        });
        t.start();
        System.out.println(t2.getName());
        //System.out.println(t.getName());
    }
}
