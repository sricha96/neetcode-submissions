class Solution {
    public int findMin(int[] nums) {
        if(nums == null){
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[l] <= nums[r]){
                return nums[l];
            }
            if(nums[l] > nums[mid]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return 0;
    }
}
