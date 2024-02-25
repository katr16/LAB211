package common;

import java.util.Scanner;

public class Validation {
    private final Scanner in;

    public Validation() {
        in = new Scanner(System.in);
    }

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputPathFile() {
        System.out.print("Enter path file: ");
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Path cannot be empty.");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public double checkInputMoney() {
        System.out.print("Enter money: ");
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input a valid double.");
                System.out.print("Enter again: ");
            }
        }
    }
}
