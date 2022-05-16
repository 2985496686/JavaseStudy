package thread;
//创建线程第二种方式：编写一个实现了Runnable接口的类(该类不是线程类)，创建Thread对象时传一个该类的对象。
//该类较常用，因为Java程序要面向接口编程，实现了接口的类还可以继承其他类，而继承了类的类，不能在继承其他类
public class ThreadTest02 {
    public static void main(String[] args) {
        /*Thread t = new Thread(new MyRunable());
        t.start();
        }*/
        //采用匿名内部类
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++){
                    System.out.println("分支线程->" + i);
                }
            }
        });
        t.start();
        for(int i = 0; i < 1000; i++){
            System.out.println("主线程->" + i);
        }
    }
}
class MyRunable implements Runnable{
    public void run(){
        for(int i = 0; i < 1000; i++){
            System.out.println("分支线程->" + i);
        }
    }
}
