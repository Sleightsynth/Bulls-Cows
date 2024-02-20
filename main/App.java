package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Player player = new Player();
        SecretCode code;
        Scanner get_user_input = new Scanner(System.in);
        String user_input;
        String header = """
                *                                    *
                 \\______U                    ______/
                  |_____|O   BULLS & COWS   O|_____|
                   /\\ /\\                      /\\ ^/\\
                """;

        System.out.println(header);
        System.out.print("Enter Name to Begin\n>>");
        user_input = get_user_input.nextLine();
        System.out.println("NAME : " + user_input);

        do {
            System.out.print("\nWhat type of Code do you want\n\t- Letter\n\t- Number\n>>");
            user_input = get_user_input.nextLine();

            if(user_input.equalsIgnoreCase("letter"))
            {
                code = new LetterCode();
            }
            else if(user_input.equalsIgnoreCase("number"))
            {
                code = new NumbersCode();
            }else
                continue;

        } while (!user_input.equalsIgnoreCase("quit"));



        get_user_input.close();
    }
}
