package controller;
import java.io.IOException;
import java.util.ArrayList;
import model.Task;
import view.TaskView;

public class TaskController {
    private TaskView view;
    private ArrayList<Task> model;
    private int taskIdCounter;

    public TaskController(TaskView view, ArrayList<Task> model) {
        this.view = view;
        this.model = model;
        taskIdCounter = 1; 
    }

    public void start() throws IOException {
        int choice;
        do {
            choice = view.readUserChoice();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    view.printTaskList(model);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void addTask() {
        Task newTask = view.readTaskInput(taskIdCounter);
        model.add(newTask);
        taskIdCounter++;
    }

    private void deleteTask() {
        if (model.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        view.printTaskList(model);
        System.out.print("Enter ID of task to delete: ");
        int idToDelete = Integer.parseInt(view.scanner.nextLine().trim());
        boolean found = false;
        for (Task task : model) {
            if (task.getId() == idToDelete) {
                model.remove(task);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }
}