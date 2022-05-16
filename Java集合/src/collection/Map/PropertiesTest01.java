/*
1.Properties是一个Map集合，继承Hashtable；Properties集合的key和value都是String类型。

2.Properties对象被称为属性类对象。

3.Properties是线程安全的。

4.Properties中的常用方法

Object setProperty(String key, String value)  —— 将该键值对存入Properties集合中

String getProperty(String key)  —— 返回key对应的value
 */
package collection.Map;

import java.util.Properties;

public class PropertiesTest01 {
    Properties pro = new Properties();

}
