class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; // Handle empty array
        if (n == 1) return nums[0]; // Handle single element
        
        // Find max number
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }
        
        // Preprocess: Count frequency
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        
        // Space-optimized DP
        int prev2 = 0; // dp[i-2]
        int prev1 = count[1]; // dp[i-1] for i=1 (points for 1 = 1 * count[1])
        
        for (int i = 2; i <= max; i++) {
            if (count[i] > 0) {
                int val = i * count[i] + prev2; // Take i, add points from i-2
                prev2 = Math.max(prev2, prev1); // Update prev2 to previous max
                prev1 = val; // Update prev1 to current max
            } else {
                // If i doesn't exist, carry forward the maximum
                if (prev2 > prev1) prev1 = prev2;
                else prev2 = prev1;
            }
        }
        
        return Math.max(prev1, prev2);
    }
}