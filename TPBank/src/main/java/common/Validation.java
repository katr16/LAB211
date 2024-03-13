package common;

import java.util.Scanner;

public class Validation {

    public String inputNumber(String title, String error) {
        String s = "";
        while (s.isEmpty() || s.length() != 10 || s.length() == 10 && s.matches("[^\\d]+")) {
            Scanner sc = new Scanner(System.in);
            System.out.println  (title + ":");
            s = sc.nextLine();
            if (s.length() != 10) {
                System.out.println(error);
            } else if (s.matches("[^\\d]+")) {
                System.out.println(error);
            }
        }
        return s;
    }

    public String inputPassword(String title, String error) {
        String s = "";
        Scanner sc = new Scanner(System.in);
        while (s.isEmpty() || !(s.length() >= 8 && s.length() <= 31 && s.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,31}$"))) {
            System.out.println(title + ":");
            s = sc.nextLine();
            if (s.length() < 8 || s.length() > 31) {
                System.out.println(error);
            } 
        }
        return s;
    }

    public StringBuilder inputCaptcha(String title, String error, StringBuilder checkCode) {
        Captcha captcha = new Captcha();
        while (true) {
            StringBuilder s = new StringBuilder();
            String str;
            Scanner sc = new Scanner(System.in);
            System.out.println(title + ":");
            str = sc.nextLine();
            s.append(str);
            if (!captcha.checkCaptcha(s, checkCode)) {
                System.out.println(error);
                continue;
            }
            return s;
        }
    }
}
