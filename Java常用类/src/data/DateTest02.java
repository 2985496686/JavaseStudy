package data;

public class DateTest02 {
    public static void main(String[] args) {
        //获取自1970年1月1日 00：00：00到当前系统的总毫秒数。
        long s = System.currentTimeMillis();
        System.out.println(s);

        //计算一个方法运行需要耗费的时间
        long start = System.currentTimeMillis();
        print();
        long end = System.currentTimeMillis();
        System.out.println("打印耗费时间:" + (end - start));
    }
    public static void print(){
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
    }
}
