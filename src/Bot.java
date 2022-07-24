public class Bot extends Player{

    public Bot(int playerid){
        super(playerid);
        System.out.println("I am a bot and I will be " + super.getPlayerid().toChar());
    }
}
