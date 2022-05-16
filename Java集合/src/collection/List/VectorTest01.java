package collection.List;
/*
Vector集合自动扩容后容量是原先的2倍

Vector底层采用了数组的数据结构，它是线程安全的。
它虽然是线程安全的，但是执行效率较低，现在保
证线程安全有别的方案，所以Vector使用较少。
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorTest01 {
    public static void main(String[] args) {
        //非线程安全转线程安全
        List l = new ArrayList();
        Collections.synchronizedCollection(l);
        //此时的集合l就由非线程安全转换为线程安全的了
    }
}