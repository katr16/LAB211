package dataAccess;

import common.Library;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.InputData;

public class AnaDao {

    private static AnaDao instance = null;
    private Library lib = new Library();

    public static AnaDao Instance() {
        if (instance == null) {
            synchronized (AnaDao.class) {
                if (instance == null) {
                    instance = new AnaDao();
                }
            }
        }
        return instance;
    }

    private HashMap<String, List<Integer>> getNumber(String s) {
        HashMap<String, List<Integer>> number = new HashMap<>();
        String[] line = s.split("\\D+");
        List<Integer> oddNumber = new ArrayList<>();
        List<Integer> evenNumber = new ArrayList<>();
        List<Integer> perfectSquare = new ArrayList<>();
        List<Integer> allNumber = new ArrayList<>();
        for (String line1 : line) {
            int a = Integer.parseInt(line1);
            if (lib.checkOddEven(a)) {
                evenNumber.add(a);
            } else {
                oddNumber.add(a);
            }
            if (lib.perfectSquare(a)) {
                perfectSquare.add(a);
            }
            allNumber.add(a);
        }
        number.put("odd", oddNumber);
        number.put("even", evenNumber);
        number.put("perfectSquare", perfectSquare);
        number.put("allNumber", allNumber);
        return number;
    }

    public void getNumber(String s, InputData data) {
        data.setNumber(getNumber(s));
        System.out.println("Perfect Square Numbers: " + data.getNumber().get("perfectSquare").toString());
        System.out.println("Odd Numbers: " + data.getNumber().get("odd").toString());
        System.out.println("Even Numbers: " + data.getNumber().get("even").toString());
        System.out.println("All Numbers: " + data.getNumber().get("allNumber").toString());
    }

    private HashMap<String, StringBuilder> getCharacter(String s) {
        HashMap<String, StringBuilder> characters = new HashMap<>();
        //create character storage for each case
        StringBuilder allCharacters = new StringBuilder();
        StringBuilder specialCharacters = new StringBuilder();
        StringBuilder upperCaseCharacters = new StringBuilder();
        StringBuilder lowerCaseCharacters = new StringBuilder();
        s = s.replaceAll("\\d+", "");
        String specialChar = s.replaceAll("[a-zA-Z]", "");
        String upperCase = s.replaceAll("[^A-Z]", "");
        String lowerCase = s.replaceAll("[^a-z]", "");
        allCharacters.append(s);
        specialCharacters.append(specialChar);
        upperCaseCharacters.append(upperCase);
        lowerCaseCharacters.append(lowerCase);
        //put all info to hashmap
        characters.put("allChar", allCharacters);
        characters.put("specialChar", specialCharacters);
        characters.put("lowerChar", lowerCaseCharacters);
        characters.put("upperChar", upperCaseCharacters);
        return characters;
    }

    public void getCharacter(String s, InputData data) {
        data.setCharacter(getCharacter(s));
        System.out.println("Uppercase Characters: " + data.getCharacter().get("upperChar").toString());
        System.out.println("Lowercase Characters: " + data.getCharacter().get("lowerChar").toString());
        System.out.println("Special Characters: " + data.getCharacter().get("specialChar").toString());
        System.out.println("All Characters: " + data.getCharacter().get("allChar").toString());
    }
}
