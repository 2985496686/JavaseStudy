package collection.List;

public class MyLink {
    LinkNode head = null;
    //增加元素
    public void add(Object obj){
        if(head == null){
            head = new LinkNode(obj,null);
        }
        else{
            head.next = new LinkNode(obj,head.next);
        }
    }

    public boolean remove(Object obj){
        if(head.element.equals(obj)) {
            head = head.next;
            return true;
        }
        LinkNode cur = head;
        while(cur.next != null && !cur.next.element.equals(obj)) {
            cur = cur.next;
        }
        if(cur.next == null){
            return false;
        }
        cur.next = cur.next.next;
        return true;
    }


    public boolean Modify(Object obj1,Object obj2){
        LinkNode cur  = head;
        while(cur != null && !cur.element.equals(obj1)){
            cur = cur.next;
        }
        if(cur == null) return false;
        cur.element = obj2;
        return true;
    }

    public Object Find(int x){
        LinkNode cur = head;
        int count  = 1;
        while(cur != null && count != x){
            cur = cur.next;
            count++;
        }
        if(cur == null) return false;
        else return cur.element;
    }
    public void LinkOrder(){
        LinkNode  cur = head;
        while(cur != null){
            System.out.print(cur.element + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLink link = new MyLink();
        link.add("a");
        link.add('b');
        link.add('c');
        link.add('d');
        link.add('e');
        link.add('f');
        link.add('g');
        link.add('h');
        System.out.println(link.Find(3));
        link.LinkOrder();
        link.Modify('h', "hhhhh");
        link.LinkOrder();
        link.remove("a");
        link.remove('b');
        link.LinkOrder();
    }
}
