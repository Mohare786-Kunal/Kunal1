class Solution {
    public int coinChange(int[] coins, int amount) {
        // Initialize DP array
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // Mark all as impossible initially
        dp[0] = 0; // Base case: 0 coins needed for amount 0
        
        // Build DP table
        for (int i = 1; i <= amount; i++) {
            // Try each coin for amount i
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // Return result
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}