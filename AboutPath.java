/*
这里演示获取一个文件的绝对路径方法，注意这里的文件必须是在当前类路径下的（src下的都是类路径）
若当前文件不是类路径下的，会报NullPointerException

解释：
Thread.currentThread() ----- 获取当前线程对象
getContextClassLoader() ----- 是线程对象的方法，可以获取到当前线程的类加载器对象
getResource("classinfo.properties") ----- 这是类加载对象的方法，当前线程的类加载器默认从类的根路径下加载资源
注意：这里的路径是相对路径，从src出发开始写(不写src)
 */
public class AboutPath {
    public static void main(String[] args) {
        String path = Thread.currentThread().getContextClassLoader().getResource("classinfo.properties ").getPath();
        System.out.println(path);
        String path2 = Thread.currentThread().getContextClassLoader().getResource("text\\Test.class").getPath();
        System.out.println(path2);
    }
}
