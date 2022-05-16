package threadSafe;
/*
用法一:
synchronized(共享对象){
    //同步代码
}
以上代码会让程序进入锁池寻找对象的锁，一个对象对应一把特定的锁

//用法二
synchronized 加在实例方法上，锁的是this，并且同步的整个方法体，相当于
synchronized(this){
    //同步方法
}


//用法三：
synchronized 加在静态方法上，找的是类锁，一个类无论new几个对象都只有一个类锁


静态变量和实例变量存在线程安全问题
常量,局部变量不存在线程安全问题
 */
public class Account {
    //账号
    private String actno;
    //余额
    private int banlance;

    //构造器
    public Account() {
    }

    public Account(String actno, int banlance) {
        this.actno = actno;
        this.banlance = banlance;
    }

    //setter and getter
    public void setBanlance(int banlance) {
        this.banlance = banlance;
    }

    public int getBanlance() {
        return banlance;
    }

    public void takeOut(Account act, int takeOut){
        //synchronized (this){  所有传相同Account对象的myThread对象都同步
        //synchronized (new Object()){  所有myThread对象都不同步
        synchronized ("123"){     //所有myThread对象都同步，因为字符串对象在字符串常量池中，是唯一的

            int newBanlance = act.getBanlance() - takeOut;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            act.setBanlance(newBanlance);
            System.out.println( Thread.currentThread().getName() + "取出：" + takeOut + "   剩余：" + newBanlance);
        }
    }
}
class myTheard extends Thread{
    Account act;
    int takeOut;
    public myTheard(){
    }
    public myTheard(Account act, int takeOut){
        this.act = act;
        this.takeOut = takeOut;
    }
    public void run(){
        act.takeOut(act,takeOut);
    }
}
class Test{
    public static void main(String[] args) {
        Account act = new Account("Joken",10000);
        //去五次钱，每次取五千
        Thread t1 = new myTheard(act,5000);
        Thread t2 = new myTheard(act,5000);
        t1.start();
        t2.start();
    }
}