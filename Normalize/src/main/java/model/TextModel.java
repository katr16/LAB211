package model;

import java.util.StringJoiner;

public class TextModel {

    private String content;

    public TextModel() {
        this.content = "";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void normalizeText() {
        normalizeSpaces();
        normalizePunctuation();
        capitalizeAfterDot();
        removeQuotesSpaces();
        capitalizeFirstWord();
        removeBlankLines();
        addDotAtEnd();
    }

    private void normalizeSpaces() {
        content = content.replaceAll("\\s+", " ");
    }

    private void normalizePunctuation() {
        content = content.replaceAll("\\s*,\\s*", ", ")
                .replaceAll("\\s*\\.\\s*", ". ")
                .replaceAll("\\s*:\\s*", ": ");
    }

    private void capitalizeAfterDot() {
        String[] lines = content.split("\n");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split("\\s+");
            StringBuilder normalizedLine = new StringBuilder();
            for (int j = 0; j < words.length; j++) {
                if (j > 0 && words[j - 1].endsWith(".")) {
                    normalizedLine.append(words[j].substring(0, 1).toUpperCase())
                            .append(words[j].substring(1).toLowerCase());
                } else {
                    normalizedLine.append(words[j].toLowerCase());
                }
                if (j < words.length - 1) {
                    normalizedLine.append(" ");
                }
            }
            result.append(normalizedLine.toString());
            if (i < lines.length - 1) {
                result.append("\n");
            }
        }
        content = result.toString();
    }

    private void removeQuotesSpaces() {
        content = content.replaceAll("\\s*\"\\s*", "\"").replaceAll("\\s*\"\\s*", "\"");
    }

    private void capitalizeFirstWord() {
        if (!content.isEmpty()) {
            content = content.substring(0, 1).toUpperCase() + content.substring(1);
        }
    }

    private void removeBlankLines() {
        content = content.replaceAll("\n+", "\n");
    }

    private void addDotAtEnd() {
        if (!content.endsWith(".")) {
            content += ".";
        }
    }
}
