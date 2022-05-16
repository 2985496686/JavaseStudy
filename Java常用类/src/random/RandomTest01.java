package random;
import java.util.Random;
import java.util.Scanner;
public class RandomTest01 {
    public static void main(String[] args) {
        Random random = new Random();
        //生成int范围内的一个随机数
        int a = random.nextInt();
        System.out.println(a);
        //生成[0,100]之间的随机数
        int b = random.nextInt(101);
        System.out.println(b);
    }
}
