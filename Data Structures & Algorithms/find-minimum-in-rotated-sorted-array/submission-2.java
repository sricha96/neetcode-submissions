class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int res = 0;
        while(i <= j){
            if(nums[i] <= nums[j]){
                res = nums[i];
                return res;
            }
            int m = (i+j)/2;
            if(nums[m] >= nums[i]){
                i = m+1;
            }else{
                j = m;
            }
        }
        return res;
    }
}
