class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i : nums){
            map.put(i, false);
        }
        solve(nums, res, sub, map);
        return res;
    }

    public void solve(int[] nums, List<List<Integer>> res, List<Integer> sub, Map<Integer, Boolean> map){
        if(sub.size() == nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!map.get(nums[i])){
                map.put(nums[i], true);
                sub.add(nums[i]);
                solve(nums, res, sub, map);
                sub.remove(sub.size() - 1);
                map.put(nums[i], false);
            }
        }
    }
}
