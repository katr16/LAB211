package repository;

import dataAccess.ChDDao;

public class ChDRepository implements IChDRepository {

    @Override
    public void checkPhone() {
        ChDDao.Instance().checkInputPhone();
    }

    @Override
    public void checkDate() {
        ChDDao.Instance().checkInputDate();
    }

    @Override
    public void checkEmail() {
        ChDDao.Instance().checkInputEmail();
    }
}
