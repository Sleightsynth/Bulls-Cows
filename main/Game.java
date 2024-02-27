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
            else
                continue;

            //TODO: Get players next command / A guess / A hint / To save / To undo / Load Game

        } while (!user_input.equalsIgnoreCase("quit"));

        get_user_input.close();
    }

    public void requestCode(SecretCode code) {
        System.out.println(code.getClass());
        this.currentCode = code;
    }

    public void enterGuess() {

    }

    public void undoGuess() {

    }

    public void saveGame() {

    }

    public void loadGame() {

    }

    public void showSolution() {
        return;
    }

}