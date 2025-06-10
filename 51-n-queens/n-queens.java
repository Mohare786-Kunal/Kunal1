class Solution {

    public static void nQueens(int col, char[][] board, List<List<String>> result, int n, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        if (col == n) {
            List<String> currentBoard = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                currentBoard.add(new String(board[i]));
            }
            result.add(currentBoard);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[(n - 1) + (col - row)] == 0) {

                board[row][col] = 'Q';

                leftRow[row] = 1;

                lowerDiagonal[row + col] = 1;

                upperDiagonal[(n - 1) + (col - row)] = 1;

                nQueens(col + 1, board, result, n, leftRow, lowerDiagonal, upperDiagonal);

                board[row][col] = '.';

                leftRow[row] = 0;

                lowerDiagonal[row + col] = 0;

                upperDiagonal[(n - 1) + (col - row)] = 0;
                
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

        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];

        nQueens(0, board, result, n, leftRow, lowerDiagonal, upperDiagonal);
        return result;
    }
}