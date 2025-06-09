class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        
        permutationsI(0, nums, list, result, freq);
        return result;
    }
    public static void permutationsI(int ind, int[] nums, List<Integer> list, List<List<Integer>> result, boolean[] freq) {
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                list.add(nums[i]);
                freq[i] = true;
                permutationsI(ind + 1, nums, list, result, freq);
                list.remove(list.size() - 1);
                freq[i] = false;
            }
        }
    }
}