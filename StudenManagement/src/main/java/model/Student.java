package model;

public class Student {

    private static int idCounter = 1;
    private int id;
    public String studentName;
    public int semester;
    public String courseName;

    public Student(String studentName, int semester, String courseName) {
        this.id = idCounter++;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }
}
