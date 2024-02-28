package main;

import java.util.Scanner;

public class Game {
    private Player playerGameMapping;
    private Player currentPlayer;
    private SecretCode currentCode;

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

    public void playGame() {
        Scanner get_user_input = new Scanner(System.in);
        String user_input;

        do {
            System.out.print("\nWhat type of Code do you want\n\t- Letter\n\t- Number\n>>");
            user_input = get_user_input.nextLine();

            if(user_input.equalsIgnoreCase("letter"))
                this.requestCode(new LetterCode());
            else if(user_input.equalsIgnoreCase("number"))
                this.requestCode(new NumbersCode());
            else if (user_input.equalsIgnoreCase("quit"))
                continue;

            //TODO: Get players next command / A guess / A hint / To save / To undo / Load Game

            this.enterGuess();

        } while (!user_input.equalsIgnoreCase("quit"));

    }

    public void requestCode(SecretCode code) {
        if(code.getClass() == LetterCode.class)
        {
            this.currentCode = new LetterCode();
        }
        else
        {
            NumbersCode numberCode = new NumbersCode();
            numberCode.getCode();
            this.currentCode = numberCode;
        }
    }

    public void enterGuess() {
        Scanner get_user_input = new Scanner(System.in);
        String user_input;
        do{
            System.out.print("Please make a guess\n>>");
            user_input = get_user_input.nextLine();
            if(user_input.equalsIgnoreCase("quit")) continue;

            if(undoGuess(user_input)) continue;

            if(user_input.equalsIgnoreCase(this.currentCode.toString())) {

                System.out.println("You are correct");
                this.currentCode.setDecipheredCode(true);
            }
            else
                System.out.println("Try Again");

        }while(!user_input.equalsIgnoreCase("quit") && !this.currentCode.isDecipheredCode());
    }

    public boolean undoGuess(String user_input) {
        Scanner get_user_input = new Scanner(System.in);
        do{
            System.out.printf("Your guess is '%s'\nAre you sure?\n- y\t- n\n>>", user_input);

            user_input = get_user_input.nextLine();

            if(user_input.equalsIgnoreCase("y"))
            {
                break;
            }
            else if(user_input.equalsIgnoreCase("n"))
            {
                return true;
            }
            else
            {
                System.out.println("Please Select:\n\t- y\n\t- n");
            }
        }while(true);

        return false;
    }

    public void saveGame() {

    }

    public void loadGame() {

    }

    public void showSolution() {
        return;
    }

}