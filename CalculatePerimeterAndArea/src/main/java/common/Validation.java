package common;

import java.util.Scanner;

public class Validation {

    public static double checkInputDouble() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }
}
