package view;

import controller.ManageEastAsiaCountries;
import java.util.ArrayList;
import model.Country;

public class Main {

    public static void main(String[] args) {
        ArrayList<Country> lc = new ArrayList<>();

        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();

        while (true) {
            int choice = manager.menu();
            switch (choice) {
                case 1 -> manager.inputCountry(lc);
                case 2 -> manager.printCountry(lc);
                case 3 -> manager.searchByName(lc);
                case 4 -> manager.printCountrySorted(lc);
                case 5 -> {
                    return;
                }
            }
        }
    }
}
