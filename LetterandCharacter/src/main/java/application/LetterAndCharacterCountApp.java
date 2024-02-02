package application;

import controller.LetterAndCharacterController;
import model.LetterAndCharacterModel;
import view.LetterAndCharacterView;

public class LetterAndCharacterCountApp {

    public static void main(String[] args) {
        LetterAndCharacterModel model = new LetterAndCharacterModel();
        LetterAndCharacterView view = new LetterAndCharacterView();
        LetterAndCharacterController controller = new LetterAndCharacterController(model, view);

        controller.processUserInput();
    }
}
