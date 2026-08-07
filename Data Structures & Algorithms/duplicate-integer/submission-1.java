class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i<= nums.length -1 ; i++){
            if(nums[i-1]== nums[i]){
                return true;
            }
        }
        return false;
    }
}
