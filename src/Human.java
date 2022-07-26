import java.util.Scanner;

public class Human extends Player {

	public Human(boolean playerorder, Game game) {
		super(playerorder, game);
	}

	public void chooseSquare() {
		int row = -1;
		int column = -1;
		while(true) {
			while(true) {
				System.out.print("Choose row you want to place line (0 indexed): ");
				try {
					row = this.game.getNextInt();
					if(row < 0 || row >= Board.DIM) {
						throw new Exception();
					}
					break;
				} catch(Exception e) {
					// System.exit(-1);
				}
			}

			while(true){
				System.out.print("Choose column you want to place line (0 indexed): ");
				try {
					column = this.game.getNextInt();
					if(column < 0 || row >= Board.DIM) {
						throw new Exception();
					}
					break;

				} catch(Exception e){
					// System.exit(-1);
				}
			}

			if(isValidSquare(column, row)) {
				this.game.getBoard().updateBoard(column, row);
				System.out.println("Player move:");
				System.out.println("__________________________________________\n\n");
				this.game.getBoard().printBoard();
				break;
			}
		}

	}

	public String toString() {
		return "I am a Human and I will be " + this.playerid;
	}

}
