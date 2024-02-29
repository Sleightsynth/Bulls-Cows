package main;

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
            System.out.print("\nWhat type of Code do you want\n\t- Letter\n\t- Number\n>>");

            user_input = getUserInput();

            if (user_input.equalsIgnoreCase("quit")) {
                System.out.println("Thank-you for playing!");
                exit(0);
            }

            requestCode(user_input);


            //TODO: Get players next command / A guess / A hint / To save / To undo / Load Game

            do {
                System.out.print("Please make a guess\n>>");

                user_input = getUserInput();

                if (!enterGuess(user_input))
                    continue;

                System.out.printf("Your guess is '%s'\nAre you sure?\n- y\t- n\n>>", user_input);

                user_input = getUserInput();

                if (undoGuess(user_input))
                    continue;

                //TODO: CHECK BULLS AND COWS
                if (user_input.equalsIgnoreCase(this.currentCode.toString())) {
                    System.out.println("You are correct");
                    this.currentCode.setDecipheredCode(true);
                } else {
                    System.out.println("You are wrong\nPlease try again");
                }

            } while (!this.currentCode.isDecipheredCode());

        } while (true);

    }

    public void requestCode(String user_input) {
        if (user_input.equalsIgnoreCase("letter"))
            this.currentCode = new LetterCode();
        else if (user_input.equalsIgnoreCase("number")) {
            NumbersCode numberCode = new NumbersCode();
            numberCode.getCode();
            this.currentCode = numberCode;
        }
    }

    public boolean enterGuess(String user_input) {
        if (this.currentCode.getClass().equals(NumbersCode.class)) {
            try {
                Integer.parseInt(user_input);
            } catch (NumberFormatException e) {
                System.out.println("Only numbers can be entered!\nTry Again\n");
                return false;
            }
        } else {
            String pattern = "^[a-zA-Z]*$";
            if (!user_input.matches(pattern))
                return false;
        }

        if (user_input.equalsIgnoreCase("quit")) {
            System.out.println("Thank-you for playing!");
            exit(0);
        } else if (user_input.toCharArray().length != 4) {
            System.out.println("Please enter 4 characters");
            return false;
        }

        this.guess = user_input;
        return true;
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

    }

    public void loadGame() {

    }

    public void showSolution() {
        return;
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