package repository;

import model.InputData;

public interface IAnaRepository {

    void getCharacter(String s, InputData data);

    void getNumber(String s, InputData data);

}
