package controller;

import java.util.Scanner;
import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            view.displayMenu();
            int choice = view.getInputChoice();

            switch (choice) {
                case 1:
                    normalCalculator();
                    break;
                case 2:
                    BMICalculator();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

       private void normalCalculator() {
        double memory = model.getMemory();
        String operator;

        System.out.println("----- Normal Calculator -----");

        do {
            double operand = view.getInputDouble("Enter number: ");
            System.out.print("Enter Operator: ");
            
            operator = view.getInputOperator();

            if (operator.equals("=")) {
                view.displayResult(memory);
                break;
            }

            switch (operator) {
                case "+":
                    memory += operand;
                    break;
                case "-":
                    memory -= operand;
                    break;
                case "*":
                    memory *= operand;
                    break;
                case "/":
                    memory /= operand;
                    break;
                case "^":
                    memory = Math.pow(memory, operand);
                    break;
                default:
                    System.out.println("Invalid operator. Please try again.");
                    continue;
            }

            System.out.println("Memory: " + memory);
        } while (true);
    }

    private void BMICalculator() {
        double weight = view.getInputDouble("Enter Weight(kg): ");
        double height = view.getInputDouble("Enter Height(cm): ");
        double bmi = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f\n", bmi);
        view.displayBMIStatus(getBMIStatus(bmi));
    }

    private String getBMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }
}