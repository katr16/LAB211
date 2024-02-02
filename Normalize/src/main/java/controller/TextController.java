package controller;

import View.TextView;
import java.io.*;
import model.TextModel;

public class TextController {

    private TextModel model;
    private TextView view;

    public TextController(TextModel model, TextView view) {
        this.model = model;
        this.view = view;
    }

    public void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        model.setContent(content.toString());
    }

    public void normalizeText() {
        model.normalizeText();
    }

    public void displayText() {
        view.display(model.getContent());
    }

    public void writeFile(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(model.getContent());
        writer.close();
    }
}
