// N-Queens II

class Solution {
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
		//horizontal
        for(int i = 0;i<board.length;i++){
            if(board[row][i]){
                return false;
            }
        }

        //vertical
        for(int i = 0;i<board.length;i++){
            if(board[i][col]){
                return false;
            }
        }
        
        //upper left
        int r = row;
        for(int c = col;c>=0 && r>=0 ;c--,r--){
            if(board[r][c]){
                return false;
            }
        }

        //upper right
        r = row;
        for(int c = col;c<board.length && r>=0;r--,c++){
            if(board[r][c]){
                return false;
            }
        }

        //lower left
        r = row;
        for(int c = col;c>=0 && r<board.length;r++,c--){
            if(board[r][c]){
                return false;
            }
        }

        //lower right
        for(int c = col;c<board.length && r<board.length;c++,r++){
            if(board[r][c]){
                return false;
            }
        }
        return true;
	}
}