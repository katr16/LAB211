package responsitory;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class DoctorRepository {

    private final ArrayList<Doctor> doctorList;
    private final Scanner scanner;

    public DoctorRepository(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
        this.scanner = new Scanner(System.in);
    }

    public void createDoctor() {
        System.out.println("Enter doctor details:");
        System.out.print("Code: ");
        String code = scanner.nextLine().trim();
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Specialization: ");
        String specialization = scanner.nextLine().trim();
        System.out.print("Availability: ");
        int availability = Integer.parseInt(scanner.nextLine().trim());

        Doctor newDoctor = new Doctor(code, name, specialization, availability);
        doctorList.add(newDoctor);

        System.out.println("Doctor created successfully.");
    }

    public void updateDoctor() {
        System.out.print("Enter the code of the doctor to update: ");
        String code = scanner.nextLine().trim();

        for (Doctor doctor : doctorList) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                System.out.println("Enter new details for the doctor:");
                System.out.print("Name: ");
                String name = scanner.nextLine().trim();
                System.out.print("Specialization: ");
                String specialization = scanner.nextLine().trim();
                System.out.print("Availability: ");
                int availability = Integer.parseInt(scanner.nextLine().trim());

                doctor.setName(name);
                doctor.setSpecialization(specialization);
                doctor.setAvailability(availability);

                System.out.println("Doctor updated successfully.");
                return;
            }
        }

        System.out.println("Doctor with code " + code + " not found.");
    }

    public void deleteDoctor() {
        System.out.print("Enter the code of the doctor to delete: ");
        String code = scanner.nextLine().trim();

        for (Doctor doctor : doctorList) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                doctorList.remove(doctor);
                System.out.println("Doctor deleted successfully.");
                return;
            }
        }

        System.out.println("Doctor with code " + code + " not found.");
    }

    public void searchDoctor() {
        System.out.print("Enter the code of the doctor to search: ");
        String code = scanner.nextLine().trim();

        for (Doctor doctor : doctorList) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                System.out.println("Doctor found:");
                System.out.println(doctor);
                return;
            }
        }

        System.out.println("Doctor with code " + code + " not found.");
    }
}
