class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // Furthest index reachable so far
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // Can't reach current index
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return true;
    }
}