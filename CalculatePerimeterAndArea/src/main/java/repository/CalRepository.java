package repository;

import DataAccess.CalDao;

public class CalRepository implements ICalRepository {

    @Override
    public void calculate() {
        CalDao.Instance().display(
                CalDao.Instance().calculateRectangle(),
                CalDao.Instance().calculateCircle(),
                CalDao.Instance().calculateTriangle());
    }
}
