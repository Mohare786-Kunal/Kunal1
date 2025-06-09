class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        
        permutationsI(0, nums, list, result);
        return result;
    }
    public static void permutationsI(int ind, int[] nums, List<Integer> list, List<List<Integer>> result ) {
        if(ind == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            swap(nums, ind, i);
            list.add(nums[ind]);  // Add the number at current position
            permutationsI(ind + 1, nums, list, result);
            list.remove(list.size() - 1);
            swap(nums, ind, i);  // Undo the swap
        }
    }
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}