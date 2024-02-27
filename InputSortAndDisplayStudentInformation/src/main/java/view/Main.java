package view;
import controller.StudentController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Student;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        StudentController controller = new StudentController();
        StudentView view = new StudentView();

        boolean moreStudents = true;

        while (moreStudents) {
            System.out.println("Enter student information (Name, Class, Mark):");
            String name, classes;
            float mark = 0;
            boolean validMark;
            do {
                System.out.print("Name: ");
                name = scanner.nextLine();
                System.out.print("Class: ");
                classes = scanner.nextLine();
                System.out.print("Mark: ");
                String markStr = scanner.nextLine();
                try {
                    mark = Float.parseFloat(markStr);
                    validMark = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid mark. Please enter a valid number.");
                    validMark = false;
                }
            } while (!validMark);

            Student student = new Student(name, mark, classes);
            students.add(student);

            System.out.print("Do you want to enter more student information? (Y/N): ");
            String response = scanner.nextLine();
            moreStudents = response.equalsIgnoreCase("Y");
        }

        students = controller.sortStudents(students);

        view.displayStudents(students);
    }
}
