package view;
import java.util.List;
import model.Student;

public class StudentView {
    public void displayStudents(List<Student> students) {
        System.out.println("Student Information:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Class: " + student.getClasses() + ", Mark: " + student.getMark());
        }
    }
}
