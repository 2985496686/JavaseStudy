package generic;

public  class GenericTest03<K> {
    public<T> T getMid(T name[]){
        return name[name.length / 2];
    }

    public static void main(String[] args) {
        GenericTest03<Integer> g = new GenericTest03();
        String [] s = {"张三","李四","王五"};
        String mid = g.<String>getMid(s);
        System.out.println(mid);
    }
}

