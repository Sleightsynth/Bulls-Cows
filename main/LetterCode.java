package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class LetterCode extends SecretCode{

    public void getCode() {
        try {
            File file = new File("LetterCode.txt");

            Scanner scanner = new Scanner(file);

            if (scanner.hasNext()) {
                String secretWord = scanner.next();
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }






}