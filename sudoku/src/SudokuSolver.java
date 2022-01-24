import java.util.*;

/**
 * Given a hard-coded sudoku board, this script provides a solution
 */
public class SudokuSolver {

    // Constant Value for the size of the square dimensions
    private static final int GRID_SIZE = 9;


    public static void main(String[] args) {

        // Hard-coded board
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
     *
     * @param board -> The solved sudoku 2D list
     */
    public static void BoardPrinter(int[][] board){
        System.out.println();

        // Loop through entire 2D array in n^2 manner
        for(int row = 0; row < GRID_SIZE; row++){
            // At each multiple of 3, the end of a block is encountered; pretty print to wall it off
            // skip the top
            if(row % 3 == 0){
                System.out.println("\s-----------");
            }
            // Same wall idea but for the vertical walls of a block
            for(int col = 0; col < GRID_SIZE; col++){
                if(col % 3 == 0){
                    System.out.print("|");
                }
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }


    /**
     *
     * @param board
     * @param number
     * @param row
     * @return
     */
    private static boolean isNumberInRow(int[][] board, int number, int row){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }


    /**
     *
     * @param board
     * @param number
     * @param col
     * @return
     */
    private static boolean isNumberInCol(int[][] board, int number, int col){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[i][col] == number){
                return true;
            }
        }
        return false;
    }


    /**
     *
     * @param board
     * @param number
     * @param row
     * @param col
     * @return
     */
    private static boolean isNumberInBox(
            int[][] board, int number, int row, int col
    ){
        int localBoxRow = row - row % 3;
        int localBoxCol= col - col % 3;

        for(int i = localBoxRow; i < localBoxRow + 3; i++){
            for(int j = localBoxCol; j < localBoxCol + 3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }

        return false;

    }


    /**
     *
     * @param board
     * @param number
     * @param row
     * @param col
     * @return
     */
    private static boolean isValidPlacement(int[][] board, int number, int row, int col){
        return !isNumberInRow(board, number, row) &&
                !isNumberInCol(board, number, col) &&
                !isNumberInBox(board, number, row, col);

    }


    private static boolean solveBoard(int[][] board){
        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                if(board[row][col] == 0){
                    for(int try_val = 1; try_val <= GRID_SIZE; try_val++){
                        if(isValidPlacement(board, try_val, row, col)){
                            board[row][col] = try_val;
                            // Recursive Call here
                            if(solveBoard(board)){
                                return true;
                            }
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
