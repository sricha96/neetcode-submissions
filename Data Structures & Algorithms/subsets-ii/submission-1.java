class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, res, sub, 0);
        return res;
        
    }

    public void subset(int[] nums, List<List<Integer>> res, List<Integer> sub, int i){
        res.add(new ArrayList<>(sub));
        for(int j = i; j < nums.length; j++){
            if(j != i && nums[j] == nums[j - 1]){
                continue;
            }
            sub.add(nums[j]);
            subset(nums, res, sub, j + 1);
            sub.remove(sub.size() - 1);
        }
    }
}
