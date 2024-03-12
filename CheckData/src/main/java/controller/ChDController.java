package controller;

import repository.ChDRepository;
import java.awt.Menu;

public class ChDController extends Menu {

    protected static String[] mc = {"Phone number", "Email", "Date", "Exit"};
    ChDRepository repo;

    public ChDController() {
        super("======== Validate Program =========", mc);
        repo = new ChDRepository();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: {
                System.out.println("------- Phone number --------");
                repo.checkPhone();
                break;
            }
            case 2: {
                System.out.println("------- Email --------");
                repo.checkEmail();
                break;
            }
            case 3: {
                System.out.println("------- Date --------");
                repo.checkDate();
                break;
            }
            case 4: {
                System.out.println("EXIT...");
                System.exit(0);
            }
            default: {
                System.err.println("No such choice!");
            }
        }
    }

}
