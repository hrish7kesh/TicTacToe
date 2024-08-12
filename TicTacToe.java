class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private int boardSize;
    private String player1Name;
    private String player2Name;

    public TicTacToe(int size, String player1, String player2) {
        boardSize = size;
        board = new char[boardSize][boardSize];
        currentPlayer = 'X';
        player1Name = player1;
        player2Name = player2;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < boardSize; i++) {
            System.out.print("| ");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean makeMove(int row, int col) {
        if (row >= 0 && row < boardSize && col >= 0 && col < boardSize && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows() {
        for (int i = 0; i < boardSize; i++) {
            boolean win = true;
            for (int j = 1; j < boardSize; j++) {
                if (board[i][j] != board[i][0] || board[i][j] == '-') {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < boardSize; i++) {
            boolean win = true;
            for (int j = 1; j < boardSize; j++) {
                if (board[j][i] != board[0][i] || board[j][i] == '-') {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private boolean checkDiagonals() {
        boolean win = true;
        for (int i = 1; i < boardSize; i++) {
            if (board[i][i] != board[0][0] || board[i][i] == '-') {
                win = false;
                break;
            }
        }
        if (win) return true;

        win = true;
        for (int i = 1; i < boardSize; i++) {
            if (board[i][boardSize - i - 1] != board[0][boardSize - 1] || board[i][boardSize - i - 1] == '-') {
                win = false;
                break;
            }
        }
        return win;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayerSymbol() {
        return currentPlayer;
    }

    public String getCurrentPlayerName() {
        return (currentPlayer == 'X') ? player1Name : player2Name;
    }
}
