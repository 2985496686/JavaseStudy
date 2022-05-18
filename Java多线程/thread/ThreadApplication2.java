package thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ThreadApplication2 {
    public static void main(String[] args){
        Timer timer1 = new Timer();
        Timer timer2 = new Timer();
        ArrayList<String> list = new ArrayList<>();
        ConsumerTimerTask c = new ConsumerTimerTask(list);
        ProcuderTimerTask p = new ProcuderTimerTask(list);
        timer1.schedule(c, new Date(),1000);
        timer2.schedule(p, new Date(), 500);
    }

}
class ConsumerTimerTask extends TimerTask {
    ArrayList<String> list = new ArrayList<>();
    public ConsumerTimerTask(ArrayList<String> list){
        this.list = list;
    }
    public void run(){
        synchronized (list){
                if(list.isEmpty()){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "消费了" + list.remove(0));
                list.notify();
        }
    }
}

class ProcuderTimerTask extends TimerTask{
    static int i = 1;
    ArrayList<String> list = new ArrayList<>();
    public ProcuderTimerTask(ArrayList<String> list){
        this.list = list;
    }
    public void run(){
        synchronized (list){
                if(list.size() == 10){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add("产品" + i);
                System.out.println(Thread.currentThread().getName() + "生产了产品" + i++);
                list.notify();
        }
    }
}
