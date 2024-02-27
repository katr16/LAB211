package controller;
import java.util.Collections;
import java.util.List;
import model.Student;
import model.StudentComparator;

public class StudentController {
    public List<Student> sortStudents(List<Student> students) {
        Collections.sort(students, new StudentComparator());
        return students;
    }
}
