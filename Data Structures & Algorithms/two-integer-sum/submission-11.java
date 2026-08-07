class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int one = nums[i];
            int second = target - one;
            if(map.containsKey(second)){
                return new int[] {map.get(second), i};
            }
            map.put(one, i);
        }
        return new int[] {};
    }
}
