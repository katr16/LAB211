package controller;

import java.util.Scanner;
import model.LetterAndCharacterModel;
import view.LetterAndCharacterView;

public class LetterAndCharacterController {

    private LetterAndCharacterModel model;
    private LetterAndCharacterView view;

    public LetterAndCharacterController(LetterAndCharacterModel model, LetterAndCharacterView view) {
        this.model = model;
        this.view = view;
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your content: ");
        String inputString = scanner.nextLine();

        model.setInputString(inputString);
        model.countLettersAndCharacters();
        model.countLetterFrequencies();

        view.displayResults(
                model.getLetterCount(),
                model.getCharacterCount(),
                model.getWordOccurrences(),
                model.getLetterFrequencies()
        );
    }
}
