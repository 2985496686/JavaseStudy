/*
public static void sleep(long millis)
               throws InterruptedException

 让当前线程休眠指定时间，参数是以毫秒每单位
 */
package thread;
public class ThreadTest05 {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() +"----->" +i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
