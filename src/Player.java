public class Player {
    private PlayerID playerid;

    public Player(int playerid){
        if(playerid == 1) {
            this.playerid = PlayerID.Blue;
        } else {
            this.playerid = PlayerID.Red;
        }
    }

    public Player(){
        playerid = null;
    }

    public PlayerID makeMove(PlayerID playerid, int x, int y){
        Board.updateBoard(x, y);
        return playerid;
    }

    public PlayerID getPlayerID(){
        return playerid;
    }

    public boolean isValidSquare(int x, int y) {
        char[][] board = Board.getBoard();

        if(x%2 == 1 || y%2 == 1) {
            if(x%2 ==1 && y%2 ==1)
                return false;

            if(board[x][y] == ' ')
                return true;
        }

        return false;
    }
}
