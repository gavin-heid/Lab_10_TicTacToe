import java.util.Scanner;
public class Main {

    private static final int Row = 3;//setting up the rows and colunms
    private static final int Col = 3;
    private static String[][] board = new String[Row][Col];
    private static String currentPlayer = "X"; //x going first
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        do {
            clearBoard();
            display();

            while (!isWin() && !isTie()) {
                int rowMove, colMove;
                do {
                    System.out.println("Player " + currentPlayer + "'s turn:");
                    rowMove = SafeInputCopy.getRangedInt(scanner, "Enter row (1-3): ", 1, 3) - 1;
                    colMove = SafeInputCopy.getRangedInt(scanner, "Enter column (1-3): ", 1, 3) - 1;
                } while (!isValidMove(rowMove, colMove));

                board[rowMove][colMove] = currentPlayer;
                display();

                if (isWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                } else if (isTie()) {
                    System.out.println("It's a tie!");
                } else {
                    togglePlayer();
                }
            }
            System.out.println("Do you want to play again?");
            playAgain = SafeInputCopy.getYNConfirm(scanner, "");
        }while (playAgain);


    }
    private static void clearBoard(){
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Col; j++) {
                board [i][j]=" ";
            }
        }

    }
    private static void display(){
        System.out.println("  1    2    3");
        for (int i = 0; i < Row; i++){
            System.out.print(i + 1 + " ");
            for (int j = 0; j < Col; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < Col - 1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < Row - 1){
                System.out.println("  -----------");
            }
        }

    }
    private static boolean isValidMove(int row,int col){
        if (Row < 0 || row >= Row || col >= Col){
            System.out.println("Invalid Move! Row and Column values must be between 1 and 3");
            return false;
        }
        if (!board[row][col].equals(" ")){
            System.out.println("That position is already occupied!");
            return false;
        }
        return true;

    }
    private static boolean isWin() {
        return isWin("X") || isWin("O");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < Row; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true; // Three in a row
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int i = 0; i < Col; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true; // Three in a column
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        // Check diagonal from top-left to bottom-right
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        // Check diagonal from top-right to bottom-left
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        return false;
    }

    private static boolean isTie() {
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Col; j++) {
                if (board[i][j].equals(" ")) {
                    return false; // If empty space, not a tie
                }
            }
        }
        return true; //no empty space, game is tie
    }
    private static void togglePlayer() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }
}