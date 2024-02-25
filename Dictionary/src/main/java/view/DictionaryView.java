package view;
import java.util.Scanner;

public class DictionaryView {
    private Scanner scanner;

    public DictionaryView() {
        scanner = new Scanner(System.in);
    }

    public int displayMenuAndGetChoice() {
        System.out.println("1. Add word");
        System.out.println("2. Delete word");
        System.out.println("3. Translate word");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public String getEnglishWord() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter English : ");
        return scanner.nextLine();
    }

    public String getVietnameseMeaning() {
        System.out.print("Enter Vietnamese: ");
        return scanner.nextLine();
    }

    public void displayTranslation(String vietnamese) {
        System.out.println("Vietnamese: " + vietnamese);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
