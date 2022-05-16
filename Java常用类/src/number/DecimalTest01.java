package number;
import java.text.DecimalFormat;

public class DecimalTest01 {
    public static void main(String[] args) {
        /*
        #  代表数字
        ， 代表千分位
        .  代表小数点
        0  代表不够时补0
         */
        //保留三位小数
        DecimalFormat d = new DecimalFormat("###,###.000");
        System.out.println(d.format(1234567.1));
    }
}
