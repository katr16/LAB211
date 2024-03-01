package view;

import controller.PersonController;
import java.util.Scanner;
import model.Person;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonController controller = new PersonController(scanner);

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
