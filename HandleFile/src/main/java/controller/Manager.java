package controller;
import common.Validation;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Collections;
import model.Person;

public class Manager {
    private final Validation validation;

    public Manager() {
        validation = new Validation();
    }

    public int menu() {
        System.out.println("1. Find person info.");
        System.out.println("2. Copy Text to new file.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        int choice = validation.checkInputIntLimit(1, 3);
        return choice;
    }

    public void findPersonInfo() {
        ArrayList<Person> lp = new ArrayList<>();
        String pathFile = validation.checkInputPathFile();
        lp = getListPerson(pathFile);
        if (lp == null) {
            return;
        }
        double money = validation.checkInputMoney();
        printListPerson(lp, money);
    }

    public void copyNewFile() {
        String pathFileInput = validation.checkInputPathFile();
        String pathFileOutput = validation.checkInputPathFile();
        String content = getNewContent(pathFileInput);
        System.out.println(content);
        writeNewContent(pathFileOutput, content);
    }

    public ArrayList<Person> getListPerson(String pathFile) {
        ArrayList<Person> lp = new ArrayList<>();
        File file = new File("test.txt");
        if (!file.exists() || !file.isFile()) {
            System.err.println("Path doesn't exist or is not a file.");
            return null;
        }
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String[] infoPerson = line.split(";");
                lp.add(new Person(infoPerson[0], infoPerson[1], getSalary(infoPerson[2])));
            }
        } catch (IOException e) {
            System.err.println("Error reading file.");
            return null;
        }
        return lp;
    }

    public double getSalary(String salary) {
        double salaryResult = 0;
        try {
            salaryResult = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            salaryResult = 0;
        }
        return salaryResult;
    }

    public void printListPerson(ArrayList<Person> lp, double money) {
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        for (Person person : lp) {
            if (person.getMoney() >= money) {
                System.out.printf("%-20s%-20s%-20.1f\n", person.getName(), person.getAddress(), person.getMoney());
            }
        }
        Collections.sort(lp);
        System.out.println("Max: " + lp.get(0).getName());
        System.out.println("Min: " + lp.get(lp.size() - 1).getName());
    }

    public String getNewContent(String pathFileInput) {
        StringBuilder content = new StringBuilder();
        File file = new File("testinput.txt");
        if (!file.exists() || !file.isFile()) {
            System.err.println("File does not exist or is not a file.");
            return null;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file.");
            return null;
        }
        return content.toString();
    }

    public void writeNewContent(String pathFileOutput, String content) {
        File file = new File("testoutput.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
            System.out.println("Write successful.");
        } catch (IOException e) {
            System.err.println("Error writing file.");
        }
    }
}
