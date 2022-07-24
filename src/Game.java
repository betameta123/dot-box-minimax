// ____           __                                       __           ____                                        ______    __     ____
   // / __ \  ____   / /_   _____         ____ _   ____   ____/ /          / __ )  ____    _  __  ___    _____         / ____/   / /    /  _/
  // / / / / / __ \ / __/  / ___/        / __ `/  / __ \ / __  /          / __  | / __ \  | |/_/ / _ \  / ___/        / /       / /     / /
 // / /_/ / / /_/ // /_   (__  )        / /_/ /  / / / // /_/ /          / /_/ / / /_/ / _>  <  /  __/ (__  )        / /___    / /___ _/ /
// /_____/  \____/ \__/  /____/         \__,_/  /_/ /_/ \__,_/          /_____/  \____/ /_/|_|  \___/ /____/         \____/   /_____//___/

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Human human;
        Bot bot;

        Board board = new Board();
        int playorder = menu();

        try {
            human = (Human)assignPlayer(playorder);
            bot = (Bot)assignPlayer(playorder * 10);
        } catch(Exception e){
            System.out.println("Failed to assign players");
        }
    }



    private static int menu(){
        int player = 0;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                                                                         |");
        System.out.println("|          ____           __                                       __           ____                                        ______    __     ____         |");
        System.out.println("|         / __ \\  ____   / /_   _____         ____ _   ____   ____/ /          / __ )  ____    _  __  ___    _____         / ____/   / /    /  _/         |");
        System.out.println("|        / / / / / __ \\ / __/  / ___/        / __ `/  / __ \\ / __  /          / __  | / __ \\  | |/_/ / _ \\  / ___/        / /       / /     / /           |");
        System.out.println("|       / /_/ / / /_/ // /_   (__  )        / /_/ /  / / / // /_/ /          / /_/ / / /_/ / _>  <  /  __/ (__  )        / /___    / /___ _/ /            |");
        System.out.println("|      /_____/  \\____/ \\__/  /____/         \\__,_/  /_/ /_/ \\__,_/          /_____/  \\____/ /_/|_|  \\___/ /____/         \\____/   /_____//___/            |");
        System.out.println("|                                                                                                                                                         |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------- \n\n");
        System.out.print("Would You like to go first(1) or second(2): ");

        while(true) {
            try{
                player = keyboard.nextInt();

                if(player != 1 && player != 2 )
                    throw new Exception("Invalid");

                break;
            } catch(Exception e) {
                System.out.print("Would You like to go first(1) or second(2): ");
            }
            System.out.print("Would You like to go first(1) or second(2): ");
        }

        keyboard.close();
        return player;
    }

    private static Player assignPlayer(int playorder) throws Exception{
        switch (playorder){
            case 1:
                return new Human(1);
            case 2:
                return new Human(2);
            case 10:
                return new Bot(2);
            case 20:
                return new Bot(1);
        }
        throw new Exception("Failed to assign players");
    }

}
