package dataAccess;

import common.Captcha;
import common.Validation;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginDao {

    private static volatile LoginDao instance = null;
    private static final Validation valid = new Validation();
    private final Captcha captcha = new Captcha();
    private final Locale localeEN = new Locale("en");
    private final Locale localeVI = new Locale("vi");
    ResourceBundle labels;

    public static LoginDao Instance() {
        LoginDao instance = LoginDao.instance;
        if (instance == null) {
            synchronized (LoginDao.class) {
                instance = LoginDao.instance;
                if (instance == null) {
                    LoginDao.instance = instance = new LoginDao();
                }
            }
        }
        return instance;
    }

    public void login(String language) {
        if ("en".equals(language)) {
            labels = ResourceBundle.getBundle("prompt", localeEN);
        } else {
            labels = ResourceBundle.getBundle("prompt", localeVI);
        }
        valid.inputNumber(labels.getString("Account_number"),
                labels.getString("Wrong_number"));
        valid.inputPassword(labels.getString("Password"),
                labels.getString("Wrong_password"));
        StringBuilder checkCode = captcha.createCaptcha(6);
        System.out.print(labels.getString("Captcha"));
        valid.inputCaptcha(labels.getString("TypeCaptcha"),
                labels.getString("Wrong_captcha"), checkCode);
        System.out.println(labels.getString("Success"));
    }
}
