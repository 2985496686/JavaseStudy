
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LambadExpression {
    public static void main(String[] args) {

        //无参数，无返回值
        Thread t = new Thread(()-> System.out.println("lambad!"));
        Thread t2 = new Thread(new myRunnable());
        Thread t3 = new Thread(()-> S);
        String[] list = {"qw","eee","qe","eeqeeddx","x"};

        //有参数有返回值，因为这里可以推断出参数类型，所以参数类型省略
        //Arrays.sort(list,(a,b)-> {return a.length() - b.length();});
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for(String data:list){
            System.out.print(data + " ");
        }
    }
}
class myRunnable implements Runnable{
    public void run(){
        System.out.println("传统方法的Runnable！");
    }
}