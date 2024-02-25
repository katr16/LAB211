package controller;

public class Controller {
    private final Manager manager;

    public Controller() {
        manager = new Manager();
    }

    public void run() {
        while (true) {
            int choice = manager.menu();
            switch (choice) {
                case 1:
                    manager.findPersonInfo();
                    break;
                case 2:
                    manager.copyNewFile();
                    break;
                case 3:
                    return;
            }
        }
    }
}
