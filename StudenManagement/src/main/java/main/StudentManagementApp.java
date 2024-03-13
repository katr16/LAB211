package main;

import controller.StudentController;
import java.util.ArrayList;
import java.util.Scanner;
import model.Student;
import view.StudentView;

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController controller = new StudentController();
        StudentView view = new StudentView();

        while (true) {
            view.displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    doCreate(controller, view, scanner);
                    break;
                case 2:
                    doFindSort(controller, view, scanner);
                    break;
                case 3:
                    doUpdateDelete(controller, view, scanner);
                    break;
                case 4:
                    doReport(controller, view);
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void doCreate(StudentController controller, StudentView view, Scanner scanner) {
        do {
            view.displayCreateStudentPrompt();
            System.out.print("Student Name: ");
            String studentName = scanner.nextLine();

            System.out.print("Semester: ");
            int semester = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Course Name (Java, .Net, C/C++): ");
            String courseName = scanner.nextLine();

            controller.createStudent(studentName, semester, courseName);

            view.displayContinueCreationPrompt();
        } while (scanner.nextLine().equalsIgnoreCase("Y"));
    }

    private static void doFindSort(StudentController controller, StudentView view, Scanner scanner) {
        view.displayFindSortPrompt();
        String searchTerm = scanner.nextLine();
        ArrayList<Student> result = controller.findAndSortStudents(searchTerm);

        for (Student student : result) {
            System.out.println(
                    "Student Name: " + student.getStudentName() + ", Semester: " + student.getSemester() + ", Course: "
                            + student.getCourseName());
        }
    }

    private static void doUpdateDelete(StudentController controller, StudentView view, Scanner scanner) {
        view.displayUpdateDeletePrompt();
        int idToUpdateOrDelete = scanner.nextInt();
        scanner.nextLine(); 

        Student studentToUpdateOrDelete = controller.findStudentById(idToUpdateOrDelete);

        if (studentToUpdateOrDelete == null) {
            System.out.println("Student not found with ID: " + idToUpdateOrDelete);
            return;
        }

        view.displayUpdateDeleteOptions();
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("U")) {
            System.out.print("Enter new Student Name: ");
            String newStudentName = scanner.nextLine();

            System.out.print("Enter new Semester: ");
            int newSemester = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter new Course Name (Java, .Net, C/C++): ");
            String newCourseName = scanner.nextLine();

            controller.updateStudent(studentToUpdateOrDelete, newStudentName, newSemester, newCourseName);
        } else if (choice.equalsIgnoreCase("D")) {
            controller.deleteStudent(studentToUpdateOrDelete);
        } else {
            System.out.println("Invalid option. No changes made.");
        }
    }

    private static void doReport(StudentController controller, StudentView view) {
        ArrayList<Student> reportData = controller.getStudents();
        view.displayReport(reportData);
    }
}