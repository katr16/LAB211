package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

// Model
public class LetterAndCharacterModel {

    private String inputString;
    private int letterCount;
    private int characterCount;
    private Map<String, Integer> wordOccurrences;
    private Map<Character, Integer> letterFrequencies;

    public LetterAndCharacterModel() {
        this.inputString = "";
        this.letterCount = 0;
        this.characterCount = 0;
        this.wordOccurrences = new HashMap<>();
        this.letterFrequencies = new HashMap<>();
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public void countLettersAndCharacters() {
        StringTokenizer tokenizer = new StringTokenizer(inputString, " .,;:\"'?()-!");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            for (char c : token.toCharArray()) {
                if (Character.isLetter(c)) {
                    letterCount++;
                }
                characterCount++;
            }

            wordOccurrences.put(token, wordOccurrences.getOrDefault(token, 0) + 1);
        }
    }

    public void countLetterFrequencies() {
        for (char c : inputString.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                letterFrequencies.put(c, letterFrequencies.getOrDefault(c, 0) + 1);
            }
        }
    }

    public int getLetterCount() {
        return letterCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public Map<String, Integer> getWordOccurrences() {
        return wordOccurrences;
    }

    public Map<Character, Integer> getLetterFrequencies() {
        return letterFrequencies;
    }
}
