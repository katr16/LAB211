package controller;

import repository.CalRepository;
import view.Menu;

public class CalController extends Menu {

    CalRepository repo;

    public CalController() {
        repo = new CalRepository();
    }

    @Override
    public void execute() {
        repo.calculate();
    }
}
