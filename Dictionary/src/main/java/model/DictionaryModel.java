package model;
import java.io.*;
import java.util.HashMap;

public class DictionaryModel {
    private HashMap<String, String> dictionary;
    private File dictionaryFile;

    public DictionaryModel() {
        dictionary = new HashMap<>();
        dictionaryFile = new File("dictionary.txt");
        loadData();
    }

    public boolean addWord(String eng, String vi) {
        if (!dictionary.containsKey(eng)) {
            dictionary.put(eng, vi);
            updateDatabase();
            return true;
        }
        return false;
    }

    public boolean removeWord(String eng) {
        if (dictionary.containsKey(eng)) {
            dictionary.remove(eng);
            updateDatabase();
            return true;
        }
        return false;
    }

    public String translate(String eng) {
        return dictionary.getOrDefault(eng, "Not found");
    }

    private void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                dictionary.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
        }
    }

    private void updateDatabase() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dictionaryFile))) {
            for (String eng : dictionary.keySet()) {
                writer.write(eng + ":" + dictionary.get(eng) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
