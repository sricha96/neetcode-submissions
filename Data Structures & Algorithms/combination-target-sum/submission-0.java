class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        solve(nums, res, com, target, 0);
        return res;
    }

    public void solve(int[] nums, List<List<Integer>> res, List<Integer> com, int target, int i){
        if(target == 0){
            res.add(new ArrayList<>(com));
            return;
        }
        if(target < 0 || i >= nums.length){
            return;
        }
        com.add(nums[i]);
        solve(nums, res, com, target - nums[i], i);
        com.remove(com.size() - 1);
        solve(nums, res, com, target, i + 1);
    }
}
