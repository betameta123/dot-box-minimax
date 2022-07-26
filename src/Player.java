public class Player {

    protected PlayerID playerid;
	protected Game game;

	public Player(boolean playerorder, Game game) {
		this.playerid = playerorder ? PlayerID.BLUE : PlayerID.RED;
		this.game = game;
		System.out.println(this);
	}

    public PlayerID makeMove(PlayerID playerid, int x, int y){
        game.getBoard().updateBoard(x, y);
        return playerid;
    }

    public PlayerID getPlayerID() {
        return playerid;
    }

	//TODO: bruh
    public boolean isValidSquare(int x, int y) {

        if(x%2 == 1 || y%2 == 1) {
            if(x%2 ==1 && y%2 ==1)
                return false;

            if(game.getBoard().getGameBoard()[x][y] == ' ')
                return true;
        }

        return false;
    }

}
