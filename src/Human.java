import java.util.Scanner;

public class Human extends Player {

    public Human(int playerid){
        super(playerid);
        System.out.println("I am a Human and I will be " + super.getPlayerID().toChar());
    }

    public Human(){

    }

    public void chooseSquare(){
        int row = -1;
        int column = -1;
        while(true){
            while(true){
                System.out.print("Choose row you want to place line (0 indexed): ");
                try{
                    row = Game.getInput();
                    if(row < 0 || row > Board.DIM) {
                        throw new Exception();
                    }
                    break;

                }catch(Exception e){
                    System.exit(-1);
                }
            }

            while(true){
                System.out.print("Choose column you want to place line (0 indexed): ");
                try{
                   column = Game.getInput();
                    if(column < 0 || row > Board.DIM) {
                        throw new Exception();
                    }
                    break;

                }catch(Exception e){
                    System.exit(-1);
                }
            }

            if(isValidSquare(column, row)){
                Board.updateBoard(column, row);
                System.out.println("Player move:");
                System.out.println("__________________________________________\n\n");
                Board.printBoard();
                break;
            }
        }

    }
}
