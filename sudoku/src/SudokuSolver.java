import java.util.*;

public class SudokuSolver {

    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {

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

        // send the board to the solver
        if(solveBoard(board)){
            System.out.println("Solved");
        }
        else{
            System.out.println("Not possible");
        }



        /*
        // TODO : figure out how to print a 2D Java Array in the following manner
        for(int[] row : board){
            System.out.println(row);
        }
        */

        vanillaBoardPrinter(board);


    }



    public static void vanillaBoardPrinter(int[][] board){
        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
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
