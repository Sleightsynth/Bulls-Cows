package main;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class Game {
    private Players playerGameMapping;
    private Player currentPlayer;
    private SecretCode currentCode;
    private String guess;
    private static boolean RUNNING;

    public Game(Players playerGameMapping, Player currentPlayer, SecretCode currentCode) {
        this.playerGameMapping = playerGameMapping;
        this.currentPlayer = currentPlayer;
        this.currentCode = currentCode;
        RUNNING = true;
    }

    public Game(Players playerGameMapping, Player currentPlayer) {
        this.playerGameMapping = playerGameMapping;
        this.currentPlayer = currentPlayer;
        RUNNING = true;
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
            System.out.print("""
                    What do you want
                        - play  {to request a code}
                        - Stats {to see your stats}
                        - load  {to load your save}
                        - Quit  {to quit the game }
                    >>""");
            user_input = getUserInput();
            if(user_input.equalsIgnoreCase("play"))
                requestCode(user_input);
            else if (user_input.equalsIgnoreCase("stats"))
            {
                System.out.println(currentPlayer.getStats());
                continue;
            }
            else if (user_input.equalsIgnoreCase("load"))
            {
                loadGame();
            }
            else if (user_input.equalsIgnoreCase("quit"))
            {
                quit();
                continue;
            }
            else
                continue;

            if(this.currentCode == null || this.currentCode.getSecretCode() == null || this.currentCode.getSecretCode().equals("0"))
                continue;

            do {
                System.out.print(
                        """
                          enter your guess or:
                            - solution  {to see the solution}
                            - hint      {to get a hint      }
                            - later     {to save for later  }
                            - quit      {to give up         }
                        >>""");

                user_input = getUserInput();

                if (user_input.equalsIgnoreCase("back"))
                    break;
                else if (user_input.equalsIgnoreCase("quit"))
                {
                    this.setCurrentCode(null);
                    break;
                }
                else if(user_input.equalsIgnoreCase("later"))
                {
                    saveGame();
                    break;
                }

                else if (!enterGuess(user_input))
                    continue;

                System.out.printf("""
                        Your guess is '%s'
                        Are you sure?
                            - y
                            - n
                        >>""", user_input);

                user_input = getUserInput();

                if (user_input.equalsIgnoreCase("quit"))
                {
                    quit();
                    continue;
                }
                else if (undoGuess(user_input))
                    continue;

                if (checkGuess(this.guess))
                    System.out.println("You are correct");
                else
                {
                    System.out.printf(
                            "Bulls -> %d%nCows -> %d%n",
                            this.currentPlayer.getNumberOfBulls(), this.currentPlayer.getNumberOfCows()
                    );
                    System.out.println("You are wrong\nPlease try again or you can save the code for later (later)");
                }
            }while (!this.currentCode.isDecipheredCode() && RUNNING);
        } while (RUNNING);
    }

    public void requestCode(String user_input) {
        boolean accept_input = false;
        System.out.println("""
                What type of code do you want
                - Letter
                - Number
                >>""");
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
        if (user_input.equalsIgnoreCase("solution")) {
            System.out.println(showSolution());
            return false;
        } else if (user_input.equalsIgnoreCase("quit")) {
            quit();
            return false;
        }
        else if(user_input.equalsIgnoreCase("hint")){
            getHint();
            return false;
        }
        else if (user_input.toCharArray().length != 4) {
            System.out.println("Please enter 4 characters");
            return false;
        }
        else if (this.currentCode.getClass().equals(NumbersCode.class)) {
            try {
                Integer.parseInt(user_input);
            } catch (NumberFormatException e) {
                System.out.println("Only numbers can be entered!\nTry Again\n");
                return false;
            }
        } else if (!user_input.matches("^[a-zA-Z]*$")) {
                System.out.println("Only letters can be entered!\n Try Again\n");
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
                System.out.println("""
                        Please Select:
                        - y
                        - n
                        >>""");
                user_input = getUserInput();
            }
    }

    public void getHint() {
        Random getRandom = new Random();
        int randomIndex = getRandom.nextInt(4);
        char hintedChar = this.currentCode.getSecretCode().charAt(randomIndex);
        System.out.printf("""
                There is a %c at position %d
                """,
                hintedChar, randomIndex+1
        );
    }

    public SecretCode showSolution() {
        return this.currentCode;
    }

    public void saveGame() {
        try {
            String username = this.currentPlayer.getUsername();
            File file = new File("Data\\" + username + ".txt");
            FileWriter write = new FileWriter(file);
            String code = currentCode.toString();
            write.write(code);
            write.close();
        } catch(IOException e) {
            System.out.println("Could not write to file.");
        }
        System.out.println("Secret code saved for later.");
    }

    public void loadGame() {
        try {
            String username = this.currentPlayer.getUsername();
            File file = new File("Data\\" + username + ".txt");
            if(file.exists()) {
                SecretCode secretCode;
                try (Scanner scanner = new Scanner(file)) {
//                    scanner.hasNext();
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

    public void quit(){
        System.out.println("Thank-you for playing!");
        playerGameMapping.savePlayers();
        RUNNING = false;
    }
}