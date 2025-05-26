class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long) nums[i]);
            Long ceil = set.ceiling((long) nums[i]);
            if (floor != null && nums[i] - floor <= valueDiff) return true;
            if (ceil != null && ceil - nums[i] <= valueDiff) return true;
            set.add((long) nums[i]);
            if (i >= indexDiff) set.remove((long) nums[i - indexDiff]);
        }
        return false;
    }
}