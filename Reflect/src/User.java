public class User {
    //四个Field对象，分别采用四种不同的访问权限修饰符
    public int no;
    private String name;
    protected  int age;
    boolean sex;
    public User(int no,String name,int age,boolean sex){
        this.no = no;
        this.age = age;
        this.sex = sex;
        this.name = name;
    }
    public User(){

    }
    public static final double MATH_PI = 3.1415926;
    public int getno(){
        return no;
    }
    public void setno(int no){
        this.no = no;
    }
    public int doSome(int i){
        System.out.println("User对象中的doSome方法执行！");
        return i;
    }
}
