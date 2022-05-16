/*
1. TreeSet底层是TreeMap，放进TreeSet中的元素相当于将元素放进了TreeMap的key部分。

2. TreeSet集合元素特点：无序不可重复，但是可以将元素自动排序。

3.对于自定义的类型，TreeSet并不能直接排序，所以无法正常的放入TreeSet集合。
  要想将自定义类型放入TreeSet集合中，需要让该类实现Comparable接口，并且实现
  该接口中的compareTo方法(在该方法中指定比较规则)。(Sting、包装类都已经实现了该接口)

4.除了让自己写的类实现Comparable接口外，还可以在创建TreeSet集合时传一个比较器对象()的方式。
  比较器可以在外部实现，也可以采用匿名内部类的方式。

5.两种方式如何选择？
  若比较规则不会发生改变，就选择实现Comparable接口，例：String类和Integer类都实现了Comparable接口。
  若比较方式会发生改变，那么就建议采用比较器的方式，
 */
package collection.List;

import java.util.Comparator;
import java.util.TreeSet;

class Student implements Comparable<Student>{
    int age;
    public Student(){

    }
    public Student(int age){
        this.age = age;
    }
    public int compareTo(Student s){
        /*
        升序排序
        this.age > s.age 返回大于0的数
        this.age = s.age 返回0
        this.age < s.age 返回小于0的数
         */
        return age - s.age;
    }
}
public class TreeSetTest01 {
    public static void main(String[] args) {
        TreeSet t = new TreeSet(new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });
        Student s1 = new Student(13);
        Student s2 = new Student(12);
        Student s3 = new Student(15);
        Student s4 = new Student(11);
        t.add(s1);
        t.add(s2);
        t.add(s3);
        t.add(s4);
        for(Object s :t) {
            Student stu = (Student) s;
            System.out.println(stu.age);
        }
}
}
class Studentcomparator implements Comparator<Student>{
    public int compare(Student o1, Student o2){
        return  o1.age - o2.age;
    }
}