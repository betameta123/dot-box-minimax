public class Player {
    private PlayerID playerid;
    public Player(int playerid){
        if(playerid == 1) {
            this.playerid = PlayerID.Blue;
        } else {
            this.playerid = PlayerID.Red;
        }
    }

    public PlayerID makeMove(PlayerID playerid, int x, int y){
        Board.updateBoard(x, y);
        return playerid;
    }

    public PlayerID getPlayerid(){
        return playerid;
    }
}
