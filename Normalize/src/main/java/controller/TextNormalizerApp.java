package controller;
import View.TextView;
import java.io.IOException;
import model.TextModel;

public class TextNormalizerApp {
    public static void main(String[] args) {
        try {
            TextModel model = new TextModel();
            TextView view = new TextView();
            TextController controller = new TextController(model, view);

            controller.readFile("input.txt");

            controller.normalizeText();

            controller.displayText();

            controller.writeFile("output.txt");

            System.out.println("Text normalization successful. Check output.txt.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
