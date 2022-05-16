package number;

import java.math.BigDecimal;

//BidDecimal 属于大数据，精度极高，不属于基本数据类型，是引用数据类型，用于财务软件当中
public class BigDecimalTest01 {

    public static void main(String[] args) {
        //这里的100是精度极高的100
        BigDecimal b = new BigDecimal(100);
        BigDecimal c = new BigDecimal(1.0/3);
       //两数相加，不能直接用 "+"
        BigDecimal e = b.add(c);
        System.out.println(e);


        //两数相乘
        BigDecimal g = b.multiply(c);
        System.out.println(g);


    }
}
