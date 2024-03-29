package model;

import java.util.Comparator;

public class Candidate implements Comparator<Candidate>{
    private int id;
    private String firstname, lastname, address, phone, email;
    private int birthDate;
    private int CandidateType;

    public Candidate(int id, String phone, String firstname, String lastname, String address, int birthDate, int cadidatetype, String email) {
        this.id = id;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.birthDate = birthDate;
        this.CandidateType = cadidatetype;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }
    
    public int getCandidateType() {
        return CandidateType;
    }

    public void setCandidateType(int typeCandidate) {
        this.CandidateType = typeCandidate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void print() {
        System.out.println(id+" | "+firstname+" "+lastname+" | "+birthDate+" | "+address+" | "+phone+" | "+email+" | "+CandidateType);
    } 

    @Override
    public int compare(Candidate cnd1, Candidate cnd2) {
        return cnd1.getFirstname().compareTo(cnd2.getFirstname());
    }
}