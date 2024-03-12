package view;
import java.util.ArrayList;
import java.util.Scanner;
import model.Task;

public class TaskView {
    public Scanner scanner;

    public TaskView() {
        scanner = new Scanner(System.in);
    }

    public void printTaskList(ArrayList<Task> taskList) {
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task task : taskList) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15s%-15s%-15s\n",
                    task.getId(),
                    task.getRequirementName(),
                    task.getTaskTypeId(),
                    task.getDate(),
                    Double.parseDouble(task.getPlanTo()) - Double.parseDouble(task.getPlanFrom()),
                    task.getAssign(),
                    task.getReviewer()
            );
        }
    }

    public Task readTaskInput(int id) {
        System.out.print("Enter Requirement Name: ");
        String requirementName = scanner.nextLine().trim();
        System.out.print("Enter Task Type: ");
        String taskTypeId = scanner.nextLine().trim();
        System.out.print("Enter Date (dd-MM-yyyy): ");
        String date = scanner.nextLine().trim();
        System.out.print("Enter From: ");
        String planFrom = scanner.nextLine().trim();
        System.out.print("Enter To: ");
        String planTo = scanner.nextLine().trim();
        System.out.print("Enter Assignee: ");
        String assign = scanner.nextLine().trim();
        System.out.print("Enter Reviewer: ");
        String reviewer = scanner.nextLine().trim();
        
        return new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer);
    }

    public int readUserChoice() {
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        return choice;
    }
}