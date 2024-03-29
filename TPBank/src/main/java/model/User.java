package model;

public class User {
    private String accountNumber;
    private String password;
    private String capcha;

    public User() {
    }

    public User(String accountNumber, String password, String capcha) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.capcha = capcha;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCapcha() {
        return capcha;
    }

    public void setCapcha(String capcha) {
        this.capcha = capcha;
    }
    
    
}