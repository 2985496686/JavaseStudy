package thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadApplication {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        ConsumerThread consumer = new ConsumerThread(list);
        ProcuderThread procuder = new ProcuderThread(list);
        consumer.setName("消费者");
        procuder.setName("生产者");
        consumer.start();
        procuder.start();
    }
}
//消费者线程
class ConsumerThread extends Thread{
    List<String> list = new ArrayList<>();
    public ConsumerThread(List<String> list){
        this.list = list;
    }
    public void run(){
        while(true){
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
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
//生产者线程
class ProcuderThread extends Thread{
    int i = 1;
    List<String> list = new ArrayList<>();
    public ProcuderThread(List<String> list){
        this.list = list;
    }
    public void run(){
        while(true){
            synchronized (list){
                if(list.size() == 10){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add("产品" + i);
                System.out.println(Thread.currentThread().getName() + "生产了" + list.get(list.size() - 1));
                i++;
                list.notify();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
