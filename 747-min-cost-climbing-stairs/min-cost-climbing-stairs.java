class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
 
        int[] dp = new int[n + 1];
        
   
        for (int i = 0; i < n; i++) {
            dp[i] = cost[i];
        }
        dp[n] = 0; 

        for (int i = n - 3; i >= -1; i--) {

            dp[i + 1] = dp[i + 1] + Math.min(dp[i + 2], dp[i + 3]);
        }
        

        return Math.min(dp[0], dp[1]);
    }
}