import java.util.Random;

public class GameLogic {
    private final Board board;
    private GameState gameState;
    private final int minesCount;
    private boolean wereMinesGenerated;

    public GameLogic(int minesCount){
        this.minesCount = minesCount;
        board = new Board();
        board.reset();
    }

    //getters
    public GameState getGameState(){
        return gameState;
    }

    public Board getBoard() {
        return board;
    }

    //
    public void toggleFlag(int x, int y, int z){
        if(gameState != GameState.RUNNING) return;
        if(!board.isInBounds(x, y, z)) return;

        Cell cell = board.getCell(x, y, z);
        if(!cell.isRevealed()){
            cell.toggleFlag();
        }
    }

    public void reveal(int x, int y, int z){
        if(gameState != GameState.RUNNING) return;
        if(!board.isInBounds(x, y, z)) return;

        Cell cell = board.getCell(x, y, z);
        if(cell.isRevealed() || cell.isFlagged()) return;//can't reveal them

        if(!wereMinesGenerated){//generating mines after first click
            generateMines(x, y, z);
            //calculateNeighbors(x, y, z);
            wereMinesGenerated = true;
        }

        if(cell.isHasMine()){//losing
            cell.reveal();
            gameState = GameState.LOST;
            //showAllMines();
        }

        //floodFill(x, y, z);
        //checkWin();
    }

    public void generateMines(int clickedX, int clickedY, int clickedZ){
        Random random = new Random();
        int placed = 0;

        while(placed < minesCount){
            int x = random.nextInt(Board.SIZE);
            int y = random.nextInt(Board.SIZE);
            int z = random.nextInt(Board.SIZE);

            Cell cell = board.getCell(x, y, z);
            if(cell.isHasMine()) continue;

            //clicked cell can't be a mine and the cell around either
            if(Math.abs(x - clickedX) <= 1 &&
                    Math.abs(y - clickedY) <= 1 &&
                    Math.abs(z - clickedZ) <= 1 ) continue;

            cell.placeMine();
            placed++;
        }
    }

    public void calculateNeighbors(){

    }

    public void floodFill(){

    }

    public void showAllMines(){

    }

    public void checkWin(){
        for (int x = 0; x < Board.SIZE; x++) {
            for (int y = 0; y < Board.SIZE; y++){
                for (int z = 0; z < Board.SIZE; z++){
                    Cell cell = board.getCell(x, y, z);
                    if(!cell.isHasMine() || !cell.isRevealed()) return;
                }
            }
        }
        //if nothing left to reveal YOU WIN!
        gameState = GameState.WON;
    }
}
