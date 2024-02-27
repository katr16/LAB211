package view;

public class ViewCalculator {
    ICalculatorRepository.CalculatorRepository program;

    public ViewCalculator() {
        program = new ICalculatorRepository.CalculatorRepository();
    }

    public void run() {
        System.out.println("\n=====Calculator Shape Program=====");
        program.inputandcalculatorShape();
    }
}
