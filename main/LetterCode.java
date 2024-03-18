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

    public LetterCode(String code) {
        Words = new ArrayList<>();
        loadWords();
        this.secretCode = code;
    }

    public void loadWords() {
        try {
            File file = new File("Data/LetterCode.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() == 10) {
                    Words.add(word);
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.err.println("File not found.");
        }
    }
    public void getCode() {
        if (Words.isEmpty()) {
            System.err.println("No valid 10-letter words found in the file.");
            secretCode = null;
        }else {
            Random random = new Random();
            int randomIndex = random.nextInt(Words.size());
            secretCode = Words.get(randomIndex);
        }
    }

    public String getSecretCode() {
        if(this.secretCode == null)
            getCode();
        return secretCode;
    }

    @Override
    public String toString(){
        return this.secretCode;
    }
}