package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LetterCode extends SecretCode{

    private List<String> Words;

    private String secretCode;

    public LetterCode() {
        Words = new ArrayList<>();
        loadWords();
    }

    public void loadWords() {
        try {
            File file = new File("Data/LetterCode.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() == 4) {
                    Words.add(word);
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.err.println("File not found.");
            e.printStackTrace();
        }
    }
    public void getCode() {
        if (Words.isEmpty()) {
            System.err.println("No valid 4-letter words found in the file.");
            secretCode = null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(Words.size());
        secretCode = Words.get(randomIndex);
    }

    public String getSecretCode() {
        return secretCode;
    }

    @Override
    public String toString(){
        return this.secretCode;
    }
}