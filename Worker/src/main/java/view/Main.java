package view;
import controller.WorkerController;

public class Main {

    public static void main(String[] args) {
        String title = "========== Workers Management ============";
        String[] s = new String[]{"Add Worker", "Up salary", "Down salary", "Display Information salary", "Exit"};
        WorkerController manage = new WorkerController(title, s);
        manage.run();
    }
}
