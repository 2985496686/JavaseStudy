package integer;

/*
java中提供了基本数据类型对应的八种包装类型

      基本数据类型                   包装类型                  父类型
      -----------------------------------------------------------------------
      byte                            java.lang.Byte             Number
      short                           java.lang.Short            Number
      int                             java.lang.Integer          Number
      long                            java.lang.Long             Number
      float                           java.lang.Float            Number
      double                          java.lang.Double           Number
      boolean                         java.lang.Boolean          Object
      char                            java.lang.Character        Object
 */

public class IntegerTest01 {

    public static void dosome(Object obj){
        System.out.println(obj);
    }
    public static void main(String[] args) {
        //当dosome方法需要传入一个int类型数据时,但是dosome方法的参数是Object类型。
        // 所以我们需要对int类型数据进行包装
        //这里的MyInt是自己模拟实现的一个包装类
        MyInt a = new MyInt(100);
        dosome(a);

        //基本数据类型转换为引用数据类型  装箱
        Integer b = new Integer(100);

        //引用数据类型转换为基本数据类型  拆箱
        int i = b.intValue();
        System.out.println("int最大值：" + Integer.MAX_VALUE);
        System.out.println("int最小值：" + Integer.MIN_VALUE);
        System.out.println("byte最大值：" + Byte.MAX_VALUE);
    }
}

