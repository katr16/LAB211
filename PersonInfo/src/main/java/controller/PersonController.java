package controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import model.Person;

public class PersonController {
    private Scanner scanner;

    public PersonController(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputString(String message) {
        System.out.print(message);
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public int inputInt(String message) {
        System.out.print(message);
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Input must be digit.");
            }
        }
    }

    public double inputSalary(String message) {
        System.out.print(message);
        while (true) {
            try {
                double result = Double.parseDouble(scanner.nextLine());
                if (result < 0) {
                    System.err.println("Salary must be greater than zero");
                } else {
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.err.println("You must input digit.");
            }
        }
    }

    public Person inputPersonInfo() {
        System.out.println("Input Information of Person");
        String name = inputString("Please input name: ");
        String address = inputString("Please input address: ");
        double salary = inputSalary("Please input salary: ");
        return new Person(name, address, salary);
    }

    public void displayPersonInfo(Person person) {
        System.out.printf("Name: %s\n", person.getName());
        System.out.printf("Address: %s\n", person.getAddress());
        System.out.printf("Salary: %.2f\n", person.getSalary());
        System.out.println();
    }

    public void sortBySalary(Person[] persons) {
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return Double.compare(person1.getSalary(), person2.getSalary());
            }
        });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonController controller = new PersonController(scanner);

        System.out.println("=====Management Person programer=====");
        int n = controller.inputInt("Enter number person: ");
        Person[] persons = new Person[n];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = controller.inputPersonInfo();
        }

        controller.sortBySalary(persons);

        for (Person person : persons) {
            controller.displayPersonInfo(person);
        }
    }
}

