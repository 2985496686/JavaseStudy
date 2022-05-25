package thread;
/*
实现两个线程，交替输出，一个输出偶数，一个输出奇数。
 */
public class HomeWork {
    public static void main(String[] args) {
        Num num = new Num(1);
        Thread t1 = new Thread(new myRunnable5(num));
        Thread t2 = new Thread(new myRunnable6(num));
        t1.start();
        t2.start();
    }
}
class myRunnable5 implements Runnable{
    Num num;
    public myRunnable5(Num i){
        this.num = i;
    }
    public void run(){
        while(true){
            synchronized (num){
                if(num.i % 2 != 0){
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+ "----->" + num.i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num.i++;
                num.notify();
            }
        }
    }
}
class Num{
    int i;
    public Num(int i){
        this.i = i;
    }
}
class myRunnable6 implements Runnable{
    Num num;
    public myRunnable6(Num i){
        this.num = i;
    }
    public void run(){
        while(true){
            synchronized (num){
                if(num.i % 2 == 0){
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "----->"+ num.i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num.i++;
                num.notify();
            }
        }

    }
}
