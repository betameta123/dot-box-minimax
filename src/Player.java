public class Player {
    private static PlayerID playerid;

    public static PlayerID makeMove(PlayerID playerid, int x, int y){
        Board.updateBoard(x, y);
        return playerid;
    }

}
