class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1;
        int right = 1;
        for(int i =0;i<nums.length;i++){
            res[i] = left;
            left = left * nums[i];
        }
        for(int j = nums.length-1; j>=0;j--){
            res[j] = res[j]*right;
            right = right * nums[j];
        }
        return res;
    }
}  
