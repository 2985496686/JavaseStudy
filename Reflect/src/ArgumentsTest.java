/*
可变长参数
int. .. args 这就是可变长度参数
语法是:类型...（注意:一定是3个点。)
1、可变长度参数要求的参数个数是:0 ~ N个。
2、可变长度参数在参数列表中必须在最后一个位置上，而且可变长度参数只能有1个。
3、可变长度参数可以当做一个数组来看待
 */
public class ArgumentsTest {
    public static void doSome1(int ...args){
        System.out.println("doSome1 执行！");
    }
    public static void doSome2(String...args){
        System.out.println("doSome2 执行！");
    }
    public static void doSome3(int[] ... args){
        System.out.println("doSome3 执行！");
    }
    public static void main(String[] args) {
        doSome1(1,2,3,2,2,1,1,2);
        doSome3(new int[]{1,2,3},new int[]{4,5,6});
    }
}
