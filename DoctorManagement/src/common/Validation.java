package common;

import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

public class Validation {

    private final Scanner in;

    public Validation() {
        this.in = new Scanner(System.in);
    }

    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.println("Enter again");
            } else {
                return result;
            }
        }
    }

    public int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number integer");
                System.out.print("Enter again: ");
            }
        }
    }

    public boolean checkCodeExist(ArrayList<Doctor> doctors, String code) {
        for (Doctor doctor : doctors) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }

    public String checkNewInputString(String oldInfomation) {
        String result = in.nextLine().trim();
        if (result.isEmpty()) {
            return oldInfomation;
        } else {
            return result;
        }
    }

    public int checkNewInputInt(int oldInformation) {
        String result = in.nextLine().trim();
        if (result.isBlank()) {
            return oldInformation;
        } else {
            while (true) {
                try {
                    int newInformation = Integer.parseInt(result);
                    return newInformation;
                } catch (NumberFormatException e) {
                    System.err.println("Please input number integer");
                    System.out.print("Enter again: ");
                }
            }
        }
    }

    public boolean checkChangeInfo(Doctor doctor, String code,
            String name, String specialization, int availability) {
        if (doctor.getCode().equalsIgnoreCase(code)
                && doctor.getName().equalsIgnoreCase(name)
                && doctor.getSpecialization().equalsIgnoreCase(specialization)
                && doctor.getAvailability() == availability) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Validation validation = new Validation();
        int inputInt = validation.checkInputInt();
        System.out.println("Entered integer: " + inputInt);
    }
}
