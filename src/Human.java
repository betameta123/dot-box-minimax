import java.util.Scanner;

public class Human extends Player {

	public Human(boolean playerorder, Game game) {
		super(playerorder, game);
	}

    public boolean turn() {
        chooseSquare();

        return true;
    }

	private void chooseSquare() {
		int row = -1;
		int column = -1;
        boolean validInput = true;
        do {
            do {
                validInput = true;
                System.out.print("Choose row you want to place line (0 indexed): ");
                try {
                    row = game.getNextInt();
                } catch(Exception e){
                    validInput = false;
                }

            } while(!validInput);

            do {
                validInput = true;
                System.out.print("Choose column you want to place line (0 indexed): ");
                try {
                    column = game.getNextInt();
                } catch(Exception e){
                    validInput = false;
                }

            } while(!validInput);

            validInput = game.isValidSquare(row, column);
            if(!validInput){
                System.out.println("Your input was invalid. Please try again.");
            }

        } while(!validInput);
    }


	public String toString() {
		return "I am a Human and I will be " + this.playerid;
	}

}
