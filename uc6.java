/**
 * TicTacToe
 * UC6 places a move on the board after validating it.
 */
public class uc6 {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    /**
     * Entry point of the program. Tests placing a move.
     */
    public static void main(String[] args) {
        int row = 1;
        int col = 1;
        char symbol = 'X';

        if (isValidMove(row, col)) {
            placeMove(row, col, symbol);
            System.out.println("Move placed successfully!");
        } else {
            System.out.println("Invalid move!");
        }

        displayBoard();
    }

    /**
     * Checks if the given row and column are within bounds
     * and if the target cell is empty.
     */
    static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        return board[row][col] == '-';
    }

    /**
     * Places the given symbol on the board at the specified position.
     * Input: Row, Column, Symbol
     */
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    /**
     * Displays the current board state.
     */
    static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}