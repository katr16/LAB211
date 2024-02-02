package view;

import controller.CalculatorController;
import java.util.Scanner;
import model.CalculatorModel;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView(scanner);
        CalculatorController controller = new CalculatorController(model, view);

        controller.run();
    }
}
