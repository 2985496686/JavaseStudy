package collection.List;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkListTest01 {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addFirst("a");
        l.add("b");
        l.add("c");
        l.add("d");
        //遍历List集合的三种方法
        Iterator it = l.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for(int  i = 0; i < l.size(); i++){
            System.out.println(l.get(i));
        }

        for(Object i : l){
            System.out.println(i);
        }


    }
}
