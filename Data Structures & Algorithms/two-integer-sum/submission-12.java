class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            int b = target - a;
            if(map.containsKey(b)){
                return new int[]{map.get(b), i};
            }
            map.put(a, i);
        }
        return new int[]{0};
    }
}
