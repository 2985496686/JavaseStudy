
/*
public static Thread currentThread()返回当前正在执行的线程对象的引用。
 */
package thread;

public class ThreadTest04 {
    public static void main(String[] args) {
        myThread2 t  = new myThread2();
        t.start();
    }
}
class myThread2 extends Thread{
    public myThread2(){
        System.out.println("构造方法测试：");
        System.out.println("Thread.currentThread().getName():" + Thread.currentThread().getName());
        System.out.println("this.getName:" + this.getName());
    }
    public void run(){
        System.out.println("Run方法执行测试：");
        System.out.println("Thread.currentThread().getName():" + Thread.currentThread().getName());
        System.out.println("this.getName:" + this.getName());
    }
}
