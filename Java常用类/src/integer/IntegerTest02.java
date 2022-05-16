package integer;
//自JDK1.5之后，支持自动装箱和自动拆箱
public class IntegerTest02 {
    public static void main(String[] args) {
        //自动装箱
        //基本数据类型 => 引用数据类型
        Integer x = 100;

        //自动拆箱
        //引用数据类型 => 基本数据类型
        int y = x;

        //包装类型在做运算时自动转换为基本数据类型
        //System.out.println(x + 1);//x会自动转换为基本数据类型，编译结果:101

        Integer a = 1000;//等价于 Integer a = new Integer(1000)，都会在堆区创建对象。
        Integer b = 1000;//等价于 Integer b = new Integer(1000)，都会在堆区创建对象。
        //a,b是他们分别在堆区创建的对象的地址
        System.out.println(a == b);//编译结果false

        /*
        Java中为了提高程序的执行效率，将 -128 到 127 之间的所有的包装对象提前创建好，
        放到了方法区的"整数型常量池"当中，在使用这个区间的数据时，不需要再new对象了，
        可以直接从池子中取出来.
        当程序中使用到了Integer，程序在类加载时会在整数型常量池中自动创建 -128 到 127
        之间的包装类对象(注意与字符串常量池的区别，字符串常量池只会在使用字符串时创建
        对象，并且没有范围限制)
         */
        Integer c = 100;//不等价于 Integer a = new Integer(1000);
        Integer d = 100;//不等价于 Integer a = new Integer(1000);
        //100的包装类型已经在方法区中创建对象，不需要在堆区中创建对象，而通过new的方式，仍然会在堆区创建对象
        //c和d都是方法区中的内存地址
        System.out.println(c == d);//编译结果为true;
    }
}
