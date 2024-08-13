import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Tic-Tac-Toe Game!");
        System.out.print("Enter the size of the board (minimum 3): ");
        int boardSize = input.nextInt();

        if (boardSize < 3) {
            System.out.println("The board size must be at least 3.");
            return;
        }

        System.out.print("Enter the name of Player 1: ");
        String player1 = input.next();
        System.out.print("Enter the name of Player 2: ");
        String player2 = input.next();

        TicTacToeGame game = new TicTacToeGame(boardSize, player1, player2);

        while (!game.isFull() && !game.hasWinner()) {
            System.out.println("Current board:");
            game.displayBoard();
            System.out.println("Player " + game.getCurrentPlayer() + "'s turn (" + game.getCurrentMark() + "). Enter row (0-" + (boardSize - 1) + ") and column (0-" + (boardSize - 1) + "):");
            int row = input.nextInt();
            int col = input.nextInt();

            if (game.placeMark(row, col)) {
                if (game.hasWinner()) {
                    System.out.println("Congratulations, " + game.getCurrentPlayer() + "! You have won!");
                } else if (game.isFull()) {
                    System.out.println("The game is a draw!");
                } else {
                    game.switchTurn();
                }
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        input.close();
    }
}
