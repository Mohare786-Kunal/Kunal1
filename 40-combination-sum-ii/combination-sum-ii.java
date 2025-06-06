class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        
        combinationSum2(0, candidates, list, result, target);
        return result;
    }
    
    public void combinationSum2(int ind, int[] nums, List<Integer> list, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i-1]) continue;
            if (nums[i] > target) break;
            
            list.add(nums[i]);
            combinationSum2(i + 1, nums, list, result, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }
}