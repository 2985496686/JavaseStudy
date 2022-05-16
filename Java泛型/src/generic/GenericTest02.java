package generic;

public class GenericTest02<T,K> {
    private T k1;
    private K k2;

    public void add(T k1, K k2){
        this.k1 = k1;
        this.k2 = k2;
    }
    public T getk1(){
        return k1;
    }
    public K getk2(){
        return k2;
    }

    public static void main(String[] args) {
        GenericTest02<Integer,Character> g = new GenericTest02<>();
    }
}
