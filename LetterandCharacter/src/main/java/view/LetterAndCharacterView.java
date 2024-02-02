package view;

import java.util.Map;

public class LetterAndCharacterView {

    public void displayResults(int letterCount, int characterCount, Map<String, Integer> wordOccurrences, Map<Character, Integer> letterFrequencies) {

        System.out.println("" + wordOccurrences);
        System.out.println("" + letterFrequencies);
    }
}
