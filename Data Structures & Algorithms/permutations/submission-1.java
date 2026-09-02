class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        for(int num : nums){
            map.put(num, false);
        }
        permutation(nums, res, sub, map);
        return res;
    }

    public void permutation(int[] nums, List<List<Integer>> res, List<Integer> sub, Map<Integer, Boolean> map){
        if(sub.size() == nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!map.get(nums[i])){
                map.put(nums[i], true);
                sub.add(nums[i]);
                permutation(nums, res, sub, map);
                sub.remove(sub.size() - 1);
                map.put(nums[i], false);
            }
        }
    }
}
