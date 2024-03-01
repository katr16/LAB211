package view;

import model.Person;

public class PersonWrapper {
    private Person person;

    public PersonWrapper(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
