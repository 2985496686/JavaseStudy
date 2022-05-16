package StringBuilder;

public class StringBuilderTest01 {

    /*
     *StringBuffer与StringBuilder区别：
     * StringBuffer中的方法都有synchronized关键字修饰，表示StringBuffer在多线程编译环境下是安全的
     * StringBuilder中方法没有synchronized关键字修饰，表示StringBuilder在多线程编译环境下是不安全的
     */
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
    }
}
