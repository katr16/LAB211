package controller;

import common.Validation;
import model.InputData;
import repository.AnaRepository;

public class Management {

    Validation valid;
    AnaRepository repo;
    InputData data;

    public Management() {
        valid = new Validation();
        repo = new AnaRepository();
        data = new InputData();
    }

    public void run() {
        System.out.println("===== Analysis String program ====");
        String s = valid.inputString("Input String");
        System.out.println("-----Result Analysis------");
        repo.getNumber(s, data);
        repo.getCharacter(s, data);
    }
}