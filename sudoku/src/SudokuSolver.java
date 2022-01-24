import java.util.*

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
        solveBoard(board);

        System.out.println(board);
        //System.out.println(Arrays.deepToString(board));
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
                    for(int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++){
                        if(isValidPlacement(board, numberToTry, row, col)){
                            board[row][col] = numberToTry;


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
    }





}