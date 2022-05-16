package StringBuffer;

/**
 *思考：
 * 频繁使用字符串拼接会有什么影响？
 * java中字符串是不可变的，每拼接一次都会产生一个新的字符串
 * 字符串是存在字符串常量池中的,频繁使用字符串拼接会占用大量的方法区空间
 */
//java.lang.StringBuffer
public class StringBufferTest {
    public static void main(String[] args) {

        //创建一个初始化容量为16个 byte[] 数组(字符串缓冲区对象)
        StringBuffer strBuffer = new StringBuffer();

        //拼接字符串调用 append()
        //append()再追加时，如果byte[]满了之后会自动扩容
        strBuffer.append(1);
        strBuffer.append('q');
        strBuffer.append(3.14);
        strBuffer.append("abc");
        System.out.println(strBuffer);//1q3.14abc

        //StringBuffer可以进行一定的优化
        //在创建StringBuffer时尽可能可能给定一个合适的初始化容量
        //从而减少底层数组的扩容次数
        //指定初始化容量的字符串缓冲区
        StringBuffer newstrBuffer = new StringBuffer(100);
    }

}
