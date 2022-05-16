package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
泛型机制
List<String> myList = new ArrayList<String>();
以上代码就是一个泛型，表示集合中元素只能存String类型，存其他类型会报错。

迭代器也有泛型机制
Iterator<String> it = myList.iterator();
以上获取迭代器时使用泛型之后，通过迭代器获得的元素都会强制转换为String类型
 */
public class GenericTest01 {
    public static void main(String[] args) {
        //List<String> myList = new ArrayList<String>();
        List myList = new ArrayList();
        myList.add(4);
        myList.add(5);
        Iterator<String> it = myList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
