package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTest01 {
    public static void main(String[] args) throws Exception{
        //在使用Date方法时需要导包
        //获取当前时间
        Date nowDate = new Date();
        //Data的toString方法已经被重写，返回的是一个日期字符串
        System.out.println(nowDate);

        //SimpleDateFormat是java.text包下的一个类，是负责日期格式化的。
        //y 年     M 月    d 日    H 时    m 分     s 秒   S 毫秒
        //在创建SimpleDateFormat对象时，可以用以上字母表示日期格式
        //日期的格式可以随便组织
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(s.format(nowDate));

        //将一个字符串转换成date型
        String myDate = "2003年7月4日";
        //注意下面括号内组织的日期格式必须要和myDate一致
        SimpleDateFormat s2 = new SimpleDateFormat("yyyy年MM月d日");
        Date MyDate = s2.parse(myDate);
        System.out.println(MyDate);
    }
}