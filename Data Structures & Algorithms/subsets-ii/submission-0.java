class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, res, subset, 0);
        return res;
    }

    public void solve(int[] nums, List<List<Integer>> res, List<Integer> subset, int i){
        res.add(new ArrayList<>(subset));
        for(int j = i; j < nums.length; j++){
            if(j != i && nums[j] == nums[j - 1]){
                continue;
            }
            subset.add(nums[j]);
            solve(nums, res, subset, j + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
