public class Board {
    public static final int SIZE = 5;

    private final Cell[][][] board;

    public Board(){
        board = new Cell[SIZE][SIZE][SIZE];//5x5x5 board [x][y][z] -> format
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++){
                for (int z = 0; z < SIZE; z++){
                    board[x][y][z] = new Cell();
                }
            }
        }
    }

    public Cell getCell(int x, int y, int z){
        return board[x][y][z];
    }

    public boolean isInBounds(int x, int y, int z){//preventing getting out of bounds
        return x >= 0 && x < SIZE &&
                y >= 0 && y < SIZE &&
                z >= 0 && z < SIZE;
    }

    public void reset(){
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++){
                for (int z = 0; z < SIZE; z++){
                    board[x][y][z].reset();
                }
            }
        }
    }

}
