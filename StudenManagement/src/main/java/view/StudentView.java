package view;

import java.util.ArrayList;
import java.util.Collections;
import model.Student;

public class StudentView {

    public void displayMainMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.print("Please choose an option (1-5): ");
    }

    public void displayCreateStudentPrompt() {
        System.out.println("Enter student information:");
    }

    public void displayContinueCreationPrompt() {
        System.out.print("Do you want to continue creating students? (Y/N): ");
    }

    public void displayFindSortPrompt() {
        System.out.print("Enter student name or a part of student name: ");
    }

    public void displayUpdateDeletePrompt() {
        System.out.print("Enter student ID to update or delete: ");
    }

    public void displayUpdateDeleteOptions() {
        System.out.println("Do you want to update (U) or delete (D) the student?");
    }

    public void displayReport(ArrayList<Student> reportData) {
        System.out.println("Report:");
        for (Student student : reportData) {
            System.out.println(student.getStudentName() + " | " + student.getCourseName() + " | "
                    + Collections.frequency(reportData, student));
        }
    }
}
