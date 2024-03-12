package controller;

import java.util.Scanner;

import model.ExpenseModel;
import view.ExpenseView;

public class ExpenseController {
    private ExpenseModel model;
    private ExpenseView view;
    private Scanner scanner;

    public ExpenseController(ExpenseModel model, ExpenseView view, Scanner scanner) {
        this.model = model;
        this.view = view;
        this.scanner = scanner;
    }

    public void processUserInput() {
        while (true) {
            view.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    displayExpenses();
                    break;
                case 3:
                    removeExpense();
                    break;
                case 4:
                    view.displayMessage("Exiting program.");
                    return;
                default:
                    view.displayMessage("Invalid choice. Please choose again.");
            }
        }
    }

    private void addExpense() {
        String date;
        double amount;
        String content;

        while (true) {
            System.out.print("Enter date (DD-MMM-YYYY): ");
            date = scanner.nextLine();
            if (!isValidDate(date)) {
                view.displayMessage("Invalid date format. Please enter date in the format DD-MMM-YYYY (e.g., 12-01-2023).");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Enter Amount: ");
            amount = scanner.nextDouble();
            scanner.nextLine();
            if (amount <= 0) {
                view.displayMessage("Amount of money must be greater than 0.");
            } else {
                break;
            }
        }

        System.out.print("Enter Content: ");
        content = scanner.nextLine();
        
        model.addExpense(date, amount, content);
        view.displayMessage("Expense added successfully.");
    }

    private boolean isValidDate(String date) {
        return date.matches("\\d{2}-\\d{2}-\\d{4}");
    }

    private void displayExpenses() {
        view.displayExpenses(model.getExpenses());
    }

    private void removeExpense() {
        System.out.print("--------Delete an expense------");
        System.out.print("Enter the ID of the expense to remove: ");
        int idToRemove = scanner.nextInt();
        scanner.nextLine();
        if (model.removeExpense(idToRemove)) {
            view.displayMessage("Expense removed successfully.");
        } else {
            view.displayMessage("Delete an expense fail. Expense with specified ID not found.");
        }
    }
}
