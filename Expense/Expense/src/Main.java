import java.util.Scanner;

import controller.ExpenseController;
import model.ExpenseModel;
import view.ExpenseView;

public class Main {
    public static void main(String[] args) {
        ExpenseModel model = new ExpenseModel();
        ExpenseView view = new ExpenseView();
        Scanner scanner = new Scanner(System.in);
        ExpenseController controller = new ExpenseController(model, view, scanner);
        controller.processUserInput();
        scanner.close();
    }
}
