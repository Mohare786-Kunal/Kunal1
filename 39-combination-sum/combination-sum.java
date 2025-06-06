class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findComb(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public void findComb(int ind , int [] arr , int target, List<List<Integer>> ans , List<Integer> temp){
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(arr[ind] <= target){
            temp.add(arr[ind]);
            findComb(ind, arr, target-arr[ind], ans, temp);
            temp.remove(temp.size()-1);
        }
        findComb(ind+1,arr,target, ans , temp);
    }
}