package collection;

import java.util.ArrayList;
import java.util.Collection;

public class RemoveTest01 {
    public static void main(String[] args) {
        ArrayList c = new ArrayList();
        String s1 = new String("abc");
        String s2 = new String("abc");
        c.add(s1);
        c.add(s1);
        //底层任然调用的是equals()
        c.remove(s2);
        System.out.println(c.size());//0
    }
}
