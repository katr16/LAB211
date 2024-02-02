package controller;

import java.util.ArrayList;
import model.Contact;
import view.Validation;

public class Manager {

    private final Validation validation = new Validation();

    public int menu() {
        System.out.println("1. Add a contact.");
        System.out.println("2. Display all contact.");
        System.out.println("3. Delete a contact.");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = validation.checkInputIntLimit(1, 4);
        return choice;
    }

    public void createContact(ArrayList<Contact> lc) {
        System.out.print("Enter id contact: ");
        int contactId = validation.checkInputInt();
        System.out.print("Enter first name: ");
        String firstName = validation.checkInputString();
        System.out.print("Enter last name: ");
        String lastName = validation.checkInputString();
        System.out.print("Enter group: ");
        String group = validation.checkInputString();
        System.out.print("Enter address: ");
        String address = validation.checkInputString();
        System.out.print("Enter phone: ");
        String phone = validation.checkInputPhone();
        lc.add(new Contact(contactId, firstName + lastName, group, address,
                phone, firstName, lastName));
        System.err.println("Add successful.");
    }

    public void printAllContact(ArrayList<Contact> lc) {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        for (Contact contact : lc) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getContactId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    public void deleteContact(ArrayList<Contact> lc) {
        System.out.print("Enter id: ");
        int idDelete = validation.checkInputInt();
        Contact contactDelete = getContactById(lc, idDelete);
        if (contactDelete == null) {
            System.err.println("Not found contact.");
            return;
        } else {
            lc.remove(contactDelete);
        }
        System.err.println("Delete successful.");
    }

    public Contact getContactById(ArrayList<Contact> lc, int idDelete) {
        for (Contact contact : lc) {
            if (contact.getContactId() == idDelete) {
                return contact;
            }
        }
        return null;
    }
}
