
class Solution {
    int count=0;
    public int totalNQueens(int n) {
        char board[][]= new char [n][n];

        for(int i=0; i<board.length;i++){
            for(int j=0; j<board.length;j++){
                board[i][j]='X';
            }
        }

        chessBoard(board,0);
        return count;
    }


     public  boolean isSafe(char board[][], int row, int col){
        // vertical col
        for(int i=row-1; i>=0; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        // left diagonal 
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // right diagonal 
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }

    

    


    public  void chessBoard(char board[][], int row){
        if(row==board.length){
            //printBoard(board);
            count++;
            return;
        }

        for(int j=0;j<board.length;j++){
            if(isSafe(board,row, j)){
                board[row][j]='Q';
                chessBoard(board, row+1);
                board[row][j]='X';
            }
            
        }
    }

  
}