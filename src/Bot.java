public class Bot extends Player {

	public Bot(boolean playerorder, Game game) {
		super(playerorder, game);
	}

    public void chooseSquare(){
        int bestScore = Integer.MIN_VALUE;
        int row = 0;
        int column = 0;
        char[][] tempBoard = this.game.getBoard().getGameBoard();

        for(int i = 0; i < Board.DIM; i++){
            for(int j = 0; j < Board.DIM; j++){
                if(isValidSquare(i,j)) {
                    tempBoard[i][j] = '_';
                    int score = miniMax(tempBoard, true);
                    tempBoard[i][j] = ' ';
                    if(score > bestScore) {
                        row = i;
                        column = j;
                    }
                }
            }
        }
        this.game.getBoard().updateBoard(row, column);
        System.out.println("Bot move:");
        System.out.println("_________________________________________________\n\n");
        this.game.getBoard().printBoard();
    }

    public int miniMax(char[][] board, boolean maxi){
        return 1;
    }

	public String toString() {
        return "I am a Bot and I will be " + this.playerid;
	}
}
