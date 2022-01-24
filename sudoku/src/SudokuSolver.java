import java.util.*;

/**
 * Given a hard-coded sudoku board, this script provides a solution
 */
public class SudokuSolver {

    // Constant Value for the size of the square dimensions
    private static final int GRID_SIZE = 9;


    public static void main(String[] args) {

        // Hard-coded board
        // The Board is initialized with 0's where the player can insert solutions. Equivalent to blank spots
        int[][] board = {
            {7, 0, 2, 0, 5, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {1, 0, 0, 0, 0, 9, 5, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 4, 3, 0, 0, 0, 7, 5, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 9, 7, 0, 0, 0, 0, 5},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };

        System.out.println("\n\n\t-----Initial Board-----\n\n");
        BoardPrinter(board);

        // send the board to the solver
        if(solveBoard(board)){
            System.out.println("\n\n\t-----Solution Found-----\n\n");
            System.out.println("\n\n\t-----Solved Board-----\n\n");
            BoardPrinter(board);
        } // Some boards are not possible to solve
        else{
            System.out.println("Not possible");
        }

    }



    /**
     *  Prints the Board
     * @param board -> The solved sudoku 2D list
     */
    public static void BoardPrinter(int[][] board){
        System.out.println();

        // Loop through entire 2D array in n^2 manner
        for(int row = 0; row < GRID_SIZE; row++){
            // At each multiple of 3, the end of a block is encountered; pretty print to wall it off
            // skip the top
            if(row % 3 == 0){
                System.out.println("\s\s----------------------");
            }
            // Same wall idea but for the vertical walls of a block
            for(int col = 0; col < GRID_SIZE; col++){
                if(col % 3 == 0){
                    System.out.print("\s|");
                }
                System.out.print("\s" + board[row][col]);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("\s\s----------------------");
    }


    /**
     * Checks if a value exists in the same row twice, returns TRUE if so, false if not
     * @param board -> the 2D sudoku board
     * @param number -> the value in consideration
     * @param row -> the current row (an int[] within the 2D int[][]) in the board
     * @return  -> boolean for indicating if the current value is a valid play
     */
    private static boolean isNumberInRow(int[][] board, int number, int row){
        // loop across the board, checking each column within a row
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[row][i] == number){
                // 'number' is an invalid play
                return true;
            }
        }
        // number is unique in the row, so it is a valid play
        return false;
    }


    /**
     * Checks if a value exists in the same column twice, returns TRUE if so, false if not
     * @param board -> 2D sudoku board
     * @param number -> value that is being checked
     * @param col -> current column within the board
     * @return -> boolean for indicating if the current value is a valid play
     */
    private static boolean isNumberInCol(int[][] board, int number, int col){
        // loop across the board, checking each row within a column
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[i][col] == number){
                // 'number' is an invalid play
                return true;
            }
        }
        // number is unique in the column, so it is a valid play
        return false;
    }


    /**
     * Checks if a value exists in the same row 3x3 square twice
     * @param board -> 2D Sudoku board
     * @param number -> value being considered for play
     * @param row -> row index of the number
     * @param col -> col index of the number
     * @return -> TRUE if a number exists twice in the square (incorrect play); FALSE if number is unique in square
     */
    private static boolean isNumberInBox(
            int[][] board, int number, int row, int col
    ){
        int localBoxRow = row - row % 3;
        int localBoxCol= col - col % 3;

        for(int i = localBoxRow; i < localBoxRow + 3; i++){
            for(int j = localBoxCol; j < localBoxCol + 3; j++){
                if(board[i][j] == number){
                    // invalid play, because 'number' already exists in the square
                    return true;
                }
            }
        }
        // 'number' is unique in the square, indicating a valid play
        return false;

    }


    /**
     * Checks the NumberInRowColBox() helper functions and performs Logical AND to check valid plays
     * @param board -> 2D board
     * @param number -> the number in consideration
     * @param row -> row index of the number
     * @param col -> row index of the number
     * @return -> TRUE if the number is a valid play, FALSE if 'number' is invalid
     */
    private static boolean isValidPlacement(int[][] board, int number, int row, int col){
        return !isNumberInRow(board, number, row) &&
                !isNumberInCol(board, number, col) &&
                !isNumberInBox(board, number, row, col);

    }


    /**
     * Performs recursive search and backtrace to find a solution to a given Sudoku board. If solution exists,
     *      the input board will contain the solved values.
     *
     *  The Board is initialized with 0's where the player can insert solutions. Equivalent to blank spots
     *
     * @param board -> 2D Sudoku board
     * @return -> false if the particular Board configuration cannot be solved
     */
    private static boolean solveBoard(int[][] board){
        // Loop through each value on the board. 0's indicate places for user input
        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                if(board[row][col] == 0){
                    // Try all possible values between [1,9]
                    for(int try_val = 1; try_val <= GRID_SIZE; try_val++){
                        if(isValidPlacement(board, try_val, row, col)){
                            board[row][col] = try_val;

                            // board now contains the 'try_val' attempt at solution
                            // commence recursively with this new board
                            if(solveBoard(board)){
                                // current board setup is valid
                                return true;
                            }
                            // if the board fails with the all down-stack combos using 'try_val' then reset the board where
                            // the 'try_val' was placed with its empty value
                            else{
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
