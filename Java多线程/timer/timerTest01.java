package timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
定时器作用:
间隔特定时间，执行特定程序

方法一：
使用sleep方法，设置睡眠时间。

方法二：
Java类库中实现了定时器：java.util.Timer
public class Timer extends Object

调用以下方法执行相关线程：
void schedule(TimerTask task, Date firstTime, long period)
其中TimerTask类如下：

public abstract class TimerTask
extends Object
implements Runnable

所以，task必须是继承了TimerTask的类，并且是实现了run()方法
 */
public class timerTest01 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = s.parse("2022-05-17 19:25:30");
        //Timer t =  new Timer(true)，相关线程将是一个守护线程
        Timer t =  new Timer();
        //这里TimerTask也可以采用匿名内部类的方式
        myTimerTask m = new myTimerTask();
        t.schedule(m,date,1000*5);
    }
}

//创建一个定时任务的类
class myTimerTask extends TimerTask{
    public void run(){
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(s.format(date) + "执行了定时任务！");
    }
}