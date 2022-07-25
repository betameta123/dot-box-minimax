public class Bot extends Player{
    private PlayerID playerid;
    public Bot(int playerid){
        super(playerid);
        System.out.println("I am a bot and I will be " + super.getPlayerID().toChar());
        this.playerid = super.getPlayerID();
    }

    public Bot(){
    }

    public void chooseSquare(){
        int bestScore = Integer.MIN_VALUE;
        int row = 0;
        int column = 0;
        char[][] tempBoard = Board.getBoard();

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
        Board.updateBoard(row, column);
        System.out.println("Bot move:");
        System.out.println("_________________________________________________\n\n");
        Board.printBoard();
    }

    public int miniMax(char[][] board, boolean maxi){
        return 1;
    }
}
