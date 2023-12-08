// Sudoku Solver

class Solution {
    private boolean isSafe(char[][] board,int row,int col,int number){
            //row checking
        for(int i = 0;i<board.length;i++){
            if(board[i][col] == (char)(number + '0')){
                return false;
            }

            //column checking
            if(board[row][i] == (char)(number+'0')){
                return false;
            }
        }

        //grid checking
        int srow = (row/3)*3;
        int scol = (col/3)*3;

        for(int i = srow;i<srow + 3;i++){
            for(int j = scol;j<scol+3;j++){
                if(board[i][j] == (char)(number + '0')){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean backtrack(char[][] board,int row,int col){
        //base case
        if(row == board.length){
            return true;
        }

        if(col == board[0].length){
          return backtrack(board,row + 1,0);
        }

        if(board[row][col] != '.'){
                return backtrack(board,row,col+1);
            }

                for(char ch = '1';ch <= '9';ch++){
                    if(isSafe(board,row,col,ch - '0')){
                        board[row][col] = ch;
                        if(backtrack(board,row,col+1)){
                            return true;
                        }
                          board[row][col] = '.';
                }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        backtrack(board,0,0);
    }
}
