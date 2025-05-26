class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE; // Initialize with a large value
        int maxProfit = 0;
        
        for (int i = 0; i < n; i++) {
            // Update the minimum price encountered so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Calculate the profit if selling on the current day
            int profit = prices[i] - minPrice;
            // Update the maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }
        
        return maxProfit;
    }
}
