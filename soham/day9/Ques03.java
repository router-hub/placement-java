import java.util.*;

public class Ques03 {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queens(board, 0);
    }

    private int queens(boolean [][] board,int row) {
        if(row == board.length) {
            return 1;
        }
        int count=0;
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board,row,col)) {
                board[row][col] = true;
                count += queens(board, row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private boolean isSafe(boolean[][] board, int row, int col) {

        for(int i = 0;i<board.length;i++){
            if(board[row][i]){
                return false;
            }
        }


        for (boolean[] booleans : board) {
            if (booleans[col]) {
                return false;
            }
        }


        int r = row;
        for(int c = col; c>=0 && r>=0 ;  c--,r--){
            if(board[r][c]){
                return false;
            }
        }


        r = row;
        for(int c = col;c<board.length && r >= 0; r--,c++){
            if(board[r][c]){
                return false;
            }
        }


        return true;
    }
}
