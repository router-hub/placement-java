// N Queens

import java.util.*;

class Solution {
    private boolean isSafe(int row,int col,char[][] board){
        //horizontal
        for(int i = 0;i<board.length;i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        //vertical
        for(int i = 0;i<board.length;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        
        //upper left
        int r = row;
        for(int c = col;c>=0 && r>=0 ;c--,r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //upper right
        r = row;
        for(int c = col;c<board.length && r>=0;r--,c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //lower left
        r = row;
        for(int c = col;c>=0 && r<board.length;r++,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //lower right
        for(int c = col;c<board.length && r<board.length;c++,r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        return true;
    }

    private void saveBoard(char[][] board,List<List<String>> allBoards){
        String str = "";
        List<String> newboard = new ArrayList<>();
        for(int i = 0;i<board.length;i++){
            str = "";
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 'Q'){
                    str += 'Q';
                }else{
                    str += '.';
                }
            }
            newboard.add(str);
        }
        allBoards.add(newboard);
    }

    private void backtrack(char[][] board,List<List<String>> allBoards,int col){
        //base condition
        if(col == board.length){
            saveBoard(board,allBoards);
            return;
        }

        for(int i = 0;i<board.length;i++){
            if(isSafe(i,col,board)){
                board[i][col] = 'Q';
                backtrack(board,allBoards,col+1);
                //to remove for backtracking
                board[i][col] = '.'; 
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        backtrack(board,allBoards,0);
        return allBoards;
    }
} 
