package generic;

public class GenericTest04 {
    public static<T extends Comparable> T getMin(T[] a){
        if(a == null || a.length == 0) return null;
        T smallest = a[0];
        for(int i  = 0; i < a.length; i++){
            if(smallest.compareTo(a[i]) > 0){
                smallest = a[i];
            }
        }
        return smallest;
    }
}
