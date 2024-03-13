package main;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.exit;

public class Game {
    private Player playerGameMapping;
    private Player currentPlayer;
    private SecretCode currentCode;
    private String guess;

    public Game(Player playerGameMapping, Player currentPlayer) {
        this.playerGameMapping = playerGameMapping;
        this.currentPlayer = currentPlayer;
    }

    public Game(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void getHint() {

    }

    public Player loadPlayer() {
        return currentPlayer;
    }

    public String getUserInput() {
        Scanner get_user_input = new Scanner(System.in);
        return get_user_input.nextLine();
    }

    public void playGame() {
        String user_input;
        do {
            System.out.print("\nWhat type of Code do you want\n\t- Letter\n\t- Number\n\t- Stats\n\t- Quit\n\t- Load\n>>");
            user_input = getUserInput();
            if (user_input.equalsIgnoreCase("quit")) {
                System.out.println("Thank-you for playing!");
                exit(0);
            }
            else if (user_input.equalsIgnoreCase("stats")) {
                System.out.println(currentPlayer.toString());
                continue;
            }
            else if(user_input.equalsIgnoreCase("load")) {
                loadGame();
            }
            else {
                requestCode(user_input);
            }

            if(this.currentCode.getSecretCode() == null || this.currentCode.getSecretCode().equals("0"))
                continue;

            do {
                System.out.print("Please make a guess\n>>");

                user_input = getUserInput();

                if (!enterGuess(user_input))
                    continue;

                System.out.printf("Your guess is '%s'\nAre you sure?\n- y\t- n\n>>", user_input);

                user_input = getUserInput();

                if (undoGuess(user_input))
                    continue;

                if (checkGuess(this.guess)) {
                    System.out.println("You are correct");
                } else {
                    System.out.printf(
                            "Bulls -> %d%nCows -> %d%n",
                            this.currentPlayer.getNumberOfBulls(), this.currentPlayer.getNumberOfCows()
                    );
                    System.out.println("You are wrong\nPlease try again or you can save the code for later (later)");
                }
            } while (!this.currentCode.isDecipheredCode());
        } while (true);
    }

    public void requestCode(String user_input) {
        boolean accept_input = false;
        while(!accept_input){
            if (user_input.equalsIgnoreCase("letter")) {
                this.currentCode = new LetterCode();
                this.currentCode.getCode();
                this.currentPlayer.incrementCodesAttempted();
                accept_input = true;
            }
            else if (user_input.equalsIgnoreCase("number")) {
                this.currentCode = new NumbersCode();
                this.currentCode.getCode();
                this.currentPlayer.incrementCodesAttempted();
                accept_input = true;
            }else{
                System.out.println("Please enter:\n- Letter\t- Number");
                user_input = getUserInput();
            }
        }
    }

    public boolean enterGuess(String user_input) {
        if(user_input.equalsIgnoreCase("later")) {
            saveGame();
        }
        String pattern = "^[a-zA-Z]*$";
        if (this.currentCode.getClass().equals(NumbersCode.class)) {
            try {
                Integer.parseInt(user_input);
            } catch (NumberFormatException e) {
                System.out.println("Only numbers can be entered!\nTry Again\n");
                return false;
            }
        } else if (!user_input.matches(pattern)) {
                System.out.println("Only letters can be entered!\n Try Again\n");
                return false;
        }

        if (user_input.equalsIgnoreCase("solution")) {
            System.out.println(showSolution());
            return false;
        } else if (user_input.equalsIgnoreCase("quit")) {
            System.out.println("Thank-you for playing!");
            exit(0);
        }

        else if (user_input.toCharArray().length != 4) {
            System.out.println("Please enter 4 characters");
            return false;
        }

        this.guess = user_input;
        return true;
    }

    public boolean checkGuess(String user_input) {
        if (user_input.equalsIgnoreCase(this.currentCode.toString())) {
            this.currentCode.setDecipheredCode(true);
            this.currentPlayer.incrementCodesDeciphered();
            this.currentPlayer.setNumberOfBulls(4);
            return true;
        } else {
            char[] guess_arr = user_input.toCharArray();
            char[] code_arr = this.currentCode.toString().toCharArray();
            int numberOfBulls = 0;
            int numberOfCows = 0;
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if (guess_arr[i] == code_arr[j])
                        if (i == j)
                            ++numberOfBulls;
                        else
                            ++numberOfCows;
            this.currentPlayer.setNumberOfCows(numberOfCows);
            this.currentPlayer.setNumberOfBulls(numberOfBulls);
        }
        return false;
    }

    public boolean undoGuess(String user_input) {
        while (true)
            if (user_input.equalsIgnoreCase("y")) {
                return false;
            } else if (user_input.equalsIgnoreCase("n")) {
                this.guess = null;
                return true;
            } else {
                System.out.println("Please Select:\n\t- y\n\t- n");
                user_input = getUserInput();
            }
    }

    public void saveGame() {
        try {
            String username = this.currentPlayer.getUsername();
            File file = new File("Data\\" + username + ".txt");
            FileWriter write = new FileWriter("Data\\" + username + ".txt");
            String code = currentCode.toString();
            write.write(code);
            write.close();
        } catch(IOException e) {
            System.out.println("Could not write to file.");
        }

        System.out.println("Secret code saved for later.");
        System.out.println("Thank-you for playing!");
        exit(0);
    }

    public void loadGame() {
        try {
            String username = this.currentPlayer.getUsername();
            File file = new File("Data\\" + username + ".txt");
            if(file.exists()) {
                FileReader reader = new FileReader(file);
                SecretCode secretCode;

                try (Scanner scanner = new Scanner(file)) {
                    scanner.hasNext();
                    String code = scanner.next();
                    if (code.length() == 4) {
                        try {
                            Integer.parseInt(code);
                            secretCode = new NumbersCode(code);
                        } catch (NumberFormatException e) {
                            secretCode = new LetterCode(code);
                        }
                        this.currentCode = secretCode;
                        System.out.println("Game loaded successfully!");
                    } else {
                        System.out.println("Invalid code length in the file.");
                    }
                }
            } else {
                System.out.println("Save file not found for user: " + username);
            }
        } catch (FileNotFoundException e){
            System.err.println("File not found.");
        }
    }

    public SecretCode showSolution() {
        return this.currentCode;
    }


    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public SecretCode getCurrentCode() {
        return currentCode;
    }

    public void setCurrentCode(SecretCode currentCode) {
        this.currentCode = currentCode;
    }
}