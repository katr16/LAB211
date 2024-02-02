package view;

import controller.EquationController;
import model.EquationModel;

public class Main {
    public static void main(String[] args) {
        EquationModel model = new EquationModel();
        EquationView view = new EquationView();
        EquationController controller = new EquationController(model, view);

        controller.processUserInput();
    }
}
