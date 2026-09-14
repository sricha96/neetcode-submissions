class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums == null){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(frequency > 1){
                return true;
            }
        }
        return false;
    }
}