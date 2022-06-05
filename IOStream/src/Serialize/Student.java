package Serialize;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String ID;
    public Student(String name, String ID){
        this.name = name;
        this.ID =  ID;
    }
    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public void setName(String name,String ID) {
        this.name = name;
        this.ID = ID;
    }
    public String toString(){
        return "{" + "name：" + name + " ID:" + ID +" }";
    }
}
