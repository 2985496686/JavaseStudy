package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest03 {

    public static void main(String[] args) {
        //用来格式化日期的对象
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        //Date的构造方法
        Date d = new Date(1);
        System.out.println(s.format(d));
        //编译结果：1970-01-01 08:00:00 001
        //解释：格林威治标准时间为 1970-01-01 00:00:00 000，但是北京位于东八区，时间要快八个小时
        //      Date的构造方法就是，初始化date时间为1970-01-01 08:00:00 000再加上d毫秒的时间

        //计算昨天的这个点的时间
        Date d2 = new Date(System.currentTimeMillis() - 1000*60*60*24);
        System.out.println(s.format(d2));
    }
}
