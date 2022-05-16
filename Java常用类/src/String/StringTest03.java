import java.sql.SQLOutput;

public class StringTest03 {
    public static void main(String[] args) {

        //public char charAt(int index)方法
        //返回索引值处的char类型字符
        char s1 = "中国人".charAt(1);
        System.out.println(s1);//国


        //public int compareTo(String anotherString)方法
        //按字典序比较两个字符串
        System.out.println("abc".compareTo("abd"));//负整数
        System.out.println("abc".compareTo("abc"));//0
        System.out.println("abc".compareTo("abb"));//正整数


        //public boolean contains(CharSequence s)方法
        //判断字符串是否包含s
        System.out.println("abcdefg".contains("efg"));//true
        System.out.println("abcdefg".contains("hij"));//false


        //public boolean endsWith(String suffix)方法
        //判断字符串是否以suffix结尾
        System.out.println("abcde".endsWith("cde"));//true
        System.out.println("abcde".endsWith("qwe"));//false


        //public boolean equalsIgnoreCase(String anotherString) 方法
        //判断两个字符串是否相等，忽略大小写
        System.out.println("ABcd".equalsIgnoreCase("abCD"));//true

        //public byte[] getBytes()
        //将字符串转换成byte数组，并返回
        byte [] s2 = "abcdefg".getBytes();
        for (int i = 0; i < s2.length; i++) {
            System.out.print(s2[i] + " ");
        }//97 98 99 100 101 102 103


        //public int indexOf(String str)
        //判断某个子字符串在当前字符串中第一次出现处的索引
        //若子字符串不存在，返回-1
        System.out.println("abcdefghigk".indexOf("hig"));//7
        System.out.println("abc".indexOf("fgh"));//-1

        //public int lastIndexOf(String str)
        //判断某个子字符串最后一次出现在当前字符串中的索引
        System.out.println("abcdhdhdabc".lastIndexOf("abc"));//8


        //public boolean isEmpty()
        //判断字符串是否为空串
        //底层调用length()方法，空串长度为0
        //注意：判断数组长度是length属性，判断字符串长度是length()方法
        System.out.println("".isEmpty());//true


        //public String replace(char oldChar,char newChar)
        //返回一个将原字符串中所有的oldChar替换为newChar的新字符串，不改变原字符串
        String s3 = "aaatttooo";
        System.out.println( s3.replace('t','q'));//aaaqqqooo


        //public String replace(CharSequence target,CharSequence replacement)
        //CharSequence可以看出String
        //将原字符串中的 target 全部换成 replacement
        String s4 = "abcsgdjsssjabcjdjjdjabc";
        System.out.println(s4.replace("abc","www"));//wwwsgdjsssjwwwjdjjdjwww

        //public String[] split(String regex)
        //以regex为分界线，将字符串分割保存在一个字符串数组当中，并返回
        String s5 = "2022-3-19";
        String [] str = s5.split("-");
        System.out.println(str[0] + str[1] + str[2]);//2022319

        //public String substring(int beginIndex)
        //返回一个以索引beginIndex开始直至结尾的字符串
        System.out.println("abcdefgh".substring(4));//efgh

        //public String substring(int beginIndex,int endIndex)
        //返回一个以索引值beginIndex开始，以索引值endIndex结束(不包含该索引值处的字符)的子字符串
        System.out.println("abcdefgh".substring(2,5));//cde

        //public char[] toCharArray()
        //将一个字符串以字符数组的形式返回
        char[] str2 = "abcdefg".toCharArray();
        for(int i = 0 ; i < str2.length ; i++){
            System.out.println(str2[i]);
        }


        //public String toLowerCase()
        //返回一个将原字符串中所有字符变成小写的新字符串
        System.out.println("ABcDeFG".toLowerCase());//abcdefg


        //public String toUpperCase()
        //返回一个将原字符串中所有字符变成大写的新字符串
        System.out.println("aCbcdEfg".toUpperCase());//ABCDEFG


        //public String trim()
        // 返回一个去除字符串的前后空白(空格)的新字符串
        System.out.println("       abcdefg      ".trim());//abcdefg


        //public static String valueOf(参数列表)
        //参数列表可以是int型，char型，int数组，对象 等等.......
        //String类中唯一一个静态方法，可以直接调用
        //将非字符串转换为字符串
        //println()底层调用的就是valueOf()方法,只要是打印在控制台上的都是字符串
        System.out.println(String.valueOf(true));
    }
}
