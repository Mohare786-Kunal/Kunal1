class Solution {

    public static boolean isSafe(int row, int col, char[][] board, int n) {
        int row_OG = row;
        int col_OG = col;

        // Check upper left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        // Check left side
        row = row_OG;
        col = col_OG;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        // Check lower left diagonal
        row = row_OG;
        col = col_OG;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    public static void nQueens(int col, char[][] board, List<List<String>> result, int n) {
        if (col == n) {
            List<String> currentBoard = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                currentBoard.add(new String(board[i]));
            }
            result.add(currentBoard);
            return;
        }
        
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                nQueens(col + 1, board, result, n);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }
        nQueens(0, board, result, n);
        return result;
    }
}