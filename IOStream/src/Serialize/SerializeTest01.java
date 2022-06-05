package Serialize;

import java.io.Serializable;

/*
Serialize -----  序列化，将Java对象拆分，有序存储到文件中，对应ObjectOutputStream
DeSerialize ----- 反序列化，将文件中被拆分的Java对象组装，重新恢复到内存当中，恢复成Java对象，对应ObjectInputStream

注意：1.参与序列化的对象，必须实现了Serializable接口。
      2.Serializable接口中没有一个抽象方法，它是一个标志性接口，这个标志是给Java虚拟机参考的。
      3.一个文件只能序列化存储一个对象，要想序列化多个对象需要拿List集合，List集合是实现了Serializable接口的。
      4.想让实现了Serializable接口的类部分属性不参与序列化，可以用修饰符transient,表示游离的。
 */
public class SerializeTest01 {
    public static void main(String[] args) {
        System.out.println("这里是笔记！！！");
    }
}
