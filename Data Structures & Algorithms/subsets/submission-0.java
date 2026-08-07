class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        solve(nums, res, sub, 0);
        return res;
    }

    public void solve(int[] nums, List<List<Integer>> res, List<Integer> sub, int i){
        if(i >= nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        solve(nums, res, sub, i + 1);
        sub.remove(sub.size() - 1);
        solve(nums, res, sub, i + 1);
    }
}
