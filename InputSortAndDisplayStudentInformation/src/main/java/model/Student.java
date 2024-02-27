package model;
public class Student {
    private String name;
    private float mark;
    private String classes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public float getMark() {
        return mark;
    }

    public String getClasses() {
        return classes;
    }

   

    public Student(String name, float mark, String classes) {
        this.name = name;
        this.mark = mark;
        this.classes = classes;
    }
}
