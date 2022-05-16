/*
1.哈希表是一种将数组和链表两种数据结构融合一起的数据结构，能够充分发挥二者的优点。
2.hashMap底层源代码分析：

public class HashMap{
    //hashMap底层是一个一维数组,数组存的是单向链表
    Node<K,V>[] table;

    //匿名内部类
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;//哈希值(是key的hashCode()方法执行后，通过哈希算法可以将哈希值转换为数组下标)
        final K key;//存储到Map集合中的key
        V value;//存储到Map集合中的value
        Node<K,V> next;//下一个节点的内存地址
    }
}

 3.通过get和put两个方法的实现原理可知，equals()方法是需要重写的，
  同时，如果所有元素的hash值都相同，那么哈希表就变成一个单向链表，
  如果所有元素的hash值都不相同，HashMap就会变成一个一维数组(不考虑哈希碰撞)。
  所以要使哈希表更好的发挥它的性能，需要让哈希表散列分布均匀，所以我们
  需要重写hashCode()方法。

 4.放在HashMap集合中的key部分的元素，和HashSet集合中的元素都需要重写hashCode()和equals()方法。

 5.HashMap默认初始容量为16，默认加载因子为0.75(当底层数组容量占用75%时，数组开始扩容,扩容后容量是原容量的二倍)

 6.源代码中注释：The default initial capacity - MUST be a power of two.
   HashMap自定义初始化容量必须是2的幂，因为这样才能达到散列分布均匀，提高HashMap的存取效率。

 7.HashMap源代码中有这两行代码：  static final int TREEIFY_THRESHOLD = 8;
                           static final int UNTREEIFY_THRESHOLD = 6;
   JDK8之后当HashMap中单链表上的节点个数大于8个时，单向链表的数据结构就会变成红黑树数据结构，
   当红黑树上节点个数小于6个时，又会变成单向链表。
 8.HashMap允许key和value是null。
 */
package collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest01 {
    public static void main(String[] args) {
        HashMap<Integer,String> h = new HashMap<>();
        h.put(1,"张三");
        h.put(1,"刘三");
        h.put(3,"王五");
        System.out.println(h.size());
        Set<Map.Entry<Integer,String>> s = h.entrySet();
        Iterator<Map.Entry<Integer,String>> it = s.iterator();
        while(it.hasNext()){
            Map.Entry<Integer,String> m = it.next();
            System.out.println(m.getKey() + " " + m.getValue());

        }
    }
}
