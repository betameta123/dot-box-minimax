//     ____           __                                       __           ____                                        ______    __     ____
//    / __ \  ____   / /_   _____         ____ _   ____   ____/ /          / __ )  ____    _  __  ___    _____         / ____/   / /    /  _/
//   / / / / / __ \ / __/  / ___/        / __ `/  / __ \ / __  /          / __  | / __ \  | |/_/ / _ \  / ___/        / /       / /     / /
//  / /_/ / / /_/ // /_   (__  )        / /_/ /  / / / // /_/ /          / /_/ / / /_/ / _>  <  /  __/ (__  )        / /___    / /___ _/ /
// /_____/  \____/ \__/  /____/         \__,_/  /_/ /_/ \__,_/          /_____/  \____/ /_/|_|  \___/ /____/         \____/   /_____//___/

import java.util.Scanner;

public class Game {

	private Scanner scanner;
	private Board board;

	private Human human;
	private Bot bot;

	enum WinState {
		BLUE, RED, NO_WINNER;
	}

	public Game() {
		this.board = new Board();
		this.scanner = new Scanner(System.in);
		init();
	}

	public Scanner getScanner() { return this.scanner; }
	public Board getBoard() { return this.board; }

	private void init() {
		boolean playerorder = menu() == 1;
		this.human = new Human(playerorder, this);
		this.bot = new Bot(!playerorder, this);
	}

	public void run() {
		gameloop(human, bot);
		cleanup();
	}

	private void cleanup() {
		this.scanner.close();
	}

    public void gameloop(Human human, Bot bot) {
        boolean running = true;
        PlayerID humanTurn = human.getPlayerID();
        while(running) {
            round(humanTurn);
        }
    }

    public void round(PlayerID humanTurn) {
        boolean endturn = true;
            switch(humanTurn) {
                case BLUE:
                    do {
                        endturn = human.turn();
                    } while(!endturn);

                    do {
                        endturn = bot.turn();
                    } while(!endturn);

					break;
                case RED:
                    do {
                        endturn = bot.turn();
                    } while(!endturn);

                    do{
                        endturn = human.turn();
                    }while(!endturn);
					break;
            }
    }

    private int menu(){

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                                                                         |");
        System.out.println("|          ____           __                                       __           ____                                        ______    __     ____         |");
        System.out.println("|         / __ \\  ____   / /_   _____         ____ _   ____   ____/ /          / __ )  ____    _  __  ___    _____         / ____/   / /    /  _/         |");
        System.out.println("|        / / / / / __ \\ / __/  / ___/        / __ `/  / __ \\ / __  /          / __  | / __ \\  | |/_/ / _ \\  / ___/        / /       / /     / /           |");
        System.out.println("|       / /_/ / / /_/ // /_   (__  )        / /_/ /  / / / // /_/ /          / /_/ / / /_/ / _>  <  /  __/ (__  )        / /___    / /___ _/ /            |");
        System.out.println("|      /_____/  \\____/ \\__/  /____/         \\__,_/  /_/ /_/ \\__,_/          /_____/  \\____/ /_/|_|  \\___/ /____/         \\____/   /_____//___/            |");
        System.out.println("|                                                                                                                                                         |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------- \n\n");


		int player = 0;
		boolean flag = false;
		do {
			flag = false;
        	System.out.print("Would You like to go first(1) or second(2): ");
			try {
				player = this.getNextInt();
			} catch (Exception e) {
				flag = true;
			}

			flag |= !(player == 1 || player == 2);
            if (flag) System.out.println("Invalid Input. Try Again!");

		} while (flag);

        return player;
    }

    public boolean isValidSquare(int row, int column) {

        if(row < 0 || row > Board.DIM || column < 0 || column > Board.DIM)
            return false;
        if (row % 2 == 1 && column % 2 == 1)
            return false;
        if(!(board.getGameBoard()[row][column] == ' '))
            return false;

        return true;
    }

    public WinState checkWinner(char[][] board){
        int numB = 0;
        int numR = 0;

        for(int i = 0; i<Board.DIM; i++){
            for(int j = 0; j<Board.DIM; j++){
                if(board[i][j] == PlayerID.BLUE.asChar())
                    numB++;
                else if(board[i][j] == PlayerID.RED.asChar())
                    numR++;
            }
        }

        if(numB >= 5) {
            return WinState.BLUE;
        }
        else if(numR >= 5) {
            return WinState.RED;
        }
        return WinState.NO_WINNER;
    }

    public int getNextInt() throws java.util.InputMismatchException {
		int value = 0;
		String input = "";

		if (scanner.hasNext()) input = scanner.nextLine().trim();
		return Integer.parseInt(input);
    }

    public static void main(String[] args) {
		new Game().run();
    }

}
