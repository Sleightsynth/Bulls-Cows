package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {

    private static ArrayList<String> banner;
    private static ArrayList<String> title;


    public static void main(String[] args) throws InterruptedException {
        {
            banner = new ArrayList<>();
            title = new ArrayList<>();
            banner.add(" *                                    *                                                                                                   ");
            banner.add("                                         /;    ;\\                                                                                        ");
            banner.add("                                     __  \\\\____//                         /                      \\                                     ");
            banner.add("                                  /{_\\_/   `'\\____                    /X/                       \\X\\                                   ");
            banner.add("                                   \\___   (o)  (o  }                   |XX\\         _____         /XX|                                  ");
            banner.add("        _____________________________/          :--' \s                 |XXX\\     _/       \\_     /XXX|___________                      ");
            banner.add("    ,-,'`@@@@@@@@       @@@@@@         \\_    `__\\                      \\XXXXXXX             XXXXXXX/            \\\\\\                 ");
            banner.add("   ;:(  @@@@@@@@@        @@@             \\___(o'o)                        \\XXXX    /     \\    XXXXX/                \\\\\\             ");
            banner.add("   :: )  @@@@          @@@@@@        ,'@@(  `===='      \s                      |   0     0   |                         \\                ");
            banner.add("   :: : @@@@@:          @@@@         `@@@:                                       |           |                           \\               ");
            banner.add("   :: \\  @@@@@:       @@@@@@@)    (  '@@@'                                       \\         /                            |______/        ");
            banner.add("   ;; /\\      /`,    @@@@@@@@@\\   :@@@@@)                                        \\       /                             |               ");
            banner.add("   ::/  )    {_----------------:  :~`,~~;                                           | O_O | \\                            |               ");
            banner.add("  ;;'`; :   )                  :  / `; ;                                             \\ _ /   \\________________           |              ");
            banner.add(" ;;;; : :   ;                  :  ;  ; :             \s                                         | |  | |      \\         /                ");
            banner.add(" `'`' / :  :                   :  :  : :                                                        / |  / |       \\______/                  ");
            banner.add("     )_ \\__;      \";\"          :_ ;  \\_\\       `,','                                        \\ |  \\ |        \\ |  \\ |             ");
            banner.add("     :__\\  \\    * `,'*         \\  \\  :  \\   *  8`;'*  *                                  __| |__| |      __| |__| |                  ");
            banner.add("         `^'     \\ :/           `^'  `-^-'   \\v/ :  \\/\s                                  |___||___|      |___||___|                   ");


            title.add("=========================================================================================================================                 ");
            title.add("=============================     BBBBBBBB    BB       BB  BBB         BBB          BBBB    =============================                 ");
            title.add("===========================       BB     BB   BB       BB  BBB         BBB         BB  BB     ===========================                 ");
            title.add("=========================         BB      BB  BB       BB  BBB         BBB        BB    BB      =========================                 ");
            title.add("=======================           BB     BB   BB       BB  BBB         BBB        BB              =======================                 ");
            title.add("======================            BBBBBBBB    BB       BB  BBB         BBB          BBBB           ======================                 ");
            title.add("=======================           BB     BB   BB       BB  BBB         BBB              BB        =======================                 ");
            title.add("=========================         BB      BB   BB     BB   BBB         BBB        BB    BB      =========================                 ");
            title.add("============================      BB     BB     BB   BB    BBB         BBB         BB  BB      ==========================                 ");
            title.add("==============================    BBBBBBB         BBB      BBBBBBBBBB  BBBBBBBBBB   BBBB    =============================                 ");
            title.add("=================================                                                         ===============================                 ");
            title.add("===================================             &&&&      &&&     &&  &&&               =================================                 ");
            title.add("====================================           &&  &&     && &&   &&  &  &&           ===================================                 ");
            title.add("=====================================         &&    &&    &&  &&  &&  &   &&         ====================================                 ");
            title.add("===================================          && &&&& &&   &&   && &&  &   &&          ===================================                 ");
            title.add("==================================          &&        &&  &&    &&&&  &&&&&              ================================                 ");
            title.add("=================================                                                         ===============================                 ");
            title.add("=============================     CCCCC      CCCC      CC       CC      CC     CCCC         =============================                 ");
            title.add("===========================     CC         CCC  CCC    CC       CC      CC    CC  CC          ===========================                 ");
            title.add("=========================     CCC         CCC    CCC   CC       CC      CC   CC    CC          ==========================                 ");
            title.add("=======================      CC          CC        CC  CC       CC      CC   CC                  ========================                 ");
            title.add("======================       CC          CC        CC  CC       CC      CC     CCCC               =======================                 ");
            title.add("=======================      CC          CC        CC   CC      CCC    CC          CC           =========================                 ");
            title.add("=========================     CCC         CCC    CCC     CC   CC   CC CC     CC    CC         ===========================                 ");
            title.add("============================    CC         CCC  CCC       CC CC     CCC       CC  CC         ============================                 ");
            title.add("============================      CCCCC      CCCC          CCC       C         CCCC          ============================                 ");
            title.add("=========================================================================================================================                 ");

            for(String line : banner){
                System.out.println(line);
            }
            TimeUnit.SECONDS.sleep(2);
            for(String line : title){
                System.out.println(line);
            }
            TimeUnit.SECONDS.sleep(2);
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
        }


        Scanner get_user_input = new Scanner(System.in);
        String user_input;
        System.out.print("Enter Name to Begin\n>>");
        user_input = get_user_input.nextLine();
        System.out.println("Welcome : " + user_input);

        Players players = new Players();
        Player player = new Player(user_input);
        Game game = new Game(players.findPlayer(player));

        game.playGame();

        get_user_input.close();

    }

}
