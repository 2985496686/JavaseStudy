package collection.List;

import java.util.ArrayList;
import java.util.Iterator;

/*
       ArrayList默认初始容量为10

       ArrayList底层是一个Object类型的数组

       ArrayList构造方法可以指定初始化容量

       当ArrayList容量不够时，会自动扩容：
       int newCapacity = oldCapacity + (oldCapacity >> 1);
       扩容后容量是原容量的1.5倍

       数组扩容的效率较低，所以在创建ArrayList时要给定一个合适的初始化容量

       优点：
             数组的检索效率很高
       缺点：
             数组元素随机的增删效率较低(数组末尾的增删除外)，数组扩容效率较低。
             数组存不了大量数据，因为数组在内存中是连续的，很难找到一块很大的连续空间。
             ArrayList是非线程安全的。
 */

/*
ArrayList中特有的常用方法：

void add(int index, E element)  ——   在集合的指定位置插入元素,将当前位置原先的元素以及后面的元素往后移。
                                       若插入元素的位置范围 0 <= index <= size，即最多插在集合的末尾，若插入元素位置
                                       index > size会报错：IndexOutOfBoundsException
E get(int index) —— 返回指定下标位置的元素

int indexOf(Object o) —— 返回该元素在集合中首次出现的下标，若集合中不存在该元素，则返回1

int lastIndexOf(Object o)  —— 返回该元素在集合中最后一次出现的下标，若集合中不存在该元素，则返回1

ArrayList的构造方法

public ArrayList() ——  创建一个初始化容量为 10 的集合。
public ArrayList(int initialCapacity) —— 创建初始化容量大小为 initialCapacity 的集合。
public ArrayList(Collection<? extends E> c) —— 构造一个包含指定集合元素的集合(按照它们由集合的迭代器返回的顺序)。
 */
public class ArrayListTest01 {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add("1");
        a.add("2");
        a.add("4");
        a.add(2,"ssss");
        System.out.println(a.size());
        Iterator it = a.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
