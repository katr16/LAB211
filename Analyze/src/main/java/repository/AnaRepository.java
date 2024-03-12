package repository;

import dataAccess.AnaDao;
import model.InputData;

public class AnaRepository implements IAnaRepository {

    @Override
    public void getNumber(String s, InputData data) {
        AnaDao.Instance().getNumber(s, data);
    }

    @Override
    public void getCharacter(String s, InputData data) {
        AnaDao.Instance().getCharacter(s, data);
    }
}
