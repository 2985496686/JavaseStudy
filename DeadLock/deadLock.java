package DeadLock;

public class deadLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        myThread t1 = new myThread(o1,o2);
        myThread2 t2 = new myThread2(o2,o1);
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();
    }
}

class myThread extends Thread{
    Object o1;
    Object o2;
    public myThread(){
    }
    public myThread(Object o1, Object O2){
        this.o1 = o1;
        this.o2 = o2;
    }
    public void run(){
        synchronized (o1){
            System.out.println(Thread.currentThread().getName() + "拿到o1的锁");
            synchronized (o2){
                System.out.println(Thread.currentThread().getName() + "拿到o2的锁");
            }
        }
    }
}

class myThread2 extends Thread{
    Object o1;
    Object o2;
    public myThread2(){
    }
    public myThread2(Object o1, Object O2){
        this.o1 = o1;
        this.o2 = o2;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName() + "拿到o2的锁");
        synchronized (o2){
            synchronized (o1){
                System.out.println(Thread.currentThread().getName() + "拿到o1的锁");
            }
        }
    }
}