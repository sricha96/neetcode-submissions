class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j){
            int middle = (i + j)/2;
            if(nums[middle] > target){
                j = middle - 1;
            }else if(nums[middle] < target){
                i = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }
}
