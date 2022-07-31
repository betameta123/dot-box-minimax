import java.util.Scanner;

public class Human extends Player {
    private Board board;

	public Human(boolean playerorder, Game game) {
		super(playerorder, game);
        board = game.getBoard();
	}

    public boolean turn() {
        int[] cord = chooseSquare();
        super.makeMove(this.playerid, cord[0], cord[1]);

        if(board.fillSquare(this.playerid, cord[0], cord[1])) {
            board.printBoard();
            return false;
        }

        board.printBoard();
        return true;
    }

	private int[] chooseSquare() {
		int row = -1;
		int column = -1;
        boolean validInput = true;
        do {
            do {
                validInput = true;
                System.out.print("Choose row you want to place line (0 indexed): ");
                try {
                    row = game.getNextInt();
                } catch(Exception e){
                    validInput = false;
                }

            } while(!validInput);

            do {
                validInput = true;
                System.out.print("Choose column you want to place line (0 indexed): ");
                try {
                    column = game.getNextInt();
                } catch(Exception e){
                    validInput = false;
                }

            } while(!validInput);

            validInput = game.isValidSquare(board, row, column);
            if(!validInput){
                System.out.println("Your input was invalid. Please try again.");
            }

        } while(!validInput);

        int[] cord = {row, column};
        return cord;
    }


	public String toString() {
		return "I am a Human and I will be " + this.playerid;
	}

}
