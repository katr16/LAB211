package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Student;

public class StudentController {
    private ArrayList<Student> students;

    public StudentController() {
        this.students = new ArrayList<>();
    }

    public void createStudent(String studentName, int semester, String courseName) {
        students.add(new Student(studentName, semester, courseName));
    }

    public ArrayList<Student> findAndSortStudents(String searchTerm) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getStudentName().contains(searchTerm)) {
                result.add(student);
            }
        }
        Collections.sort(result, Comparator.comparing(Student::getStudentName));
        return result;
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(Student student, String newStudentName, int newSemester, String newCourseName) {
        student.studentName = newStudentName;
        student.semester = newSemester;
        student.courseName = newCourseName;
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}