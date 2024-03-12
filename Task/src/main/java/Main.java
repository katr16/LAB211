
import controller.TaskController;
import java.io.IOException;
import java.util.ArrayList;
import model.Task;
import view.TaskView;

public class Main {
    public static void main(String[] args) throws IOException {
        TaskView view = new TaskView();
        ArrayList<Task> model = new ArrayList<>();
        TaskController controller = new TaskController(view, model);
        controller.start();
    }
}