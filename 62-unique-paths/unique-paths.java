class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 2D DP array to store the number of paths
        int[][] dp = new int[m][n];
        
        // Fill the DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Base case: top-left cell has 1 way to reach
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                
                // Calculate paths from above and left
                int up = 0, left = 0;
                if (i > 0) up = dp[i-1][j];
                if (j > 0) left = dp[i][j-1];
                
                // Total paths to (i,j) = paths from above + paths from left
                dp[i][j] = up + left;
            }
        }
        
        // Return the number of paths to (m-1,n-1)
        return dp[m-1][n-1];
    }
}