import java.util.ArrayList;

public class JDBCTest09  {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
    }
}
