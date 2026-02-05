import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameLogic game = new GameLogic(25);
        game.setGameState(GameState.RUNNING);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj x y z: ");

        while (game.getGameState() == GameState.RUNNING) {
            printBoard(game);
            System.out.println("Podaj x y z:");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();

            game.reveal(x, y, z);
        }

        printBoard(game);
        System.out.println("GAME STATE: " + game.getGameState());
    }

    private static void printBoard(GameLogic game) {
        for (int z = 0; z < Board.SIZE; z++) {
            System.out.println("Layer z=" + z);
            for (int y = 0; y < Board.SIZE; y++) {
                for (int x = 0; x < Board.SIZE; x++) {
                    Cell c = game.getBoard().getCell(x, y, z);
                    if (!c.isRevealed()) System.out.print("# ");
                    else if (c.isHasMine()) System.out.print("* ");
                    else System.out.print(c.getNeighbourMines() + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
