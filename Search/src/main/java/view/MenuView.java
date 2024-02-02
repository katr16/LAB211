
package view;

import  java.util.Scanner;

public class MenuView {
    private Scanner scanner = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("1. Tim kiem bang sap xep nhi phan");
        System.out.println("2. Tim kiem bang sap xep tuyen tinh");
        System.out.println("3. Thoat");
        return scanner.nextInt();
    }

    public int getInputValue() {
        System.out.print("Nhap gia tri can tim: ");
        return scanner.nextInt();
    }
}
