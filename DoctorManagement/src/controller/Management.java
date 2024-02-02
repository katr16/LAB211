package controller;

import model.Doctor;
import view.Menu;

import java.util.ArrayList;
import responsitory.DoctorRepository;

public class Management extends Menu {

    private final ArrayList<Doctor> arr;

    public Management(String title, String[] s, ArrayList<Doctor> arr) {
        super(title, s);
        this.arr = arr;
    }

    @Override
    public void execute(int choice) {
        DoctorRepository doctorRepository = new DoctorRepository(arr);

        switch (choice) {
            case 1:
                doctorRepository.createDoctor();
                break;
            case 2:
                doctorRepository.updateDoctor();
                break;
            case 3:
                doctorRepository.deleteDoctor();
                break;
            case 4:
                doctorRepository.searchDoctor();
                break;
            case 5:
                System.out.println("Exited");
                return;
            default:
                System.err.println("Choose 1-5");
                break;
        }
    }
}
