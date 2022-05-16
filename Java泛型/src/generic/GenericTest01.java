package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest01 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("abcd");
        for(String obj : l){
            String s = obj;
            System.out.println(l);
        }
    }
}
