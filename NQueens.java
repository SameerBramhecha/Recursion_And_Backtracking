import java.util.*;

public class NQueens {

    // function to check if the queen is safe in a particular cell
    public static boolean isSafe(int row, int col, char[][] board) {
        // horizontally
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        // vertically
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // upper right
        int r = row;
        for (int c = col; c < board.length && r >= 0; c++, r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        // lower right
        r = row;
        for (int c = col; c < board.length && r < board.length; c++, r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        // upper left
        r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        // lower left
        r = row;
        for (int c = col; c >= 0 && r < board.length; c--, r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // function to save the board for correct solution
    public static void saveBoard(List<List<String>> ans, char[][] board) {
        String row = "";
        List<String> bord = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
            bord.add(row);
        }
        ans.add(bord);
    }

    public static void nqueens(List<List<String>> ans, char[][] board, int col) {
        if (col == board.length) {
            saveBoard(ans, board);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                nqueens(ans, board, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        nqueens(ans, board, 0);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        if (n > 3) {
            List<List<String>> ls = solveNQueens(n);

            System.out.println("All Possible ways are");
            for (int i = 0; i < ls.size(); i++) {
                for (int j = 0; j < ls.get(i).size(); j++) {
                    System.out.println(ls.get(i).get(j) + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No Solution Possible");
        }

    }
}
