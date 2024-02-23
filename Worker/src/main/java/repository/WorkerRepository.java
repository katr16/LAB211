package repository;

import common.Library;
import common.Validation;
import dataaccess.WorkerData;
import java.util.Collections;
import java.util.List;
import model.Worker;

public class WorkerRepository implements IWorkerRepository {

    @Override
    public void addWorker(List<Worker> workers, Worker new_worker) {
        if (!WorkerData.Instance().addWorker(workers, new_worker)) {
            System.err.println("ID exist");
            return;
        }
        System.err.println("Successful");
    }

    @Override
    public void changeSalary(List<Worker> workers, int type) {
        if (workers.isEmpty()) {
            System.err.println("List is empty!");
            return;
        }
        Collections.sort(workers, new Library());
        Validation valid = new Validation();
        String iD = valid.inputString("Enter ID");
        int location = valid.checkID(workers, iD);
        if (location == -1) {
            System.err.println("ID not exist");
            return;
        }
        if (!WorkerData.Instance().changeSalary(workers, location, type)) {
            System.err.println("Change salary exceed original salary!");
            return;
        }
        System.err.println("Successful");
    }

    @Override
    public void display(List<Worker> workers) {
        if (workers.isEmpty()) {
            System.err.println("List is empty!");
            return;
        }
        WorkerData.Instance().display(workers);
    }
}
