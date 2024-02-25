package view;

import controller.DictionaryController;
import model.DictionaryModel;

public class DictionaryMain {
    public static void main(String[] args) {
        DictionaryModel model = new DictionaryModel();
        DictionaryView view = new DictionaryView();
        DictionaryController controller = new DictionaryController(model, view);
        controller.processUserInput();
    }
}
