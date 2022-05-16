package generic;

public class GenericTest05<T> {
    private T data;
    public GenericTest05(){
    }
    public GenericTest05(T data){
        this.data = data;
    }
    public void Set(T data){
        this.data = data;
    }
    public T get(){
        return data;
    }
    public static void main(String[] args) {

        //这样不允许
        //GenericTest05<Number> g = new GenericTest05<Integer>();

        //泛型通配符
        GenericTest05<? extends Number> g= new GenericTest05<Integer>(9);

        //get 和 set操作
        //允许get操作，get返回类型会是number
        Number g2 = g.get();
        //不允许set(add)操作，因为编译器无法判断需要什么类型
        //g.set(100);

        //使用了? extends 被称为“生产者”
    }
}
