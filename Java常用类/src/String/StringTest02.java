//String类构造方法的使用
public class StringTest02 {
    public static void main(String[] args) {
        byte []x1 = { 97 , 98 , 99 };
        char []x2 = {'我','是','中','国','人'};
        //String s = new String(byte数组);
        String y1 = new String(x1);
        System.out.println(y1);
        //String s = new String(byte数组，偏移量，长度)
        String y2  = new String(x1,1,2);
        System.out.println(y2);
        //String s = new String(char数组)
        String y3 = new String(x2);
        System.out.println(y3);
        //String s = new String(char数组，偏移量，长度)
        String y4 = new String(x2,2,3);
        System.out.println(y4);
    }
}
