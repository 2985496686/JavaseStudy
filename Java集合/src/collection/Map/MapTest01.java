package collection.Map;

import java.util.*;

/*
1.Map和Collection没有关系。

2.Map集合以key和value的方式存储(键值对)
  key和value都属于引用数据类型。
  key和value都存储对象的内存地址。
  key起主导的地位，value是key的一个附属品。
3.Map接口中的常用方法：
     V put(K key, V value) ——  将键值对存到Map集合中。

     V get(Object key)  —— 返回key所对应的value。

     void clear() —— 清空Map集合中的元素

     boolean isEmpty()  —— 判断Map集合是否为空

     boolean containsKey(Object key)  —— 判段Map集合中是否包含某个key

     boolean containsValue(Object value)  —— 判断Map集合中是否包含某个value
     contains方法底层都是调用的equals()方法

     V put(K key, V value)  —— 向Map集合中添加键值对。

     V remove(Object key)  —— 通过key来删除某一键值对。

     Collection<V> values()  —— 获取Map中的所有value，以Collection集合的形式返回。

     Set<K> keySet()  —— 获取Map中的所有key，以Set集合的形式返回。

     Set<Map.Entry<K,V>> entrySet() —— 将Map转换为一个Set集合，其中Map.Entry<K,V>是Map类中的一个静态内部类.
                                         Set集合中存的是Map.Entry<K,V>类对象，该对象中有两个属性，K key 和 K value

     例：
     map集合对象m
     key                 value
     -------------------------
     1                    张三
     2                    李四
     3                    王五

     Set s = m.entrySet();

     Set集合对象s
     1=张三
     2=李四
     3=王五

 */
public class MapTest01 {
    public static void main(String[] args) {
        HashMap<Integer,String> m = new HashMap<>();
        m.put(1,"张三");
        m.put(2,"李四");
        m.put(3,"王五");
        String s = m.get(3);
        System.out.println(s);
        Collection<String> c = m.values();
        for(String data: c){
            System.out.print(data + " ");
        }
        System.out.println();
        //遍历Map集合的方式1 —— 通过keySet()方法获得key的集合，通过values()方法获得value()集合
        Set<Integer> s1 = m.keySet();
        Collection<String> c1 = m.values();
        Iterator<Integer> it1 = s1.iterator();
        Iterator<String> it2 = c1.iterator();
        while(it1.hasNext() && it2.hasNext()){
            System.out.println(it1.next() + " " + it2.next());
        }

        //遍历Map集合的方式2
        Set<Map.Entry<Integer,String>> set = m.entrySet();
        Iterator<Map.Entry<Integer,String>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<Integer,String> node = it.next();
            System.out.println(node.getKey() + " " + node.getValue());
        }
    }
}
