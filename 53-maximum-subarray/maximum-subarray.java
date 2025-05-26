class Solution {
    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];  // Base case: single element
        }

        int mid = (left + right) / 2;  // Find the middle point
        int leftSum = divideAndConquer(nums, left, mid);  // Left half maximum sum
        int rightSum = divideAndConquer(nums, mid + 1, right);  // Right half maximum sum
        int crossSum = findCrossingSum(nums, left, mid, right);  // Maximum sum that crosses the middle

        return Math.max(Math.max(leftSum, rightSum), crossSum);  // Return the best of the three
    }

    private int findCrossingSum(int[] nums, int left, int mid, int right) {
        int leftMax = Integer.MIN_VALUE;  // Track the maximum sum on the left side
        int rightMax = Integer.MIN_VALUE;  // Track the maximum sum on the right side
        int sum = 0;

        // Find the maximum sum starting from the middle and expanding to the left
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);  // Update leftMax with the best possible sum
        }

        sum = 0;
        // Find the maximum sum starting from the middle+1 and expanding to the right
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);  // Update rightMax with the best possible sum
        }

        // The crossing sum is the sum of the best left and right sums
        return leftMax + rightMax;
    }
}
