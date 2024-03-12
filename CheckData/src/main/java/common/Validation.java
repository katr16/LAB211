package common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    //check input phone
    public String checkInputPhone(String title) {
        String s = "";
        while (s.length() < 10 || s.length() > 10) {
            Scanner sc = new Scanner(System.in);
            System.out.print(title + ": ");
            s = sc.nextLine();
            try {
                long a = Long.parseLong(s);
                if (s.length() < 10 || s.length() > 10) {
                    System.out.println("Phone number must be 10 digits");
                }
            } catch (NumberFormatException e) {
                System.out.println("Phone number must be number");
            }
        }
        return s;
    }

    public String checkInputEmail(String title, String regex) {
        String s = "";
        while (!s.matches(regex)) {
            Scanner sc = new Scanner(System.in);
            System.out.print(title + ": ");
            s = sc.nextLine();
            if (!s.matches(regex)) {
                System.out.println(title + " Email must is correct format");
            }
        }
        return s;
    }

    public String checkInputString(String title) {
        String s = "";
        while (s.isBlank() || s.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.print(title + ": ");
            s = sc.nextLine();
        }
        return s;
    }

    public Date checkInputDate(String title) {
        Date date;
        while (true) {
            DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            try {
                date = sdf.parse(checkInputString(title));
                return date;
            } catch (ParseException e) {
                System.out.println("Date to correct format(dd/mm/yyyy)");
            }
        }
    }
}
