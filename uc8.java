/**
 * TicTacToe
 * UC8 controls the continuous game loop and alternates
 * turns until the game ends.
 */
public class uc8 {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    static char humanSymbol = 'X';
    static char computerSymbol = 'O';

    /**
     * Entry point of the program. Runs the game loop.
     */
    public static void main(String[] args) {

        while (!gameOver) {

            displayBoard();

            if (isHumanTurn) {
                System.out.println("Human Turn");
                humanMove(); // UC3 + UC6 assumed reused
            } else {
                System.out.println("Computer Turn");
                computerMove(); // UC7 reused
            }

            // Check game state after move
            if (checkWin()) {
                gameOver = true;
                displayBoard();
                System.out.println((isHumanTurn ? "Human" : "Computer") + " wins!");
            } else if (isBoardFull()) {
                gameOver = true;
                displayBoard();
                System.out.println("Game is a Draw!");
            } else {
                // Switch turn
                isHumanTurn = !isHumanTurn;
            }
        }
    }

    // ---------------- GAME LOGIC ----------------

    static void humanMove() {
        int slot = getUserSlot();
        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);

        if (isValidMove(row, col)) {
            placeMove(row, col, humanSymbol);
        } else {
            System.out.println("Invalid move. Try again.");
            humanMove(); // retry
        }
    }

    static void computerMove() {
        java.util.Random random = new java.util.Random();

        while (true) {
            int slot = random.nextInt(9) + 1;

            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            if (isValidMove(row, col)) {
                placeMove(row, col, computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // ---------------- HELPERS ----------------

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] == '-';
    }

    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    static int getUserSlot() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter slot (1-9): ");
        return sc.nextInt();
    }

    static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin() {
        // rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                return true;
            }
        }

        // cols
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' &&
                board[0][j] == board[1][j] &&
                board[1][j] == board[2][j]) {
                return true;
            }
        }

        // diagonals
        if (board[0][0] != '-' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            return true;
        }

        if (board[0][2] != '-' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }
}