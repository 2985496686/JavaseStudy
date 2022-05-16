package integer;
//Integer中的方法
public class IntegerTest03 {
    public static void main(String[] args) {

        // 静态方法 static int parseInt(String s)
        //将s转换为int型数字
        int i = Integer.parseInt("123");
        System.out.println(i);//编译结果为123
        //如果传入该方法的参数不是数字字符串，编译器就会报错
        //int j = Integer.parseInt("中文");报错：java.lang.NumberFormatException
        //同理，在其他包装类中也存在类似方法 ：Double.parseDouble , Float.parseFloat ......

        //静态方法  static String toBinaryString(int i)
        //将i转换为二进制字符串
        System.out.println(Integer.toBinaryString(5));//编译结果：101
        //同理还存在以下方法:
        //static String toHexString(int i)//将i转换为16进制字符串
        //static String toOctalString(int i)//将i转换为8进制字符串

        //实例方法  String toString()
        //该方法已经被重写，字符串的形式返回包装类数据
        Integer x = 1000;
        System.out.println(x.toString() + 1);//编译结果为10001

        //实例方法  boolean equals(Object obj)
        //判断两个包装类对象是否一样，并非对象地址
        Integer y = 1000;
        System.out.println(x.equals(y));//编译结果为：true
    }

}
