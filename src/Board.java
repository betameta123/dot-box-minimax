public class Board {

	public static final short DIM = 7;

	private char[][] gameBoard;

	public Board() {
		this.gameBoard= new char[DIM][DIM];

		for(int j = 0; j < DIM; j++) {
			for(int i = 0; i < DIM; i++) {
				gameBoard[i][j] = i%2 == 0 && j%2 == 0 ? '.' : ' ';
			}
		}
	}

	public char[][] getGameBoard() { return this.gameBoard; }

	public void updateBoard(int x, int y) {
		gameBoard[x][y] = '_';
	}

	public void printBoard() {
		for(int j = 0; j < DIM; j++) {
			for(int i = 0; i < DIM; i++) {
				System.out.print(gameBoard[i][j]);
			}
			System.out.print("\n");
		}
	}

	public void fillSquare(char player, int x, int y) throws Exception {
		if(x%2 == 0 || y%2 == 0)
			throw new Exception("Invalid Square Filled");

		gameBoard[x][y] = player;
	}

	public char[][] fillSquare(char player, int x, int y, char[][] tempBoard) throws Exception {
		if(x%2 == 0 || y%2 == 0)
			throw new Exception("Invalid Square Filled");
		tempBoard[x][y] = player;
		return tempBoard;

	}

}
