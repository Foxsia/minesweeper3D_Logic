public class Cell {
    private boolean hasMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int neighbourMines;

    public Cell(){
        reset();
    }

    void reset(){
        hasMine = false;
        isRevealed = false;
        isFlagged = false;
        neighbourMines = 0;
    }

    //getters
    public boolean isHasMine() {
        return hasMine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public int getNeighbourMines() {
        return neighbourMines;
    }

    //setters

    void placeMine() { //if it does not have privae/public/protected -> package-private -> UI won't be able to change it but game logic will
        hasMine = true;
    }

    void setNeighbourMines(int count) {
        neighbourMines = count;
    }

    void reveal() {
        isRevealed = true;
    }

    void toggleFlag() {
        isFlagged = !isFlagged;
    }
}
