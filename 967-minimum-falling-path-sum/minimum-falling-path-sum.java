class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] front = new int[n];

        // Initialize the front array with the last row of the matrix
        for (int col = 0; col < n; col++) {
            front[col] = matrix[n - 1][col];
        }

        // Iterate from the second last row to the top
        for (int row = n - 2; row >= 0; row--) {
            int[] current = new int[n]; // Temporary array for the current row
            for (int col = 0; col < n; col++) {
                // Get the minimum path sum from the row below
                int downPath = front[col];
                int leftDiagonalPath = (col > 0) ? front[col - 1] : Integer.MAX_VALUE;
                int rightDiagonalPath = (col < n - 1) ? front[col + 1] : Integer.MAX_VALUE;

                // Update the current cell with the minimum falling path sum
                current[col] = matrix[row][col] + Math.min(downPath, Math.min(leftDiagonalPath, rightDiagonalPath));
            }
            front = current; // Move to the next row
        }

        // Find the minimum path sum in the first row
        int minPathSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minPathSum = Math.min(minPathSum, front[col]);
        }

        return minPathSum;
    }
}
