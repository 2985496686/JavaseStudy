package collection;

import java.util.ArrayList;
import java.util.Collection;
/*
Collection 中常用方法
     boolean add(E e) —— 在使用“泛型”之前，可以添加任何类型(Object)元素，使用“泛型”之后，只能添加某个具体类型类。
     void clear()  —— 清空集合
     boolean contains(Object o)  —— 判断集合中是否包含o，如果包含返回true
     boolean isEmpty()  —— 判断集合是否为空，为空返回true
     boolean remove(Object o)  —— 删除集合中的元素o，删除成功返回true。
     Object[] toArray()  —— 返回一个包含该集合所有元素的数组
 */
public class CollectionTest01 {
    public static void main(String[] args) {
        //多态
        ArrayList c = new ArrayList();
        c.add(1);
        c.add(1);
        System.out.println(c.size());
        System.out.println(c.contains(1));
        c.remove(1);
        c.remove(1);
        System.out.println(c.isEmpty());
        c.clear();
        System.out.println(c.isEmpty());
        System.out.println(c.remove(100));
    }
}
