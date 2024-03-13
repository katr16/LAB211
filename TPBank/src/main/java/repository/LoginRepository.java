package repository;

import dataAccess.LoginDao;

public class LoginRepository implements ILoginRepository {

    @Override
    public void login(String language) {
        LoginDao.Instance().login(language);
    }
}
