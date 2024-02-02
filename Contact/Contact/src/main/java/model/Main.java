package model;

import controller.Manager;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Contact> lc = new ArrayList<>();
        lc.add(new Contact(1, "Iker Casillas", "Star", "Spain", "1234567890", "Iker", "Casillas"));
        lc.add(new Contact(2, "John Terry", "Star", "England", "1234567890", "John", "Terry"));
        lc.add(new Contact(3, "Raul Gonzalez", "Star", "Spain", "1234567890", "Raul", "Gonzalez"));

        Manager manager = new Manager();

        while (true) {
            int choice = manager.menu();

            switch (choice) {
                case 1 -> manager.createContact(lc);
                case 2 -> manager.printAllContact(lc);
                case 3 -> manager.deleteContact(lc);
                case 4 -> {
                    return;
                }
            }
        }
    }
}
