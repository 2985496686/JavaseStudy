public class StringTest01 {
    //这两行代码表示创建3个字符串对象，且都在字符串常量池中
    String A = "abc";
    String B = "abc" + "de";
    //通过 new 来创建字符串对象,会先在字符串常量池中寻找"abc"
    //找不到的话就会在字符串常量池中创建一个"abc"对象
    //在堆中创建创建字符串对象，并且保存"abc"在字符串常量池中的地址
    String C = new String("abc");

    public static void main(String[] args) {
        //没有在堆中创建对象
        //s1与s2都存的是"hello"在字符串常量池中的地址
        String s1 = "hello";
        String s2 = "hello";
        //在堆中创建了对象
        //m,n分别存的是他们在堆中对象的地址
        String m = new String("你好！");
        String n = new String("你好！");
        System.out.println(s1 == s2);//结果为true
        System.out.println(m == n);//结果为false
    }
}
