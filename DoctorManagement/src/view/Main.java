package view;

import controller.Management;
import model.Doctor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String title = "========== Doctor Management ============";
        String[] s = new String[]{"Add a Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};

        ArrayList<Doctor> doctorList = new ArrayList<>();

        Management manage = new Management(title, s, doctorList);
        manage.run();
    }
}
