public class TicTacToe {

    static char[][] board = new char[3][3];

    // Entry point of the program
    public static void main(String[] args) {
        initializeBoard();
        printBoard();
    }

    // Initialize the board with '-'
    static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    // Print the board in grid format
    static void printBoard() {
        System.out.println("Tic-Tac-Toe Board:");

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println(); // Move to next line after each row
        }
    }
}