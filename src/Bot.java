public class Bot extends Player {

    private Board board;

	public Bot(boolean playerorder, Game game) {
		super(playerorder, game);
        board = super.game.getBoard();
	}

    public boolean turn() {
        int[] cord = chooseSquare();
        System.out.println("Bot turn");
        super.makeMove(this.playerid, cord[0], cord[1]);

        if(board.fillSquare(this.playerid, cord[0], cord[1])) {
            board.printBoard();
            return false;
        }

        board.printBoard();
        return true;
    }

    public int[] chooseSquare(){
        int bestScore = Integer.MIN_VALUE;
        int[] cord = {-1 , -1};

        for(int i = 0; i < Board.DIM; i++) {
            for(int j = 0; j < Board.DIM; j++) {
                Board board = new Board(this.board);
                //memory go BRRRRRRRR
                if(game.isValidSquare(board, i, j)) {
                    board.updateBoard(i, j);
                    int score = miniMax(board, 0, true);
                    if(score > bestScore) {
                        bestScore = score;
                        cord[0] = i;
                        cord[1] = j;
                    }
                }
            }
        }
        return cord;
    }

    public int miniMax(Board board, int depth, boolean maximizing){
        int bestScore;
        if(game.isOver(board)) {
            switch(game.getWinner(board)){
                case BLUE:
                    if(this.playerid == PlayerID.BLUE)
                        return 1;
                    return 0;
                case RED:
                    if(this.playerid == PlayerID.RED)
                        return 1;
                    return 0;
            }
        }

        if(maximizing){
            bestScore = Integer.MIN_VALUE;
            for(int i = 0; i < Board.DIM; i++) {
                for(int j = 0; j < Board.DIM; j++) {
                    Board calcboard = new Board(board);

                    if(game.isValidSquare(board, i, j)) {
                        calcboard.updateBoard(i, j);
                        int score = miniMax(calcboard, depth + 1, false);
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
        } else {
            bestScore = Integer.MAX_VALUE;
            for(int i = 0; i < Board.DIM; i++) {
                for(int j = 0; j < Board.DIM; j++) {
                    Board calcboard = new Board(board);

                    if(game.isValidSquare(board, i, j)) {
                        calcboard.updateBoard(i, j);
                        int score = miniMax(calcboard, depth + 1, true);
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
        }

        return bestScore;
    }

	public String toString() {
        return "I am a Bot and I will be " + this.playerid;
	}
}
