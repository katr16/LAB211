package model;

import java.util.ArrayList;

public class ExpenseModel {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private int lastExpenseId = 0;

    public void addExpense(String date, double amount, String content) {
        lastExpenseId++;
        Expense newExpense = new Expense(lastExpenseId, date, amount, content);
        expenses.add(newExpense);
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public boolean removeExpense(int id) {
        return expenses.removeIf(expense -> expense.getId() == id);
    }
}
