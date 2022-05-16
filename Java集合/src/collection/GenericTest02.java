package collection;
/*
Java支持自定义泛型

自定义泛型时，首先在类名后面加 <标识符> ，标识符可以自己随便写，
在自定义泛型的这个类中，可以用该标识符表示某一特定的类型，但是该
特定的类并不在定义泛型时确定，而是在使用泛型时确定。
 */

class B<T>{
    public T doSome(T o){
        System.out.println("doSome!!!");
        return o;
    }
}
public class GenericTest02 {
    public static void main(String[] args) {
        B<Character> b = new B<>();
        b.doSome('d');
    }
}
