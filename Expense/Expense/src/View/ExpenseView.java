package view;

import java.util.ArrayList;
import model.Expense;

public class ExpenseView {
    public void displayMenu() {
        System.out.println("\n=======Handy Expense program======");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Remove an expense");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }

    public void displayExpenses(ArrayList<Expense> expenses) {
        System.out.println("\n---------Display all expenses------------");
        System.out.println("\nID\tDate\t\tAmount\t\tContent");
        for (Expense expense : expenses) {
            System.out.println(expense.getId() + "\t" + expense.getDate() + "\t" + expense.getAmount() + "\t\t" + expense.getContent());
        }
        double total = expenses.stream().mapToDouble(Expense::getAmount).sum();
        System.out.println("Total: " + total);
    }

    public void displayMessage(String message) {
        System.err.println(message);
    }
}
