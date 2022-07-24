public class Human extends Player{

    public Human(int playerid){
        super(playerid);
        System.out.println("I am a Human and I will be " + super.getPlayerid().toChar());
    }
}
