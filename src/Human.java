import java.util.Scanner;

public class Human extends Player{

    public Human(int playerid){
        super(playerid);
        System.out.println("I am a Human and I will be " + super.getPlayerID().toChar());
    }

    public Human(){

    }

    public void chooseSquare(){
        int row = -1;
        int column = -1;
        Scanner keyboard = new Scanner(System.in);
        while(true){
            while(true){
                System.out.println("Choose row you want to place line (0 indexed): ");
                try{
                    row = keyboard.nextInt();
                    if(row < 0 || row > Board.DIM) {
                        throw new Exception();
                    }
                    break;

                }catch(Exception e){
                    System.out.println("Invalid input");
                }
            }

            while(true){
                System.out.println("Choose column you want to place line (0 indexed): ");
                try{
                   column = keyboard.nextInt();
                    if(column < 0 || row > Board.DIM) {
                        throw new Exception();
                    }
                    break;

                }catch(Exception e){
                    System.out.println("Invalid input");
                }
            }

            if(isValidSquare(column, row)){
                Board.updateBoard(column, row);
                Board.printBoard();
                break;
            }
        }

    }
}
