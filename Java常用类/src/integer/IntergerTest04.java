package integer;
//int    String    Integer   之间的类型转换
public class IntergerTest04 {
    public static void main(String[] args) {

        // int --> String
        //数字后面加一个空字符串
        int i = 100;
        String j = 100 + "";
        System.out.println(j + 1);//编译结果：1001


        //String --> int
        //使用静态方法 Integer.parseInt()
        String x = "1234";
        int y = Integer.parseInt(x);
        System.out.println(y + 1);//编译结果：1235

        //int --> Integer
        //自动装箱
        Integer m = 100;
        //手动装箱
        Integer m2 = Integer.valueOf(100);
        //手动装箱(已过时)
        Integer m3 = new Integer(100);

        //Integer --> int
        //自动拆箱
        int n = m;
        //手动拆箱
        int n2 = m.intValue();

        //String --> Integer
        Integer p = Integer.valueOf("1234");

        //Integer --> String
        String q = String.valueOf(m);
    }
}
