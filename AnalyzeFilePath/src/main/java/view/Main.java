package view;

import controller.PathInfoController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PathInfoView view = new PathInfoView();
        PathInfoController controller = new PathInfoController(scanner, view);
        controller.checkInputPath();
        scanner.close();
    }
}   