package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
实现线程的第三种方式：
  实现Callable接口，传入FutureTask对象，再将FutrueTask对象传入Thread
  这种方式不同于其它两种方式的是可以得到线程的返回值
  Callable中的call()方法相当于run()方法
  该线程的返回值通过：FutureTask对象.get()的方式得到

  缺点：在该线程开始后，主线程进入阻塞状态，直到获得了该线程的返回值。
 */
public class ThreadTest09 {
    public static void main(String[] args) {
        FutureTask f = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Call----->start");
                Thread.sleep(1000*5);
                System.out.println("Call----->end");
                return 1000;
            }
        });
        Thread t = new Thread(f);
        t.start();
        try {
            System.out.println("执行结果为：" + f.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
