package collection;

import java.util.ArrayList;
import java.util.Objects;

public class ContainsTest01 {
    public static void main(String[] args) {

        ArrayList c = new ArrayList();
        String s1 = "abc";
        c.add(s1);
        String s2 = new String("abc");
        //这里的s1是"abc"在字符串常量池中的地址
        //s2是堆中对象的地址
        System.out.println(c.contains(s2));//true，集合中保存的是对象的内存地址，但是判断包含不包含是比较二者内容。

        //contains()最底层调用的是equals()方法，若添加的对象没有重写equals()方法，那么比较的将会是二者的内存地址。
        A a1 = new A("张三");
        A a2 = new A("张三");
        c.add(a1);
        System.out.println(c.contains(a2));
    }
}
class A{
        String name;
        public  A(){

        }
        public A(String name){
            this.name = name;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return Objects.equals(name, a.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
