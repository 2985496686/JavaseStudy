package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest01 {
    public static void main(String[] args) {
        //创建集合
        Collection c = new ArrayList();
        //添加元素
        c.add(100);
        c.add("1234");
        c.add(1.234);
        c.add('w');
        //创建迭代器对象
        Iterator it = c.iterator();
        /*
        迭代器对象中的方法：
              boolean hasNext()  —— 判断集合中是否还有可迭代元素，如果有返回true
              E next()  —— 将集合迭代的下一个元素返回，不使用“泛型”时，均返回Object类引用,但是对象类型不会改变。
         */
        /*
        while(it.hasNext()){
            System.out.println(it.next());
        }
        */
        Collection c2 = new HashSet();
        c2.add(1);
        c2.add(1);
        c2.add(1);
        //System.out.println(c2.size());
        c2.add(2);
        c2.add(3);
        c2.add(4);
        c2.add(5);
        c2.add(6);
        c2.add(7);

        c2.add(9);
        c2.add(10);

        c2.add(13);
        c2.add(2);
        c2.add(3);
        c2.add(4);
        c2.add(5);
        Iterator it2 = c2.iterator();
        //System.out.println(c2.size());
       /*while(it2.hasNext()){
            System.out.println(it2.next());
        }*/
       for(Object i : c2){
           System.out.println(i);
       }



    }
}
