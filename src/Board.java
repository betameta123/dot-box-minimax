public class Board {
    private static final short DIM = 7;
    private static char[][] board = new char[DIM][DIM];

    public Board() {
        for(int j = 0; j < DIM; j++) {
                for(int i = 0; i < DIM; i++) {
                board[i][j] = i%2 == 0 && j%2 == 0 ? '.' : ' ';
            }
        }
    }

    public static void updateBoard(int x, int y) {
        board[x][y] = 'X';
    }

    public static char[][] getBoard(){
        return board;
    }

    public static void printBoard() {
        for(int j = 0; j < DIM; j++) {
                for(int i = 0; i < DIM; i++) {
                    System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void fillSquare(char player, int x, int y) throws Exception{
        if(x%2 == 0 || y%2 == 0)
            throw new Exception("Invalid Square Filled");

        board[x][y] = player;
    }

}
