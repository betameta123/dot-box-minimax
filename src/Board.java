public class Board implements Cloneable{

	public static final short DIM = 7;

	private char[][] gameBoard;

	public Board() {
		this.gameBoard= new char[DIM][DIM];

		for(int i = 0; i < DIM; i++) {
			for(int j = 0; j < DIM; j++) {
				gameBoard[i][j] = i%2 == 0 && j%2 == 0 ? '.' : ' ';
			}
		}
	}
    public Board(Board board) {
		this.gameBoard= new char[DIM][DIM];
        fillNewBoard(board);
    }

    private void fillNewBoard(Board board) {
        for(int i = 0; i < DIM; i++) {
            for(int j = 0; j < DIM; j++) {
                this.gameBoard[i][j] = board.getGameBoard()[i][j];
            }
        }
    }

	public char[][] getGameBoard() { return this.gameBoard; }

	public void updateBoard(int x, int y) {
        if(x % 2 == 0)
            gameBoard[x][y] = '_';
        else
            gameBoard[x][y] = '|';
	}

    public boolean fillSquare(PlayerID playerid, int x, int y){
        boolean flag = false;

        if( x > 0 && x % 2 == 0) {//Verticles that are not the left edge
            if(gameBoard[x - 1][y - 1] != ' ' && gameBoard[x - 2][y] != ' ' && gameBoard[x - 1][y + 1] != ' ') {
                gameBoard[x-1][y] = playerid.asChar();
                flag = true;
            }
        }
        if(x < DIM - 1 && x % 2 == 0) {// Verticles that are not right edge
            if(gameBoard[x + 1][y - 1] != ' ' && gameBoard[x + 2][y] != ' ' && gameBoard[x + 1][y + 1] != ' ') {
                gameBoard[x+1][y] = playerid.asChar();
                flag = true;
            }
        }
        if( y < DIM - 1 && y % 2 == 0){//Horizontals that are not bottom edge
            if(gameBoard[x - 1][y + 1] != ' ' && gameBoard[x][y + 2] != ' ' && gameBoard[x + 1][y + 1] != ' ') {
                gameBoard[x][y + 1] = playerid.asChar();
                flag = true;
            }
        }
        if( y > 0 && y % 2 == 0) {//Horizontal that is not top edge
            if(gameBoard[x - 1][y - 1] != ' ' && gameBoard[x][y - 2] != ' ' && gameBoard[x + 1][y - 1] != ' ') {
                gameBoard[x][y - 1] = playerid.asChar();
                flag = true;
            }
        }
        return flag;
    }

	public void printBoard() {
		for(int i = 0; i < DIM; i++) {
			for(int j = 0; j < DIM; j++) {
				System.out.print(gameBoard[i][j]);
			}
			System.out.print("\n");
		}
	}

}
