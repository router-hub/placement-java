import java.util.*;
class Solution {
    public static boolean isSafe(char board[][], int row, int col) {
        // vertical col
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void chessBoard(char board[][], int row, List<List<String>> ans) {
        int n = board.length;
        if (row == n) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                res.add(sb.toString());
            }
            ans.add(res);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                chessBoard(board, row + 1, ans);
                board[row][j] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();

        chessBoard(board, 0, ans);

        return ans;
    }
}