package controller;

import model.DictionaryModel;
import view.DictionaryView;

public class DictionaryController {
    private DictionaryModel model;
    private DictionaryView view;

    public DictionaryController(DictionaryModel model, DictionaryView view) {
        this.model = model;
        this.view = view;
    }

    public void processUserInput() {
        int choice;
        do {
            choice = view.displayMenuAndGetChoice();
            switch (choice) {
                case 1:
                    addWord();
                    break;
                case 2:
                    deleteWord();
                    break;
                case 3:
                    translateWord();
                    break;
                case 4:
                    view.displayMessage("Exiting program...");
                    break;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void addWord() {
        String eng = view.getEnglishWord();
        String vi = view.getVietnameseMeaning();
        boolean added = model.addWord(eng, vi);
        if (added) {
            view.displayMessage("Successfull.");
        } else {
            view.displayMessage("Word already exists in the dictionary.");
        }
    }

    private void deleteWord() {
        String eng = view.getEnglishWord();
        boolean removed = model.removeWord(eng);
        if (removed) {
            view.displayMessage("Successfull.");
        } else {
            view.displayMessage("Word not found in the dictionary.");
        }
    }

    private void translateWord() {
        String eng = view.getEnglishWord();
        String vietnamese = model.translate(eng);
        view.displayTranslation(vietnamese);
    }
}
