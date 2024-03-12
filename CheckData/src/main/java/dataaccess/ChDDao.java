package dataAccess;

import common.Validation;

public class ChDDao {

    private static ChDDao instance = null;
    private Validation valid = new Validation();

    public static ChDDao Instance() {
        if (instance == null) {
            synchronized (ChDDao.class) {
                if (instance == null) {
                    instance = new ChDDao();
                }
            }
        }
        return instance;
    }

    public void checkInputPhone() {
        valid.checkInputPhone("Phone number");
        System.err.println("Successfull");
    }

    public void checkInputEmail() {
        valid.checkInputEmail("Email", "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        System.err.println("Successfull");
    }

    public void checkInputDate() {
        valid.checkInputDate("Date");
        System.err.println("Successfull");
    }
}
