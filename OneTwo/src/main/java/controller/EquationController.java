package controller;

import model.EquationModel;
import view.EquationView;

public class EquationController {
    private EquationModel model;
    private EquationView view;

    public EquationController(EquationModel model, EquationView view) {
        this.model = model;
        this.view = view;
    }

    public void processUserInput() {
        while (true) {
            System.out.println("----- Calculate Equation -----");
            int choice = view.menu();
            switch (choice) {
                case 1:
                    processSuperlativeEquation();
                    break;
                                case 2:
                    processQuadraticEquation();
                    break;
                case 3:
                    return;
            }
        }
    }

    private void processSuperlativeEquation() {
        System.out.print("Enter A: ");
        model.setA(view.checkInputDouble());

        // Check if A is not zero
        while (model.getA() == 0) {
            System.out.println("Please input a non-zero value for A.");
            System.out.print("Enter A: ");
            model.setA(view.checkInputDouble());
        }

        System.out.print("Enter B: ");
        model.setB(view.checkInputDouble());

        double x = -model.getB() / model.getA();
        System.out.println("Solution: x = " + String.format("%.3f", x));

        // Print odd, even, and perfect square numbers
        printNumberProperties("Number is Odd:", checkOdd(x));
        printNumberProperties("Number is Even:", checkEven(x));
        printNumberProperties("Number is Perfect Square:", checkSquareNumber(x));
    }

    private void processQuadraticEquation() {
        System.out.print("Enter A: ");
        model.setA(view.checkInputDouble());

        // Check if A is not zero
        while (model.getA() == 0) {
            System.out.println("Please input a non-zero value for A.");
            System.out.print("Enter A: ");
            model.setA(view.checkInputDouble());
        }

        System.out.print("Enter B: ");
        model.setB(view.checkInputDouble());

        System.out.print("Enter C: ");
        model.setC(view.checkInputDouble());

        double delta = model.getB() * model.getB() - 4 * model.getA() * model.getC();
        double x1 = (-model.getB() + Math.sqrt(delta)) / (2 * model.getA());
        double x2 = (-model.getB() - Math.sqrt(delta)) / (2 * model.getA());
        System.out.println("Solution: x1 = " + String.format("%.3f", x1) + " and x2 = " + String.format("%.3f", x2));

        // Print odd, even, and perfect square numbers
        printNumberProperties("Number is Odd:", checkOdd(x1), checkOdd(x2));
        printNumberProperties("Number is Even:", checkEven(x1), checkEven(x2));
        printNumberProperties("Number is Perfect Square:", checkSquareNumber(x1), checkSquareNumber(x2));
    }

    private void printNumberProperties(String message, boolean... conditions) {
        System.out.print(message);
        for (boolean condition : conditions) {
            if (condition) {
                System.out.print(model.getA() + ", ");
                System.out.print(model.getB() + ", ");
                System.out.print(model.getC() + " ");
                System.out.print(String.format("%.3f", -model.getB() / (2 * model.getA())) + " ");
            }
        }
        System.out.println();
    }

    private boolean checkOdd(double n) {
        return n % 2 == 1;
    }

    private boolean checkEven(double n) {
        return n % 2 == 0;
    }

    private boolean checkSquareNumber(double n) {
        return (int) Math.sqrt(n) * (int) Math.sqrt(n) == n;
    }
}

